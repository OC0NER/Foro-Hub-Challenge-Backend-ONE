create table usuarios (
    id bigint not null auto_increment primary key,
    username varchar(100) not null,
    pass varchar(300) not null
);