package top.kwseeker.tomcat.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {

    //初始化方法
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    //业务处理方法
    //ServletRequest就是第一章里面的Request（封装一个请求，包含获取输入流以及各种获取请求报文的方法）,只不过是接口，而且方法更丰富
    //读输入流->解析请求报文
    //ServletResponse则对应着第一章里面的Response,(包含获取输出流以及封装版输出流Writer及各种设置返回报文的方法)
    //构造回复报文->写输出流
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }

    public void destroy() {
        System.out.println("destroy");
    }

    public String getServletInfo() {
        return null;
    }
    public ServletConfig getServletConfig() {
        return null;
    }

}

