
# Comic Engine

这是一个网上动漫购物网站。在Spring Boot下编写，能够实现用户注册登陆，浏览商品，管理购物车，管理个人付款信息及邮寄地址信息等功能。

## 如何使用

在eclipse中新建一个spring boot项目，选择java 8 version，maven project type。选择项目的执行环境为javaSE-1.8(jre1.8.0_161)。下载本zip文件，解压后将src文件夹及pom文件拷贝到eclipse的项目中并覆盖。创建一个数据库schema，修改application.properties文件中的数据库url并将其指向新建的schema，所有表会在运行期间自动生成。打开MYSQL服务，在eclipse中选择项目run as->Spring Boot App,打开浏览器输入 http://localhost:8080/ 。如果修改过tomcat端口则将上述8080改为修改后的端口号即可。

### 所需软件及运行环境

```
Eclipse
MYSQL
Java 8
Spring Boot 1.43
JavaSE-1.8
Jre1.8.0_161
```

## 运用技术

* Spring Boot 自动配置的MVC框架
* Thymeleaf 模板引擎，代码可读性强于JSP
* Spring Security 管理用户登陆，分配不同权限。只有拥有管理者权限才可添加商品
* MySQL 数据库，存储用户及管理者数据
* Hibernate 全自动orm框架减少了冗杂的SQL语句编写
* Bootstrap 友好的前端界面
* CSS 界面个性化设置
* Maven 方便的jar包管理

## 版本

1.0.0

## 作者

王垠翔（yinxiang wang） 
git:https://github.com/CamXyinxiang
邮箱：491064068@qq.com

## 感谢

* udemy网上课程
* Google
* Stack Overflow
* CSDN
* Prof.Ubal

