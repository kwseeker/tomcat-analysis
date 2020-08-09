package top.kwseeker.tomcat03.startup;

import top.kwseeker.tomcat03.connector.http.HttpConnector;

/**
 * Web服务器启动类
 */
public final class Bootstrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
