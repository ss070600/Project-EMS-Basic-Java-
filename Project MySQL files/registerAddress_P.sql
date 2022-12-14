CREATE DEFINER=`root`@`localhost` PROCEDURE `registerAddress`(
in iarea varchar(200),in icity varchar(200),
out newId int)
BEGIN
insert into address (area,city) values(iarea,icity);

select id into newId from address where area = iarea and city = icity;
END