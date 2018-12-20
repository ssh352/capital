CREATE TABLE `user_info` (
  `id` int(10)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `id_card` varchar(20) NOT NULL COMMENT '身份证',
  `sex` tinyint(4) unsigned NOT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `creator` varchar(20) NOT NULL COMMENT '创建人',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `is_deleted` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_id_card` (`id_card`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='用户信息';