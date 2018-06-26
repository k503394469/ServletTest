package initPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //获取浏览器的Referer
        String referer = request.getHeader("Referer");
        //防盗链，获取Referer进行判断，如果结果为null或者不是允许进来的链接的话，跳转到Error
        if (referer == null||!referer.startsWith("http://localhost:8080/ServletTest")) {
            response.sendRedirect("/ServletTest/Error");
            return;
        }

        //用request对象来获取http请求信息
        String host = request.getHeader("Host");//获取各种消息头
        out.println(host);

        out.println("Very Important 123456");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

}
