package mypack;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    private Font font = new Font("Courier",Font.BOLD,12);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get number
        String count = request.getParameter("count");

        if (count == null) {
            count = "1";
        }

        int len = count.length();

        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        //create one image in buffer length = 11*len ,high = 16
        BufferedImage image = new BufferedImage(11*len,16,BufferedImage.TYPE_INT_RGB);

        //get Graphics
        Graphics g= image.getGraphics();
        g.setColor(Color.black);
        //set one black box, length = 11*lem,high = 16
        g.fillRect(0,0,11*len,16);
        g.setColor(Color.white);
        g.setFont(font);
        char c;
        for(int i=0;i<len;i++) {
            c=count.charAt(i);
            g.drawString(c+"",i*11+1,12); // write a white number

            g.drawLine((i+1)*11-1,0,(i+1)*11-1,16); // write a white |
        }

        //print JPEG font picture
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
