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

 Date: 24/05/2022 14:56:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_role_tenant_rel
-- ----------------------------
DROP TABLE IF EXISTS `u_role_tenant_rel`;
CREATE TABLE `u_role_tenant_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色与租户关系主键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色主键',
  `tenant_id` bigint(20) DEFAULT NULL COMMENT '租户主键',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色租户关系表';

-- ----------------------------
-- Records of u_role_tenant_rel
-- ----------------------------
BEGIN;
INSERT INTO `u_role_tenant_rel` (`id`, `role_id`, `tenant_id`, `create_time`) VALUES (1, 1, 1, '2022-05-20 19:49:07');
INSERT INTO `u_role_tenant_rel` (`id`, `role_id`, `tenant_id`, `create_time`) VALUES (2, 1, 2, '2022-05-24 14:41:49');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
