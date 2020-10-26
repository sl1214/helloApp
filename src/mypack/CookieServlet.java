package mypack;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    int count = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        //get all cookies in Http request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            //access everyone cookie
            for (int i = 0; i < cookies.length; i++) {
                out.println("cookie name:"+cookies[i].getName());
                out.println("cookie value:"+cookies[i].getValue());
                out.println("Max age:"+cookies[i].getMaxAge()+"\r\n");
            }
        } else {
            out.println("no cookie");
        }

        //writer a cookie for everyone customer
        Cookie cookie = new Cookie("cookieName"+count,"cookieValue"+count);
        cookie.setMaxAge(1000);
        System.out.println(cookie.getMaxAge());
        response.addCookie(cookie);
        count++;
    }
}
