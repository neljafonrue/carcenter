/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.0 		*/
/*  Created On : 04-may.-2022 5:21:58 p.�m. 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `TIPOS_PERSONA` CASCADE
;

/* Create Tables */

CREATE TABLE `TIPOS_PERSONA`
(
	`ID_TIPO_PERSONA` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'C�digo identificador del tipo de persona. Es la llave primaria de la tabla.',
	`NOMBRE` NVARCHAR(30) NOT NULL COMMENT 'Denominaci�n del tipo de persona.',
	`DESCRIPCION` NVARCHAR(100) NOT NULL COMMENT 'Descripci�n detallada del tipo de persona.',
	CONSTRAINT `PK_TIPO_PERSONA` PRIMARY KEY (`ID_TIPO_PERSONA` ASC)
)
COMMENT = 'Tabla donde se almacenan los tipos de persona que se manejan en el sistema.'

;

SET FOREIGN_KEY_CHECKS=1
; 
