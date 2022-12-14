-- drop database electricity_management_system;
use electricity_management_system;
show tables;

-- to show columns of a table
SHOW columns FROM bill;

-- select from all tables
select * from address;
select * from consumer;
select * from connection_type;
select * from connections;
select * from bill;

-- desc from all tables
desc address;
desc bill;
desc connections;
desc connection_type;
desc consumer;

-- date functions
select year(added_on),
month(added_on),
monthname(added_on),
dayname(added_on),
dayofmonth(added_on),
dayofyear(added_on),
hour(added_on),
minute(added_on),
second(added_on) from consumer;

-- misc

select * from connections;
select * from bill;
-- ------------------------------------------------------------------------------------
set @fixedCharge = 0;
set @perUnitCharge = 0;
select fixed_charge,per_unit_charge into @fixedCharge,@perUnitCharge
from connection_type where id = 2;
select @fixedCharge,@perUnitCharge;
-- ------------------------------------------------------------------------------------
select * from connections where id = 6;
set @inp1 = 6;
set @inp2 = 5125;
call generateBillByConnectionId(@inp1, @inp2);
select * from connections where id = 6;

select * from connections;
select * from bill;

select max(new_reading) from bill;
delete from bill where id >= 16;
select * from bill;