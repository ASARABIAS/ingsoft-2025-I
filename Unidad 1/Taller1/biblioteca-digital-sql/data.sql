INSERT INTO libros (titulo, autor, isbn, categoria, copias, copias_disponibles, fecha_creacion) VALUES 
('Clean Code', 'Robert C. Martin', '9780132350884', 'NORMAL', 5, 5, CURRENT_TIMESTAMP),
('Design Patterns', 'Gang of Four', '9780201633612', 'PREMIUM', 3, 3, CURRENT_TIMESTAMP),
('Refactoring', 'Martin Fowler', '9780201485677', 'PREMIUM', 4, 4, CURRENT_TIMESTAMP),
('Effective Java', 'Joshua Bloch', '9780134685991', 'NORMAL', 6, 6, CURRENT_TIMESTAMP),
('Spring in Action', 'Craig Walls', '9781617294945', 'ESPECIAL', 2, 2, CURRENT_TIMESTAMP),
('Arquitectura Limpia', 'Robert C. Martin', '9780134494166', 'REFERENCIA', 1, 1, CURRENT_TIMESTAMP);

INSERT INTO usuarios (nombre, email, telefono, direccion, tipo_usuario, fecha_registro, activo) VALUES 
('Juan Pérez', 'juan.perez@email.com', '1234567890', 'Calle 1 #123', 'ESTUDIANTE', CURRENT_TIMESTAMP, true),
('María García', 'maria.garcia@email.com', '0987654321', 'Carrera 2 #456', 'PROFESOR', CURRENT_TIMESTAMP, true),
('Carlos López', 'carlos.lopez@email.com', '1122334455', 'Avenida 3 #789', 'ADMINISTRATIVO', CURRENT_TIMESTAMP, true),
('Ana Martínez', 'ana.martinez@email.com', '5544332211', 'Calle 4 #012', 'ESTUDIANTE', CURRENT_TIMESTAMP, true);

INSERT INTO prestamos (usuario_id, libro_id, fecha_prestamo, fecha_devolucion_esperada, estado) VALUES 
(1, 1, CURRENT_TIMESTAMP, TIMESTAMPADD(DAY, 15, CURRENT_TIMESTAMP), 'ACTIVO'),
(2, 2, CURRENT_TIMESTAMP, TIMESTAMPADD(DAY, 30, CURRENT_TIMESTAMP), 'ACTIVO'),
(3, 3, TIMESTAMPADD(DAY, -20, CURRENT_TIMESTAMP), TIMESTAMPADD(DAY, -5, CURRENT_TIMESTAMP), 'VENCIDO');
