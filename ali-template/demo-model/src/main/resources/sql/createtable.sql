drop table if exists demo.TB_DEMO_USER;

/*==============================================================*/
/* Table: TB_DEMO_USER                                     */
/*==============================================================*/
create table demo.TB_DEMO_USER
(
   USER_ID              int(11) not null auto_increment comment '用户ID',
   LOGIN_ID             char(64) not null comment '登录ID',
   USERNAME             char(64) not null comment '用户姓名',
   PASSWORD             char(32) not null comment '密码',
   EMAIL                char(128) comment '邮箱',
   TEL                  char(32) comment '电话',
   SEX                  char(1) comment '性别:M男,F女',
   STATUS               int(11) not null default 1 comment '状态:1表示有效，0表示无效',
   ADDRESS              char(255) comment '地址',
   BIRTHDAY             timestamp default CURRENT_TIMESTAMP comment '生日',
   LATNNO               char(16) comment '所属地市',
   LOGIN_NUMBER         int(11) comment '登录次数',
   TOKEN                char(64) comment '访问身份',
   EXPIRE_DATE          timestamp comment '身份失效时间',
   LAST_LOGIN_TIME      timestamp comment '最后登录时间',
   CREATE_TIME          timestamp not null comment '创建时间',
   CREATE_PERSON        int(11) comment '创建人',
   UPDATE_TIME          timestamp not null comment '更新时间',
   UPDATE_PERSON        int(11) comment '更新人',
   primary key (USER_ID),
   key AK_TB_DEMO_USER (LOGIN_ID)
);

alter table demo.TB_DEMO_USER comment '用户信息';


