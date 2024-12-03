CREATE USER 'pokemon_owner_user'@'%' IDENTIFIED BY '654789';
GRANT ALL PRIVILEGES ON *.* TO 'pokemon_owner_user'@'%' WITH GRANT OPTION;
CREATE schema pokemon_owner_db;

USE pokemon_owner_db;

CREATE TABLE IF NOT EXISTS owners (
	code bigint auto_increment,
    name varchar(25) NOT NULL,
    document_identification bigint NOT NULL,
    main_pokemon_code bigint NOT NULL,
    
    PRIMARY KEY (code)
);

CREATE TABLE IF NOT EXISTS pokemones (
	code bigint auto_increment,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(30) NOT NULL,
    
    primary key (code)
);    

INSERT INTO owners (name, document_identification, main_pokemon_code) VALUES ('Lorena', 98567412, '123');
INSERT INTO owners (name, document_identification, main_pokemon_code) VALUES ('Miguel', 98567420, '321');
INSERT INTO owners (name, document_identification, main_pokemon_code) VALUES ('Jhunior', 98567421, '789');
INSERT INTO owners (name, document_identification, main_pokemon_code) VALUES ('Karla', 98567422, '987');

INSERT INTO pokemones (code, name, type) VALUES ('123', 'Pikachu', 'Eléctrico');
INSERT INTO pokemones (code, name, type) VALUES ('321', 'Charmander', 'Fuego');
INSERT INTO pokemones (code, name, type) VALUES ('789', 'Squirtle', 'Agua');
INSERT INTO pokemones (code, name, type) VALUES ('987', 'Bulbasaur', 'Planta');
INSERT INTO pokemones (code, name, type) VALUES ('456', 'Evee', 'Normal');

DROP TABLE pokemones;
DROP TABLE owners;