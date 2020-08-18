package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得UserName请求参数
        String userName = request.getParameter("username");

        if (userName == null) {
            response.sendError(response.SC_FORBIDDEN);
            return;
        }


        response.setContentType("text/html;charset=GBK");

        /*输出HTML文档*/
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>HelloServlet</title></head>");
        out.println("<body>");
        out.println("hello:"+userName);
        out.println("</body></html>");

        //关闭之前提交的状态，应为false
        System.out.println("before close()"+response.isCommitted());
        out.close();
        //关闭之后提交的状态，应为true
        System.out.println("after close()"+response.isCommitted());
    }
}
