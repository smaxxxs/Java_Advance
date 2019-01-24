drop database if exists magazines;

create database magazines char set UTF8;
use magazines;
create table list (
id int not null primary key auto_increment,
name varchar(120) not null,
price decimal (5,2) default 0.00
);

insert into  list (name,price) values 
("Moto",234.32),
("Avto",400),
("PLane",290),
("Boat",150);
SELECT * FROM list;

create table users (
id_user int not null primary key auto_increment,
username varchar(120) unique default "user",
subscribes varchar(360) not null,
pass  varchar(18) 
);
insert into users (username,subscribes,pass) values
("sql","1,3","pass"),
("css","1,4","derdasda");
select * from users;
create table payments(
id_payment int not null primary key auto_increment,
date datetime null default null,
username varchar(120) not null,
description varchar (360) not null,
sum decimal

);
insert into payments (date,username,description,sum) values
(now(),"sql","Moto",234.2);
select * from payments;