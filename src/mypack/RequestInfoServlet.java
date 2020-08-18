package mypack;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RequestInfoServlet extends HttpServlet {

    /*响应客户请求*/
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应正文数据类型
        response.setContentType ("text/html; charset=GBK");
        /*输出HTML文档*/
        PrintWriter out = response.getWriter();
        out.println ("<html><head><title>RequestInfo</TITLE></head>");
        out.println ("<body>" );
        //打印服务器端的IP地址
        out.println ( "<br>LocalAddr: "+request.getLocalAddr());
        //打印服务器端的主机名
        out.println("<br>LocalName: "+request.getLocalName () );
        //print FTP port
        out.println ("<br>LocalPort: "+request.getLocalPort());
        //打印通讯协议和版本号
        out.println ("<br>Protocol: "+request.getProtocol() );
        //打印客户端ip
        out.println ( "<br>RemoteAddr: "+request.getRemoteAddr() );
        //打印客户端主机名
        out.println("<br>RemoteHost: "+request.getRemoteHost());
        //打印客户端FTP端口
        out.println("<br>RemotePort: "+request.getRemotePort());

        //打印HTTP请求方式
        out.println ("<br>Method:"+request.getMethod());
        //print HTTP URI
        out.println ("<br>URI:"+request.getRequestURI());
        //打印客户端所请求访问的web应用的URL入口
        out.println ("<br>ContextPath:"+request.getContextPath());
        //print HTTP request queryString
        out.println ("<br>Querystring: "+request.getQueryString());

        /*print HTTP head*/
        out.println ("<br>start printf HTTP head");
        Enumeration eu=request.getHeaderNames ();
        while(eu.hasMoreElements()) {
            String headerName = (String) eu.nextElement();
            out.println("<br>" + headerName + ": "
                    + request.getHeader(headerName));
        }
        out.println ( "<br>end print HTTP heda");
        //print requestParam username
        out.println ("<br>username: "+request.getParameter ("username"));
        out.println("</body></html>");

        out.close() ;
        }

}
