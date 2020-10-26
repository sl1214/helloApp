package mypack;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //read CheckServlet message in request
        String message = (String) request.getAttribute("msg");
        PrintWriter out = response.getWriter();

        out.println(message);
        out.close();
    }
}
