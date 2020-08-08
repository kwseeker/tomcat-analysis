package top.kwseeker.tomcat01.socket;

import java.io.*;

/*
  HTTP Response = Status-Line
    *(( general-header | response-header | entity-header ) CRLF)
    CRLF
    [ message-body ]
    Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
*/

public class Response {

    private static final int BUFFER_SIZE = 10240;
    Request request;
    OutputStream output;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);

                StringBuilder body = new StringBuilder();
                int len;
                while ((len = fis.read(bytes, 0, BUFFER_SIZE)) !=-1) {
                    body.append(new String(bytes, 0, len));
                }

                StringBuilder heads = new StringBuilder();
                if(request.getUri().endsWith(".html")) {
                    heads.append("HTTP/1.1 200 OK\r\n")          //注意必须回车换行结尾
                            .append("Content-Type: text/html\r\n")
                            .append(String.format("Content-Length: %d\r\n", body.toString().getBytes().length))
                            .append("\r\n");
                } else if(request.getUri().endsWith(".gif")) {
                    //图片资源
                    heads.append("HTTP/1.1 200 OK\r\n")          //注意必须回车换行结尾
                            //.append("Content-Type: image/gif\r\n")
                            .append("Content-Type: application/octet-stream\r\n")
                            .append("Content-Transfer-Encoding: binary\r\n")
                            .append(String.format("Content-Length: %d\r\n", body.toString().getBytes().length))
                            .append("\r\n");
                }

                System.out.println(heads + "" + body);
                //output.write(heads.toString().getBytes());
                //output.write(body.toString().getBytes());
                PrintWriter writer = new PrintWriter(output, true); //TODO: autoFlush设置true或false为何效果一样,下面body还是可以正常显示？做特殊处理了不写body不flush?
                writer.println(heads.toString());
                writer.println(body.toString());
                //writer.println(heads + "" + body);
                //writer.flush();
            } else {
                // file not found
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        }
        catch (Exception e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString() );
        }
        finally {
            if (fis!=null)
                fis.close();
        }
    }
}
