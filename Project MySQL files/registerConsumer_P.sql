CREATE DEFINER=`root`@`localhost` PROCEDURE `registerConsumer`(
in ifirstName varchar(200),in ilastName varchar(200),
in iaddressId int,out newId int)
BEGIN
insert into consumer (first_name,last_name,address_id) values(ifirstName,ilastName,iaddressId);

select id into newId from consumer 
where first_name = ifirstName and last_name = ilastName 
and address_id = iaddressId;
END