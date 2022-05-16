/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.0 		*/
/*  Created On : 05-may.-2022 4:48:19 p.�m. 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `DETALLE_MANTENIMIENTOS` CASCADE
;

/* Create Tables */

CREATE TABLE `DETALLE_MANTENIMIENTOS`
(
	`ID_DETALLE_MANTENIMIENTO` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'C�digo identificador del registro de detalle. Es la llave primaria de la tabla.',
	`ID_PRODUCTO` INT UNSIGNED NOT NULL COMMENT 'C�digo identificador del producto relacionado en el mantenimiento. Es campo de llave for�nea con la tabla PRODUCTOS.',
	`ID_MANTENIMIENTO` INT UNSIGNED NOT NULL COMMENT 'C�digo identificador del mantenimiento al que pertenece este detalle. Es campo de llave for�nea con la tabla MANTENIMIENTOS.',
	`CANTIDAD_UTILIZADA` DECIMAL(6,0) NOT NULL COMMENT 'Cantidad de unidades de producto utilizadas en el mantenimiento.',
	CONSTRAINT `PK_DETALLE_MANTENIMIENTOS` PRIMARY KEY (`ID_DETALLE_MANTENIMIENTO` ASC)
)
COMMENT = 'Tabla que almacena el detalle de los mantenimientos efectuados a los veh�culos.'

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `DETALLE_MANTENIMIENTOS` 
 ADD INDEX `IDX_ID_MANTENIMIENTO` (`ID_MANTENIMIENTO` ASC)
;

ALTER TABLE `DETALLE_MANTENIMIENTOS` 
 ADD INDEX `IXFK_DETALLE_MANTENIMIENTOS_PRODUCTOS` (`ID_PRODUCTO` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `DETALLE_MANTENIMIENTOS` 
 ADD CONSTRAINT `FK_DETALLE_MANTENIMIENTOS_MANTENIMIENTOS`
	FOREIGN KEY (`ID_MANTENIMIENTO`) REFERENCES `MANTENIMIENTOS` (`ID_MANTENIMIENTO`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `DETALLE_MANTENIMIENTOS` 
 ADD CONSTRAINT `FK_DETALLE_MANTENIMIENTOS_PRODUCTOS`
	FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `PRODUCTOS` (`ID_PRODUCTO`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
; 