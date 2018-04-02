CREATE TABLE `staff` (
  `StaffID` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `BranchID` int(11) NOT NULL,
  `Lawyer` bit(1) NOT NULL,
  `Secretary` bit(1) NOT NULL,
  `Receptionist` bit(1) NOT NULL,
  `Manager` bit(1) NOT NULL,
  PRIMARY KEY (`StaffID`),
  KEY `fbranchs_idx` (`BranchID`),
  CONSTRAINT `fbranchs` FOREIGN KEY (`BranchID`) REFERENCES `branch` (`BranchID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
