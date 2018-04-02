CREATE TABLE `client` (
  `ClientID` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `CaseID` int(11) NOT NULL,
  `Transaction` varchar(45) NOT NULL,
  `Recommentation` varchar(1000) NOT NULL,
  `LegalOpinion` varchar(1000) DEFAULT NULL,
  `RiskStatus` bit(1) NOT NULL,
  `StrategyID` int(11) NOT NULL,
  `Comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ClientID`),
  KEY `fcase_idx` (`CaseID`),
  KEY `fstrategy_idx` (`StrategyID`),
  CONSTRAINT `fcase` FOREIGN KEY (`CaseID`) REFERENCES `case` (`CaseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fstrategy` FOREIGN KEY (`StrategyID`) REFERENCES `legalstrategy` (`LegalStrategyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
