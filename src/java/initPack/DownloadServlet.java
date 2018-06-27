package initPack;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        //下载文件
        response.setHeader("Content-Disposition", "attachment;filename=laosan.jpg");
        //打开文件
        //1，获取文件的绝对路径
        String path = this.getServletContext().getRealPath("/images/laosan.jpg");
        //2，输入流
        FileInputStream fis = new FileInputStream(path);
        //缓存字节数组
        byte buff[] = new byte[1024];
        int length = 0;//表示实际每次读取了多少字节
        OutputStream os=response.getOutputStream();
        while ((length = fis.read(buff)) > 0) {
            os.write(buff, 0, length);
        }
        //关闭流
        os.close();
        fis.close();
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
