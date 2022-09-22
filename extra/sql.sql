SET FOREIGN_KEY_CHECKS=0 
;

/* Drop Tables */

DROP TABLE IF EXISTS `Booking` CASCADE
;

DROP TABLE IF EXISTS `ParkingSlot` CASCADE
;

DROP TABLE IF EXISTS `User` CASCADE
;

DROP TABLE IF EXISTS `User_Vehicle` CASCADE
;

DROP TABLE IF EXISTS `Vehicle` CASCADE
;

DROP TABLE IF EXISTS `VehicleBrand` CASCADE
;

/* Create Tables */

CREATE TABLE `Booking`
(
	`id_booking` BIGINT NOT NULL AUTO_INCREMENT,
	`init_date` DATETIME(4) NOT NULL,
	`end_date` DATETIME NOT NULL,
	`id_vehicle` BIGINT NOT NULL,
	`payment_value` DECIMAL(10,2) NOT NULL,
	`payment_status` BOOL NOT NULL,
	`createdAt` TIMESTAMP NOT NULL,
	`updateAt` TIMESTAMP NOT NULL,
	`id_parkingslot` BIGINT NOT NULL,
	CONSTRAINT `PK_Booking` PRIMARY KEY (`id_booking` ASC)
)

;

CREATE TABLE `ParkingSlot`
(
	`id_parkingslot` BIGINT NOT NULL AUTO_INCREMENT,
	`number` VARCHAR(50) NOT NULL,
	`status` VARCHAR(50) NOT NULL,
	CONSTRAINT `PK_ParkingSlot` PRIMARY KEY (`id_parkingslot` ASC)
)

;

CREATE TABLE `User`
(
	`id_user` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50) NOT NULL,
	`address` VARCHAR(50) NOT NULL,
	`role` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`document` VARCHAR(50) NOT NULL,
	`type_document` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50),
	CONSTRAINT `PK_User` PRIMARY KEY (`id_user` ASC)
)

;

CREATE TABLE `User_Vehicle`
(
	`id_user_vehicle` BIGINT NOT NULL AUTO_INCREMENT,
	`id_vehicle` BIGINT NOT NULL,
	`id_user` BIGINT NOT NULL,
	CONSTRAINT `PK_User_Vehicle` PRIMARY KEY (`id_user_vehicle` ASC)
)

;

CREATE TABLE `Vehicle`
(
	`id_vehicle` BIGINT NOT NULL AUTO_INCREMENT,
	`placa` VARCHAR(50) NOT NULL,
	`color` VARCHAR(50) NOT NULL,
	`image` VARCHAR(50) NOT NULL,
	`id_vehiclebrand` BIGINT NOT NULL,
	CONSTRAINT `PK_Vehicle` PRIMARY KEY (`id_vehicle` ASC)
)

;

CREATE TABLE `VehicleBrand`
(
	`id_vehiclebrand` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`brand` VARCHAR(50) NOT NULL,
	CONSTRAINT `PK_VehicleBrand` PRIMARY KEY (`id_vehiclebrand` ASC)
)

;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE `Booking` 
 ADD INDEX `IXFK_Booking_ParkingSlot` (`id_parkingslot` ASC)
;

ALTER TABLE `Booking` 
 ADD INDEX `IXFK_Booking_Vehicle` (`id_vehicle` ASC)
;

ALTER TABLE `User_Vehicle` 
 ADD INDEX `IXFK_User_Vehicle_User` (`id_user` ASC)
;

ALTER TABLE `User_Vehicle` 
 ADD INDEX `IXFK_User_Vehicle_Vehicle` (`id_vehicle` ASC)
;

ALTER TABLE `Vehicle` 
 ADD INDEX `IXFK_Vehicle_VehicleBrand` (`id_vehiclebrand` ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE `Booking` 
 ADD CONSTRAINT `FK_Booking_ParkingSlot`
	FOREIGN KEY (`id_parkingslot`) REFERENCES `ParkingSlot` (`id_parkingslot`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Booking` 
 ADD CONSTRAINT `FK_Booking_Vehicle`
	FOREIGN KEY (`id_vehicle`) REFERENCES `Vehicle` (`id_vehicle`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `User_Vehicle` 
 ADD CONSTRAINT `FK_User_Vehicle_User`
	FOREIGN KEY (`id_user`) REFERENCES `User` (`id_user`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `User_Vehicle` 
 ADD CONSTRAINT `FK_User_Vehicle_Vehicle`
	FOREIGN KEY (`id_vehicle`) REFERENCES `Vehicle` (`id_vehicle`) ON DELETE Restrict ON UPDATE Restrict
;

ALTER TABLE `Vehicle` 
 ADD CONSTRAINT `FK_Vehicle_VehicleBrand`
	FOREIGN KEY (`id_vehiclebrand`) REFERENCES `VehicleBrand` (`id_vehiclebrand`) ON DELETE Restrict ON UPDATE Restrict
;

SET FOREIGN_KEY_CHECKS=1 
;
