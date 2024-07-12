create table respuestas (
    id bigint auto_increment primary key,
    autor varchar(100) not null,
    mensaje varchar(500) not null,
    fecha_creacion datetime not null,
    id_topico bigint not null
);