create table `test_table` (
`id`  int(11) not null auto_increment ,
`parent_id`  int(11) null default null ,
`name`  varchar(100) character set utf8 collate utf8_unicode_ci null default null ,
`url`  varchar(1000) character set utf8 collate utf8_unicode_ci null default null ,
`sort`  int(11) null default null ,
`status`  tinyint(4) null default 0 ,
`permission`  varchar(255) character set utf8 collate utf8_unicode_ci null default null ,
`remark`  varchar(255) character set utf8 collate utf8_unicode_ci null default null ,
`created_at`  datetime null default null ,
`updated_at`  datetime null default null ,
`create_user_id`  int(11) null default null ,
`update_user_id`  int(11) null default null ,
`menu_type`  tinyint(4) null default 0 ,
`open`  tinyint(1) null default 0 ,
`controller_name`  varchar(255) character set utf8 collate utf8_unicode_ci null default null ,
`action_name`  varchar(255) character set utf8 collate utf8_unicode_ci null default null ,
`moko_sys_url_id`  int(11) null default null ,
`tree_number`  varchar(255) character set utf8 collate utf8_unicode_ci null default null ,
primary key (`id`)
)
engine=innodb
default character set=utf8 collate=utf8_unicode_ci
auto_increment=1096
row_format=compact
;

