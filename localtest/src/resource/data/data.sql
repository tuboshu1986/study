CREATE TABLE `NewTable` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`parent_id`  int(11) NULL DEFAULT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`url`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`sort`  int(11) NULL DEFAULT NULL ,
`status`  tinyint(4) NULL DEFAULT 0 ,
`permission`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`remark`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`created_at`  datetime NULL DEFAULT NULL ,
`updated_at`  datetime NULL DEFAULT NULL ,
`create_user_id`  int(11) NULL DEFAULT NULL ,
`update_user_id`  int(11) NULL DEFAULT NULL ,
`menu_type`  tinyint(4) NULL DEFAULT 0 ,
`open`  tinyint(1) NULL DEFAULT 0 ,
`controller_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`action_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`moko_sys_url_id`  int(11) NULL DEFAULT NULL ,
`tree_number`  varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_unicode_ci
AUTO_INCREMENT=1096
ROW_FORMAT=COMPACT
;

