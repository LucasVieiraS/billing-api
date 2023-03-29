ALTER TABLE contasPagar
ADD CONSTRAINT FK_contasPagar_cliente
FOREIGN KEY(idcliente)
REFERENCES cliente(id);