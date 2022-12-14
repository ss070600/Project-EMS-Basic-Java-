CREATE DEFINER=`root`@`localhost` PROCEDURE `registerConnection`(
in iconsumerId int,in iconnectionTypeId int,
in ioldReading int,out newId int)
BEGIN
insert into Connections (consumer_id,connection_type_id,old_reading)values(iconsumerId,iconnectionTypeId,ioldReading);

select id into newId from connections where
consumer_id = iconsumerId and connection_type_id = iconnectionTypeId;
END