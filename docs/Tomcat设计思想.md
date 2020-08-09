# Tomcat设计思想

文章中仅为个人观点，有大量待考证的地方。

## Tomcat核心设计

**要做的三件事**：

+ 创建request对象，填充请求的参数、头部、cookies、查询字符串、URI等等。

  实现javax.servlet.ServletRequest 或 javax.servlet.http.ServletRequest 接口。

+ 创建response对象，用于将响应发送回客户端。

  实现javax.servlet.ServletResponse 或 javax.servlet.http.ServletResponse 接口。

+ 调用servlet的service方法，并传入request和response对象，从request对象取值，处理，写入response对象。

**Catalina核心架构**：

Connector + Container

连接器是用来“连接”容器里边的请求的，为接收到每一个 HTTP 请求构造一个 request 和 response 对象。

容器从连接器接收到 requset 和 response 对象之后调用 servlet 的 service 方法用于响应。

**设计流程**：

１）Socket实现处理Http请求;

２）引入Servlet接口规范；将业务逻辑抽离到Servlet。



## 设计简单的Web服务器

设计一个简单的Web服务器实现前面说的三件事。

首先需要补习一下HTTP（超文本传输协议）的原理和规范（后面在《HTTP协议规范和通信原理.md》中深入总结）：

+ HTTP请求/响应组成

+ HTTP协议族

+ 基于HTTP协议通信原理

+ TCP/IP通信原理与Socket套接字接口

  从常见的涉及通信的框架底层实现一般都会看到Socket。
  
  处理请求的Socket默认实现类SocksSocketImpl（即使是http请求，在传输层看来也是TCP包）。
  
  而Socket里面有一个FileDescriptor的东西，应该就是对应网络底层设备的“文件”了。
  
  FileDescriptor又被NIO包装了一次。但是数据传输都是通过FileDescriptor。
  
  ```java
  //获取输入输出流
  Socket::getInputStream()
  Socket::getOutputStream()
  ```

最简Web服务器工作流程：

１）创建ServerSocket,并启动8080监听连接accept();

２）有连接(Socket)接入获取输入流getInputStream();读取read()请求处理；

下面已经是经过层层解包，获取的请求报文了。

```txt
GET /staticResource HTTP/1.1
User-Agent: PostmanRuntime/7.22.0
Accept: */*
Cache-Control: no-cache
Postman-Token: 402ed828-5846-44d2-ad7b-2dcee3d89d42
Host: localhost:8080
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
```

３）获取输出流getOutputStream()，将请求处理结果写入write()到输出流；

```java
//这里报文就是一串HTTP Response字符串，没有引入HTTP协议处理（HTTP协议处理的结果也就是这么一串字符串？）
String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
    "Content-Type: text/html\r\n" +
    "Content-Length: 23\r\n" +
    "\r\n" +
    "<h1>File Not Found</h1>";
output.write(errorMessage.getBytes());
```

之后经过层层封包经过物理层传输出去。

４）关闭Socket连接close()。



## 设计简单的Servlet容器

### 核心类(规范)

+ **ServletRequest**

  定义请求的接口，核心包括`输入流`以及读取输入流后获取`请求报文内容`的方法；

  **读输入流->解析请求报文**

+ **ServletResponse**

  定义回复的接口，核心包括`输出流`以及设置`回复报文内容`的方法

  **构造回复报文->写输出流**

  里面还为输出流封装了一个接口Writer.

+ **Servlet**

  前面的类封装了那些比较固定操作，如流读写、报文内容获取或构造；所有的请求的这些操作都是一样的；

  而**Servlet则定义哪些不同的业务流程**，比如商品服务获取商品信息，订单服务下订单等。

  > Servlet 类似多线程的Task, Servlet容器类似多线程的ThreadPoolExecutor

+ **ServletConfig**

### Java.net

+ **URL**

  URL是URI的子集, URI = URL + URN(基本没什么应用); 

  统一资源定位符类;指向www上的某个资源;

  资源可以是文件(文档/图片/视频)/目录/服务(数据库查询)/指向搜索引擎(?)等等;

  ```shell
  # URL的格式
  # URL的第一部分是URL协议，第二部分是服务器的位置，第三部分是资源路径。
  <scheme>://<user>:<password>@<host>:<port>/<path>;<params>?<query>#<frag>
  # 协议方案名      登录信息      服务器地址/端口 资源文件路径 参数 查询字符串 片段标识符 
  # TODO:第三部分定位资源的原理?
  # 示例
  ftp://ftp.is.co.za/rfc/rfc1808.txt
  http://www.ietf.org/rfc/rfc2396.txt
  ldap://[2001:db8::7]/c=GB?objectClass?one
  mailto:John.Doe@example.com
  news:comp.infosystems.www.servers.unix
  tel:+1-816-555-1212
  telnet://192.0.2.16:80/
  urn:oasis:names:specification:docbook:dtd:xml:4.1.2
  ```

  URL支持的协议: http/ftp/file/mailto/telnet/...;

  URL类的数据结构也正是对应着上面`<scheme>://<user>:<password>@<host>:<port>/<path>;<params>?<query>#<frag>`。

+ **URLClassLoader**

  通过URL定位Class资源，然后进行加载。支持从文件目录加载、从Jar包加载、从Http远程加载。

  

## 引入连接器

连接器就是一个Socket服务线程，监听连接请求。并将建立的连接（Socket）交给一个新建的Processor处理（即每建立一个Socket连接都要新建一个Processor处理）。

### 附录

+ ResouceBundle

  用于资源包加载，实现国际化的类。

  

## 将处理封装成容器

## 协作组件的生命周期同步管理

## 加入日志系统

## 容器优化

### 容器内Servlet类的动态加载

### Session会话引入（有状态引入）与管理

#### Session会话的生成保存与cookie在前后端的协作原理

### 访问安全控制

### 容器细化分类设计

#### Wrapper

#### Context

##### 部署器原理

##### Servlet管理器

##### JMX-Based Management

#### Host & Engine

### 引入Server服务器组件

用于优雅地管理连接器和Servlet容器启动关闭，而不需要再一个个地启动和关闭连接器和容器了。

#### Tomcat启动/关闭流程

##### Linux/Unix启动脚本



## 整体优化

### 引入XML实现配置软编码（Disgester）

### 引入关闭钩子

关闭钩子不知在各种源码里见了多少次。



