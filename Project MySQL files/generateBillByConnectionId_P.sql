CREATE DEFINER=`root`@`localhost` PROCEDURE `generateBillByConnectionId`(in inputId int ,in currentReading int)
BEGIN

declare consumerId int default 0;
declare connectionTypeId int default 0;
declare oldReading int default 0;
declare newReading int default 0;
declare billedUnits int default 0;
declare fixedCharge decimal(10,2) default 0;
declare perUnitCharge decimal(10,2) default 0;
declare totalAmount decimal(10,2) default 0;

select consumer_id,connection_type_id,old_reading into consumerId, connectionTypeId,oldReading
from connections where id = inputId;

select fixed_charge,per_unit_charge into fixedCharge,perUnitCharge
from connection_type where id = connectionTypeId;

set newReading = currentReading;
update connections set old_reading = currentReading where id = inputId;
set billedUnits = newReading - oldReading;
set totalAmount = fixedCharge + (billedUnits * perUnitCharge);

insert into bill 
(connection_id, consumer_id, connection_type_id, old_reading, new_reading, billed_units, total_amount)
values(inputId,consumerId,connectionTypeId,oldReading,newReading,billedUnits,totalAmount);

END