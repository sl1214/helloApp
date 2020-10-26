package mypack;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Check1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        //read userName
        String userName = request.getParameter("userName");
        String message = null;
        if (userName == null) {
            message = "Please input userName";
        } else {
            message = "Hello:"+userName;
        }

        //add msg in request
        request.setAttribute("msg",message);

        writer.println("Output from Check1Servlet before redirecting.");
        System.out.println("Output from Check1Servlet before redirecting.");
        //response.sendRedirect("/helloapp/output1?msg="+message); //ok
        //response.sendRedirect("/output1?msg="+message); //wrong
        //response.sendRedirect("http://localhost:8080/helloapp/output1?msg="+message); //ok
        response.sendRedirect("http://www.baidu.com"); //ok

        writer.println("Output from check1Servlet after redirecting.");
        System.out.println("Output from check1Servlet after redirecting.");
    }
}
