package top.kwseeker.tomcat03.connector.http;

/**
 * 请求行
 * 示例：
 *  GET /staticResource HTTP/1.1
 *  method   uri        protocol
 */
final class HttpRequestLine {

    //请求行参数太长的话可以动态扩容
    public static final int INITIAL_METHOD_SIZE = 8;
    public static final int INITIAL_URI_SIZE = 64;
    public static final int INITIAL_PROTOCOL_SIZE = 8;
    public static final int MAX_METHOD_SIZE = 1024;
    public static final int MAX_URI_SIZE = 32768;
    public static final int MAX_PROTOCOL_SIZE = 1024;

    public char[] method;           //GET POST PUT DELETE OPTIONS etc
    public int methodEnd;           //method char数组末尾索引+1, 比如GET，methodEnd=3, 0-2存储"GET"
    public char[] uri;              //请求资源路径 /<path>;<params>?<query>#<frag>，如上请求行的 /staticResource
    public int uriEnd;              //uri char数组末尾索引+1
    public char[] protocol;         //请求协议，如HTTP/1.1
    public int protocolEnd;

    // ----------------------------------------------------------- Constructors

    public HttpRequestLine() {
        this(new char[INITIAL_METHOD_SIZE], 0,
                new char[INITIAL_URI_SIZE], 0,
                new char[INITIAL_PROTOCOL_SIZE], 0);
    }

    public HttpRequestLine(char[] method, int methodEnd,
                           char[] uri, int uriEnd,
                           char[] protocol, int protocolEnd) {
        this.method = method;
        this.methodEnd = methodEnd;
        this.uri = uri;
        this.uriEnd = uriEnd;
        this.protocol = protocol;
        this.protocolEnd = protocolEnd;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Release all object references, and initialize instance variables, in
     * preparation for reuse of this object.
     */
    public void recycle() {
        methodEnd = 0;
        uriEnd = 0;
        protocolEnd = 0;
    }

    /**
     * Test if the uri includes the given char array.
     */
    public int indexOf(char[] buf) {
        return indexOf(buf, buf.length);
    }

    /**
     * Test if the value of the header includes the given char array.
     */
    public int indexOf(char[] buf, int end) {
        char firstChar = buf[0];
        int pos = 0;
        while (pos < uriEnd) {
            pos = indexOf(firstChar, pos);
            if (pos == -1)
                return -1;
            if ((uriEnd - pos) < end)
                return -1;
            for (int i = 0; i < end; i++) {
                if (uri[i + pos] != buf[i])
                    break;
                if (i == (end-1))
                    return pos;
            }
            pos++;
        }
        return -1;
    }

    /**
     * Test if the value of the header includes the given string.
     */
    public int indexOf(String str) {
        return indexOf(str.toCharArray(), str.length());
    }

    /**
     * Returns the index of a character in the value.
     */
    public int indexOf(char c, int start) {
        for (int i=start; i<uriEnd; i++) {
            if (uri[i] == c)
                return i;
        }
        return -1;
    }

    // --------------------------------------------------------- Object Methods

    public int hashCode() {
        // FIXME
        return 0;
    }

    public boolean equals(Object obj) {
        return false;
    }
}

