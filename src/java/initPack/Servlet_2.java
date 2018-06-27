package initPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet_2 extends HttpServlet {
   
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");
                PrintWriter out=response.getWriter();
                //5秒后去goto页面（延时跳转或者刷新）
                response.setHeader("Refresh", "5;url=/ServletTest/goto.html");
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