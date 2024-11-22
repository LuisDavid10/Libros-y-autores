INSERT INTO public.persona(
	 nombre, apaterno, amaterno, telefono, correo, edad, id_usuario)
	VALUES 
('Luis', 'García', 'Martínez', '1234567890', 'luis.garcia@example.com', 25,1),
('Ana', 'Pérez', 'López', '1234567891', 'ana.perez@example.com', 30,2),
('Juan', 'Sánchez', NULL, '1234567892', 'juan.sanchez@example.com', 22, 5),
('María', 'Ramírez', 'Hernández', '1234567893', 'maria.ramirez@example.com', 28, 6),
('Carlos', 'Fernández', NULL, '1234567894', 'carlos.fernandez@example.com', 35, 3);


SELECT column_name, data_type, is_nullable
FROM information_schema.columns
WHERE table_name = 'persona';

ALTER TABLE persona ALTER COLUMN id_persona SET DEFAULT nextval('persona_id_persona_seq');


select * FROM persona


SELECT * from editorial


SELECT * from idioma

alter TABLE idioma 

UPDATE public.idioma
	SET id_idioma=1, abreviado='ES', espanol='Español', ingles='Spanish', id_usuario=1
	WHERE id_idioma=1;


	
UPDATE public.idioma
	SET  id_usuario=2
	WHERE id_idioma=2;


	
	
UPDATE public.idioma
	SET  id_usuario=3
	WHERE id_idioma=3;

INSERT INTO public.idioma(
	 abreviado, espanol, ingles, id_usuario)
	VALUES 
('DE', 'Alemán', 'German',5),
('IT', 'Italiano', 'Italian',4);


UPDATE public.idioma
	SET id_idioma=4
	WHERE id_idioma=6;
	

UPDATE public.idioma
	SET id_idioma=5
	WHERE id_idioma=7;

	ALTER SEQUENCE idioma_id_idioma_seq RESTART WITH 6;



	Select * FROM libro


	INSERT INTO libro (titulo, numero_paginas, año_publicacion, precio, id_editorial, id_idioma,id_usuario) VALUES
('Cien Años de Soledad', 417, 1967, 299.99, 1, 1, 1),
('Don Quijote de la Mancha', 863, 1605, 499.50, 2, 1, 2),
('1984', 328, 1949, 350.00, 3, 2, 5),
('El Principito', 96, 1943, 150.00, 4, 3, 3),
('Moby Dick', 635, 1851, 399.99, 5, 2, 6);


SELECT * FROM prestamo


INSERT INTO prestamo (fecha_prestamo, fecha_devolucion,id_usuario) VALUES
('2024-11-01', '2024-11-15',1),
('2024-11-02', '2024-11-16',3),
('2024-11-03', '2024-11-17',5),
('2024-11-04', '2024-11-18',2),
('2024-11-05', '2024-11-19',6);


INSERT INTO persona_prestamo (id_prestamo, id_persona) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

SELECT * FROM persona_prestamo

INSERT INTO prestamo_libro (id_prestamo, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

	
SELECT * FROM prestamo_libro


select * from usuarios