drop table if exists employees;
create table employees(employeeid serial primary key, name varchar(30), username varchar(25), email varchar(40), password varchar(20));

insert into employees(employeeid, name, username, email, password)
values(1, 'john marks', 'jj850', 'jj850@gmail.com', 'password1');
insert into employees(employeeid, name, username, email, password)
values(2, 'Preston Herst', 'phers006', 'phers006@gmail.com', 'pass123');

select * from employees;

drop table if exists customers;
create table customers(customerid serial, name varchar(30), username varchar(25) primary key, email varchar(40), password varchar(20));

insert into customers(customerid, name, username, email, password)
values(1, 'johnny appleseed', 'jojo1', 'jojo01@gmail.com', 'password1');
insert into customers(customerid, name, username, email, password)
values(2, 'Mary Snow', 'msnow007', 'msnow007@gmail.com', 'pass123');

select * from customers;


drop table if exists items;
create table items(carID serial primary key, carYear varchar(4), make varchar(20), model varchar(20), type varchar(10), price int, status varchar(10));

insert into items(carID, carYear, make, model, type, price, status) values (101, '2014', 'Honda', 'Accord', 'Car', 15000, 'For Sale');
insert into items(carID, carYear, make, model, type, price, status) values (102, '2016', 'Nissan', 'Altima', 'Car', 12000, 'For Sale');
insert into items(carID, carYear, make, model,type, price, status) values (103, '2020', 'Toyota', 'Tacoma','Truck', 35000, 'Sold');
insert into items(carID, carYear, make, model,type, price, status) values (104, '2018', 'Ford', 'F-150','Truck', 27000, 'For Sale');
insert into items(carID, carYear, make, model,type, price, status) values (105, '2020', 'Subaru', 'Outlander','SUV', 22000, 'For Sale');

select * from items;

drop table if exists offers;
create table offers(customerid int, username varchar(20) references customers(username), carID int references items(carID), offer int, status varchar(10));
insert into offers(customerid, username, carid, offer, status) values(2, 'msnow007', 101, 32500, 'Pending');
insert into offers(customerid, username, carid, offer, status) values(2, 'msnow007', 104, 26500, 'Pending');
insert into offers(customerid, username, carid, offer, status) values(1, 'jojo1', 101, 14500, 'Pending');

select * from offers;

drop table if exists carsowned;
create table carsowned(customeruser varchar(15) references customers(username), carid int references items(carid));
insert into carsowned(customeruser, carid) values('msnow007', 103);

select * from carsowned;

select customers.employeeid, carsowned.customeruser, items.caryear, items.make, items.model
FROM ((carsowned INNER JOIN customers ON carsowned.customeruser = customers.username) INNER JOIN items ON carsowned.carid = items.carid)
where customers.username = 'msnow007';

select customeruser from carsowned where carid = 103;
