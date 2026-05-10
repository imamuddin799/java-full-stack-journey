/*
SQLyog Community Edition- MySQL GUI v6.07
Host - 5.1.44-community : Database - aspam_transformer_model
*********************************************************************
Server version : 5.1.44-community
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `aspam_transformer_model`;

USE `aspam_transformer_model`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `auth_group` */

DROP TABLE IF EXISTS `auth_group`;

CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `auth_group` */

/*Table structure for table `auth_group_permissions` */

DROP TABLE IF EXISTS `auth_group_permissions`;

CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `auth_group_permissions` */

/*Table structure for table `auth_permission` */

DROP TABLE IF EXISTS `auth_permission`;

CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `auth_permission` */

insert  into `auth_permission`(`id`,`name`,`content_type_id`,`codename`) values (1,'Can add log entry',1,'add_logentry'),(2,'Can change log entry',1,'change_logentry'),(3,'Can delete log entry',1,'delete_logentry'),(4,'Can add permission',2,'add_permission'),(5,'Can change permission',2,'change_permission'),(6,'Can delete permission',2,'delete_permission'),(7,'Can add group',3,'add_group'),(8,'Can change group',3,'change_group'),(9,'Can delete group',3,'delete_group'),(10,'Can add user',4,'add_user'),(11,'Can change user',4,'change_user'),(12,'Can delete user',4,'delete_user'),(13,'Can add content type',5,'add_contenttype'),(14,'Can change content type',5,'change_contenttype'),(15,'Can delete content type',5,'delete_contenttype'),(16,'Can add session',6,'add_session'),(17,'Can change session',6,'change_session'),(18,'Can delete session',6,'delete_session'),(19,'Can add client register_ model',7,'add_clientregister_model'),(20,'Can change client register_ model',7,'change_clientregister_model'),(21,'Can delete client register_ model',7,'delete_clientregister_model'),(22,'Can add client posts_ model',8,'add_clientposts_model'),(23,'Can change client posts_ model',8,'change_clientposts_model'),(24,'Can delete client posts_ model',8,'delete_clientposts_model'),(25,'Can add feedbacks_ model',9,'add_feedbacks_model'),(26,'Can change feedbacks_ model',9,'change_feedbacks_model'),(27,'Can delete feedbacks_ model',9,'delete_feedbacks_model');

/*Table structure for table `auth_user_groups` */

DROP TABLE IF EXISTS `auth_user_groups`;

CREATE TABLE `auth_user_groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `auth_user_groups` */

/*Table structure for table `auth_user_user_permissions` */

DROP TABLE IF EXISTS `auth_user_user_permissions`;

CREATE TABLE `auth_user_user_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `auth_user_user_permissions` */

/*Table structure for table `django_content_type` */

DROP TABLE IF EXISTS `django_content_type`;

CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `django_content_type` */

insert  into `django_content_type`(`id`,`app_label`,`model`) values (1,'admin','logentry'),(3,'auth','group'),(2,'auth','permission'),(4,'auth','user'),(8,'Client_Site','clientposts_model'),(7,'Client_Site','clientregister_model'),(9,'Client_Site','feedbacks_model'),(5,'contenttypes','contenttype'),(6,'sessions','session');

/*Table structure for table `django_session` */

DROP TABLE IF EXISTS `django_session`;

CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime NOT NULL,
  PRIMARY KEY (`session_key`),
  KEY `django_session_expire_date_a5c62663` (`expire_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `django_session` */

insert  into `django_session`(`session_key`,`session_data`,`expire_date`) values ('msrl0r5c0lmsate8xo2wbcn8bx6fj2kx','N2U5NGVjMWM2Mzk1Zjc2Yjg3YTlkNTNmYWI1Njc0NjE4NzA3ZmVlZjp7InVzZXJpZCI6NH0=','2023-05-11 05:01:40');

/*Table structure for table `remote_user_aspam_transformer_prediction` */

DROP TABLE IF EXISTS `remote_user_aspam_transformer_prediction`;

CREATE TABLE `remote_user_aspam_transformer_prediction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SMS_Message` varchar(30000) NOT NULL,
  `Prediction` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `remote_user_aspam_transformer_prediction` */

insert  into `remote_user_aspam_transformer_prediction`(`id`,`SMS_Message`,`Prediction`) values (1,'Free entry in 2 a wkly comp to win FA Cup final tkts 21st May 2005. Text FA to 87121 to receive entry question(std txt rate)T&C\'s apply 08452810075over18\'s','Spam'),(2,'I\'m gonna be home soon and i don\'t want to talk about this stuff anymore tonight, k? I\'ve cried enough today.','Ham'),(3,'URGENT! You have won a 1 week FREE membership in our å£100,000 Prize Jackpot! Txt the word: CLAIM to No: 81010 T&C www.dbuk.net LCCLTD POBOX 4403LDNW1A7RW18','Ham'),(4,'XXXMobileMovieClub: To use your credit, click the WAP link in the next txt message or click here>> http://wap. xxxmobilemovieclub.com?n=QJKGIGHJJGCBL','Ham'),(5,'Thanks for your subscription to Ringtone UK your mobile will be charged å£5/month Please confirm by replying YES or NO. If you reply NO you will not be charged','Ham'),(6,'Urgent UR awarded a complimentary trip to EuroDisinc Trav, Aco&Entry41 Or å£1000. To claim txt DIS to 87121 18+6*å£1.50(moreFrmMob. ShrAcomOrSglSuplt)10, LS1 3AJ','Ham'),(7,'You are a winner U have been specially selected 2 receive å£1000 or a 4* holiday (flights inc) speak to a live operator 2 claim 0871277810910p/min (18+) ','Spam'),(8,'Want 2 get laid tonight? Want real Dogging locations sent direct 2 ur mob? Join the UK\'s largest Dogging Network bt Txting GRAVEL to 69888! Nt. ec2a. 31p.msg@150p','Ham'),(9,'Customer service annoncement. You have a New Years delivery waiting for you. Please call 07046744435 now to arrange delivery','Spam'),(10,'Life is more strict than teacher... Bcoz Teacher teaches lesson &amp; then conducts exam, But Life first conducts Exam &amp; then teaches Lessons. Happy morning. . .','Ham'),(11,'U 447801259231 have a secret admirer who is looking 2 make contact with U-find out who they R*reveal who thinks UR so special-call on 09058094597','Spam'),(12,'Hey I am really horny want to chat or see me naked text hot to 69698 text charged at 150pm to unsubscribe text stop 69698','Ham'),(13,'hai','Ham'),(14,'i will kill you','Ham'),(15,'i will kill you','Ham'),(16,'Txt: CALL to No: 86888 & claim your reward of 3 hours talk time to use from your phone now! ubscribe6GBP/ mnth inc 3hrs 16 stop?txtStop','Ham'),(17,'Have you ever received a text message from a company or person you recognized, but it didn’t seem quite “right”? ','Ham'),(18,'Winning an unexpected prize sounds great, in theory. However, being notified of winning a contest you didn’t enter is a dead giveaway of a phishing text. If you’re unsure whether an offer is authentic, contact the business directly to verify.','Ham'),(19,'You’ve won!','Ham'),(20,'Customer service annoncement. You have a New Years delivery waiting for you. Please call 07046744435 now to arrange delivery','Spam');

/*Table structure for table `remote_user_clientregister_model` */

DROP TABLE IF EXISTS `remote_user_clientregister_model`;

CREATE TABLE `remote_user_clientregister_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phoneno` varchar(50) NOT NULL,
  `country` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `remote_user_clientregister_model` */

insert  into `remote_user_clientregister_model`(`id`,`username`,`email`,`password`,`phoneno`,`country`,`state`,`city`) values (1,'Harish','Harish123@gmail.com','Harish','9535866270','India','Karnataka','Bangalore'),(2,'Ramesh','Ramesh123@gmail.com','Ramesh','9535866270','India','Karnataka','Bangalore'),(3,'Manjunath','tmksmanju13@gmail.com','Manjunath','9535866270','India','Karnataka','Bangalore'),(4,'nivas','nivas@gmail.com','nivas','9087654321','india','ts','hyd');

/*Table structure for table `remote_user_detection_accuracy` */

DROP TABLE IF EXISTS `remote_user_detection_accuracy`;

CREATE TABLE `remote_user_detection_accuracy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `names` varchar(300) NOT NULL,
  `ratio` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

/*Data for the table `remote_user_detection_accuracy` */

insert  into `remote_user_detection_accuracy`(`id`,`names`,`ratio`) values (36,'Naive Bayes','97.847533632287'),(37,'SVM','98.7443946188341'),(38,'Logistic Regression','98.29596412556054'),(39,'Decision Tree Classifier','97.04035874439462'),(40,'Random Forest Classifier','97.30941704035875'),(41,'SGD Classifier','98.11659192825111'),(42,'KNeighborsClassifier','92.55605381165918');

/*Table structure for table `remote_user_detection_ratio` */

DROP TABLE IF EXISTS `remote_user_detection_ratio`;

CREATE TABLE `remote_user_detection_ratio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `names` varchar(300) NOT NULL,
  `ratio` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `remote_user_detection_ratio` */

insert  into `remote_user_detection_ratio`(`id`,`names`,`ratio`) values (22,'Spam','33.33333333333333'),(23,'Ham','66.66666666666666');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
