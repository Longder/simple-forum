

create table if not exists SYS_USER
(
    id_ bigint auto_increment
        primary key,
    name_ varchar(100) null,
    login_name_ varchar(100) null,
    password_ varchar(100) null
);


insert into SYS_USER(name_, login_name_, password_) values ('管理员','admin','1234');