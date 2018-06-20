package initPack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class ServletConfigTest extends HttpServlet {

        
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //读取web.xml里面的init-param里面的param-name,实现所对应的编码值（只能用于本Servlet）
        response.setContentType("text/html;charset=utf-8");
        System.out.println(this.getServletConfig().getInitParameter("encoding"));
        response.setCharacterEncoding(this.getServletConfig().getInitParameter("encoding"));
        PrintWriter out=response.getWriter();
        
        out.println("编码"+this.getServletConfig().getInitParameter("encoding"));
        //使用枚举获取多个init-param的值
        Enumeration <String> initParamNames=this.getServletConfig().getInitParameterNames();
        while (initParamNames.hasMoreElements()) {            
            String names=initParamNames.nextElement();
            out.println(names);
            out.println(this.getServletConfig().getInitParameter(names));
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