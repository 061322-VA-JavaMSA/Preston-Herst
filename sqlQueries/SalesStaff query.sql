
--Normalizing relational data
--Preston Herst
--06/20/22

--creating table for SalesOffice
DROP TABLE IF EXISTS salesoffice;
CREATE TABLE salesoffice(
officeName varchar(20) primary key,
street varchar(20),
city varchar(20),
state varchar(2),
zipcode varchar(5)
);

--creating table for SalesStaff
DROP TABLE IF EXISTS salesstaff;
CREATE TABLE salesstaff(
employeeid serial PRIMARY KEY,
salesperson varchar(20),
saleslocation varchar(20) REFERENCES salesoffice(officeName),
age integer,
dob date
);

--inserting data into salesoffice
insert into salesoffice(officeName, street, city, state, zipcode)
values('Headquarters', '777 East Ave', 'Panama City', 'FL', '32401');

--viewing data in salesoffice table
select * from salesoffice;

--inserting data into salesstaff table
insert into salesstaff(employeeid, salesperson, saleslocation, age, dob)
values(1, 'John Lewis', 'Headquarters', 23, '1999-05-11');

--viewing data in salesstaff table
select * from salesstaff;