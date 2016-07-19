/*
SQLyog v10.2 
MySQL - 5.1.32-community : Database - db_sgdata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_sgdata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_sgdata`;

/*Table structure for table `tb_courses` */

DROP TABLE IF EXISTS `tb_courses`;

CREATE TABLE `tb_courses` (
  `courseID` varchar(11) NOT NULL COMMENT '课程代码',
  `courseName` varchar(35) NOT NULL COMMENT '课程名称',
  `credit` int(11) NOT NULL COMMENT '学分',
  `type` varchar(4) NOT NULL COMMENT '课程类型',
  `time` date NOT NULL COMMENT '开课时间',
  `week1` int(11) NOT NULL COMMENT '课程开始周数，默认为1',
  `week2` int(11) NOT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_courses` */

insert  into `tb_courses`(`courseID`,`courseName`,`credit`,`type`,`time`,`week1`,`week2`) values ('JY1121','安卓姓名实战',4,'选修','2015-11-11',1,17),('JY1128','Hadoop大数据',4,'选修','2015-11-11',1,17);

/*Table structure for table `tb_departments` */

DROP TABLE IF EXISTS `tb_departments`;

CREATE TABLE `tb_departments` (
  `departID` int(11) NOT NULL,
  `departName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`departID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_departments` */

insert  into `tb_departments`(`departID`,`departName`) values (1,'软件工程系'),(2,'国际经贸系'),(3,'网络技术系'),(4,'管理系'),(5,'电子系'),(6,'外语系'),(7,'数码媒体系'),(8,'财会系'),(9,'计算机系');

/*Table structure for table `tb_matchs` */

DROP TABLE IF EXISTS `tb_matchs`;

CREATE TABLE `tb_matchs` (
  `matchID` int(11) NOT NULL AUTO_INCREMENT COMMENT '比赛ID号',
  `matchName` varchar(35) NOT NULL COMMENT '比赛名称',
  `matchTime` date NOT NULL COMMENT '比赛时间',
  `matchReward` varchar(255) NOT NULL COMMENT '比赛成绩',
  PRIMARY KEY (`matchID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_matchs` */

insert  into `tb_matchs`(`matchID`,`matchName`,`matchTime`,`matchReward`) values (1,'蓝桥杯','2015-11-11','一等奖'),(2,'比赛A','2016-02-29','一等奖'),(3,'比赛B','2016-02-29','一等奖'),(4,'比赛C','2016-02-29','一等奖');

/*Table structure for table `tb_student_course` */

DROP TABLE IF EXISTS `tb_student_course`;

CREATE TABLE `tb_student_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `score` int(11) DEFAULT NULL COMMENT '学生的考试成绩',
  `stuID` varchar(11) DEFAULT NULL,
  `courseID` varchar(11) DEFAULT NULL,
  `teaID` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `STUID` (`stuID`),
  KEY `COURSEID` (`courseID`),
  KEY `TEAID` (`teaID`),
  CONSTRAINT `COURSEID` FOREIGN KEY (`courseID`) REFERENCES `tb_courses` (`courseID`),
  CONSTRAINT `STUID` FOREIGN KEY (`stuID`) REFERENCES `tb_students` (`stuID`),
  CONSTRAINT `TEAID` FOREIGN KEY (`teaID`) REFERENCES `tb_teachers` (`teaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student_course` */

insert  into `tb_student_course`(`id`,`score`,`stuID`,`courseID`,`teaID`) values (1,90,'1340121311','JY1121','1234'),(2,100,'1340121312','JY1121','1233'),(3,90,'1340121311','JY1128','1234'),(4,100,'1340121312','JY1128','1233');

/*Table structure for table `tb_student_match` */

DROP TABLE IF EXISTS `tb_student_match`;

CREATE TABLE `tb_student_match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuID` varchar(11) DEFAULT NULL,
  `teaID` varchar(11) DEFAULT NULL,
  `matchID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `STUDENTID` (`stuID`),
  KEY `MAYCHID` (`matchID`),
  KEY `TEACHERID` (`teaID`),
  CONSTRAINT `MAYCHID` FOREIGN KEY (`matchID`) REFERENCES `tb_matchs` (`matchID`),
  CONSTRAINT `STUDENTID` FOREIGN KEY (`stuID`) REFERENCES `tb_students` (`stuID`),
  CONSTRAINT `TEACHERID` FOREIGN KEY (`teaID`) REFERENCES `tb_teachers` (`teaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_student_match` */

insert  into `tb_student_match`(`id`,`stuID`,`teaID`,`matchID`) values (1,'1340121311','1234',1),(2,'1340121312','1234',1);

/*Table structure for table `tb_students` */

DROP TABLE IF EXISTS `tb_students`;

CREATE TABLE `tb_students` (
  `stuID` varchar(11) NOT NULL COMMENT '学号',
  `stuName` varchar(30) NOT NULL COMMENT '学生姓名',
  `stuSex` varchar(2) NOT NULL COMMENT '学生性别',
  `stuBirth` date NOT NULL COMMENT '学生生日',
  `stuTel` varchar(20) NOT NULL COMMENT '学生电话',
  `stuEmail` varchar(20) NOT NULL COMMENT '邮箱',
  `stuIDCard` varchar(20) NOT NULL COMMENT '身份证',
  `className` varchar(20) NOT NULL COMMENT '班级名',
  `password` varchar(10) NOT NULL COMMENT '密码',
  `dept` varchar(10) NOT NULL COMMENT '系部',
  `departID` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_students` */

insert  into `tb_students`(`stuID`,`stuName`,`stuSex`,`stuBirth`,`stuTel`,`stuEmail`,`stuIDCard`,`className`,`password`,`dept`,`departID`) values ('1340121311','王飞扬','女','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',NULL),('1340121312','王强','男','2015-11-11','12332212232','23123123@qq.com','1122311112323123','软件开发1班','1111','软件工程系',1),('1340121313','李杨杨','女','2016-02-29','12332212232','12313232@qq.com','1231312312312315','软件开发1班','1111','软件工程系',1),('1340121314','王麟','男','2016-02-29','12332212232','12313232@qq.com','1231312312312319','软件开发1班','1111','软件工程系',1),('1340121315','林海海','女','2016-02-29','12313312312','12313232@qq.com','1231312312312311','软件开发1班','1111','软件工程系',1),('1340121316','赵飞飞','男','2016-02-29','12332212232','12313232@qq.com','1231312312312322','软件开发1班','1111','软件工程系',1),('1340121317','李飞\n\n扬','女','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1),('1340121318','王\n\n飞飞','男','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1),('1340121319','李\n\n飞','女','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1),('1340121320','张\n\n扬','男','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1),('1340121321','赵\n\n飞','女','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1),('1340121322','高\n\n飞','男','2015-11-11','12313312312','12313232@qq.com','1231312312312312','软件开发1班','1111','软件工程系',1);

/*Table structure for table `tb_teacher_course` */

DROP TABLE IF EXISTS `tb_teacher_course`;

CREATE TABLE `tb_teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` varchar(11) DEFAULT NULL,
  `teaID` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q5awm8lk434e7xma73lcwjxy4` (`courseID`),
  KEY `FK_hydun6b1ow8ahr7r54cnw0vmr` (`teaID`),
  CONSTRAINT `FK_hydun6b1ow8ahr7r54cnw0vmr` FOREIGN KEY (`teaID`) REFERENCES `tb_teachers` (`teaID`),
  CONSTRAINT `FK_q5awm8lk434e7xma73lcwjxy4` FOREIGN KEY (`courseID`) REFERENCES `tb_courses` (`courseID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher_course` */

insert  into `tb_teacher_course`(`id`,`courseID`,`teaID`) values (1,'JY1121','1234'),(2,'JY1128','1234'),(3,'JY1121','1233');

/*Table structure for table `tb_teacher_match` */

DROP TABLE IF EXISTS `tb_teacher_match`;

CREATE TABLE `tb_teacher_match` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matchID` int(11) DEFAULT NULL,
  `teaID` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q75g87fepy1uuaqoed02qsn6o` (`matchID`),
  KEY `FK_lyp8hq4qxdgim31uskay8vi0w` (`teaID`),
  CONSTRAINT `FK_lyp8hq4qxdgim31uskay8vi0w` FOREIGN KEY (`teaID`) REFERENCES `tb_teachers` (`teaID`),
  CONSTRAINT `FK_q75g87fepy1uuaqoed02qsn6o` FOREIGN KEY (`matchID`) REFERENCES `tb_matchs` (`matchID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_teacher_match` */

insert  into `tb_teacher_match`(`id`,`matchID`,`teaID`) values (1,1,'1234');

/*Table structure for table `tb_teachers` */

DROP TABLE IF EXISTS `tb_teachers`;

CREATE TABLE `tb_teachers` (
  `teaID` varchar(11) NOT NULL COMMENT '工号',
  `teaName` varchar(30) NOT NULL COMMENT '姓名',
  `teaSex` varchar(2) NOT NULL COMMENT '性别',
  `teaBirth` date NOT NULL COMMENT '生日',
  `teaTel` varchar(20) NOT NULL COMMENT '电话',
  `teaEmail` varchar(20) NOT NULL COMMENT '邮箱',
  `dept` varchar(10) NOT NULL COMMENT '部门',
  `password` varchar(10) NOT NULL COMMENT '教师密码',
  `isManager` varchar(1) DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`teaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_teachers` */

insert  into `tb_teachers`(`teaID`,`teaName`,`teaSex`,`teaBirth`,`teaTel`,`teaEmail`,`dept`,`password`,`isManager`) values ('1232','李林','女','2016-02-29','12323223312','123123312@qq.com','软件工程系','111111','1'),('1233','王强','女','2016-02-08','12323223313','123123311@qq.com','软件工程系','111111','1'),('1234','张林','男','2015-11-11','12323223312','123123312@qq.com','软件工程系','111111','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
