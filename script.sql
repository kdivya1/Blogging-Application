create table users(
id_user int primary key auto_increment not null,
username varchar(40) unique,
password varchar(40),
enabled tinyint
);

insert into users(username,password,enabled) values('admin','admin',1);

create table categories(
id_category int primary key auto_increment not null,
name varchar(40)
);

create table posts(
id_post int primary key auto_increment not null,
title varchar(100),
content text,
id_user int,
username varchar(40),
id_category int,
category varchar(40),
date timestamp,
FOREIGN KEY (id_user) references users(id_user) ON DELETE CASCADE,
FOREIGN KEY (id_category) references categories(id_category) ON DELETE CASCADE
);

create table comments(
id_comment int primary key auto_increment not null,
id_post int,
content text,
author varchar(20),
ip varchar(20),
date timestamp,
FOREIGN KEY (id_post) references posts(id_post) ON DELETE CASCADE
);


create table tags(
id int primary key not null auto_increment,
name varchar(30),
id_post int,
FOREIGN KEY (id_post) references posts(id_post) ON DELETE CASCADE
);