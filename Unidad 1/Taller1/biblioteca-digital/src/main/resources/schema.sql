CREATE TABLE IF NOT EXISTS libros (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                      titulo VARCHAR(255),
    autor VARCHAR(255),
    isbn VARCHAR(20),
    categoria VARCHAR(50),
    copias INT,
    copias_disponibles INT,
    fecha_creacion TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS usuarios (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    tipo_usuario VARCHAR(50),
    fecha_registro TIMESTAMP,
    activo BOOLEAN
    );

CREATE TABLE IF NOT EXISTS prestamos (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         usuario_id BIGINT,
                                         libro_id BIGINT,
                                         fecha_prestamo TIMESTAMP,
                                         fecha_devolucion_esperada TIMESTAMP,
                                         estado VARCHAR(20),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (libro_id) REFERENCES libros(id)
    );