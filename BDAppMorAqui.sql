/*drop schema AppMorAqui;*/
create schema AppMorAqui;
use AppMorAqui;

create table locatario(
	CodUsuario int primary key auto_increment,
	Nome varchar(60) not null,
	RG varchar(13),
	CPF varchar(15) not null,
	DataNasc date,
	Endereço varchar(60),
	CEP varchar(11),
	Sexo varchar(15),
	Senha varchar(10),
    Aprovado boolean,
    Fumante boolean,
    Alergias varchar(200)
);

create table locato(
	CodUsuario int primary key auto_increment,
	Nome varchar(60) not null,
	RG varchar(13),
	CPF varchar(15) not null,
	DataNasc date,
	Endereço varchar(60),
	CEP varchar(11),
	Sexo varchar(15),
	Senha varchar(10),
    Aprovado boolean
);

create table gerenciador(
	CodGerenciador int primary key auto_increment,
	Nome varchar(60) not null,
	RG varchar(13),
	CPF varchar(15) not null,
    Senha varchar(10)
);

INSERT INTO locatario (Nome, RG, CPF, DataNasc, Endereço, CEP, Sexo, Senha, Aprovado, Fumante, Alergias) VALUES ('Marcelo','44.122.789-2','123.456.789-10','99-04-10','Rua ali ala', '86300-000', 'Masculino', '123456', false, false, '');
insert into gerenciador (Nome, RG, CPF, Senha) values ('Wagner', '33.777.222-99', '333.777.222-99', '112233');