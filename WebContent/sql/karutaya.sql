drop database if exists karutaya;
create database karutaya;
use karutaya;
create table users(
userid int not null primary key auto_increment,
email varchar(255),
password varchar(255),
username varchar(255)
);

INSERT INTO users VALUES(1,"aaa@gmail.com","111","山田太郎");