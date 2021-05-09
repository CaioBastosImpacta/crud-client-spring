set foreign_key_checks = 0;

delete from client;

set foreign_key_checks = 1;

alter table client auto_increment = 1;

insert into client (id, name, birth) values (1, 'Caio Bastos', '1997-09-24');