insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (0, '2016-06-17', 'My Book description',254, 'My Book1');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (1, '2016-06-18', 'My Book description',254, 'My Book2');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (2, '2016-06-19', 'My Book description',254, 'My Book3');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (3, '2016-06-20', 'My Book description',254, 'My Book4');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (4, '2016-06-21', 'My Book description',254, 'My Book5');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (5, '2016-06-22', 'My Book description',254, 'My Book6');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (6, '2016-06-23', 'My Book description',254, 'My Book7');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (7, '2016-06-24', 'My Book description',254, 'My Book8');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (8, '2016-06-25', 'My Book description',254, 'My Book9');
insert into Produto (id, dataLancamento, descricao, paginas, titulo) values (9, '2016-06-26', 'My Book description',254, 'My Book10');
insert into Produto_precos (Produto_id, tipo, valor) values (0, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (0, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (0, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (1, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (1, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (1, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (2, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (2, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (2, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (3, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (3, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (3, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (4, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (4, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (4, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (5, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (5, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (5, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (6, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (6, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (6, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (7, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (7, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (7, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (8, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (8, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (8, 2, 10);

insert into Produto_precos (Produto_id, tipo, valor) values (9, 0, 5);
insert into Produto_precos (Produto_id, tipo, valor) values (9, 1, 6);
insert into Produto_precos (Produto_id, tipo, valor) values (9, 2, 10);

insert into Role values ('ROLE_ADMIN');
insert into Usuario (email, nome, senha) values ('admin@casadocodigo.com.br', 'Administrador', '$2a$04$qP517gz1KNVEJUTCkUQCY.JzEoXzHFjLAhPQjrg5iP6Z/UmWjvUhq');
insert into Usuario_Role(Usuario_email, roles_nome) values ('admin@casadocodigo.com.br', 'ROLE_ADMIN');
