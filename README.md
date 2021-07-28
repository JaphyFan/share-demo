### 前置条件
1. intellij idea(新版自带jdk)
2. chrome 浏览器
3. navicat(可选，用作连接mysql)


### 数据库
当使用内置h2数据库时：
- 启动服务后在浏览器中 输入 http://localhost:8888/h2-console/ 打开h2界面

当使用mysql时
- 替换application.yml 中datasource部分为application-mysql.yml中的，更改url, username 和password
  