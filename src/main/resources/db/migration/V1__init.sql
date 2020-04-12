CREATE TABLE persons(
	id_person SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
	born_date TIMESTAMP NOT NULL
);
CREATE TABLE accounts(
	id_account SERIAL NOT NULL PRIMARY KEY,
	id_person INTEGER NOT NULL,
	balance NUMERIC NOT NULL,
	daily_withdrawal_limit NUMERIC NOT NULL,
	active_account BOOLEAN NOT NULL,
	account_type INTEGER NOT NULL,
	creation_date TIMESTAMP NOT NULL
);
CREATE TABLE transactions(
	id_transaction SERIAL NOT NULL PRIMARY KEY,
	id_account INTEGER NOT NULL,
	value NUMERIC NOT NULL,
	data_transaction TIMESTAMP NOT NULL
);

ALTER TABLE "accounts" ADD CONSTRAINT account_person_foreignkey FOREIGN KEY (id_person) REFERENCES "persons" (id_person);
ALTER TABLE "transactions" ADD CONSTRAINT account_transaction_foreignkey FOREIGN KEY (id_account) REFERENCES "accounts" (id_account);