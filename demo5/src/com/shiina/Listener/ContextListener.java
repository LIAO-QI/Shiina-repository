package com.shiina.Listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

@WebListener
public class ContextListener implements ServletRequestListener,ServletContextListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    // 代表一个请求的来临
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext sc = sre.getServletContext();

        // 拿到HttpServletRequest对象从而可以调用getRequestURI()方法拿到当前访问的地址
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        // 只有在访问包含shop.jsp的链接时用户的访问量才会增加
        if (request.getRequestURI().contains("shop.jsp")) {
            // 从sc中读取web应用初始化的count属性
            int num = (int) sc.getAttribute("count");
            num++;
            sc.setAttribute("count",num);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext sc = arg0.getServletContext();

        try {

            // 从文件中读取count的值
            FileInputStream fis = new FileInputStream("D:/JavaProject2/Experiment5/web/WEB-INF/count.txt");

            // 构建InputStreamReader对象,编码与写入相同
            InputStreamReader reader = new InputStreamReader(fis, "UTF-8");

            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                // 转成char加到StringBuffer对象中
                sb.append((char) reader.read());
            }

            // 把拿到的count值存入ServletContext对象中，这样整个应用都可以访问到该属性
            sc.setAttribute("count", Integer.parseInt(sb.toString()));

            // 关闭读取流
            reader.close();

            // 关闭输入流,释放系统资源
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        ServletContext sc = arg0.getServletContext();
        int count = (int) sc.getAttribute("count");

        if (count != 0) {
            try {

                // 把count值写进count.txt里
                FileOutputStream fos = new FileOutputStream("D:/JavaProject2/Experiment5/web/WEB-INF/count.txt");

                // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
                OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");

                // 写入到缓冲区
                // writer.append((char)count); //char类型写进文件是乱码
                writer.append(String.valueOf(count));

                // 关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
                writer.close();

                // 关闭输出流,释放系统资源
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}