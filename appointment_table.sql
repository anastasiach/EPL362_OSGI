CREATE TABLE `appointment` (
  `AppointmentID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `ClientID` int(11) NOT NULL,
  `StaffID` int(11) NOT NULL,
  `BranchID` int(11) NOT NULL,
  `DropIn` bit(1) NOT NULL,
  `Canceled` bit(1) NOT NULL,
  `Update` bit(1) NOT NULL,
  `Append` bit(1) NOT NULL,
  PRIMARY KEY (`AppointmentID`),
  KEY `fclienta_idx` (`ClientID`),
  KEY `fstaffa_idx` (`StaffID`),
  KEY `fbrancha_idx` (`BranchID`),
  CONSTRAINT `fbrancha` FOREIGN KEY (`BranchID`) REFERENCES `branch` (`BranchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fclienta` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ClientID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fstaffa` FOREIGN KEY (`StaffID`) REFERENCES `staff` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
