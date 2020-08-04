package top.kwseeker.tomcat.socket;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

public class Socket01Test {

    /**
     * socket是对TCP/IP协议的封装，它的出现只是使得程序员更方便地使用TCP/IP协议栈
     * 一旦你成功创建了一个 Socket 类的实例,你可以使用它来发送和接受字节流，并不需要连接（连接是请求TCP服务器的操作）
     *
     * 这里Socket居然也可以不connect,发送http请求，为什么？
     *
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void socketTest1() throws IOException, InterruptedException {

        //先将tomcat启动(8088端口)
        Socket socket = new Socket("localhost", 8088);      //建立一个网络端点（客户端）连接localhost:8088
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //socket.getOutputStream()：socket输出数据到其他地方出口
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));    //socket.getInputStream: socket读取其他地方数据的入口
        System.out.println("local port: " + socket.getLocalPort());

        //使用Socket请求Tomcat首页
        out.println("GET / HTTP/1.1");
        out.println("Host: localhost:8088");
        //out.println("Connection: keep-alive");
        out.println("Connection: Close");
        out.println();

        boolean loop = true;
        StringBuffer sb = new StringBuffer(1024);
        while (loop) {
            if ( in.ready() ) {
                int i=0;
                while (i!=-1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.sleep(50);
        }
        System.out.println(sb.toString());
        socket.close();
    }

    /**
     * Socket代理
     *
     */
    @Test
    public void socketTest2() {
        //Proxy netProxyer = new Proxy();             //定义一个网络代理
        //Socket socket = new Socket(netProxyer);     //客户端Socket连接一个网络代理

    }

}