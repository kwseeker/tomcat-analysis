package top.kwseeker.tomcat02.servletContainer1.server1;

import top.kwseeker.tomcat02.servletContainer1.Constants;
import top.kwseeker.tomcat02.servletContainer1.Request;
import top.kwseeker.tomcat02.servletContainer1.Response;

import java.io.*;

public class StaticResourceProcessor {

  private static final int BUFFER_SIZE = 1024;

  public void process(Request request, Response response) {
    try {
      sendStaticResource(request, response);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /* This method is used to serve a static page */
  public void sendStaticResource(Request request, Response response) throws IOException {
    byte[] bytes = new byte[BUFFER_SIZE];
    FileInputStream fis = null;
    OutputStream output = response.getOutputStream();
    try {
      File file = new File(Constants.WEB_ROOT, request.getUri());
      fis = new FileInputStream(file);
      /*
         HTTP Response = Status-Line
           *(( general-header | response-header | entity-header ) CRLF)
           CRLF
           [ message-body ]
         Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
      */
      int ch = fis.read(bytes, 0, BUFFER_SIZE);
      while (ch != -1) {
        output.write(bytes, 0, ch);
        ch = fis.read(bytes, 0, BUFFER_SIZE);
      }
    } catch (FileNotFoundException e) {
      String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
              "Content-Type: text/html\r\n" +
              "Content-Length: 23\r\n" +
              "\r\n" +
              "<h1>File Not Found</h1>";
      output.write(errorMessage.getBytes());
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }
}
