-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema webdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema webdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `webdb` DEFAULT CHARACTER SET utf8 ;
USE `webdb` ;

-- -----------------------------------------------------
-- Table `webdb`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu_name` VARCHAR(45) NULL,
  `menu_url` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webdb`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone_no` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `user_type` VARCHAR(45) NULL,
  `created_by` VARCHAR(45) NULL,
  `created_date` DATE NULL,
  `mod_by` VARCHAR(45) NULL,
  `mod_date` DATE NULL,
  `delete_flag` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webdb`.`menu_has_menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`menu_has_menu` (
  `menu_id` INT NOT NULL,
  `menu_id1` INT NOT NULL,
  PRIMARY KEY (`menu_id`, `menu_id1`),
  INDEX `fk_menu_has_menu_menu1_idx` (`menu_id1` ASC),
  INDEX `fk_menu_has_menu_menu_idx` (`menu_id` ASC),
  CONSTRAINT `fk_menu_has_menu_menu`
    FOREIGN KEY (`menu_id`)
    REFERENCES `webdb`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_menu_menu1`
    FOREIGN KEY (`menu_id1`)
    REFERENCES `webdb`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webdb`.`role_menu_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`role_menu_mapping` (
  `menu_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_menu_has_role_role1_idx` (`role_id` ASC),
  INDEX `fk_menu_has_role_menu1_idx` (`menu_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_menu_has_role_menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `webdb`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_menu_has_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `webdb`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `webdb`.`user_role_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `webdb`.`user_role_mapping` (
  `role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  INDEX `fk_role_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_role_has_user_role1_idx` (`role_id` ASC),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  CONSTRAINT `fk_role_has_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `webdb`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `webdb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
