create table student(
    id int(10) not null auto increment,
    name varchar(20) null,
    age int(10) null,
    constraint PK_T_STUDENT primary key clustered (id)
);

insert into student(name,age) values ("Zhangsan",25);
insert into student(name,age) values ("Lisi",28);
insert into student(name,age) values ("Wangwu",23);