drop schema walmart;
create schema walmart;
use walmart;

set foreign_key_checks=0;

CREATE TABLE IF NOT EXISTS Produto(
	idProduto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    precoProduto double,
    nomeProduto VARCHAR(50),
    observacao VARCHAR(50),
    empresaProduto VARCHAR(50),
    barcodeProduto VARCHAR(50),
    dataVencimentoProduto VARCHAR(50),
    quantidadeDisponivelProduto INT
);

drop table if exists Cliente;
CREATE TABLE IF NOT EXISTS Cliente(
	idCliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cpfCliente VARCHAR(30) NOT NULL,
    nomeCliente VARCHAR(50),
    emailCiente VARCHAR(50),
    telefoneCliente VARCHAR(50),
    enderecoCliente VARCHAR(80),
    nascimentoCliente VARCHAR(50)
);

drop table if exists Remessa;
CREATE TABLE IF NOT EXISTS Remessa(
	idRemessa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dataRemessa VARCHAR(20),
    horaRemessa VARCHAR(20),
    empresaRemessa VARCHAR(50),
    funcionarioRemessa varchar(30),
    tipoRemessa varchar(40)
);

drop table if exists Funcionario;
CREATE TABLE IF NOT EXISTS Funcionario(

	idFuncionario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	cpfFuncionario VARCHAR(30),
    nomeFuncionario VARCHAR(50),
    emailFuncionario VARCHAR(50),
    telefoneFuncionario VARCHAR(50),
    enderecoFuncionario VARCHAR(80),
    nascimentoFuncionario VARCHAR(50),
    usuarioFuncionario varchar(40),
    senhaFuncionario varchar(40)
);

DELIMITER $$
create procedure alterTablesProcedure()
BEGIN
	ALTER TABLE cliente DROP idCliente;
    ALTER TABLE cliente AUTO_INCREMENT = 1;
    ALTER TABLE cliente ADD idCliente int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
    ALTER TABLE funcionario DROP idFuncionario;
    ALTER TABLE funcionario AUTO_INCREMENT = 1;
    ALTER TABLE funcionario ADD idFuncionario int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
    ALTER TABLE produto DROP idProduto;
    ALTER TABLE produto AUTO_INCREMENT = 1;
    ALTER TABLE produto ADD idProduto int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
    ALTER TABLE remessa DROP idRemessa;
    ALTER TABLE remessa AUTO_INCREMENT = 1;
    ALTER TABLE remessa ADD idRemessa int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;
END $$
DELIMITER ;
CALL alterTablesProcedure();


DELIMITER $$
CREATE FUNCTION insertDataExamples() returns VARCHAR(40)
BEGIN
	insert into Produto values('0', '2.00', 'Macarrão', 'Alimento não perecível.', 'Maglioni', '0001010100', '12/12/12','15');
    insert into Produto values('0', '3.00', 'Leite Integral', 'Alimento perecível.', 'ClasseA', '0001010100', '12/12/12','15');
    insert into Produto values('0', '4.00', 'Margarina', 'Alimento perecível.', 'Qualy', '0001010100', '12/12/12','15');
    insert into Produto values('0', '5.00', 'Manteiga', 'Alimento perecível.', 'Qualy', '0001010100', '12/12/12','15');
    insert into Produto values('0', '6.00', 'Nescal', 'Alimento não perecível.', 'Nestle', '0001010100', '12/12/12','15');
    insert into Produto values('0', '7.00', 'Papel higiênico', 'Limpeza.', 'Mili', '0001010100', '12/12/12','15');
    insert into Produto values('0', '8.00', 'Sabonete', 'Limpeza.', 'Dove', '0001010100', '12/12/12','15');
    insert into Produto values('0', '10.00', 'Detergente', 'Limpeza.', 'Ype', '0001010100', '12/12/12','15');
    insert into Cliente values('','','','','','','');
    insert into Cliente values('','','','','','');
    insert into funcionario values('1','1319', 'Pedrao Polez', 'pedro@internet.feliz', '9998887', 'Rua Margaridas 12', '20/12/95', 'polez', 'root');
	insert into funcionario values('0', '10323', 'Ruan Patrick', 'ruan@internet.feliz', '9998887', 'Rua Margaridas 12', '24/01/97', 'ruan', 'root');
    insert into funcionario values('0', '10323', 'Ensley Ribeiro', 'ensley@internet.feliz', '9998887', 'Rua Margaridas 12', '00/00/00', 'ensley', 'root');
    return 'Dados de exemplo inseridos com sucesso';
END $$
DELIMITER ;
select insertDataExamples();



flush privileges;

insert into Produto values('0', '2.00', 'Macarrão', 'É perecível.', 'Maglioni', '0001010100', '12/12/12','15');
insert into funcionario values('1','1349', 'Pedro Polez', 'pedro@internet.feliz', '9998887', 'Rua Margaridas 12', '20/12/95', 'polez', 'root');
insert into funcionario values('1','1319', 'Pedrao Polez', 'pedro@internet.feliz', '9998887', 'Rua Margaridas 12', '20/12/95', 'polez', 'root');
insert into funcionario values('0', '10323', 'Ruan Patrick', 'ruan@internet.feliz', '9998887', 'Rua Margaridas 12', '24/01/97', 'ruan', 'root');
select * from remessa;
select * from cliente;
select * from produto;
SELECT * FROM funcionario;
#UPDATE cliente set cpfCliente = '00' where emailCiente = 'pedro_hpr@hotmail.com';
