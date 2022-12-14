CREATE DEFINER=`root`@`localhost` PROCEDURE `billsByCityAndArea`(in iarea varchar(200),in icity varchar(200))
BEGIN
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
where e.area = iarea and e.city = icity
order by year(a.date_time),month(a.date_time),a.id;
END