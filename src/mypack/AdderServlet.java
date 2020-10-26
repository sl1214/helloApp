package mypack;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdderServlet extends HttpServlet {
    int sum = 100;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get increase parameter
        int increase = Integer.parseInt(request.getParameter("increase"));

        //setting HTTP response content MIME type and char code
        response.setContentType("text/html;charset=GB2312");

        /*print HTML document*/
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>AdderServlet</title></head>");
        out.println("<body>");
        out.print(sum + "+" + increase + "=");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum += increase;
        out.println(sum);
        out.println("</body></html>");
        out.close();
    }
}
