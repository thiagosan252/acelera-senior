DROP TABLE IF EXISTS coordenador;
DROP TABLE IF EXISTS gerente;
DROP TABLE IF EXISTS salario;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS endereco;

CREATE TABLE endereco (
	id int primary key not null,
	rua varchar(100) not null,
    estado varchar(100) not null,
	numero integer not null
);

CREATE TABLE funcionario (
	nome varchar(100) not null,
    cpf varchar(14) primary key not null,
    endereco_id int null,
    
    CONSTRAINT endereco_fk FOREIGN KEY (endereco_id)
    REFERENCES endereco(id) 

);

CREATE TABLE salario (
	cpf_funcionario varchar(14) not null,
    salario_liquido bigint null,
    
	CONSTRAINT cpf_salario_fk FOREIGN KEY (cpf_funcionario)
    REFERENCES funcionario(cpf) 
);

CREATE TABLE coordenador (
	cpf_funcionario varchar(14) not null,
	loja varchar(100) null,
	meta_loja bigint null,
    
    CONSTRAINT cpf_coordenador_fk FOREIGN KEY (cpf_funcionario)
    REFERENCES funcionario(cpf) 

);

CREATE TABLE gerente (
	cpf_funcionario varchar(14) not null,
    regional varchar(100) null,
	meta_regional bigint null,
    
    CONSTRAINT cpf_gerente_fk FOREIGN KEY (cpf_funcionario)
    REFERENCES funcionario(cpf) 

);