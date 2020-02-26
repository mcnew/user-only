CREATE TABLE IF NOT EXISTS `profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `id_profile` INT NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_user_profile1_idx` (`id_profile` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_user_profile1`
    FOREIGN KEY (`id_profile`)
    REFERENCES `profile` (`id`));

CREATE TABLE IF NOT EXISTS `role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

CREATE TABLE IF NOT EXISTS `permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  `code_a` VARCHAR(15) NOT NULL,
  `code_b` VARCHAR(5) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

CREATE TABLE IF NOT EXISTS `role_permission` (
  `id_role` INT NOT NULL,
  `id_permission` INT NOT NULL,
  INDEX `fk_role_permission_role_idx` (`id_role` ASC),
  INDEX `fk_role_permission_permission1_idx` (`id_permission` ASC),
  PRIMARY KEY (`id_permission`, `id_role`),
  CONSTRAINT `fk_role_permission_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `role` (`id`),
  CONSTRAINT `fk_role_permission_permission1`
    FOREIGN KEY (`id_permission`)
    REFERENCES `permission` (`id`));

CREATE TABLE IF NOT EXISTS `profile_role` (
  `id_profile` INT NOT NULL,
  `id_role` INT NOT NULL,
  INDEX `fk_profile_role_profile1_idx` (`id_profile` ASC),
  INDEX `fk_profile_role_role1_idx` (`id_role` ASC),
  PRIMARY KEY (`id_role`, `id_profile`),
  CONSTRAINT `fk_profile_role_profile1`
    FOREIGN KEY (`id_profile`)
    REFERENCES `profile` (`id`),
  CONSTRAINT `fk_profile_role_role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `role` (`id`));
