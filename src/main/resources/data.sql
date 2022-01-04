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
  ownerId uuid NOT NULL,
  accountNumber VARCHAR(250) NOT NULL,
  balance DECIMAL(12,4) NOT NULL DEFAULT 0
);
