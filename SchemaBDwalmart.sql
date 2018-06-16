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

drop table if exists remessa;
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

flush privileges;

insert into Produto values('0', '2.00', 'Macarrão', 'É perecível.', 'Maglioni', '0001010100', '12/12/12','15');
insert into funcionario values('0','134999746-30', 'Pedro Polez', 'pedro@internet.feliz', '9998887', 'Rua Margaridas 12', '20/12/95', 'polez', 'root');
insert into funcionario values('0', '10323', 'Ruan Patrick', 'ruan@internet.feliz', '9998887', 'Rua Margaridas 12', '24/01/97', 'ruan', 'root');
select * from remessa;
select * from cliente;
select * from produto;

SELECT * FROM funcionario;