CREATE SCHEMA `demo-spring-mvc-jdbc` ;
/*CREATE TABLE `demo-spring-mvc-jdbc`.`customer` (
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
); */

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

  CREATE TABLE `demo-spring-mvc-jdbc`.`category` (
    `id` INT(5) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(100) NOT NULL,
    `notes` VARCHAR(100),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB;


  CREATE TABLE `demo-spring-mvc-jdbc`.`product` (
    `id` INT(10) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `desc` TEXT NOT NULL,
    `SKU` VARCHAR(50) NOT NULL,
    `category_id`  INT(5) DEFAULT '0', /* PK*/
    `price` DECIMAL(6) NOT NULL,
    `discount_id` INT(5) DEFAULT '0', /* PK*/
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP,
    UNIQUE KEY `prod_index` (`id`) USING BTREE,
    UNIQUE KEY `sku_index` (`id`,`SKU`) USING BTREE,
    PRIMARY KEY (`id`)

) ENGINE=InnoDB;


ALTER TABLE  `demo-spring-mvc-jdbc`.`product`
ADD CONSTRAINT `fk_product_category`   FOREIGN KEY (`category_id`)   REFERENCES `demo-spring-mvc-jdbc`.`category` (`id`)  
ON DELETE SET NULL  
ON UPDATE SET NULL
/*
 CONSTRAINT `fk_shopping_user_order`
        FOREIGN KEY (`user_id`)
        REFERENCES `shopping_cart`.`user` (`id`)
        ON DELETE SET NULL
        ON UPDATE SET NULL,
    CONSTRAINT `fk_order_payment`
        FOREIGN KEY (`payment_id`)
        REFERENCES `shopping_cart`.`payment_details` (`id`)
        ON DELETE SET NULL
        ON UPDATE SET NULL */


  CREATE TABLE `demo-spring-mvc-jdbc`.`discount` (
    `id` INT(5) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100),
    `desc` TEXT,
    `discount_percent` DECIMAL(2),
    `active` boolean,
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP
   
) ENGINE=InnoDB;
/* shopping_session */
CREATE TABLE `demo-spring-mvc-jdbc`.`cart_session` ( 
    `id` INT(30) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) DEFAULT NULL,
    `total` DECIMAL(10) NOT NULL DEFAULT '0.00',
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP,
    UNIQUE KEY `session_index` (`id`,`user_id`) USING BTREE,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

/* cart item */
CREATE TABLE `demo-spring-mvc-jdbc`.`cart_session_item` ( 
    `id` INT(30) NOT NULL AUTO_INCREMENT,
    `session id` INT(30) NOT NULL,
    `product_id` INT(10) NOT NULL,
    `quantity` INT
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

/* order_details */
CREATE TABLE `demo-spring-mvc-jdbc`.`order_confirmed` (
    `id` INT(20) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10),
    `total` DECIMAL(10) NOT NULL,
    `payment_id` INT(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP,
    UNIQUE KEY `order_index` (`id`) USING BTREE,
    UNIQUE KEY `customer_order_index` (`id`,`user_id`) USING BTREE,
    PRIMARY KEY (`id`) /*,
    CONSTRAINT `fk_shopping_user_order`
        FOREIGN KEY (`user_id`)
        REFERENCES `shopping_cart`.`user` (`id`)
        ON DELETE SET NULL
        ON UPDATE SET NULL,
    CONSTRAINT `fk_order_payment`
        FOREIGN KEY (`payment_id`)
        REFERENCES `shopping_cart`.`payment_details` (`id`)
        ON DELETE SET NULL
        ON UPDATE SET NULL */
) ENGINE=InnoDB;


  /* order_items */
  CREATE TABLE `demo-spring-mvc-jdbc`.`order_confirmed_details` (
  	`id` INT(20) NOT NULL AUTO_INCREMENT,
  	`order_id` INT(20)
  	`product _id` INT(10)
  	`created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP
  ) ENGINE=InnoDB;

  
  /* payment_details */
    CREATE TABLE `demo-spring-mvc-jdbc`.`payment_details` (
  	`id` INT(20) NOT NULL AUTO_INCREMENT,
  	`order_id` INT(20)
  	`amount` DECIMAL(10)
  	`provider` VARCHAR(100)
  	`status` VARCHAR(100)
  	`created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP
  ) ENGINE=InnoDB;
  
INSERT INTO `demo-spring-mvc-jdbc`.`user` (`idUser`, `username`, `password`, `phone`, `email`, `first_name`, `last_name`) VALUES ('1', 'lamphongthanh1992', '123', '0834636777', 'lamphongthanh1992@gmail.com', 'Thạnh', 'Lâm Phong');
INSERT INTO `demo-spring-mvc-jdbc`.`category` (`id`, `type`, `notes`) VALUES ('0', 'Chung', 'Chung cho quần áo phụ kiện');
INSERT INTO `demo-spring-mvc-jdbc`.`category` (`type`, `notes`) VALUES ('Áo', 'phân loại áo');
INSERT INTO `demo-spring-mvc-jdbc`.`category` (`type`, `notes`) VALUES ('Quần', 'phân loại quần');
INSERT INTO `demo-spring-mvc-jdbc`.`category` (`type`) VALUES ('Phụ Kiện');
INSERT INTO `demo-spring-mvc-jdbc`.`product` (`name`, `desc`, `SKU`, `category_id`, `price`, `discount_id`, `created_at`) VALUES ('Quan Jean', 'Quan Jean Denim', 'sku quan', '3', '20000', '0', CURRENT_TIMESTAMP);
INSERT INTO `demo-spring-mvc-jdbc`.`product` (`name`, `desc`, `SKU`, `category_id`, `price`, `discount_id`, `created_at`) VALUES ('Áo thun', 'Áo thun', 'sku áo', '2', '1000', '0', CURRENT_TIMESTAMP);

