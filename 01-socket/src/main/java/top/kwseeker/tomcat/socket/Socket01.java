package top.kwseeker.tomcat.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 套接字是网络连接的一个端点。套接字使得一个应用可以从网络中读取和写入数据
 * Java套接字的实现：java.net.Socket
 */
public class Socket01 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);  //建立一个网络端点连接localhost:8080

        Socket socket1 = new Socket();  //建立一个网络端点连接localhost:8080

    }
}
