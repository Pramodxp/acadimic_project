/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.36-community : Database - finalmapapp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`finalmapapp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `finalmapapp`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `USERNAME` varchar(10) DEFAULT NULL,
  `PASSWORD` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`USERNAME`,`PASSWORD`) values ('admin','admin');

/*Table structure for table `driverdetails` */

DROP TABLE IF EXISTS `driverdetails`;

CREATE TABLE `driverdetails` (
  `driverid` int(5) NOT NULL AUTO_INCREMENT,
  `drivername` varchar(100) DEFAULT NULL,
  `driveremail` varchar(100) DEFAULT NULL,
  `driverpass` varchar(100) DEFAULT NULL,
  `isdriveractive` int(1) DEFAULT '1',
  PRIMARY KEY (`driverid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `driverdetails` */

insert  into `driverdetails`(`driverid`,`drivername`,`driveremail`,`driverpass`,`isdriveractive`) values (1,'sachin','sachintest@gmail.com','12345',1);

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `stuid` int(5) NOT NULL AUTO_INCREMENT,
  `stuname` varchar(50) NOT NULL,
  `stuusn` varchar(50) NOT NULL,
  `stuemailid` varchar(150) NOT NULL,
  `stupass` varchar(20) NOT NULL,
  `stuisactive` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `students` */

/*Table structure for table `stupickuplocation` */

DROP TABLE IF EXISTS `stupickuplocation`;

CREATE TABLE `stupickuplocation` (
  `stupikid` int(5) NOT NULL AUTO_INCREMENT,
  `stupikusn` varchar(100) DEFAULT NULL,
  `stupiklat` varchar(100) DEFAULT NULL,
  `stupiklang` varchar(100) DEFAULT NULL,
  `stupikplace` varchar(600) DEFAULT NULL,
  `stupikisadminact` int(1) DEFAULT '0',
  `stupikisdriveract` int(1) DEFAULT '0',
  `stupikdriverid` varchar(100) DEFAULT NULL,
  `stupickupdate` date DEFAULT NULL,
  PRIMARY KEY (`stupikid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `stupickuplocation` */

insert  into `stupickuplocation`(`stupikid`,`stupikusn`,`stupiklat`,`stupiklang`,`stupikplace`,`stupikisadminact`,`stupikisdriveract`,`stupikdriverid`,`stupickupdate`) values (12,'1272','37.4116332','-122.08547180000001','1701 Rock St, Mountain View, CA 94043, USA',1,1,'sachin','2018-04-22'),(13,'1272','37.420927899999995','-122.08269380000002','Mountain View, CA 94043, USA',0,1,'sachin','2018-04-22'),(14,'1272','37.4201768','-122.07997180000001','Google Building 1489, 1489 Charleston Rd, Mountain View, CA 94043, USA',0,1,'sachin','2018-04-22'),(15,'1272','37.4186317','-122.0797499','Google Building 1055, 1055 Joaquin Rd, Mountain View, CA 94043, USA',1,0,NULL,'2018-04-22'),(16,'1272','12.961896','75.4519516','Puduvettu, Karnataka, India',1,0,NULL,'2018-04-22'),(17,'1272','37.4216548','-122.08563740000001','Google Building 42, 1600 Amphitheatre Pkwy, Mountain View, CA 94043, USA',1,0,NULL,'2018-04-22'),(18,'1272','37.420895099999996','-122.08862659999998','Google Building 1875, 1875 Charleston Rd, Mountain View, CA 94043, USA',1,0,NULL,'2018-04-22'),(19,'1272','37.422194600000005','-122.08336399999999','Mountain View, CA 94043, USA',1,0,NULL,'2018-04-22'),(20,'1272','37.422050999999996','-122.08186979999998','1500 Charleston Rd, Mountain View, CA 94043, USA',0,0,NULL,'2018-04-22');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
