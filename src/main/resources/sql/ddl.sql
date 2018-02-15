/* 用户表 */
create table `easyhr_user`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` VARCHAR(50) NOT NULL COMMENT '昵称',
  `account` VARCHAR(20) NOT NULL COMMENT '账号',
  `password` VARCHAR(255) NOT NULL COMMENT '密码',
  `token` VARCHAR(255) NOT NULL COMMENT 'token',
  `avatar` VARCHAR(255) NOT NULL COMMENT '头像地址',
  `phone` CHAR(11) NOT NULL COMMENT '电话',
  `email` VARCHAR(255) NOT NULL COMMENT '邮箱',
  `address` VARCHAR(255) NOT NULL COMMENT '地址',
  `is_freeze` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否冻结',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `is_super_admin` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否超级管理员',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname_account` (`nickname`,`account`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 角色表 */
create table `easyhr_role`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` VARCHAR(255) NOT NULL COMMENT '角色名称',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 用户-角色表 */
create table `easyhr_user_role`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(11) unsigned NOT NULL COMMENT '用户id',
  `role_id` bigint(11) unsigned NOT NULL COMMENT '角色id',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 权限表 */
drop table if EXISTS `easyhr_permission`;
create table `easyhr_permission`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `module_one` VARCHAR(255) NOT NULL COMMENT '一级模块',
  `module_two` VARCHAR(255) NOT NULL COMMENT '二级模块',
  `name` VARCHAR(255) NOT NULL COMMENT '权限名称',
  `level` tinyint(1) NOT NULL DEFAULT 0 COMMENT '权限级别',
  `url` VARCHAR(255) NOT NULL COMMENT '权限路径',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `url` (`url`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into easyhr_permission(module_one,module_two,name,level,url,gmt_created,gmt_modified,created_user_id,modified_user_id) values
("全部模块","全部模块","全部功能",5,"/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("仪表盘","仪表盘","查看仪表盘",3,"/board",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","全部模块","全部功能",4,"/permission/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","用户管理","全部功能",3,"/permission/user/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","用户管理","查看用户",1,"/permission/user/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","用户管理","添加用户",2,"/permission/user/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","用户管理","删除用户",2,"/permission/user/delete",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","用户管理","冻结用户",2,"/permission/user/freeze",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","角色管理","全部功能",3,"/permission/role/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","角色管理","查看角色",1,"/permission/role/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","角色管理","添加角色",2,"/permission/role/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","角色管理","删除角色",2,"/permission/role/delete",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("权限管理","角色管理","编辑角色",2,"/permission/role/edit",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("资源管理","资源管理","全部功能",3,"/resource/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("资源管理","资源管理","查看资源",1,"/resource/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("资源管理","资源管理","上传资源",2,"/resource/upload",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("资源管理","资源管理","下载资源",2,"/resource/download",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("备忘录","备忘录","全部功能",3,"/memorandum/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","员工管理","全部功能",4,"/employee/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","全部模块","全部功能",3,"/employee/employee/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","员工管理","查看员工",1,"/employee/employee/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","员工管理","添加员工",1,"/employee/employee/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","员工管理","编辑员工",2,"/employee/employee/edit",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","员工管理","删除员工",2,"/employee/employee/delete",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","岗位管理","全部功能",2,"/employee/post/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","岗位管理","查看岗位",1,"/employee/post/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","岗位管理","添加岗位",2,"/employee/post/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("员工管理","岗位管理","删除岗位",2,"/employee/post/delete",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","全部模块","全部功能",4,"/interview/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","候选人管理","全部功能",3,"/interview/candidate/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","候选人管理","查看候选人",1,"/interview/candidate/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","候选人管理","添加候选人",2,"/interview/candidate/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","候选人管理","编辑候选人",2,"/interview/candidate/edit",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","面试记录","全部功能",3,"/interview/record/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","面试记录","查看面试记录",1,"/interview/record/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","面试记录","添加面试记录",2,"/interview/record/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","模板管理","全部功能",3,"/interview/template/*",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","模板管理","查看模板",1,"/interview/template/index",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","模板管理","添加模板",2,"/interview/template/add",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","模板管理","编辑模板",2,"/interview/template/edit",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0),
("面试管理","模板管理","删除模板",2,"/interview/template/delete",'2018-01-03 19:29:17','2018-01-03 19:29:17',0,0);

/* 权限-角色表 */
create table `easyhr_role_permission`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(11) unsigned NOT NULL COMMENT '角色id',
  `permission_id` bigint(11) unsigned NOT NULL COMMENT '权限id',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 岗位表 */
create table `easyhr_post`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `post_name` VARCHAR(100) NOT NULL COMMENT '岗位名称',
  `post_introduction` TEXT NULL COMMENT '岗位简介',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 员工表 */
drop table if EXISTS `easyhr_employee`;
create table `easyhr_employee`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `is_locked` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0-否 1-是',
  `token` VARCHAR(255) NULL COMMENT '链接token',
  `resource_id` bigint(11) NOT NULL COMMENT '简历id',
  `resume_source` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '简历来源',
  `number` bigint(11) unsigned NOT NULL COMMENT '工号',
  `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `nickname` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '花名',
  `post_id` bigint(11) NOT NULL COMMENT '岗位id',
  `grade` VARCHAR(100) NULL COMMENT '职级',
  `phone` CHAR(11) NOT NULL COMMENT '电话',
  `enterprise_email` VARCHAR(100) NULL COMMENT '企业邮箱',
  `personal_email` VARCHAR(100) NULL COMMENT '个人邮箱',
  `sex` tinyint(1) NOT NULL DEFAULT 0 COMMENT '性别 0-男 1-女',
  `id_card_no` VARCHAR(100) NOT NULL COMMENT '身份证号',
  `birthday` TIMESTAMP NOT NULL COMMENT '生日',
  `entry_date` TIMESTAMP NOT NULL COMMENT '入职日期',
  `education` VARCHAR(255) NOT NULL COMMENT '学历',
  `graduate_school` VARCHAR(255) NULL COMMENT '毕业院校',
  `major` VARCHAR(255) NULL COMMENT '专业',
  `contract_date` TIMESTAMP NOT NULL COMMENT '劳动合同签订日期',
  `term` tinyint(2) NOT NULL DEFAULT 0  COMMENT '劳动合同期限',
  `is_expire` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否到期 0-否 1-是',
  `is_party_member` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否党员 0-否 1-是',
  `is_married` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否已婚 0-否 1-是',
  `nation` VARCHAR(100) NOT NULL DEFAULT '汉族' COMMENT '民族',
  `children` VARCHAR(255) NULL COMMENT '子女状况',
  `residence_type` VARCHAR(255) NOT NULL DEFAULT '本地城镇' COMMENT '户籍类型',
  `birth_address` TEXT NOT NULL DEFAULT '' COMMENT '出生地',
  `residence_address` TEXT NOT NULL  DEFAULT ''COMMENT '户口所在地址',
  `current_live_address` TEXT NOT NULL  DEFAULT ''COMMENT '现居住地址',
  `social_security_address` TEXT NOT NULL  DEFAULT '' COMMENT '社保缴纳地址',
  `emergency_contact_one_name` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '紧急联系人1',
  `get_emergency_contact_one_phone` CHAR(11) NOT NULL DEFAULT '' COMMENT '紧急联系人1电话',
  `relationship_one` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '紧急联系人1与本人关系',
  `emergency_contact_two_name` VARCHAR(20) NULL COMMENT '紧急联系人2',
  `get_emergency_contact_two_phone` CHAR(11) NULL COMMENT '紧急联系人2电话',
  `relationship_two` VARCHAR(100) NULL COMMENT '紧急联系人2与本人关系',
  `inner_relationship` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '内部关系',
  `remarks` TEXT NULL COMMENT '备注',
  `bank_card` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '银行卡号',
  `bank_card_address` TEXT NOT NULL DEFAULT '' COMMENT '开户行地址',
  `candidate_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '候选人id',
  `status` tinyint(11) NOT NULL DEFAULT 0 COMMENT '状态',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `number_nickname` (`number`,`nickname`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 候选人表 */
drop table IF EXISTS `easyhr_candidate` ;
create table `easyhr_candidate`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `is_employment_later` tinyint(1) NOT NULL DEFAULT 0  COMMENT '后续是否想录用,0-否 1-是',
  `post_id` bigint(11) NOT NULL DEFAULT 0 COMMENT '岗位id',
  `post2_id` bigint(11) NULL COMMENT '岗位id',
  `resume_source` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '简历来源',
  `resume_id` bigint(11) NULL COMMENT '简历id',
  `phone` CHAR(11) NOT NULL DEFAULT '' COMMENT '电话',
  `address` TEXT NOT NULL DEFAULT '' COMMENT '地址',
  `pre_company_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '上家单位名称',
  `pre_company_type` VARCHAR(255) NULL COMMENT '上家单位类型',
  `salary` DOUBLE NOT NULL DEFAULT 0 COMMENT '当前薪资',
  `overtime` TEXT NOT NULL DEFAULT '' COMMENT '加班费计算方式',
  `is_pay_five_insurance` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否缴纳五险 0-否 1-是',
  `is_pay_fund` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否缴纳一金 0-否 1-是',
  `is_provide_food` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否包吃 0-否 1-是',
  `is_provide_house` tinyint(1) NOT NULL DEFAULT 0  COMMENT '是否包住 0-否 1-是',
  `status` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '候选人状态',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_phone` (`name`,`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 面试记录表 */
drop table if EXISTS `easyhr_interview_record`;
create table `easyhr_interview_record`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `record` TEXT NOT NULL COMMENT '面试记录',
  `is_locked` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否锁定, 0-否，1-是',
  `employee_id` bigint(11) unsigned NULL COMMENT '员工id',
  `token` VARCHAR(255) NULL COMMENT '链接token',
  `step` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '步骤',
  `candidate_id` bigint(11) unsigned NOT NULL COMMENT '候选人id',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 备忘录表 */
create table `easyhr_memorandum`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` VARCHAR(500) NOT NULL COMMENT '内容',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 提醒表 */
create table `easyhr_remind`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `remind_type` tinyint(1) NOT NULL DEFAULT 0 COMMENT '提醒类型',
  `content` TEXT NOT NULL COMMENT '提醒内容',
  `remind_time` TIMESTAMP NOT NULL COMMENT '提醒时间',
  `remind_mode` tinyint(1) NOT NULL DEFAULT 0 COMMENT '提醒方式',
  `remind_times` tinyint(1) NOT NULL DEFAULT 0 COMMENT '提醒次数',
  `delay_time` int(11) NOT NULL DEFAULT 3 COMMENT '延期时间',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 类目 */
create table `easyhr_catalogue`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `parent_id` bigint(11) unsigned NOT NULL COMMENT '父节点id',
  `level` tinyint(1) NOT NULL DEFAULT 0 COMMENT '节点等级',
  `order_value` int(3) NOT NULL DEFAULT 0 COMMENT '排序值',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 资源表 */
create table `easyhr_resource`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `origin_name` VARCHAR(50) NOT NULL COMMENT '原文件名称',
  `type` VARCHAR(50) NOT NULL COMMENT '类型',
  `location` VARCHAR(50) NOT NULL COMMENT '路径',
  `desc` VARCHAR(50) NOT NULL COMMENT '描述',
  `content` TEXT NOT NULL COMMENT '内容',
  `parent_id` bigint(11) unsigned NOT NULL COMMENT '父节点id',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 模板 */
drop table if EXISTS `easyhr_template`;
create table `easyhr_template`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` VARCHAR(255) NOT NULL COMMENT '名称',
  `content` TEXT NOT NULL COMMENT '内容',
  `comment` VARCHAR(1024) NOT NULL COMMENT '描述',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 任务表 */
create table `easyhr_task`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` TEXT NOT NULL COMMENT '任务名称',
  `content` VARCHAR(50) NOT NULL COMMENT '任务内容',
  `start_time` TIMESTAMP NOT NULL COMMENT '开始时间',
  `stop_time` TIMESTAMP NOT NULL  COMMENT '截至时间',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '任务状态',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 任务表 */
create table `easyhr_task_instance`(
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `task_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '任务id',
  `execute_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '执行人id',
  `start_time` TIMESTAMP NOT NULL COMMENT '开始时间',
  `stop_time` TIMESTAMP NOT NULL  COMMENT '截至时间',
  `finished_time` TIMESTAMP NOT NULL  COMMENT '完成时间',
  `progress` int(3) NOT NULL DEFAULT 0 COMMENT '任务完成进度',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '任务实例状态',
  `summary` TEXT NOT NULL DEFAULT '' COMMENT '任务总结',
  `gmt_created` TIMESTAMP NOT NULL COMMENT '创建时间',
  `gmt_modified` TIMESTAMP NOT NULL COMMENT '修改时间',
  `created_user_id` bigint(11) unsigned NOT NULL DEFAULT 0 COMMENT '创建人',
  `modified_user_id` bigint(11) unsigned NOT NULL DEFAULT 0  COMMENT '修改人',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;