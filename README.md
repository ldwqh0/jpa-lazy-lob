这是一个JPA Lob字段延迟加载的示例
在某些情况下，我们在设计实体的时候，可能会将一些大字段设计到实体内部，比如一些超长的说明文字等。
但我们在向前端输出接口的时候，可能并不是任何时候都需要这些大的字段。
比如我们向页面输出一个列表时，只需要简单的几个字段即可。
通常情况下，我们通过设计数据传输对象，通过减少数据传输对象中的数据属性来规避服务器到客户端直接的网络流量。
但在使用JPA的时候，当我们获取某个对象时，总会向数据库服务器发送完整的sql语句，如果这个对象有Lob类型的字段，并且正巧里面存入了大量数据的话，就会导致发送大量的查询流量。但这些查询流量我们可能在某次请求中并不需要。
JPA规范本身提供了标准让字段也可以延迟加载。
这个项目演示了如果延迟加载特定字段。
## 项目的下载
```bash
git clone https://github.com/ldwqh0/jpa-lazy-lob.git
```
## 项目的运行
项目提供了两个3个测试方法用户测试，它们位于src/test/java/UserTest中。
* addUser 用于添加一个用户
* loadOnlyName 演示仅仅加载用户name属性的情况
* loadAll 演示加载用户name属性和descript属性的情况
## 结论观察
注意观察控制台输出的SQL语句