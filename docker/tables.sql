CREATE TABLE IF NOT EXISTS car_mark (
  id            SERIAL PRIMARY KEY,
  car_mark 		VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
  id              SERIAL PRIMARY KEY,
  user_name       VARCHAR(20) UNIQUE NOT NULL,
  password		  VARCHAR(255) NOT NULL,
  token			  VARCHAR(255) UNIQUE NOT NULL,
  email			  VARCHAR(30) UNIQUE NOT NULL,
  phone_number    VARCHAR(10) NOT NULL

);

CREATE TABLE IF NOT EXISTS advertisement (
	id 			  SERIAL	PRIMARY KEY,
	car_mark_id	  INT NOT NULL,
	uploader_ID   INT NOT NULL,
	car_serial_nr VARCHAR(6) UNIQUE NOT NULL,
	description   VARCHAR(255),
	price 		  integer,
	FOREIGN KEY (car_mark_id)
		REFERENCES car_mark (id),
	FOREIGN KEY (uploader_ID)
		REFERENCES account (id)
);

CREATE TABLE IF NOT EXISTS picture (
	id 					SERIAL	PRIMARY KEY,
	file_path			VARCHAR(255) NOT NULL,
	file_name			VARCHAR(255) UNIQUE NOT NULL,
	advertisement_id 	INT NOT NULL,
	FOREIGN KEY (advertisement_id)
		REFERENCES advertisement (id)
);

CREATE TABLE IF NOT EXISTS role (
    id 					SERIAL	PRIMARY KEY,
	name			    VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_role(
    account_id  INT NOT NULL,
    role_id     INT NOT NULL,
    PRIMARY KEY (account_id, role_id),
    FOREIGN KEY (account_id)
		REFERENCES account (id),
	FOREIGN KEY (role_id)
		REFERENCES role (id)
);

INSERT INTO role (name, id) values ('ADMIN', 1);
INSERT INTO role (name, id) values ('USER', 2);
INSERT INTO role (name, id) values ('GUEST', 3);

INSERT INTO account(id, user_name, password, token, email, phone_number) VALUES
(1, 'aaa', '$2a$10$tq..FDKdH4nVCPQVX9Y0tuBd08IparVCBQgRo12khuclEjPegTpCG', 'testiworks', 'wtf', '6656565');

INSERT INTO account_role(account_id, role_id) VALUES (1, 2);
INSERT INTO account_role(account_id, role_id) VALUES (1, 1);

