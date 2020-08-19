package mypack;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ContextTesterServlet extends HttpServlet {

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        // get object servletContext
        ServletContext servletContext = getServletContext();

        //setting HTTP response MIME type and char code
        response.setContentType("text/html;charset=GBK");

        //print HTML DOCUMENT
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>ContextServlet</title></head>");
        out.println("<body>");
        out.println("<br>Email:"+servletContext.getInitParameter("emailOfWebMaster"));
        out.println("<br>RealPath:"+servletContext.getRealPath("/lib"));
        out.println("<br>ContextPath:"+servletContext.getContextPath());
        out.println("<br>MimeType:"+servletContext.getMimeType("/WEB-INF/web.xml"));
        out.println("<br>MajorVersion:"+servletContext.getMajorVersion());
        out.println("<br>MinorVersion:"+servletContext.getMinorVersion());
        out.println("<br>ServerInfo:"+servletContext.getServerInfo());
        Enumeration enumeration = servletContext.getAttributeNames();
        while(enumeration.hasMoreElements()) {
            String attributeName = (String) enumeration.nextElement();
            out.println("<br>attributeName:" + attributeName);
        }
        out.println("<br>");
        out.println("</body></html>");

        servletContext.log("this is ContextTesterServlet print logs");
        out.close();
    }
}
