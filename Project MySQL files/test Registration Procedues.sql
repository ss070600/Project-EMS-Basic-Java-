use electricity_management_system;
select * from address;

set @inp1 = 'abc';
set @inp2 = 'xyz';
set @out ='';
call registerAddress(@inp1,@inp2,@out);
select @out;
delete from address where id = 12;

select * from consumer;

set @inp1 = 'abc';
set @inp2 = 'xyz';
set@inp3 = 12;
call registerConsumer(@inp1,@inp2,@inp3);

select * from connections;

set @inp1 = 12;
set @inp2 = 2;
set@inp3 = 5326;
call registerConnection(@inp1,@inp2,@inp3);

set @inp1 = 31;
set @out1 ='';
call doesConnectionIdExists(@inp1,@out1);
select @out1;

call billsOfAllConsumers();

set @inp1 = 'chowk';
set @inp2 ='shahjahanpur';
call billsByCityAndArea(@inp1,@inp2);

set @inp1 = '2022';
set @inp2 ='9';
call billsByMonthAndYear(@inp1,@inp2);
