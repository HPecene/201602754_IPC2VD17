CREATE DATABASE Proyecto;

USE Proyecto;

CREATE TABLE adminHD (
	id_admin_hd INT PRIMARY KEY,
	usuarioHD VARCHAR,
	passHD VARCHAR NOT NULL
);

CREATE TABLE usuario (
	id_user INT PRIMARY KEY,
	usuario VARCHAR,
	passUser VARCHAR,
	karma INT,
	foto VARCHAR
);

CREATE TABLE post (
	id_post INT PRIMARY KEY,
	contenido VARCHAR,
	id_creador INT NOT NULL,
	CONSTRAINT fk_id_creador FOREIGN KEY (id_creador) REFERENCES usuario(id_user)
);

CREATE TABLE comentario (
	id_comentario INT PRIMARY KEY,
	contenido VARCHAR,
	id_creador INT NOT NULL,
	id_post INT NOT NULL,
	CONSTRAINT fk_id_creador FOREIGN KEY (id_creador) REFERENCES usuario(id_user),
	CONSTRAINT fk_id_post FOREIGN KEY (id_post) REFERENCES post(id_post)
);

CREATE TABLE asociacion (
	id_asociacion INT PRIMARY KEY,
	nombre VARCHAR,
	objetivo VARCHAR,
	logo VARCHAR,
	id_creador INT,
	CONSTRAINT fk_id_creador FOREIGN KEY (id_creador) REFERENCES usuario(id_user)
);

CREATE TABLE subAdmin (
	id_subAdmin INT PRIMARY KEY,
	id_usuario INT,
	id_asociacion INT,
	CONSTRAINT fk_id_user FOREIGN KEY (id_usuario) REFERENCES usuario(id_user),
	CONSTRAINT fk_id_asociacion FOREIGN KEY (id_asociacion) REFERENCES asociacion(id_asociacion)
);

CREATE TABLE habilidad (
	id_habilidad INT PRIMARY KEY,
	nombre VARCHAR,
	descripcion VARCHAR
	);

CREATE TABLE conocimiento (
	id_conocimiento INT PRIMARY KEY,
	nombre VARCHAR,
	id_habilidad INT,
	CONSTRAINT fk_id_habilidad FOREIGN KEY (id_habilidad) REFERENCES habilidad(id_habilidad)
);

CREATE TABLE conocimientoUser (
	id_CU INT PRIMARY KEY,
	id_usuario INT,
	id_conocimiento INT,
	CONSTRAINT fk_id_user FOREIGN KEY (id_usuario) REFERENCES usuario(id_user),
	CONSTRAINT fk_id_conocimiento FOREIGN KEY (id_conocimiento) REFERENCES conocimiento(id_conocimiento)
);

CREATE TABLE proyecto (
	id_proyecto INT PRIMARY KEY,
	nombre VARCHAR,
	descripcion VARCHAR,
	id_creador INT,
	CONSTRAINT fk_id_creador FOREIGN KEY (id_creador) REFERENCES usuario(id_user)
);

CREATE TABLE detalleUserProyecto (
	id_DUP INT PRIMARY KEY,
	id_usuario INT,
	id_proyecto INT,
	CONSTRAINT fk_id_user FOREIGN KEY (id_usuario) REFERENCES usuario(id_user),
	CONSTRAINT fk_id_proyecto FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
);

CREATE TABLE tarea (
	id_tarea INT PRIMARY KEY,
	nombre VARCHAR,
	descripcion VARCHAR,
	avance INT,
	id_usuario INT,
	id_proyecto INT,
	CONSTRAINT fk_id_user FOREIGN KEY (id_usuario) REFERENCES usuario(id_user),
	CONSTRAINT fk_id_proyecto FOREIGN KEY (id_proyecto) REFERENCES proyecto(id_proyecto)
);