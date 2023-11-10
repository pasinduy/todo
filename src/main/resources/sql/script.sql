create database test;
use test;

create table user(
    email varchar(35) primary key,
    username varchar(155) not null,
    password text not null,
);

create table tasks(
    id int primary key auto_increment,
    email varchar(35) not null,
    description varchar(255) not null,
    dueDate date not null,
    isCompleted boolean default false not null,
    foreign key (email) references user(email) on delete cascade on update cascade
);