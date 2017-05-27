DROP TABLE `USER_PERMISSION`;
DROP TABLE `PRODUCT`;

CREATE TABLE `PRODUCT` (
  `id` varbinary(36) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `USER_PERMISSION` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `entity_id` varbinary(36) NOT NULL,
  `user_id` varchar(256) DEFAULT NULL,
  `reading` tinyint(1) DEFAULT '0',
  `writing` tinyint(1) DEFAULT '0',
  `deleting` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `entity_id` (`entity_id`),
  CONSTRAINT `user_permission_ibfk_1` FOREIGN KEY (`entity_id`) REFERENCES `PRODUCT` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;