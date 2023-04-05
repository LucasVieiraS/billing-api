CREATE TABLE IF NOT EXISTS contaspagar(
    id INT NOT NULL AUTO_INCREMENT,
    data DATE,
    datavencimento DATE,
    idcliente INT NOT NULL,
    valor DECIMAL(12, 2) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO contaspagar(data, datavencimento, idcliente, valor)
VALUES ('2021/02/20', '2021/03/20', 1, 100),
       ('2023/04/20', '2024/07/20', 2, 6100),
       ('2019/01/05', '2020/02/15', 3, 2500),
       ('2024/03/10', '2026/09/12', 4, 5000);
