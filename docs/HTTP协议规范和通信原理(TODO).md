# HTTP协议规范和通信原理

## HTTP通信流程原理

首先使用抓包工具`WireShark`看下网络连接过程(`Loopback:Io(port8080)`)：

![](../img/http本地请求数据包.png)

显示经历３次握手然后客户端给服务端发`HTTP Get`请求，然后服务端返回确认收到请求`Ack`,然后返回处理结果，最后是４次分手。

> `WireShark`适用于`TCP`/`UDP`/`HTTP`抓包。
>
> `Charles`适用于`HTTP`/`HTTPS`抓包。

