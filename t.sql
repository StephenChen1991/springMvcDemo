-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5167
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 demo 的数据库结构
CREATE DATABASE IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demo`;

-- 导出  表 demo.girls 结构
CREATE TABLE IF NOT EXISTS `girls` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `comingtime` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  `maxscore` int(11) NOT NULL,
  `minscore` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  demo.girls 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `girls` DISABLE KEYS */;
INSERT INTO `girls` (`id`, `name`, `comingtime`, `age`, `maxscore`, `minscore`) VALUES
	(1, 'testA', '2011-02-09', 16, 88, 38),
	(2, 'testB', '2015-01-02', 16, 90, 36),
	(3, 'testC', '2015-09-09', 22, 89, 23),
	(4, 'testD', '2013-09-06', 29, 67, 60),
	(5, 'testE', '2011-09-02', 23, 95, 29),
	(6, 'testF', '2011-02-09', 16, 67, 21),
	(7, 'testG', '2015-09-09', 22, 56, 28),
	(8, 'testH', '2013-09-06', 27, 29, 12),
	(9, 'testI', '2015-09-09', 17, 68, 32),
	(10, 'testJ', '2019-01-03', 15, 89, 68);
/*!40000 ALTER TABLE `girls` ENABLE KEYS */;

-- 导出  表 demo.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- 正在导出表  demo.user 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `address`) VALUES
	(1, '小陈', '杭州市'),
	(4, 'user001', 'HangZhou'),
	(38, '99', '9999999'),
	(42, '877', '877878'),
	(44, '9', '9'),
	(45, '1212', '121212'),
	(46, '5', '5'),
	(47, '999', '999999999');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 导出  表 demo.user_t 结构
CREATE TABLE IF NOT EXISTS `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  demo.user_t 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `user_t` DISABLE KEYS */;
INSERT INTO `user_t` (`id`, `user_name`, `password`, `age`) VALUES
	(1, '测试', 'sfasgfaf', 24);
/*!40000 ALTER TABLE `user_t` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
