CREATE TABLE IF NOT EXISTS car_mark (
  id            SERIAL PRIMARY KEY,
  car_mark 		VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS account (
  id              SERIAL PRIMARY KEY,
  user_name       VARCHAR(20) UNIQUE NOT NULL,
  password		  VARCHAR(20) NOT NULL,
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
