package top.kwseeker.tomcat02.servletContainer1;

import java.io.File;

public class Constants {

  public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "design-philosophy" + File.separator + "webroot";
  public static final String SERVLET_ROOT = WEB_ROOT + File.separator + "servlet";
}
