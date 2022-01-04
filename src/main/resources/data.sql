DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
  id uuid PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  age int NOT NULL,
  nif VARCHAR(15) NOT NULL
);

DROP TABLE IF EXISTS Wallets;

CREATE TABLE Wallets (
  id uuid PRIMARY KEY,
  owner_id uuid NOT NULL,
  account_number VARCHAR(250) NOT NULL,
  balance DECIMAL(12,4) NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS Movements;

CREATE TABLE Movements (
  id uuid PRIMARY KEY,
  wallet_id uuid NOT NULL,
  origin_account VARCHAR(250) NOT NULL,
  destination_account VARCHAR(250) NOT NULL,
  concept VARCHAR(250) NOT NULL,
  type VARCHAR(1) NOT NULL,
  amount DECIMAL(12,4) NOT NULL DEFAULT 0,
  operation_date timestamp without time zone
);
