/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : m1

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 24/05/2022 14:55:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role_rel`;
CREATE TABLE `u_user_role_rel` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '用户与角色关系主键',
  `user_id` bigint(11) NOT NULL COMMENT '用户主键ID',
  `role_id` bigint(11) NOT NULL COMMENT '角色主键ID',
  `tenant_id` bigint(11) NOT NULL COMMENT '租户ID',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色关系表';

-- ----------------------------
-- Records of u_user_role_rel
-- ----------------------------
BEGIN;
INSERT INTO `u_user_role_rel` (`id`, `user_id`, `role_id`, `tenant_id`, `create_time`) VALUES (1, 1, 1, 1, '2022-05-20 19:49:07');
INSERT INTO `u_user_role_rel` (`id`, `user_id`, `role_id`, `tenant_id`, `create_time`) VALUES (2, 1, 1, 2, '2022-05-24 14:41:49');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
