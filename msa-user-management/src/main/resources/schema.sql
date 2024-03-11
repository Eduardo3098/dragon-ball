-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------

IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE'
AND TABLE_NAME = 'users')
CREATE TABLE users (
                       user_id int IDENTITY(1,1) NOT NULL,
                       user_name varchar(45) NOT NULL,
                       email varchar(45) NOT NULL,
                       password varchar(45) NOT NULL,
                       CONSTRAINT pk_users PRIMARY KEY (user_id),
                       CONSTRAINT uk_user_name UNIQUE (user_name),
                       CONSTRAINT uk_email UNIQUE (email)
);