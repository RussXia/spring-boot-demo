CREATE TABLE `test_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(128) DEFAULT NULL COMMENT '姓名',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `score` decimal(10,2) DEFAULT NULL COMMENT '积分',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别:0-女性;1-男性',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `test_account` (`id`, `user_name`, `address`, `score`, `sex`, `register_time`)
VALUES
	(1, '小张', '北京市', 3.97, 1, '2020-12-30 00:00:00'),
	(2, '小李', '上海市', 4.46, 0, '2020-12-29 00:00:00'),
	(3, '小王', '天津市', 5.56, 0, '2020-12-31 00:00:00');

