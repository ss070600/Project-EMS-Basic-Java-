use electricity_management_system;
-- address 
insert into address (area,city) values('cantt','shahjahanpur');
insert into address (area,city) values('town hall','shahjahanpur');
insert into address (area,city) values('modern valley','bareilly');
insert into address (area,city) values('charbagh','lucknow');
insert into address (area,city) values('transport nagar','lucknow');

insert into address (area,city) values('chowk','shahjahanpur');
insert into address (area,city) values('sadar','calcutta');
insert into address (area,city) values('thane','jodhpur');
insert into address (area,city) values('kharar','dehradun');
insert into address (area,city) values('b1 complex','hyderabad');
insert into address (area,city) values('rupnagar','ahemdabad');

-- Consumer
insert into consumer (first_name,last_name,address_id,added_on) values('King','Singh',1,'2022-10-26 06:25:12');
insert into consumer (first_name,last_name,address_id,added_on) values('Kochar','Thakkar',2,'2021-08-18 10:25:43');
insert into consumer (first_name,last_name,address_id,added_on) values('Smith','Kushwaha',3,'2020-07-16 11:25:35');
insert into consumer (first_name,last_name,address_id,added_on) values('John','Rawat',4,'2019-07-06 10:25:12');
insert into consumer (first_name,last_name,address_id,added_on) values('Alice','Ravinuthala',5,'2018-03-21 11:28:10');

insert into consumer (first_name,last_name,address_id,added_on) values('Sandeep','Singh',6,'2020-07-16 11:25:35');
insert into consumer (first_name,last_name,address_id,added_on) values('Tripti','Kushwaha',7,'2019-07-06 10:25:12');
insert into consumer (first_name,last_name,address_id,added_on) values('Falguni','Thakkar',8,'2018-03-21 11:28:10');
insert into consumer (first_name,last_name,address_id,added_on) values('Himanshu','Rawat',9,'2021-08-18 10:25:43');
insert into consumer (first_name,last_name,address_id,added_on) values('Mrudula','Ravinuthala',10,'2022-08-26 06:25:12');
insert into consumer (first_name,last_name,address_id,added_on) values('Pournima','Kashid',11,'2021-10-28 06:25:12');

-- connection_type
insert into connection_type (type,fixed_charge,per_unit_charge) values(1,200.91,6.36);
insert into connection_type (type,fixed_charge,per_unit_charge) values(2,350.45,6.20);
insert into connection_type (type,fixed_charge,per_unit_charge) values(3,490.86,5.86);
insert into connection_type (type,fixed_charge,per_unit_charge) values(4,700.95,4.38);

-- Connections
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(5,1,2356,'2018-03-21 11:28:10');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(8,2,2296,'2018-03-21 11:28:10');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(4,2,2618,'2019-07-06 10:25:12');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(7,3,2198,'2019-07-06 10:25:12');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(3,4,2349,'2020-07-16 11:25:35');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(6,1,2481,'2020-07-16 11:25:35');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(2,2,2364,'2021-08-18 10:25:43');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(9,4,2618,'2021-08-18 10:25:43');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(11,2,2165,'2021-10-28 06:25:12');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(10,2,2148,'2022-08-26 06:25:12');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(1,1,2349,'2022-10-26 06:25:12');

-- connections same consumers with different type of connections
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(6,4,2416,'2021-03-08 11:25:35');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(3,2,2782,'2021-04-07 11:25:35');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(11,1,2416,'2022-08-23 06:25:12');
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(8,3,2496,'2019-03-26 11:28:10');

-- bill
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(1,5,1,'2018-04-21 11:28:10',0,2356,2356,50186.93);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(2,8,2,'2018-04-21 11:28:10',0,2296,2296,51632.82);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(3,4,2,'2019-08-06 10:25:12',0,2198,2198,47362.16);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(4,7,3,'2019-08-06 10:25:12',0,2349,2349,48165.36);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(5,3,4,'2020-08-16 11:25:35',0,2481,2418,48356.12);

insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(6,6,1,'2020-08-16 11:25:35',0,2618,2618,55165.23);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(7,2,2,'2021-09-18 10:25:43',0,2148,2148,53124.89);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(8,9,4,'2021-12-18 10:25:43',0,2349,2349,49145.90);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(9,11,2,'2021-11-28 06:25:12',0,2416,2416,55165.23);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(10,10,2,'2022-09-26 06:25:12',0,2416,2416,53165.78);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(11,1,1,'2022-11-26 06:25:12',0,2496,2496,45963.16);

-- bills of same consumers with different connection types
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(15,8,3,'2019-04-26 11:28:10',0,2618,2618,47199.32);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(12,6,4,'2021-05-08 11:25:35',0,2165,2165,55165.23);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(13,3,2,'2021-12-07 11:25:35',0,2364,2364,51324.86);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(14,11,1,'2022-09-23 06:25:12',0,2782,2782,53194.14);

/*
select count(*) from address;
select count(*) from consumer;
select count(*) from connection_type;
select count(*) from connections;
select count(*) from bill;
*/
/*

-- connections same consumers with different type of connections
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(6,4,1163,'2021-03-08 11:25:35');2
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(3,2,5632,'2021-04-07 11:25:35');3
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(11,1,4126,'2022-08-23 06:25:12');4
insert into Connections (consumer_id,connection_type_id,old_reading,added_on)values(8,3,6789,'2019-03-26 11:28:10');1

insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(2,8,3,'2019-03-26 11:28:10',7101,0,0,0);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(6,6,4,'2021-03-08 11:25:35',8623,0,0,0);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(5,3,2,'2021-04-07 11:25:35',5667,0,0,0);
insert into bill (connection_id,consumer_id,connection_type_id,date_time,old_reading,new_reading,billed_units,total_amount)values(9,11,1,'2022-08-23 06:25:12',4365,0,0,0);


select c.id,c.added_on from consumer c order by added_on asc;

select concat('(',cs.id,',',cs.consumer_id,',',cs.connection_type_id,',\'',cs.added_on,'\',',cs.old_reading,',','0',',','0',',','0',');') as val  
from connections cs join consumer co on cs.consumer_id = co.id
order by cs.added_on asc;

(1,5,1,'2018-03-21 11:28:10',5362,0,0,0);
(2,8,2,'2018-03-21 11:28:10',5222,0,0,0);
(3,4,2,'2019-07-06 10:25:12',5632,0,0,0);
(4,7,3,'2019-07-06 10:25:12',6358,0,0,0);
(5,3,4,'2020-07-16 11:25:35',8365,0,0,0);
(6,6,1,'2020-07-16 11:25:35',5123,0,0,0);
(7,2,2,'2021-08-18 10:25:43',5648,0,0,0);
(8,9,4,'2021-08-18 10:25:43',9643,0,0,0);
(9,11,2,'2021-10-28 06:25:12',5986,0,0,0);
(10,10,2,'2022-08-26 06:25:12',8236,0,0,0);
(11,1,1,'2022-10-26 06:25:12',4369,0,0,0);
*/


