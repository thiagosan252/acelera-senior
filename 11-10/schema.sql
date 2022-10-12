drop table if exists professor;
drop table if exists estudante;
drop table if exists pessoa;
drop table if exists endereco;

create table endereco (
	id int auto_increment primary key,
	cidade varchar(100) not null,
    rua varchar(100) not null,
    numero int not null
);

create table pessoa (
	id bigint auto_increment primary key,
	cpf varchar(16) not null,
	nome varchar(100) not null,
    endereco_id int,
    
	CONSTRAINT endereco_fk FOREIGN KEY (endereco_id)
    REFERENCES endereco(id),
    
    unique (`cpf`)
);

create table estudante (
	pessoa_id bigint not null,
    turma varchar(40) null,
    media int null,
    
    CONSTRAINT pessoa_estu_fk FOREIGN KEY (pessoa_id)
    REFERENCES pessoa(id)  ON DELETE CASCADE
);

create table professor (
	pessoa_id bigint not null,
    disciplina varchar(40) null,
    salario int null,
    
    CONSTRAINT pessoa_prof_fk FOREIGN KEY (pessoa_id)
    REFERENCES pessoa(id)  ON DELETE CASCADE
);