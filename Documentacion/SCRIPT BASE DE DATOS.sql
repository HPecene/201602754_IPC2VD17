CREATE DATABASE PROYECTO;

USE PROYECTO;

CREATE TABLE USUARIO(
id_usuario serial primary key,
nickname varchar(30) not null,
passwd varchar(30) not null,
email varchar(30) not null
);

CREATE TABLE PROYECTO(
id_proyecto serial primary key,
nombreProyecto varchar(30) not null,
id_fundador bigint(20) unsigned not null,
constraint foreign key(id_fundador)
references USUARIO(id_usuario)
);


CREATE TABLE TAREA(
id_tarea serial primary key,
nombreTarea varchar(30) not null,
id_proyecto bigint(20) unsigned not null,
constraint foreign key(id_proyecto)
references PROYECTO(id_proyecto)
);

CREATE TABLE ASOCIACION(
id_asociacion serial primary key,
nombreAsociacion varchar(30) not null,
id_admin bigint(20) unsigned not null,
constraint foreign key(id_admin)
references USUARIO(id_usuario)
);

CREATE TABLE HABILIDAD(
id_habilidad serial primary key,
habilidad varchar(20) not null,
karma int not null,
id_user bigint(20) unsigned not null,
constraint foreign key(id_user)
references USUARIO(id_usuario)
);

CREATE TABLE POST(
id_post serial primary key,
post varchar(1000) not null,
likes int not null,
dislikes int not null,
id_creator bigint(20) unsigned not null,
constraint foreign key(id_creator)
references USUARIO(id_usuario)
);

CREATE TABLE COMENTARIO(
id_comentario serial primary key,
comentario varchar(1000) not null,
id_post bigint(20) unsigned not null,
id_creator bigint(20) unsigned not null,
constraint foreign key(id_post)
references POST(id_post),
constraint foreign key(id_creator)
references USUARIO(id_usuario)
);

CREATE TABLE AMISTAD(
id_amistad serial primary key,
id_user1 bigint(20) unsigned not null,
id_user2 bigint(20) unsigned not null,
constraint foreign key(id_user1)
references USUARIO(id_usuario),
constraint foreign key(id_user2)
references USUARIO(id_usuario)
);
