package top.kwseeker.tomcat02.servletContainer1.server1;

import org.junit.Test;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1Test {

    @Test
    public void testURLClassLoaderLoadClassFromJar()
            throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String jarAbsFilePath = "/home/lee/.m2/repository/top/kwseeker/tomcat/my-servlet/1.0-SNAPSHOT/my-servlet-1.0-SNAPSHOT.jar";
        File jarFile = new File(jarAbsFilePath);
        URL url = jarFile.toURI().toURL();
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Class<?> primitiveServletClass = classLoader.loadClass("top.kwseeker.tomcat.servlet.PrimitiveServlet");
        Servlet servlet = (Servlet) primitiveServletClass.newInstance();
        servlet.destroy();
    }

    @Test
    public void testURLClassLoaderLoadClassFromJava()
            throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        String path = System.getProperty("user.dir")+File.separator+"webroot"+File.separator+"servlet";
        File classpath = new File(path);
        String repository =(new URL("file", null, classpath.getCanonicalPath() + File.separator)).toString() ;
        System.out.println(repository);
        URL url = new URL(null, repository, (URLStreamHandler) null);
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Class<?> clazz = classLoader.loadClass("top.kwseeker.tomcat.servlet.PrimitiveServlet");
        Servlet servlet = (Servlet) clazz.newInstance();
        servlet.destroy();
    }
}