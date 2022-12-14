use electricity_management_system;

select a.id as BILL_ID,a.date_time as 'DATE & TIME' ,a.connection_id as CONNECTION_ID,a.consumer_id as CONSUMER_ID,
d.first_name as FIRST_NAME,d.last_name as LAST_NAME,e.area as AREA,e.city as CITY,
c.type as TYPE,c.fixed_charge as FIXED_CHARGE,c.per_unit_charge as PER_UNIT_CHARGE,
b.old_reading as LAST_RECORDED_READING,a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join consumer d on d.id = b.consumer_id
join address e on e.id = d.address_id
join connection_type c on c.id = b.connection_type_id
order by BILL_ID;


