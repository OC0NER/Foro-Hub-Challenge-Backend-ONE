create table topicos (
    id bigint auto_increment primary key,
    autor varchar(100) not null,
    titulo varchar(100) not null unique,
    mensaje varchar(500) not null unique,
    curso varchar(100) not null,
    fecha_creacion datetime not null,
    cantidad_respuestas int not null,
    estado varchar(7) not null
);