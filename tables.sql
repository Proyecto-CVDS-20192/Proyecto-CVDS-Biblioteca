CREATE TABLE IF NOT EXISTS TIPO_RECURSO(
    id INTEGER NOT NULL,
    tipo VARCHAR(50) NOT NUll,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS RECURSO(
    id_interno INTEGER NOT NULL,
    id_tipo INTEGER NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    capacidad INTEGER,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_interno),
    CONSTRAINT fk_recruso_tipoRecurso
        FOREIGN KEY (id_tipo)
        REFERENCES TIPO_RECURSO(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS RECURSO_RENTADO(
    id INTEGER NOT NULL,
    fecha_in DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    id_recurso INTEGER,
    PRIMARY KEY(id),
    CONSTRAINT fk_Rentado_recurso
        FOREIGN KEY(id_recurso)
        REFERENCES RECURSO(id_interno)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

--Poblado
--INSERT into recurso VALUES (1,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (2,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (3,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (4,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (5,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (6,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (7,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (8,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (9,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (10,1,'PC', 'Biblioteca', null , 'Disponible');
--INSERT into recurso VALUES (11,1,'PC', 'Biblioteca', null , 'Disponible');

--INSERT into recurso VALUES (12,3,'PC', 'Biblioteca', 10 , 'Disponible');
--INSERT into recurso VALUES (13,3,'PC', 'Biblioteca', 5 , 'Disponible');
--INSERT into recurso VALUES (14,3,'PC', 'Biblioteca', 5 , 'Disponible');
--INSERT into recurso VALUES (15,3,'PC', 'Biblioteca', 5 , 'Disponible');
--INSERT into recurso VALUES (16,3,'PC', 'Biblioteca', 12 , 'Disponible');
--INSERT into recurso VALUES (17,3,'PC', 'Biblioteca', 20 , 'Disponible');
--INSERT into recurso VALUES (18,3,'PC', 'Biblioteca', 4 , 'Disponible');
--INSERT into recurso VALUES (19,3,'PC', 'Biblioteca', 7 , 'Disponible');
--INSERT into recurso VALUES (20,3,'PC', 'Biblioteca', 9 , 'Disponible');
--INSERT into recurso VALUES (21,3,'PC', 'Biblioteca', 6 , 'Disponible');
--INSERT into recurso VALUES (22,3,'PC', 'Biblioteca', 5 , 'Disponible');

  
