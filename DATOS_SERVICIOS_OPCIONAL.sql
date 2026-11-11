-- Ejecutar en SQL Developer SOLO si FIDE_SERVICIOS_TB esta vacia.
-- Para verificar: SELECT * FROM FIDE_SERVICIOS_TB;
INSERT INTO FIDE_SERVICIOS_TB (ID_SERVICIO, NOMBRE, DESCRIPCION, PRECIO, ESTADO) VALUES (1, 'Ceremonia de despedida', 'Organizacion de ceremonia y acompanamiento familiar', 175000, 'ACTIVO');
INSERT INTO FIDE_SERVICIOS_TB (ID_SERVICIO, NOMBRE, DESCRIPCION, PRECIO, ESTADO) VALUES (2, 'Servicio de cremacion', 'Coordinacion de cremacion y entrega de urna', 325000, 'ACTIVO');
INSERT INTO FIDE_SERVICIOS_TB (ID_SERVICIO, NOMBRE, DESCRIPCION, PRECIO, ESTADO) VALUES (3, 'Traslado funerario', 'Transporte especializado', 85000, 'ACTIVO');
COMMIT;
