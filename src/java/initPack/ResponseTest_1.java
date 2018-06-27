package initPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResponseTest_1 extends HttpServlet {
   
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");
                PrintWriter out=response.getWriter();
                
                //第一种方法(302状态的演示)
                response.setStatus(302);
                response.setHeader("Location", "/ServletTest/ResponseTest_2");
//                第二种方法
//                response.sendRedirect("/ServletTest/ResponseTest_2");
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