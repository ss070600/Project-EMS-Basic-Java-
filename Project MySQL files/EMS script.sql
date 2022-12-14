-- create database electricity_management_system;
use electricity_management_system;

create table address(
id int auto_increment primary key,
area varchar(200) not null,
city varchar(200) not null
);

create table consumer(
id int auto_increment primary key,
first_name varchar(200) not null,
last_name varchar(200) not null,
address_id int,
added_on timestamp not null default current_timestamp,
constraint fk_consumer_address foreign key(address_id) references address(id) on delete set null on update cascade
);

create table connection_type(
id int auto_increment primary key,
type enum('Domestic Medium Load','Domestic Heavy Load','Commercial Medium Load','Commercial Heavy Load') not null Unique,
fixed_charge decimal(10,2) not null,
per_unit_charge decimal(10,2) not null
);

create table connections(
id int auto_increment primary key,
consumer_id int not null,
connection_type_id int not null,
old_reading int not null,
added_on timestamp not null default current_timestamp,
constraint fk_connection_consumer foreign key (consumer_id) references consumer(id) on update cascade,
constraint fk_connection_connection_type foreign key (connection_type_id) references connection_type(id) on update cascade
);

create table bill(
id int auto_increment primary key,
connection_id int not null,
consumer_id int not null,
connection_type_id int not null,
date_time timestamp not null default current_timestamp,
old_reading int not null,
new_reading int not null,
billed_units int not null,
total_amount decimal(10,2) not null,
constraint fk_bill_connections foreign key (connection_id) references connections(id) on update cascade,
constraint fk_bill_consumer foreign key (consumer_id) references consumer(id) on update cascade,
constraint fk_bill_connection_type foreign key (connection_type_id) references connection_type(id) on update cascade
);



