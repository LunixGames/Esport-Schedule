-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.2.11-MariaDB-10.2.11+maria~jessie - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5191
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for esport_schedule
CREATE DATABASE IF NOT EXISTS `esport_schedule` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `esport_schedule`;

-- Dumping structure for table esport_schedule.esports
CREATE TABLE IF NOT EXISTS `esports` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `avg_playtime` smallint(3) unsigned NOT NULL DEFAULT 0,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.events
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_esport` int(10) unsigned NOT NULL,
  `id_league` int(10) unsigned NOT NULL,
  `id_team_one` int(10) unsigned NOT NULL,
  `id_team_two` int(10) unsigned NOT NULL,
  `event_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted` tinyint(1) unsigned DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_esport` (`id_esport`),
  KEY `id_league` (`id_league`),
  KEY `id_team_one` (`id_team_one`),
  KEY `id_team_two` (`id_team_two`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.events_metadata
CREATE TABLE IF NOT EXISTS `events_metadata` (
  `id_event` int(10) unsigned NOT NULL,
  `type` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  KEY `id_event` (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.leagues
CREATE TABLE IF NOT EXISTS `leagues` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_esport` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_esport` (`id_esport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.players
CREATE TABLE IF NOT EXISTS `players` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_team` int(10) unsigned NOT NULL,
  `id_esport` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `id_esport` (`id_esport`),
  KEY `id_team` (`id_team`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.players_metadata
CREATE TABLE IF NOT EXISTS `players_metadata` (
  `id_player` int(10) unsigned NOT NULL,
  `type` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  KEY `id_event` (`id_player`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
-- Dumping structure for table esport_schedule.teams
CREATE TABLE IF NOT EXISTS `teams` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `ctime` timestamp NOT NULL DEFAULT current_timestamp(),
  `mtime` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `deleted` tinyint(1) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
