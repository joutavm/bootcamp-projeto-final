insert into product(name, price, category) values('queijo', 2.0, 'FS');
insert into product(name, price, category) values('presunto', 3.0, 'FS');
insert into warehouse(code) values('a');
insert into section(code, size, warehouse_id) values('a', 10, 1);
insert into section(code, size, warehouse_id) values('secao b', 5, 1);
-- insert into stock(current_quantity, current_temperature, due_date, initial_quantity, manufacturing_date, manufacturing_time, minimum_temperature, product_id) values(2, 10, TO_DATE('05/08/2021', 'DD/MM/YYYY'), 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 5, 1);
-- insert into stock(current_quantity, current_temperature, due_date, initial_quantity, manufacturing_date, manufacturing_time, minimum_temperature, product_id) values(2, 10, TO_DATE('05/08/2021', 'DD/MM/YYYY'), 2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), TO_DATE('17/12/2015', 'DD/MM/YYYY'), 5, 2);