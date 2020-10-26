package mypack;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckServlet extends GenericServlet {

    /**response customer request*/
    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        //read userName
        String userName = request.getParameter("userName");
        String message = null;
        if (userName == null) {
            message = "Please input userName";
        } else {
            message = "Hello,"+userName;
        }
        //setting message in request
        request.setAttribute("msg",message);

        /**forward request to OutputServlet*/
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/output");
        //RequestDispatcher dispatcher = request.getRequestDispatcher("output");
        PrintWriter writer = response.getWriter();

        writer.println("Output from CheckServlet before forwarding request.");
        System.out.println("Output from CheckServlet before forwarding request.");



        dispatcher.forward(request,response);

        writer.println("Output from CheckServlet after forwarding request.");
        System.out.println("Output from CheckServlet after forwarding request.");

        writer.close();
    }

}
