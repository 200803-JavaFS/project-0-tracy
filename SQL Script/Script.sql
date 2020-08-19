--CREATE DATABASE demos;
--This a SQL COMMENT.

--DDL commands

	DROP TABLE IF EXISTS avengers;
	
	CREATE TABLE avengers(
			superhero_name VARCHAR(30),
			superhero_power VARCHAR(30),
			real_name VARCHAR(30),
			power_level INTEGER
	);
	
	ALTER TABLE avengers ADD COLUMN active BOOLEAN;

	TRUNCATE TABLE avengers;

	--DML commands
	
	INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 20),
		  ('Hawkeye', 'plucky can-do attitude', 'Clint Barton',55);
	
	UPDATE avengers SET active = FALSE WHERE superhero_name = 'Capt. America';
	UPDATE avengers SET active = TRUE WHERE superhero_name = 'Hawkeye';