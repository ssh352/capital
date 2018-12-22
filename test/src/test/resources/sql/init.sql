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

CREATE TABLE `ticket_info` (
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

CREATE TABLE `depth_market_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ask` varchar(100) NOT NULL COMMENT '10档申卖价',
  `ask_qty` int(10) NOT NULL COMMENT '十档申卖量',
  `avg_price` decimal(10,2) NOT NULL COMMENT '当日均价=(turnover/qty)',
  `bid` varchar(100) DEFAULT NULL COMMENT '十档申买价',
	`bid_qty` int(10) NOT NULL COMMENT '十档申买量',
  `close_price`decimal(10,2) NOT NULL COMMENT '今收盘',
  `curr_delta` decimal(10,2) NOT NULL COMMENT '预留',
	`dataTime` TIMESTAMP COMMENT '行情时间',
  `exchange_type` TINYINT(2) NOT NULL COMMENT '交易所类型 上海 1， 深圳 2， 未知 3',
  `high_price` decimal(10,2) NOT NULL COMMENT '最高价',
  `last_price` decimal(10,2) NOT NULL COMMENT '最新价',
  `lower_limit_price` decimal(10,2) NOT NULL COMMENT '跌停价',
  `low_price` decimal(10,2) NOT NULL COMMENT '最低价',
  `open_price` decimal(10,2) NOT NULL COMMENT '今日开盘价',
	`pre_close_price` decimal(10,2) NOT NULL COMMENT '昨日收盘价',
	`pre_delta` decimal(10,2) NOT NULL COMMENT '昨日预留',
 	`pre_settlement_price` decimal(10,2) NOT NULL COMMENT '昨日结算价',
	`pre_total_long_positon` bigint(10)   COMMENT '昨日持仓量(张)(目前未填写)',
	`qty` bigint(10)   COMMENT '数量，为总成交量（单位股，与交易所一致）',
	`settlement_price` decimal(10,2) NOT NULL COMMENT '今日结算价',
	`ticker` varchar(100) NOT NULL COMMENT '股票代码',
	`ticker_status` varchar(100) NOT NULL COMMENT '当前交易状态说明',
 	`total_long_positon` bigint(10)   COMMENT '持仓量(张)',
	`trades_count` bigint(10)   COMMENT '成交笔数',
	`turnover` decimal(10,2) NOT NULL COMMENT '成交金额，为总成交金额（单位元，与交易所一致）',
	`upper_limit_price` decimal(10,2) NOT NULL COMMENT '涨停价',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='普通行情';

CREATE TABLE `tick_by_tick` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `datetime` long NOT NULL COMMENT '委托时间',
  `seq` long DEFAULT NULL COMMENT '预留',
  `ticker` varchar(16) NOT NULL COMMENT '合约代码',
  `entrust_id` BIGINT NOT NULL COMMENT '逐笔委托id',
  `exchange_type` TINYINT NOT NULL COMMENT '交易所代码',
  `trade_id` BIGINT NOT NULL COMMENT '逐笔成交id',
	`type` TINYINT NOT NULL COMMENT '委托 or 成交',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='逐笔行情通知 包括股票指数和期权';

CREATE TABLE `tick_by_tick_entrust` (
  `id` BIGINT  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `channelNo` INT NOT NULL COMMENT '频道代码',
  `ordType` varchar NOT NULL COMMENT '订单类别: 1: 市价; 2: 限价; 3: 本方最优',
  `price` decimal NOT NULL COMMENT '状态',
  `qty` BIGINT NOT NULL COMMENT '委托数量',
  `seq` BIGINT NOT NULL COMMENT '委托序号(在同一个channel_no内唯一，从1开始连续)',
  `side` varchar NOT NULL COMMENT '1:买; 2:卖; G:借入; F:出借',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_deleted` int(11) NOT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='逐笔委托(仅适用深交所)';


