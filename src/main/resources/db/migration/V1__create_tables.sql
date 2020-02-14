create schema jpa;

create table jpa.person(
	id serial primary key,
	name varchar(255) not null,
	cpf varchar(11) unique not null 
);