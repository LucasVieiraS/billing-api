CREATE TABLE IF NOT EXISTS contasPagar(
    id INT NOT NULL AUTO_INCREMENT,
    data DATE,
    datavencimento DATE,
    idcliente INT NOT NULL,
    valor DECIMAL(12, 2) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO contasPagar(data, datavencimento, idcliente, valor)
VALUES ('2021/02/20', '2021/03/20', 1, 100),
       ('2023/04/20', '2024/07/20', 1, 6100),
       ('2019/01/05', '2020/02/15', 1, 2500),
       ('2024/03/10', '2026/09/12', 1, 5000);