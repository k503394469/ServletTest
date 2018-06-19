package initPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_1 extends HttpServlet {

    
    int ticket = 2;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i= 0;
        i++;
        //Servlet是单例，所以会出现线程并发问题，购票问题
        response.getWriter().print("helloworld" + new java.util.Date().toString()+"\n"+i);
        PrintWriter out = response.getWriter();
        out.println("hello");
        //解决方法
        //如果不加同步机制，会出现问题
        //如果一个变量需要被多个用户共享，则应当在访问该变量的时候，加同步机制synchronized
        //如果一个变量不需要共享，则直接在doGet或者doPost中定义
        synchronized (this) {
            if (ticket > 0) {
                System.out.println("购票成功");
//                try {
//                    //stop
//                    Thread.sleep(10 * 1000);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
                ticket--;
            } else {
                System.out.println("无票");
            }
        }
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
