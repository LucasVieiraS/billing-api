ALTER TABLE contaspagar
ADD CONSTRAINT FK_contaspagar_cliente
FOREIGN KEY(idcliente)
REFERENCES cliente(id);
