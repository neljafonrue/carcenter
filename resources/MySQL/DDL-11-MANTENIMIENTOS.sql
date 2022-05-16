/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.0 		*/
/*  Created On : 05-may.-2022 4:47:48 p.�m. 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `MANTENIMIENTOS` CASCADE
;

/* Create Tables */

CREATE TABLE `MANTENIMIENTOS`
(
	`ID_MANTENIMIENTO` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'C�digo identificador del mantenimiento. Es la llave primaria de la tabla.',
	`MATRICULA_VEHICULO` NVARCHAR(10) NOT NULL COMMENT 'Placa o matr�cula del veh�culo en mantenimiento. Es campo de llave for�nea con la tabla VEHICULOS.',
	`TIPO_DOCUMENTO_MECANICO` INT UNSIGNED NOT NULL COMMENT 'C�digo identificador del tipo de documento de identificaci�n del mec�nico que realiza el mantenimiento. Es campo de llave for�nea con la tabla PERSONAS.',
	`NUMERO_DOCUMENTO_MECANICO` DECIMAL(15,0) NOT NULL COMMENT 'N�mero de documento de identificaci�n del mec�nico que realiza el mantenimiento. Es campo de llave for�nea con la tabla PERSONAS.',
	`ID_TIENDA` INT UNSIGNED NOT NULL COMMENT 'C�digo identificador de la tienda donde se hace el mantenimiento. Es campo de llave for�nea con la tabla TIENDAS.',
	`FECHA_PROGRAMACION` DATE NOT NULL COMMENT 'Fecha y hora en que se programa el mantenimiento.',
	`FECHA_TERMINACION` DATE NULL COMMENT 'Fecha y hora en la que se da por completado o terminado el mantenimiento.',
	`ESTADO` CHAR(1) NOT NULL DEFAULT 'P' COMMENT 'Estado del mantenimiento. Puede ser PROGRAMADO (P), EN DESARROLLO (D), SUSPENDIDO (S) o TERMINADO (T).',
        `ID_FACTURA` INT UNSIGNED NULL COMMENT 'Dato de control de mantenimientos que ya se facturaron'
	CONSTRAINT `PK_MANTENIMIENTOS` PRIMARY KEY (`ID_MANTENIMIENTO` ASC)
)
COMMENT = 'Tabla donde se almacena la programaci�n y estado de los mantenimientos solicitados por los clientes.'

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `MANTENIMIENTOS` 
 ADD CONSTRAINT `CHECK_ESTADO_MANTENIMIENTO` CHECK (ESTADO IN ('P','D','S','T'))
;

ALTER TABLE `MANTENIMIENTOS` 
 ADD INDEX `IDX_MANTENIMIENTOS_PERSONAS` (`TIPO_DOCUMENTO_MECANICO` ASC, `NUMERO_DOCUMENTO_MECANICO` ASC)
;

ALTER TABLE `MANTENIMIENTOS` 
 ADD INDEX `IDX_MATRICULA_VEHICULO` (`MATRICULA_VEHICULO` ASC)
;

ALTER TABLE `MANTENIMIENTOS` 
 ADD INDEX `IXFK_MANTENIMIENTOS_TIENDAS` (`ID_TIENDA` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `MANTENIMIENTOS` 
 ADD CONSTRAINT `FK_MANTENIMIENTOS_PERSONAS`
	FOREIGN KEY (`TIPO_DOCUMENTO_MECANICO`, `NUMERO_DOCUMENTO_MECANICO`) REFERENCES `PERSONAS` (`ID_TIPO_DOCUMENTO`,`NUMERO_DOCUMENTO`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `MANTENIMIENTOS` 
 ADD CONSTRAINT `FK_MANTENIMIENTOS_TIENDAS`
	FOREIGN KEY (`ID_TIENDA`) REFERENCES `TIENDAS` (`ID_TIENDA`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `MANTENIMIENTOS` 
 ADD CONSTRAINT `FK_MANTENIMIENTOS_VEHICULOS`
	FOREIGN KEY (`MATRICULA_VEHICULO`) REFERENCES `VEHICULOS` (`MATRICULA`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1
; 
