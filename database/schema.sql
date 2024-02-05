CREATE SCHEMA `demo-spring-mvc-jdbc` ;
CREATE TABLE `demo-spring-mvc-jdbc`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  commit;
  
  CREATE TABLE `demo-spring-mvc-jdbc`.`SALES` (
   `ID` INT NOT NULL AUTO_INCREMENT,
     `ITEM` VARCHAR(50)  NOT NULL,
    `QUANTITY` INT NOT NULL,
   `AMOUNT` FLOAT(8,2) NOT NULL,
   PRIMARY KEY (`ID` )
);

CREATE TABLE `demo-spring-mvc-jdbc`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `first_name` NVARCHAR(100) NOT NULL,
  `last_name` NVARCHAR(100) NULL,
  `gender` VARCHAR(20) NULL,
  `dateOfBirth` DATETIME NULL,
  `address` NVARCHAR(150) NULL,
  `create_at` TIMESTAMP(2) NULL,
  `modify_at` TIMESTAMP(2) NULL,
  `last_login` TIMESTAMP(2) NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
  ALTER TABLE `demo-spring-mvc-jdbc`.`user` 
CHANGE COLUMN `phone` `phone` VARCHAR(20) NULL ,
CHANGE COLUMN `email` `email` VARCHAR(100) NULL ,
DROP INDEX `email_UNIQUE` ,
DROP INDEX `phone_UNIQUE` ;
;

  
  
  INSERT INTO `demo-spring-mvc-jdbc`.`user` (`idUser`, `username`, `password`, `phone`, `email`, `first_name`, `last_name`) VALUES ('1', 'lamphongthanh1992', '123', '0834636777', 'lamphongthanh1992@gmail.com', 'Thạnh', 'Lâm Phong');
  

