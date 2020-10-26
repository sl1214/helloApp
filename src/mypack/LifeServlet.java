package mypack;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeServlet extends GenericServlet {
    private int initVar = 0;
    private int serviceVar = 0;
    private int destoryVar = 0;
    private String name;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getServletName();
        initVar++;
        System.out.println(name+">init():servlet inited "+initVar+" time");
    }

    public void destroy(){
        destoryVar++;
        System.out.println(name+">destroy():servlet has destroy "+destoryVar+" time");
    }


    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        serviceVar++;
        System.out.println(name+">service():servlet has service "+serviceVar+" time");

        String content1 = "inited time:"+initVar;
        String content2 = "service time:"+serviceVar;
        String content3 = "destroy time:"+destoryVar;

        servletResponse.setContentType("text/html;charset=GBK");

        PrintWriter out = servletResponse.getWriter();
        out.println("<html><head><title>LifeServlet</title></head>");
        out.println("<body>");
        out.println("<h1>"+content1+"</h1>");
        out.println("<h1>"+content2+"</h1>");
        out.println("<h1>"+content3+"</h1>");
        out.println("</body></html>");
        out.close();
    }
}
