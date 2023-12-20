create database agenteMovil;

create table server_central_info
(
	id_c bigserial primary key,
	procesador varchar(50),
	tipo_disco varchar(50),
	velocidad_red varchar(50),
	v_tarj_wifi varchar(50),
	sistema_opertivo varchar(50),
	servidor varchar(50)
);

select * from server_central_info;

insert into server_central_info (procesador,tipo_disco,velocidad_red,v_tarj_wifi,sistema_opertivo,servidor) values ('','','','','','')

