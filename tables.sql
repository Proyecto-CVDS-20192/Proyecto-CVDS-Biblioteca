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
    estado TINYINT(1) NOT NULL,
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

  