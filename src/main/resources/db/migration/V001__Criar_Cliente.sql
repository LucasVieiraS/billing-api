CREATE TABLE IF NOT EXISTS cliente(
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO cliente(nome)
VALUES ('Carlos'), ('André'), ('João'), ('Júlio');