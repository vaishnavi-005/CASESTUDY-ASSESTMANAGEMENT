create database assetmanagement;
use assetmanagement;

create table employees(
employee_id int primary key,
ename varchar(50),
department varchar(50),
email varchar(255),
password varchar(100)
);
select * from employees;

create table assets(
assest_id int primary key,
name varchar(50),
type varchar(50),
serialnumber int unique,
purchasedate date,
loaction varchar(50),
status varchar(50),
ownerid int,
foreign key(ownerid) references employees(employee_id)
);
select * from assets;

create table maintenance(
maintenance_id int primary key,
asset_id int,
maintenance_date date,
description varchar(255),
cost decimal(10,2),
foreign key(asset_id) references assets(assest_id)
);
select * from maintenance;


create table allocation(
allocation_id int primary key,
asset_id int,
employee_id int,
allocationdate date,
returndate date,
foreign key(asset_id) references assets(assest_id),
foreign key(employee_id) references employees(employee_id)

);
select * from allocation;

create table reservation(
reservation_id int primary key,
asset_id int,
employee_id int,
reservationdate date,
startdate date,
enddate date,
status varchar(50),
foreign key(asset_id) references assets(assest_id),
foreign key(employee_id) references employees(employee_id)
);
select * from reservation;

