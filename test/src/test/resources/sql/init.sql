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

CREATE TABLE `tickey_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ticker` varchar(30) NOT NULL COMMENT '股票代码',
  `ticket_name` varchar(60) NOT NULL COMMENT '股票名称',
  `exchange_type` tinyint(2) NOT NULL COMMENT '交易所类型 上海 1， 深圳 2， 未知 3',
  `ticker_type` tinyint(2) DEFAULT NULL COMMENT '合约类型  1 股票 2 其他',
  `buy_qty_unit` int(8) NOT NULL COMMENT '合约最小交易量',
  `upper_limit_price` decimal(10,0) NOT NULL COMMENT '涨停板价',
  `lower_limit_price` decimal(10,0) NOT NULL COMMENT '跌停板价',
  `pre_close_price` decimal(10,0) NOT NULL COMMENT '昨收盘价',
  `price_tick` decimal(10,0) NOT NULL COMMENT '最小变动价位',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='股票信息';
