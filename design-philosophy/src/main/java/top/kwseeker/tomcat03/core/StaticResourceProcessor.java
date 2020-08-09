package top.kwseeker.tomcat03.core;

import top.kwseeker.tomcat03.connector.http.HttpRequest;
import top.kwseeker.tomcat03.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
