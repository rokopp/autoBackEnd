CREATE TABLE IF NOT EXISTS marks (
  id            SERIAL PRIMARY KEY,
  car_mark 		VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS pictures (
	id 			SERIAL	PRIMARY KEY,
	file_path	VARCHAR(255) NOT NULL,
	file_name	VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
  id              SERIAL PRIMARY KEY,
  user_name       VARCHAR(20) UNIQUE NOT NULL,
  password		  VARCHAR(20) NOT NULL,
  email			  VARCHAR(30) UNIQUE NOT NULL,
  phone_number    VARCHAR(10) NOT NULL		
);

CREATE TABLE IF NOT EXISTS advertisements (
	id 			  SERIAL	PRIMARY KEY,
	car_mark	  INT NOT NULL,
	picture		  INT NOT NULL,
	uploader_ID   INT NOT NULL,
	car_serial_nr VARCHAR(6) UNIQUE NOT NULL,
	description   VARCHAR(255),
	price 		  VARCHAR(7),
	FOREIGN KEY (car_mark)
		REFERENCES marks (id),
	FOREIGN KEY (picture)
		REFERENCES pictures (id),
	FOREIGN KEY (uploader_ID)
		REFERENCES users (id)
);