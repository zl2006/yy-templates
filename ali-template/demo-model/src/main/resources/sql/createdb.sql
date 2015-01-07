--grant all privileges on *.* to root@'%';

--创建数据库
create database if not exists demo default charset utf8 collate utf8_general_ci;

--创建用户
CREATE USER demo  IDENTIFIED  BY 'demo' ;
 
--授权
grant all privileges on demo.* to demo@"%" identified  by 'demo';
grant all privileges on demo.* to demo@"127.0.0.1" identified  by 'demo';
grant all privileges on demo.* to demo@"localhost" identified  by 'demo';
flush privileges;

