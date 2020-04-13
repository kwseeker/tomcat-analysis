package top.kwseeker.tomcat.requesthandle;

import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NioEndPoint {

    public void bind() {
        ServerSocketChannel serverSock = ServerSocketChannel.open();
        //省略了部分属性配置（TODO）
        InetSocketAddress addr = new InetSocketAddress("localhost", 8089);
        serverSock.socket().bind(addr, 100);    //连接等待队列最大长度100
        serverSock.configureBlocking(true);
        Selector shardSelector = Selector.open();

        //启动
        NioBlockingSelector nioBlockingSelector = new NioBlockingSelector();
        nioBlockingSelector.open(shardSelector);
    }
}
