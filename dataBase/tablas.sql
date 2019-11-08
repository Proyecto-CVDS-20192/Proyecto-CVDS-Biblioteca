CREATE TABLE TIPO_RECURSO
(id integer NOT NULL,
tipo VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE RECURSO
(id_interno integer NOT NULL,
id_tipo integer NOT NULL,
nombre VARCHAR(50) NOT NULL,
ubicacion VARCHAR(50) NOT NULL,
capacidad integer,
estado BOOLEAN NOT NULL,
PRIMARY KEY (id_interno)
);

CREATE TABLE RECURSO_RENTADO
(id integer NOT NULL,
fecha_ini DATE NOT NULL,
fecha_fin DATE NOT NULL,
id_recurso integer,
PRIMARY KEY (id)
);