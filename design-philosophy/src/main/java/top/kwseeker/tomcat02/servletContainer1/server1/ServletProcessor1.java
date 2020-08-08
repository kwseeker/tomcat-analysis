package top.kwseeker.tomcat02.servletContainer1.server1;

import top.kwseeker.tomcat02.servletContainer1.Constants;
import top.kwseeker.tomcat02.servletContainer1.Request;
import top.kwseeker.tomcat02.servletContainer1.Response;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1 {

  public void process(Request request, Response response) {

    String uri = request.getUri();
    String servletName = uri.substring(uri.lastIndexOf("/") + 1);
    URLClassLoader classLoader = null;

    //创建URLClassLoader用于加载Constants.SERVLET_ROOT下的Servlet类
    try {
      File classPath = new File(Constants.SERVLET_ROOT);
      // the forming of repository is taken from the createClassLoader method in org.apache.catalina.startup.ClassLoaderFactory
      String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
      // the code for forming the URL is taken from the addRepository method in org.apache.catalina.loader.StandardClassLoader class.
      URL servletUrl = new URL(null, repository, (URLStreamHandler) null);
      classLoader = new URLClassLoader(new URL[]{servletUrl});
    } catch (IOException e) {
      System.out.println(e.toString());
    }

    //加载类并实例化Servlet,并执行service()
    try {
      assert classLoader != null;
      Class<?> servletClass = classLoader.loadClass(servletName);
      Servlet servlet = (Servlet) servletClass.newInstance();
      servlet.service(request, response);
    } catch (ClassNotFoundException | IOException | IllegalAccessException | ServletException | InstantiationException e) {
      System.out.println(e.toString());
    }
  }
}
