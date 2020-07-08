# Tomcat设计思想

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



## 设计简单的Web服务器

设计一个简单的Web服务器实现前面说的三件事。

首先需要补习一下HTTP（超文本传输协议）的原理和规范（后面在《HTTP协议规范和通信原理.md》中深入总结）：

+ HTTP请求/响应组成
+ HTTP协议族
+ 基于HTTP协议通信原理

+ TCP/IP通信原理与Socket套接字接口

  从常见的涉及通信的框架底层实现一般都会看到Socket。

## 设计简单的Servlet容器

## 引入连接器

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



