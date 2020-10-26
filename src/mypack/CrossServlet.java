package mypack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CrossServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //read userName
        String userName = request.getParameter("userName");
        String message = null;
        if (userName == null) {
            message = "Please input userName";
        } else {
            message = "Hello," + userName;
        }
        //add msg in request
        request.setAttribute("msg", message);

        ServletContext context = getServletContext();
        ServletContext crossContext = context.getContext("/helloapp1");
        RequestDispatcher dispatcher = crossContext.getRequestDispatcher("/output");

        PrintWriter out = response.getWriter();
        dispatcher.forward(request, response);
    }
}
