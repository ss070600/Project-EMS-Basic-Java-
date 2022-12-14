use electricity_management_system;

-- consumers with maximum bill amount
select a.id as BILL_ID,a.connection_id as CONNECTION_ID,a.consumer_id as CONSUMER_ID,
d.first_name as FIRST_NAME,e.city as CITY,
c.type as TYPE,c.fixed_charge as FIXED_CHARGE,
b.old_reading as LAST_RECORDED_READING,a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join consumer d on d.id = b.consumer_id
join address e on e.id = d.address_id
join connection_type c on c.id = b.connection_type_id

where a.total_amount >=(select max(total_amount) from bill x) 
order by BILL_ID;

-- ------------------------------------------------------------------------

-- consumers with minimum bill amount
select a.id as BILL_ID,a.connection_id as CONNECTION_ID,a.consumer_id as CONSUMER_ID,
d.first_name as FIRST_NAME,e.city as CITY,
c.type as TYPE,c.fixed_charge as FIXED_CHARGE,
b.old_reading as LAST_RECORDED_READING,a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join consumer d on d.id = b.consumer_id
join address e on e.id = d.address_id
join connection_type c on c.id = b.connection_type_id

where a.total_amount <=(select min(total_amount) from bill x) 
order by BILL_ID; 