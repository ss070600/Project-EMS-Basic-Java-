use electricity_management_system;

-- requirement 2
select a.id as BILL_ID,year(a.date_time) as 'YEAR',month(a.date_time) as 'MONTH'
,a.date_time as 'DATE & TIME' ,a.connection_id as CONNECTION_ID,
a.consumer_id as CONSUMER_ID,
c.type as TYPE,
a.new_reading as LAST_RECORDED_READING,a.billed_units as BILLED_UNITS, a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join connection_type c on c.id = b.connection_type_id
order by year(a.date_time),month(a.date_time),a.id;

-- requirement 3a bills of all the consumers (same as above)
select a.id as BILL_ID,year(a.date_time) as 'YEAR',month(a.date_time) as 'MONTH'
,a.date_time as 'DATE & TIME' ,a.connection_id as CONNECTION_ID,
a.consumer_id as CONSUMER_ID,
c.type as TYPE,
a.new_reading as LAST_RECORDED_READING,a.billed_units as BILLED_UNITS, a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join connection_type c on c.id = b.connection_type_id
order by year(a.date_time),month(a.date_time),a.id;

-- requirement 3b for specific city and area
select a.id as BILL_ID,year(a.date_time) as 'YEAR',month(a.date_time) as 'MONTH'
,a.date_time as 'DATE & TIME' ,a.connection_id as CONNECTION_ID,
a.consumer_id as CONSUMER_ID,
c.type as TYPE,
a.new_reading as LAST_RECORDED_READING,a.billed_units as BILLED_UNITS, a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join consumer d on d.id = b.consumer_id
join address e on e.id = d.address_id
join connection_type c on c.id = b.connection_type_id
where e.area = 'chowk' and e.city = 'shahjahanpur'
order by year(a.date_time),month(a.date_time),a.id;


-- requirement 3c
select a.id as BILL_ID,year(a.date_time) as 'YEAR',month(a.date_time) as 'MONTH'
,a.date_time as 'DATE & TIME' ,a.connection_id as CONNECTION_ID,
a.consumer_id as CONSUMER_ID,
c.type as TYPE,
a.new_reading as LAST_RECORDED_READING,a.billed_units as BILLED_UNITS, a.total_amount as AMOUNT
from bill a
join connections b on a.connection_id = b.id
join connection_type c on c.id = b.connection_type_id
where year(a.date_time) = '2022' and month(a.date_time)='9'
order by year(a.date_time),month(a.date_time),a.id;




