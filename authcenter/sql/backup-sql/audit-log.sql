CREATE DATABASE IF NOT EXISTS `log-center` DEFAULT CHARACTER SET = utf8;
Use `log-center`;

-- ----------------------------
-- Table structure for user_audit_log
-- ----------------------------
DROP TABLE IF EXISTS `user_audit_log`;
CREATE TABLE `log_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `desc_name` varchar(255) COMMENT '描述',
  `user_id` int(11)  COMMENT '用户ID',
  `user_name` varchar(50)  NOT NULL COMMENT '用户姓名',
  `org_id` int(11)  DEFAULT NULL COMMENT '组织机构ID',
  `ip_address` varchar(255)  COMMENT 'ip地址',
  `browser_info` varchar(255) COMMENT '浏览器信息',
  `resource_url` varchar(255) COMMENT '请求地址信息',
  `type` varchar(50) COMMENT '操作类型 resource：资源 menue 菜单 ',
  `methond_type` varchar(50) COMMENT '请求方法', 
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;



