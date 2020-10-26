package mypack;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class DirTesterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();
        response.setContentType("text/html;charset=GB2312");
        PrintWriter out = response.getWriter();
        Enumeration eu = context.getAttributeNames();
        while (eu.hasMoreElements()) {
            String attributeName = (String) eu.nextElement();
            out.println("<br>"+attributeName+": "+context.getAttribute(attributeName));
        }
        out.close();

        //get working dir attribute
        File workDir = (File) context.getAttribute("javax.servlet.context.tempdir");
        //create a new file in working dir
        FileOutputStream fileOut = new FileOutputStream(workDir+"/temp.txt");
        fileOut.write("Hello World".getBytes());
        fileOut.close();
    }
}
