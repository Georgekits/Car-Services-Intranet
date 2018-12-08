
Table structure for table `AUTHORITIES`


CREATE TABLE IF NOT EXISTS `AUTHORITIES` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `AUTHORITIES`
--

INSERT INTO `AUTHORITIES` (`username`, `authority`) VALUES
('engineer', 'ROLE_ENGINEER'),
('root', 'ROLE_ADMIN'),
('secretary', 'ROLE_SECRETARY');


Table structure for table `CARDB`


CREATE TABLE IF NOT EXISTS `CARDB` (
  `plateDB` varchar(255) NOT NULL,
  `insurance` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  PRIMARY KEY (`plateDB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `CARDB`
--

INSERT INTO `CARDB` (`plateDB`, `insurance`, `owner`) VALUES
('ZMM - 4969', 'yes', 'george');


Table structure for table `CLIENT`


CREATE TABLE IF NOT EXISTS `CLIENT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `debt` int(11) NOT NULL,
  `appointment` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `CLIENT`
--

INSERT INTO `CLIENT` (`id`, `username`, `password`, `debt`, `appointment`) VALUES
(1, 'george', 'geokits', 100, NULL),
(2, 'alex', 'alexmoud', 50, '2018-09-12');


Table structure for table `MANAGINGSYSTEM`


CREATE TABLE IF NOT EXISTS `MANAGINGSYSTEM` (
  `plate` varchar(255) NOT NULL,
  `owner` varchar(255) NOT NULL,
  `last_check` date DEFAULT NULL,
  `model` varchar(255) NOT NULL,
  `auto_type` varchar(255) NOT NULL,
  `next_check` date DEFAULT NULL,
  `damage` varchar(255) DEFAULT NULL,
  `client_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`plate`),
  KEY `client_id` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MANAGINGSYSTEM`
--

INSERT INTO `MANAGINGSYSTEM` (`plate`, `owner`, `last_check`, `model`, `auto_type`, `next_check`, `damage`, `client_id`) VALUES
('BNT - 236', 'alex', '2015-09-21', 'Duke', 'Car <= 1800cc', '2019-09-21', 'no', 2),
('ZMM - 4969', 'george', '2015-10-21', 'Ford', 'Car <= 1800cc', NULL, NULL, 1);


Table structure for table `PERMISSIONS`


CREATE TABLE IF NOT EXISTS `PERMISSIONS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `services` varchar(45) NOT NULL,
  `secretary` varchar(45) NOT NULL,
  `engineer` varchar(45) NOT NULL,
  `administrator` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `PERMISSIONS`
--

INSERT INTO `PERMISSIONS` (`id`, `services`, `secretary`, `engineer`, `administrator`) VALUES
(1, 'AddUser', '0', '0', '1'),
(2, 'DeleteUser', '0', '0', '1'),
(3, 'UpdateUser', '0', '0', '1'),
(4, 'CheckForUser', '0', '0', '1'),
(5, 'PrintAllUsers', '0', '0', '1'),
(6, 'AddService', '0', '0', '1'),
(7, 'DeleteService', '0', '0', '1'),
(8, 'PrintServices', '0', '0', '1');


Table structure for table `USER`


CREATE TABLE IF NOT EXISTS `USER` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`username`, `password`, `enabled`) VALUES
('engineer', '$2a$10$PqPkhAFRRBjC06fj8WXjBuhVLLSPek445aJ2120ttj3pZgWjDwofy', 1),
('root', '$2a$10$Fbm4WfF7qaqo/kIYDTqwyOn5SL/SUR.EP8.4CUyqbJpHPptkxsjT.', 1),
('secretary', '$2a$10$bZLF1OwtHJPZ6pDqotukce3HYbEB6kZ5JhX4ya8VZrqftGFeKebJK', 1);


-- Constraints for table `AUTHORITIES`

ALTER TABLE `AUTHORITIES`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `USER` (`username`);


-- Constraints for table `CARDB`

ALTER TABLE `CARDB`
  ADD CONSTRAINT `CARDB_ibfk_1` FOREIGN KEY (`plateDB`) REFERENCES `MANAGINGSYSTEM` (`plate`);


-- Constraints for table `MANAGINGSYSTEM`

ALTER TABLE `MANAGINGSYSTEM`
  ADD CONSTRAINT `MANAGINGSYSTEM_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `CLIENT` (`id`);