# TCP/IP、Socket与网络IO模型详解

关于`TCP/IP`、`Socket` 还是找几本书浏览下，了解下全貌，形成体系。使用层面就是`Socket API`, 原理层面就是`TCP/IP`协议和套接字实现与封装，高性能就是网络IO模型。



## TCP/IP协议

### 基本概念

+ **网络分层**（7层与5层模型）

  各层功能和相关网络协议。

  网络传输流程案例参考《图解TCP/IP》P1.6.2-P1.6.3。

  分组交换技术（解决众多计算机使用同一条线路同时进行通信，通过给每个数据包或者称分组添加首部定义发送端和接收端的地址实现）。

  分组交换机，类似电路交换机。

+ **WAN & LAN**

+ **网络组件**

  互联网、防火墙、路由器、中继器、交换机、集线器、主机(网卡) ......

+ **网络协议**：IP、TCP、UDP ...
+ **网络地址**：MAC、IP、Port

+ **网络传输分类**：单播、广播、多播、任播
+ **TCP/IP协议是一个协议族**（包含IP、ICMP、TCP、UDP、TELNET、FTP、HTTP等协议）
  + IP: 定位数据包目的地。
  + ICMP: 诊断网络健康状态。
  + ARP: 从IP地址解析MAC地址。
+ **ISP** (网络服务供应商)
+ **VPN**（虚拟专用网络）

### IP协议

Internet Protocol, 属于网络层，网络层除了IP协议还有ICMP(Internet Control Message Protocol)协议。

#### 功能

+ **IP寻址**

  

+ **路由控制**

  将分组的数据发送到最终目标地址。

+ **IP分包与组包**

### Internet地址

### URL & URI

### URLConnnection



## Java Socket







## 附录

+ 参考资料
  + RFC协议官网
  + 《图解TCP/IP》
  + 《TCP IP 详解卷1：协议》
  + 《Java网络编程》
  + 《高性能浏览器网络》