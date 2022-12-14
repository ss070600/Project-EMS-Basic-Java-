CREATE DEFINER=`root`@`localhost` PROCEDURE `doesConnectionIdExists`(
in inputId int, out result varchar(200)
)
BEGIN
declare count int default 0;
select count(id) into count from connections where id = inputId;

if count >0 then
set result = 'True';
else
set result = 'False';
end if;

END