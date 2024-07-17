# myblog项目

> @author wangkehua

## 项目介绍
实现一个包含用户管理（登录、注册、注销、更新、检索、权限管理）和帖子管理（创建、删除、编辑、更新）的系统
### 使用技术

- Spring Boot 3.3.1
- Spring MVC
- Spring AOP 切面编程
- Spring 事务注解
- MyBatis + MyBatis Plus 数据访问（开启分页）

### 数据存储

- MySQL 数据库
- Redis 内存数据库
- 表结构
```sql 
-- 用户表
create table if not exists user
(
user_id           bigint auto_increment comment 'user_id' primary key,
username  varchar(256)                           not null comment '用户昵称',
password varchar(512)                           not null comment '密码',
email   varchar(1024)                          null comment '用户头像',
userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
created   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
last_modified   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '用户' collate = utf8mb4_unicode_ci;

-- 帖子表
create table if not exists post
(
post_id         bigint auto_increment comment 'post_id' primary key,
title      varchar(512)                       null comment '标题',
content    text                               null comment '内容',
user_id     bigint                             not null comment '创建用户 id',
created datetime default CURRENT_TIMESTAMP not null comment '创建时间',
last_modified datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
isDelete   tinyint  default 0                 not null comment '是否删除',
index idx_userId (user_id)
) comment '帖子' collate = utf8mb4_unicode_ci;
```
### 工具类

- Hutool 工具库
- Apache Commons Lang3 工具类
- Lombok 注解

### 业务特性

- Spring Session Redis 分布式登录
- 全局请求响应拦截器（记录日志）
- 全局异常处理器
- 自定义错误码
- 封装通用响应类
- Swagger + Knife4j 接口文档
- 自定义权限注解 + 全局校验
- 全局跨域处理
- 长整数丢失精度解决


## 业务功能

- 提供示例 SQL（用户、帖子）
- 用户登录、注册、注销、更新、检索、权限管理
- 帖子创建、删除、编辑、更新、数据库检索

### 单元测试

- JUnit5 单元测试
- 示例单元测试类

### 架构设计

- 合理分层



### MySQL 数据库

1）修改 `application.yml` 的数据库配置为你自己的：

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/my_db
    username: root
    password: 123456
```

2）执行 `sql/create_table.sql` 中的数据库语句，自动创建库表

3）启动项目，访问 `http://localhost:8101/api/doc.html` 即可打开接口文档


### Redis 分布式登录

1）修改 `application.yml` 的 Redis 配置为你自己的：

```yml
spring:
  redis:
    database: 1
    host: localhost
    port: 6379
    timeout: 5000
    password: 123456
```

2）修改 `application.yml` 中的 session 存储方式：

```yml
spring:
  session:
    store-type: redis
```




