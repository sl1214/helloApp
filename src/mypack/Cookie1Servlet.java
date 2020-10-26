package mypack;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Cookie1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = null;

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        //get all cookies in Http request
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            //access everyone cookie
            for (int i = 0; i < cookies.length; i++) {
                out.println("CookieName:"+cookies[i].getName());
                out.println("CookieValue:"+cookies[i].getValue());
                if (cookies[i].getName().equals("username")) {
                    cookie = cookies[i];
                }
            }
        } else {
            out.println("No cookie");
        }
        if (cookie == null) {
            //writer a new Cookie for customer
            cookie = new Cookie("username","Tom");
            response.addCookie(cookie);
        } else if (cookie.getValue().equals("Tom")) {
            //modify Cookie
            cookie.setValue("Jack");
            response.addCookie(cookie);
        } else if (cookie.getValue().equals("Jack")) {
            //delete Cookie
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
}
