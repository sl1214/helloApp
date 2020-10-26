package mypack;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Output1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = (String) request.getAttribute("msg");
        System.out.println("msg in request container:"+message);

        //read msg request parameter
        message = request.getParameter("msg");
        System.out.println("msg in request parameter:"+message);

        PrintWriter out = response.getWriter();

        out.println(message);
        out.close();
    }
}
