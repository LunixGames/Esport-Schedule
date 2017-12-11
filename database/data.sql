-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.2.11-MariaDB-10.2.11+maria~jessie - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table esport_schedule.esports: ~0 rows (approximately)
DELETE FROM `esports`;
/*!40000 ALTER TABLE `esports` DISABLE KEYS */;
INSERT INTO `esports` (`id`, `name`, `avg_playtime`, `ctime`, `mtime`, `deleted`) VALUES
	(1, 'Dota 2', 45, '2017-12-11 19:26:23', '2017-12-11 19:26:23', 0),
	(2, 'Overwach', 10, '2017-12-11 19:41:48', '2017-12-11 19:41:48', 0),
	(3, 'League of Legends', 30, '2017-12-11 19:42:00', '2017-12-11 19:42:04', 0);
/*!40000 ALTER TABLE `esports` ENABLE KEYS */;

-- Dumping data for table esport_schedule.events: ~0 rows (approximately)
DELETE FROM `events`;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` (`id`, `id_esport`, `id_league`, `id_team_one`, `id_team_two`, `event_time`, `ctime`, `mtime`, `deleted`) VALUES
	(1, 1, 1, 1, 2, '2017-12-11 21:44:06', '2017-12-11 19:44:10', '2017-12-11 19:44:10', 0),
	(2, 3, 2, 3, 4, '2017-12-11 19:45:13', '2017-12-11 19:45:13', '2017-12-11 19:45:13', 0),
	(3, 1, 1, 1, 4, '2018-01-11 21:45:38', '2017-12-11 21:45:38', '2017-12-11 22:05:24', 0);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;

-- Dumping data for table esport_schedule.events_metadata: ~0 rows (approximately)
DELETE FROM `events_metadata`;
/*!40000 ALTER TABLE `events_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_metadata` ENABLE KEYS */;

-- Dumping data for table esport_schedule.leagues: ~0 rows (approximately)
DELETE FROM `leagues`;
/*!40000 ALTER TABLE `leagues` DISABLE KEYS */;
INSERT INTO `leagues` (`id`, `id_esport`, `name`, `ctime`, `mtime`, `deleted`) VALUES
	(1, 1, 'The International 2017', '2017-12-11 21:42:33', '2017-12-11 19:42:54', 0),
	(2, 3, 'The Worlds Final', '2017-12-11 19:43:41', '2017-12-11 19:43:41', 0);
/*!40000 ALTER TABLE `leagues` ENABLE KEYS */;

-- Dumping data for table esport_schedule.players: ~0 rows (approximately)
DELETE FROM `players`;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
/*!40000 ALTER TABLE `players` ENABLE KEYS */;

-- Dumping data for table esport_schedule.players_metadata: ~0 rows (approximately)
DELETE FROM `players_metadata`;
/*!40000 ALTER TABLE `players_metadata` DISABLE KEYS */;
/*!40000 ALTER TABLE `players_metadata` ENABLE KEYS */;

-- Dumping data for table esport_schedule.teams: ~0 rows (approximately)
DELETE FROM `teams`;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` (`id`, `name`, `ctime`, `mtime`, `deleted`) VALUES
	(1, 'Fnatic', '2017-12-11 19:44:25', '2017-12-11 19:44:25', 0),
	(2, 'TSM', '2017-12-11 19:44:33', '2017-12-11 19:44:33', 0),
	(3, 'Liquid', '2017-12-11 19:44:43', '2017-12-11 19:44:43', 0),
	(4, 'C9', '2017-12-11 19:44:48', '2017-12-11 19:44:48', 0);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
