package top.kwseeker.tomcat03.core;

import top.kwseeker.tomcat03.connector.http.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor {

    public void process(HttpRequest request, HttpResponse response) {

        String uri = request.getRequestURI();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader classLoader = null;
        try {
            File classPath = new File(Constants.WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
            URL url = new URL(null, repository, (URLStreamHandler)null);
            classLoader = new URLClassLoader(new URL[]{url});
        } catch (IOException e) {
            System.out.println(e.toString() );
        }

        try {
            Class<?> servletClass = classLoader.loadClass(servletName);
            Servlet servlet = (Servlet) servletClass.newInstance();

            HttpRequestFacade requestFacade = new HttpRequestFacade(request);
            HttpResponseFacade responseFacade = new HttpResponseFacade(response);
            servlet.service(requestFacade, responseFacade);

            ((HttpResponse) response).finishResponse();
        } catch (ClassNotFoundException | IOException | InstantiationException | ServletException | IllegalAccessException e) {
            System.out.println(e.toString());
        }
    }
}