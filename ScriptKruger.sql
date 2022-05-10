/*1_Borrar base de datos*/
DROP DATABASE "kruger";

/*2_Creacion de la base de datos*/
create database "kruger"

/*3_creacion de las tablas*/
create table employees (
	id_employees serial primary key,
	ci varchar(10) unique not null,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	password varchar(255) not null,
	email VARCHAR (50) unique not null,
	isVaccinated boolean
);

create table roles(
   id_rol serial PRIMARY KEY,
   rol_name VARCHAR (50) UNIQUE NOT NULL
);

create table vaccines (
	id_vaccines serial primary key,
	vaccinType varchar(50) not null,
	dateVaccination Date not null,
	numberDoses Integer not null
);


/*4_Relaciones entre tablas - cardinalidad*/
alter table public.employees add cod_vaccines integer; 

alter table public.employees add constraint vaccines_fk foreign key (cod_vaccines) references public.vaccines(id_vaccines);


alter table public.employees add cod_rol integer;

alter table public.employees add constraint employees_fk foreign key (cod_rol) references public.roles(id_rol);

/*5_insercion de roles de la empresa*/
INSERT INTO public.roles
(rol_name)
VALUES('administrator');

INSERT INTO public.roles
(rol_name)
VALUES('employee');

/*6_comprobar tablas*/
select * from roles;
select * from employees; 
select * from vaccines;

