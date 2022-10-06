DROP TABLE IF EXISTS login;
DROP TABLE IF EXISTS usuario;

create table usuario (
	`id` int auto_increment not null primary key ,
	`name` varchar(100) not null,
    `email` varchar(100) not null,
    `contact` varchar(100) not null,
	unique(`email`)
);

create table login (
	`userId` int not null,
	`username` varchar(45) not null primary key,
    `password` varchar(45) not null,
    
     CONSTRAINT usuario_login_fk FOREIGN KEY (userId)
	 REFERENCES usuario(id)

);