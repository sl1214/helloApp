package mypack;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {
    private String filePath;
    private String tempFilePath;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        filePath = config.getInitParameter("filePath");
        tempFilePath = config.getInitParameter("tempFilePath");
        //read initParams tempFilePath
        filePath = getServletContext().getRealPath(filePath);
        tempFilePath = getServletContext().getRealPath(tempFilePath);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        //define content outNet of send customer
        PrintWriter outNet = response.getWriter();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //set buffer size of write data to disk,this is 4K
        factory.setSizeThreshold(4 * 1024);
        //set temp path
        factory.setRepository(new File(tempFilePath));

        //build one master of upload
        ServletFileUpload upload = new ServletFileUpload(factory);
        //set the maximum file size allowed to upload,here is 4M
        upload.setFileSizeMax(4 * 1024 * 1024);

        try {
            List items = upload.parseRequest(request);
            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem fileItem = (FileItem) iterator.next();
                if (fileItem.isFormField()) {
                    processFormField(fileItem, outNet);
                } else {
                    processUploadFile(fileItem, outNet);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outNet.close();
        }
    }

    private void processFormField(FileItem fileItem, PrintWriter outNet) {
        String name = fileItem.getFieldName();
        String value = fileItem.getString();
        outNet.println(name + ":" + value + "\r\n");
    }

    private void processUploadFile(FileItem fileItem, PrintWriter outNet) throws Exception {
        String fileName = fileItem.getName();
        int index = fileName.lastIndexOf("\\");
        fileName = fileName.substring(index + 1, fileName.length());
        long fileSize = fileItem.getSize();

        if (fileName.equals("") && fileSize == 0) {
            return;
        }
        File uploadFile = new File(filePath+"/"+fileName);
        fileItem.write(uploadFile);
        outNet.println(fileName+" is saved.");
        outNet.println("The size of "+fileName+" is " +fileSize+"\r\n");
    }


}
