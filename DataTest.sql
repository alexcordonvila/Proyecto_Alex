-- Inserts para la tabla 'marcas'
INSERT INTO marcas (id, marca) VALUES
(1, 'Dell'),
(2, 'HP'),
(3, 'Apple'),
(4, 'Lenovo'),
(5, 'Acer'),
(6, 'Asus'),
(7, 'MSI'),
(8, 'Toshiba'),
(9, 'Samsung'),
(10, 'Sony');

-- Inserts para la tabla 'modelos'
INSERT INTO modelos (id, modelo, FK_marca) VALUES
(1, 'XPS 13', 1),
(2, 'Inspiron 15', 1),
(3, 'Alienware m15', 1),
(4, 'Latitude 7400', 1),
(5, 'Precision 5550', 1),

(6, 'Pavilion 15', 2),
(7, 'Spectre x360', 2),
(8, 'Omen 17', 2),
(9, 'EliteBook 850', 2),
(10, 'ProBook 450', 2),

(11, 'MacBook Air', 3),
(12, 'MacBook Pro 16', 3),
(13, 'iMac 24"', 3),
(14, 'Mac Mini', 3),
(15, 'Mac Pro', 3),

(16, 'ThinkPad X1', 4),
(17, 'IdeaPad 3', 4),
(18, 'Yoga Slim 7', 4),
(19, 'Legion 5', 4),
(20, 'ThinkBook 14s', 4),

(21, 'Swift 3', 5),
(22, 'Aspire 5', 5),
(23, 'Predator Helios 300', 5),
(24, 'Nitro 5', 5),
(25, 'Spin 5', 5),

(26, 'ZenBook 13', 6),
(27, 'ROG Strix G15', 6),
(28, 'VivoBook S14', 6),
(29, 'TUF Dash F15', 6),
(30, 'ProArt StudioBook', 6),

(31, 'GF63 Thin', 7),
(32, 'Prestige 14', 7),
(33, 'Creator Z16', 7),
(34, 'Katana GF66', 7),
(35, 'Modern 15', 7),

(36, 'Satellite Pro', 8),
(37, 'Tecra A50', 8),
(38, 'Portégé X30', 8),
(39, 'Dynabook E10', 8),
(40, 'L50', 8),

(41, 'Galaxy Book Pro', 9),
(42, 'Galaxy Book Flex', 9),
(43, 'Notebook 9', 9),
(44, 'Chromebook 4', 9),
(45, 'Galaxy Book Odyssey', 9),

(46, 'VAIO Z', 10),
(47, 'VAIO S', 10),
(48, 'VAIO Fit 15E', 10),
(49, 'VAIO Pro 13', 10),
(50, 'VAIO Duo 11', 10);

-- Inserts para la tabla 'ordenadores'
INSERT INTO ordenadores (id, numeroSerie, capacidad, ram, anotaciones, FK_modelo) VALUES
(1, 'SN123456D1', 512, 16, 'Laptop ligero', 1),
(2, 'SN123457D2', 256, 8, 'Con pantalla táctil', 1),
(3, 'SN123458D3', 1024, 32, 'Para gaming', 2),
(4, 'SN123459D4', 512, 16, 'Laptop empresarial', 4),
(5, 'SN123460D5', 2048, 64, 'Estación de trabajo', 5),

(6, 'SN223456H1', 512, 16, 'Laptop para oficina', 6),
(7, 'SN223457H2', 256, 8, 'Convertible con pantalla táctil', 7),
(8, 'SN223458H3', 1024, 32, 'Para gaming', 8),
(9, 'SN223459H4', 512, 16, 'Laptop de alta gama', 9),
(10, 'SN223460H5', 256, 8, 'Modelo económico', 10),

(11, 'SN323456A1', 256, 8, 'Laptop ligero y delgado', 11),
(12, 'SN323457A2', 512, 16, 'Laptop para creadores', 12),
(13, 'SN323458A3', 1024, 32, 'Para diseño gráfico', 13),
(14, 'SN323459A4', 256, 8, 'PC compacto', 14),
(15, 'SN323460A5', 2048, 64, 'Potente para edición de vídeo', 15),

(16, 'SN423456L1', 512, 16, 'Laptop empresarial', 16),
(17, 'SN423457L2', 256, 8, 'Modelo de gama media', 17),
(18, 'SN423458L3', 1024, 32, 'Ultrabook delgado', 18),
(19, 'SN423459L4', 512, 16, 'Para gaming', 19),
(20, 'SN423460L5', 256, 8, 'Laptop empresarial', 20),

(21, 'SN523456AC1', 512, 16, 'Laptop ultradelgado', 21),
(22, 'SN523457AC2', 256, 8, 'Para estudiantes', 22),
(23, 'SN523458AC3', 1024, 32, 'Para gaming', 23),
(24, 'SN523459AC4', 512, 16, 'Laptop económico', 24),
(25, 'SN523460AC5', 256, 8, 'Convertible 2 en 1', 25),

(26, 'SN623456AS1', 512, 16, 'Laptop profesional', 26),
(27, 'SN623457AS2', 1024, 32, 'Para gaming', 27),
(28, 'SN623458AS3', 256, 8, 'Modelo económico', 28),
(29, 'SN623459AS4', 512, 16, 'Laptop para creadores', 29),
(30, 'SN623460AS5', 2048, 64, 'Estación de trabajo potente', 30);
