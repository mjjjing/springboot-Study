drop table if exists test;
create table test (
    id bigint not null comment 'id' primary key ,
    name varchar(50) comment  '名称',
    password varchar(50) comment  '密码'
)engine = innodb default charset=utf8mb4 comment = '测试';

insert into test (id, name,password) values (1, '测试',"password");