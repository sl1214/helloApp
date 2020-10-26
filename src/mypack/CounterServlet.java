package mypack;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();

        Counter counter = (Counter) context.getAttribute("counter");
        if (counter == null) {
            counter = new Counter(1);
        }
        context.setAttribute("counter",counter);
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>CounterServlet</title></head>");
        out.println("<body>");
        //counter.getCount()
        //print current counter
        String imageLink = "<img src='image?count="+counter.getCount()+"'/>";
        out.println("<h1>welcome! you are "+imageLink+"th visitor</h1>");
        out.println("</body></html>");
        counter.add(1);
        out.close();
    }
}
