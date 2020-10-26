package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获得UserName请求参数

        String userName = request.getParameter("username");
        HttpSession session = request.getSession(true);
        Cookie[] cookies = request.getCookies();
        //print HTML document
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>HelloServlet</title></head>");
        out.println("<body>");

        if (cookies == null) {
            out.println("no cookie");
        } else {
            for (int i = 0;i<cookies.length;i++) {
                out.println("cookie name:"+cookies[i].getName());
                out.println("cookie value:"+cookies[i].getValue());
            }
        }

        if (userName == null) {
            response.sendError(response.SC_FORBIDDEN);
            return;
        }
        out.println("hello:"+userName);
        out.println("</body></html>");

        response.setContentType("text/html;charset=GBK");

        response.encodeRedirectURL("/helloServlet");

        //关闭之前提交的状态，应为false
        System.out.println("before close()"+response.isCommitted());
        out.close();
        //关闭之后提交的状态，应为true
        System.out.println("after close()"+response.isCommitted());
    }
}
