/*mostrar todo*/
SELECT * FROM db_mascotas.info_mascotas
ORDER BY id_mascota  /*ASC o DESC*/;

/*insertar info*/
INSERT INTO `db_mascotas`.`info_mascotas`
VALUES
(2,'Canela','Cane',1,'shih tzu',3,'es una bola de pelos chiquita y hermosa');

/*ACTUALIZAR DATOS*/
UPDATE `db_mascotas`.`info_mascotas`
SET
`Nombre_mascota` =  'Rocky'
WHERE Nombre_mascota = 'rocky';

UPDATE `db_mascotas`.`info_mascotas`
SET
`id_mascota` =  3
WHERE Nombre_mascota = 'Canela';
DELETE FROM `db_personas`.`info_personas`
WHERE `Cedula` = 1000285591;

UPDATE `db_personas`.`info_personas`
SET
`Name` = 'Sebastian',
`UserName` = 'orjuelalalaley20',
`Password` = '123456',
`Email` = 'sebasorjuela@gmail.com',
`Cedula` = '1000285591',
`Genero` = 'Masculino',
`Edad` = '20',
`Celular` = 3222263066
WHERE  `Cedula` = 1000285591;



