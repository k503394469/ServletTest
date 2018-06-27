/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initPack;
import com.sendme.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * <load-on-startup>使用
 * init
 */
public class Servlet_3 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

    @Override
    public void init() throws ServletException {
        System.out.println(getClass().toString()+"的init被调用");
        //完成一些初始化任务
        System.out.println("创建数据库，表，读取参数");
        //创建一个线程
        SendEmailThread sendEmailThread=new SendEmailThread();
        //sendEmailThread.start();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        this.doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
