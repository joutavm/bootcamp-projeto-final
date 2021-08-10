insert into product(name, price) values('queijo', 5.0);
insert into product(name, price) values('presunto', 5.0);
insert into warehouse(code) values('a');
insert into section(code, size, warehouse_id) values('a', 10, 1);
insert into section(code, size, warehouse_id) values('secao b', 5, 1);
insert into profiles(role) values ('representante');
insert into profiles(role) values ('comprador');
--12345
insert into integrantes(name, password) values ('jorge', '$2a$10$vviww86InXz7RggmP873pubArXf05vwKGTalArLRZXEFTtD1xZ7cm');
insert into integrantes(name, password) values ('carlos', '$2a$10$vviww86InXz7RggmP873pubArXf05vwKGTalArLRZXEFTtD1xZ7cm');
insert into integrantes_profiles(user_id, profiles_id) values (1, 1);
insert into integrantes_profiles(user_id, profiles_id) values (2, 2);
insert into stock(current_quantity, current_temperature, due_date, initial_quantity, manufacturing_date, manufacturing_time, minimum_temperature, product_id) values(10, 10, TO_DATE('05/08/2021', 'DD/MM/YYYY'), 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 5, 2);
insert into stock(current_quantity, current_temperature, due_date, initial_quantity, manufacturing_date, manufacturing_time, minimum_temperature, product_id) values(10, 10, TO_DATE('05/08/2021', 'DD/MM/YYYY'), 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 5, 1);