package mypack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //setting HttpResponse Type
        response.setContentType("text/html");

        /*print Html document*/
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>MainServlet</title></heda>");
        out.println("<body>");
        ServletContext context = this.getServletContext();
        RequestDispatcher headDispatcher = context.getRequestDispatcher("/header.html");
        RequestDispatcher greetDispatcher = context.getRequestDispatcher("/greet");
        RequestDispatcher footerDispatcher = context.getRequestDispatcher("/footer.html");

        //include header.htm
        headDispatcher.include(request,response);
        //include document of GreetServlet print
        greetDispatcher.include(request,response);
        //include footer.htm
        footerDispatcher.include(request,response);

        out.println("</body></html>");

        out.close();
    }
}
