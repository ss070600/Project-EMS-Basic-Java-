CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteConnectionByConnectionId`(in inputId int)
BEGIN
declare consumerIdLocal int default 0;
declare addressIdLocal int default 0;
declare consumerCount int default 0;
declare addressCount int default 0;
declare connectionIdCount int;

select count(id) into connectionIdCount from connections where id = inputId;

if connectionIdCount = 0 then
select 'IdNotExists' as output;
else

delete from bill where connection_id =inputId;
select count(consumer_id) into consumerCount from connections where consumer_id = (select consumer_id from connections where id =inputId);
if consumerCount > 1 then
delete from connections where id = inputId;

else

select consumer_id into consumerIdLocal from connections where id =inputId;
delete from connections where id = inputId;

select address_id into addressIdLocal from consumer where id = consumerIdLocal;
select count(address_id) into addressCount from consumer where address_id = addressIdLocal;

if addressCount >1 then
delete from consumer where id = consumerIdLocal;
else
delete from consumer where id = consumerIdLocal;
delete from address where id = addressIdLocal;

end if;

end if;
select 'DeleteSuccessful' as output;
end if;
END