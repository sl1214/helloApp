package mypack;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DownloadServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        OutputStream out;
        InputStream in;
        String fileName = request.getParameter("fileName");
        if (fileName == null) {
            out = response.getOutputStream();
            out.write("Please input fileName.".getBytes());
            out.close();
        } else {
            in = getServletContext().getResourceAsStream("/store/" + fileName);
            int length = in.available();

            //设置响应正文的MIME类型
            response.setContentType("application/force-download");
            response.setHeader("Content-Length", String.valueOf(length));
            response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\" ");

            /*把本地文件中的数据发送给客户*/
            out = response.getOutputStream();
            int bytesRead = 0;
            byte[] buffer = new byte[512];
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer,0,bytesRead);
            }
            in.close();
            out.close();
        }
    }
}
