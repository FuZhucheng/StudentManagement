## 这个系列会以逐步掌握Java后端框架为主线来写些基本的项目。希望大家有所收获。

## J2EE项目系列（一）--运用MVC模式及JavaWeb三层框架的学生管理系统。此外，此项目最好结合我的博客来一起看，我在博客中，解释了我的工程架构，我的项目功能等等。
### [J2EE项目系列（一）--学生管理系统](http://blog.csdn.net/Jack__Frost/article/details/53691782)

***
### 一、项目介绍：
#### 总述：一个适合初学者学习MVC架构的J2EE项目--学生管理系统
#### （1）功能介绍：
##### 1.添加管理账号，包括账号、密码，你的名字；
##### 2.登录功能大概流程模式
##### 3.根据姓名查询学生信息，根据姓名删除学生信息,查询所有学生信息，增加学生，修改学生名字。
#### （2）运用的知识：
##### 1.基本数据库知识
##### 2.jsp+servlet+mysql
##### 3.（重点）MVC设计模式的应用
#### （3）导入的jar包：
##### commons-beanutils-1.9.3.jar，commons-logging-1.2.jar，logback-classic-1.1.7.jar，logback-core-1.1.7.jar，mysql-connector-java-5.0.8-bin.jar，slf4j-api-1.7.21.jar
#### （4）建包，如下图：用了个非大型项目分包方式，方便初学者看的方式。
##### 只用两个包管理，一个管理user的，一个管理学生信息的。
#### （5）数据库：
```
//学生表
CREATE TABLE student(
STID INT AUTO_INCREMENT PRIMARY KEY,
STNAME VARCHAR(20),
STSEX VARCHAR(10),
STAGE VARCHAR(10),
STPHONE VARCHAR(20)
);
//管理员表，起这个名我们要注意到，我们在工厂的bean类名为：UserStudent。这两者是必须对应的。
CREATE TABLE userstudent(
userid VARCHAR(30) PRIMARY KEY,
name VARCHAR(30),
password VARCHAR(32)
);
//测试数据
INSERT INTO userstudent(userid,name,password) VALUES ('fuzhu','fuzhu','751197996');
INSERT INTO student(STID,STNAME,STSEX,STAGE,STPHONE) VALUES (123,'fuzhufuzhu',boy','20','13531477062');
```
***
***
## 源码传送门：github地址：[J2EE项目系列（一）--学生管理系统](https://github.com/FuZhucheng/StudentManagement) 喜欢的可以star或fork啦，谢谢！
### 好了，J2EE项目从0开始（一）--学生管理系统。本博客是学习J2EE开始的第一个小项目，这也是J2EE项目从0开始系列的（一），我会把我的理解、思考路线、项目构建一一详细写在这一系列的博客中。欢迎在下面指出错误，共同学习！
### 转载请注明：【JackFrost的博客】     
### 更多内容，可以访问[JackFrost的博客](http://blog.csdn.net/jack__frost?viewmode=contents)


