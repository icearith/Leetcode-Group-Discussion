/*

CREATE TABLE `Person` (
  `PersonId` int,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  PRIMARY KEY (`PersonId`)
);

CREATE TABLE `Address` (
  `AddressId` int,
  `PersonId` int,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  PRIMARY KEY (`AddressId`)
);
*/

select FirstName,LastName,City,State
from Person
left join Address on Person.PersonId=Address.PersonId
