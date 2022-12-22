drop database if exists customer_db;

create database customer_db;

use customer_db;

create table customer (
  customer_id int auto_increment not null ,
  emailid varchar(20),
  name varchar(20),
  date_of_birth date, 
  constraint customer_pk primary key (customer_id)
);

insert into customer values (1001,'steven@infy.com', 'Steven Martin', sysdate()-interval 7476 day);
insert into customer values (1002,'kevin@infy.com', 'Kevin Nelson', sysdate()-interval 11374 day);
insert into customer values (1003,'john@infy.com', 'John Matric',sysdate()-interval 12344 day);
insert into customer values (1004,'chan@infy.com', 'Chan Mathew', sysdate()-interval 10344 day);
insert into customer values (1005,'jill@infy.com', 'Jill Mathew', sysdate()-interval 11374 day);

create table card (
  card_id int not null,
  card_number varchar(20),
  expiry_date date,
  cust_id int,
  constraint card_pk primary key (card_id),
  constraint fk_card_cust foreign key (cust_id) references customer(customer_id)
);



insert into card values(12346, '6642160005012193',sysdate()+interval 3400 day,1001);
insert into card values(12347, '6642160005012194',sysdate()+interval 4560 day,1001);
insert into card values(12348, '6642160005012195',sysdate()+interval 1160 day,1001);
insert into card values(12349, '6642160005012196',sysdate()+interval 5660 day,1002);
insert into card values(12350, '6642160005012197',sysdate()+interval 5640 day,1003);
insert into card values(12351, '6642160005012198',sysdate()+interval 5620 day,1003);

commit;


select * from card;
select * from customer;
