DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT(id INTEGER PRIMARY KEY, name VARCHAR(255) NOT NULL, password VARCHAR(20) NOT NULL, gender INTEGER, birthDate VARCHAR(255), place VARCHAR(255), mobile VARCHAR(255));