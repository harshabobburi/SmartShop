-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema smartshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema smartshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smartshop` DEFAULT CHARACTER SET utf8 ;
USE `smartshop` ;

-- -----------------------------------------------------
-- Table `smartshop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`product` (
  `pr_code` VARCHAR(50) NOT NULL,
  `pr_name` VARCHAR(50) NOT NULL,
  `pr_type` VARCHAR(10) NOT NULL,
  `pr_brand` VARCHAR(50) NOT NULL,
  `pr_quantity_type` VARCHAR(10) NULL DEFAULT NULL,
  `pr_rate_per_quantity` VARCHAR(15) NOT NULL,
  `pr_stock_count` INT(11) NOT NULL,
  `pr_add_date` DATE NOT NULL,
  `pr_aisle` VARCHAR(15) NOT NULL,
  `pr_shelf` VARCHAR(15) NOT NULL,
  `pr_date_of_manufacture` DATE NOT NULL,
  `pr_date_of_expiry` DATE NOT NULL,
  `pr_image` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`pr_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`user` (
  `us_id` VARCHAR(15) NOT NULL,
  `us_firstname` VARCHAR(50) NOT NULL,
  `us_lastname` VARCHAR(50) NOT NULL,
  `us_age` INT(2) NOT NULL,
  `us_gender` VARCHAR(6) NOT NULL,
  `us_contactnumber` VARCHAR(10) NOT NULL,
  `us_password` VARCHAR(75) NOT NULL,
  `us_type` VARCHAR(1) NOT NULL,
  `us_status` VARCHAR(1) NOT NULL,
  `us_secret_question_1` VARCHAR(50) NOT NULL,
  `us_secret_question_2` VARCHAR(50) NOT NULL,
  `us_secret_question_3` VARCHAR(50) NOT NULL,
  `us_secret_answer_1` VARCHAR(50) NOT NULL,
  `us_secret_answer_2` VARCHAR(50) NOT NULL,
  `us_secret_answer_3` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table to save users details';


-- -----------------------------------------------------
-- Table `smartshop`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`purchase` (
  `pu_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pu_us_id` VARCHAR(15) NOT NULL,
  `pu_total_amount` INT(11) NOT NULL,
  `pu_reward_points` INT(11) NULL DEFAULT NULL,
  `pu_date` DATE NOT NULL,
  PRIMARY KEY (`pu_id`),
  INDEX `user_idx` (`pu_us_id` ASC),
  CONSTRAINT `user`
    FOREIGN KEY (`pu_us_id`)
    REFERENCES `smartshop`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `smartshop`.`purchase_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartshop`.`purchase_details` (
  `pd_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pd_pr_code` VARCHAR(50) NOT NULL,
  `pd_quantity` INT(11) NOT NULL,
  `pd_pu_id` INT(11) NOT NULL,
  PRIMARY KEY (`pd_id`),
  INDEX `prodcut_idx` (`pd_pr_code` ASC),
  INDEX `purchase_idx` (`pd_pu_id` ASC),
  CONSTRAINT `prodcut`
    FOREIGN KEY (`pd_pr_code`)
    REFERENCES `smartshop`.`product` (`pr_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `purchase`
    FOREIGN KEY (`pd_pu_id`)
    REFERENCES `smartshop`.`purchase` (`pu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
