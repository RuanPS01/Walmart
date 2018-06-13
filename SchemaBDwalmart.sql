drop schema walmart;
create schema walmart;
use walmart;

set foreign_key_checks=0;

CREATE TABLE IF NOT EXISTS Produto(
	idProduto INT NOT NULL PRIMARY KEY,
    precoProduto double,
    nomeProduto VARCHAR(50),
    observacao VARCHAR(50),
    empresaProduto VARCHAR(50),
    barcodeProduto VARCHAR(50),
    dataVencimentoProduto VARCHAR(50),
    quantidadeDisponivelProduto INT
);

insert into Produto values('0', '2.00', 'Macarrão', 'É perecível.', 'Maglioni', '0001010100', '12-12-12','15');

CREATE TABLE IF NOT EXISTS Cliente(
	cpfCliente INT NOT NULL PRIMARY KEY,
    nomeCliente VARCHAR(50),
    emailCiente VARCHAR(50),
    telefoneCliente VARCHAR(50),
    enderecoCliente VARCHAR(80),
    nascimentoCliente VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS Remessa(
	idRemessa INT NOT NULL PRIMARY KEY,
    dataRemessa VARCHAR(20),
    horaRemessa VARCHAR(20),
    empresaRemessa VARCHAR(50),
    funcionarioRemessa VARCHAR(20), 	 
    constraint fk_funcRemessa FOREIGN KEY (funcionarioRemessa) REFERENCES Funcionario(nomeFuncionario)
);
drop table if exists Funcionario;
CREATE TABLE IF NOT EXISTS Funcionario(
	cpfFuncionario INT NOT NULL PRIMARY KEY,
    nomeFuncionario VARCHAR(20),
    emailFuncionario VARCHAR(50),
    telefoneFuncionario VARCHAR(50),
    enderecoFuncionario VARCHAR(80),
    nascimentoFuncionario VARCHAR(50),
    usuarioFuncionario varchar(40),
    senhaFuncionario varchar(40)
);
flush privileges;

select * from remessa;
select * from cliente;