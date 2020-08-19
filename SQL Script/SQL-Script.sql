CREATE DATABASE projecto;

DROP TABLE IF existsusers;
DROP TABLE IF EXISTS accounts;

CREATE TABLE users (
	user_id serial PRIMARY KEY,
	login_name varchar(30),
	pass_word varchar(30),
	end_user varchar(30),
	first_name varchar(30),
	last_name varchar(30),
	date_birth varchar(30),
	);
	
	CREATE TABLE account (
		account_id serial PRIMARY KEY,
		user_id_fk Integer REFERENCES users(user_id),
		account_type varchar(30),
		account_balance varchar(30),
		status varchar(30)
	);
	
	INSERT INTO users (login_name, pass_word, end_user,first_name,last_name, date_birth)
		values('john777', 'Winner777', 'Customer', 'John', 'Smith', '101881'),
		('he11ow0rd', 'mary1234', 'Customer', 'Mary', 'Lu','120578)'',
		(wit08, girl7654, Employee, Rick, Nguyen, 070679')
		('admin1', '08032020', 'Admin', 'Tracy', 'Mai', '102578')
		
		INSERT INTO account ( user_id_fk, account_type, account_balance,status)
			VALUES ('Checking', 1000.00, 'Pending'),
			('Savings', 2000.00,'Approved'),
			('Checking', 3000.00, 'Pending'),
			('Savings', 4000.00,'Approved'),