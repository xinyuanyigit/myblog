# 数据库初始化
# @author wangkehua

-- 创建库
create database if not exists test_db;

-- 切换库
use test_db;

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

