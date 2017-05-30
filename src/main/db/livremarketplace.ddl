DROP TABLE `USER_PERMISSION`;
DROP TABLE `PRODUCT`;
DROP TABLE `CUSTOMER`;
DROP TABLE `SUPPLIER`;

CREATE TABLE `PRODUCT` (
  `id` varbinary(36) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CUSTOMER` (
  `id` varbinary(36) NOT NULL,
  `name` varchar(256) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `address` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `SUPPLIER` (
  `id` varbinary(36) NOT NULL,
  `name` varchar(256) NOT NULL,
  `email` varchar(254) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `address` text DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;