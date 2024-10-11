-- Tabla Persona
CREATE TABLE persona (
    id_Persona SERIAL PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    APaterno VARCHAR(255) NOT NULL,
    AMaterno VARCHAR(255),
    telefono VARCHAR(20),
    correo VARCHAR(255) UNIQUE,
    edad INT CHECK (Edad >= 0)
);

-- Tabla Editorial
CREATE TABLE editorial (
    id_Editorial SERIAL PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla Genero
CREATE TABLE genero (
    id_Genero SERIAL PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Clasificacion VARCHAR(255)
);

-- Tabla Autor
CREATE TABLE autor (
    id_autor SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apaterno VARCHAR(255) NOT NULL,
    amaterno VARCHAR(255),
    fecha_nacimiento DATE
);

-- Tabla Idioma
CREATE TABLE idioma (
    id_idioma SERIAL PRIMARY KEY,
    abreviado VARCHAR(10) NOT NULL UNIQUE,
    espanol VARCHAR(255) NOT NULL UNIQUE,
    ingles VARCHAR(255) UNIQUE
);

-- Tabla Libro
CREATE TABLE libro (
    id_libro SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    numero_paginas INT CHECK (numero_paginas > 0),
    año_publicacion INT, -- Puedes usar DATE si necesitas el día y mes
    precio DECIMAL(10, 2) CHECK (precio >= 0),
    id_editorial INT NOT NULL,
    id_idioma INT NOT NULL,
    FOREIGN KEY (id_editorial) REFERENCES editorial(id_editorial),
    FOREIGN KEY (id_idioma) REFERENCES idioma(id_idioma)
);

-- Tabla Prestamo
CREATE TABLE prestamo (
    id_prestamo SERIAL PRIMARY KEY,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    CHECK (fecha_devolucion >= fecha_prestamo)
);

-- Tabla Estado
CREATE TABLE estado (
    id_estado SERIAL PRIMARY KEY,
    nombre_estado VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla Ciudad
CREATE TABLE ciudad (
    id_ciudad SERIAL PRIMARY KEY,
    id_estado INT NOT NULL,
    nombre_ciudad VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
);

-- Tabla Colonia
CREATE TABLE colonia (
    id_colonia SERIAL PRIMARY KEY,
    id_ciudad INT NOT NULL,
    nombre_colonia VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad)
);

-- Tabla Domicilio
CREATE TABLE domicilio (
    id_domicilio SERIAL PRIMARY KEY,
    id_colonia INT NOT NULL,
    id_persona INT NOT NULL,
    calle VARCHAR(255) NOT NULL,
    codigo_postal VARCHAR(10),
    numero_exterior VARCHAR(10),
    numero_interior VARCHAR(10),
    FOREIGN KEY (id_colonia) REFERENCES colonia(id_colonia),
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

-- Tabla Persona_has_Prestamo (Relación muchos a muchos entre Persona y Prestamo)
CREATE TABLE persona_prestamo (
    id_prestamo INT NOT NULL,
    id_persona INT NOT NULL,
    PRIMARY KEY (id_prestamo, id_persona),
    FOREIGN KEY (id_prestamo) REFERENCES prestamo(id_prestamo),
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

-- Tabla Prestamo_has_Libro (Relación muchos a muchos entre Prestamo y Libro)
CREATE TABLE prestamo_libro (
    id_prestamo INT NOT NULL,
    id_libro INT NOT NULL,
    PRIMARY KEY (id_prestamo, id_libro),
    FOREIGN KEY (id_prestamo) REFERENCES prestamo(id_prestamo),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Tabla Genero_has_Libro (Relación muchos a muchos entre Genero y Libro)
CREATE TABLE genero_libro (
    id_genero INT NOT NULL,
    id_libro INT NOT NULL,
    PRIMARY KEY (id_genero, id_libro),
    FOREIGN KEY (id_genero) REFERENCES genero(id_genero),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Tabla Autor_has_Libro (Relación muchos a muchos entre Autor y Libro)
CREATE TABLE autor_libro (
    id_autor INT NOT NULL,
    id_libro INT NOT NULL,
    PRIMARY KEY (id_autor, id_libro),
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Tabla Usuarios
CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    cuenta VARCHAR(255) NOT NULL UNIQUE,
    clave VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apaterno VARCHAR(255) NOT NULL,
    amaterno VARCHAR(255)
);
