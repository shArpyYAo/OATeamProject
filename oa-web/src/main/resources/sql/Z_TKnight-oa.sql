# ======================================================================================================== #
# 数据库
# ======================================================================================================== #

drop database if exists z_tknight_oa;

create database z_tknight_oa;

use z_tknight_oa;

# ======================================================================================================== #
# 用户信息表
# ======================================================================================================== #

create table t_user (															/* 【用户信息表】 */
	user_no int(4) not null auto_increment comment '用户编号',					/* 用户编号 */
	user_name varchar(15) not null comment '用户名',							/* 用户名 */
	password varchar(20) not null comment '密码',								/* 密码 */
	nick_name varchar(20) not null comment '昵称',								/* 昵称 */
	introduction varchar(250) comment '介绍',									/* 介绍 */
	dept_no int(4) comment '用户所属部门',										/* 用户所属部门 */
	back_up int(4) comment '备用字段',											/* 备用字段 */
	primary key(user_no)														/* 主键 */
) comment = '用户信息表';

create table t_role (															/* 【角色表】 */
	role_no int(4) not null auto_increment comment '角色编号',					/* 角色编号 */
	role_name varchar(20) not null comment '角色名',							/* 角色名 */
	primary key(role_no)														/* 主键 */
) comment = '角色表';

create table t_permission (														/* 【权限表】 */
	permission_no int(4) not null auto_increment comment '权限编号',			/* 权限编号 */
	permission_name varchar(20) not null comment '权限名',						/* 权限名 */
	primary key(permission_no)													/* 主键 */
) comment = '权限表';

# ======================================================================================================== #
# 顺序表
# ======================================================================================================== #

create table t_board_order (													/* 【看板顺序表】 */
	order_no int(4) not null auto_increment comment '顺序编号',					/* 顺序编号 */
	board_space_no int(4) not null comment '看板空间编号',						/* 看板空间编号 */
	board_order text not null comment '看板顺序',								/* 看板顺序 */
	primary key(order_no)														/* 主键 */
) comment = '看板顺序表';

create table t_list_order (														/* 【列表顺序表】 */
	order_no int(4) not null auto_increment comment '顺序编号',					/* 顺序编号 */
	board_no int(4) not null comment '看板编号',								/* 看板编号 */
	list_order text not null comment '列表顺序',								/* 列表顺序 */
	primary key(order_no)														/* 主键 */
) comment = '列表顺序表';

create table t_card_order (														/* 【卡片顺序表】 */
	order_no int(4) not null auto_increment comment '顺序编号',					/* 顺序编号 */
	list_no int(4) not null comment '列表编号',									/* 列表编号 */
	card_order text not null comment '卡片顺序',								/* 卡片顺序 */
	primary key(order_no)														/* 主键 */
) comment = '卡片顺序表';

# ======================================================================================================== #
# 关系表
# ======================================================================================================== #

create table t_board_space_user (												/* 【看板空间和用户关系表】 */
	relation_no int(4) not null auto_increment comment '关系编号',				/* 关系编号 */
	board_space_no int(4) not null comment '看板空间编号',						/* 看板空间编号 */
	user_no int(4) not null comment '用户编号',									/* 用户编号 */
	primary key(relation_no)													/* 主键 */
) comment = '看板空间和用户关系表';

create table t_card_user (														/* 【卡片和用户关系表】 */
	relation_no int(4) not null auto_increment comment '关系编号',				/* 关系编号 */
	card_no int(4) not null comment '卡片编号',									/* 卡片编号 */
	user_no int(4) not null comment '用户编号',									/* 用户编号 */
	primary key(relation_no)													/* 主键 */
) comment = '卡片和用户关系表';

create table t_card_tag (														/* 【卡片和标签关系表】 */
	relation_no int(4) not null auto_increment comment '关系编号',				/* 关系编号 */
	card_no int(4) not null comment '卡片编号',									/* 卡片编号 */
	tag_no int(4) not null comment '标签编号',									/* 标签编号 */
	primary key(relation_no)													/* 主键 */
) comment = '卡片和标签关系表';

create table t_user_roles (														/* 【用户角色关系表】 */
	user_roles_no int(4) not null auto_increment comment '用户角色关系编号',	/* 用户角色关系编号 */
	user_no int(4) not null comment '用户编号',									/* 用户编号 */
	role_no int(4) not null comment '角色编号',									/* 角色编号 */
	primary key(user_roles_no)													/* 主键 */
) comment = '用户角色关系表';

create table t_role_permissions (												/* 【角色权限关系表】 */
	role_permissions_no 
	int(4) not null auto_increment comment '角色权限关系编号',					/* 角色权限关系编号 */
	role_no int(4) not null comment '角色编号',									/* 角色编号 */
	permission_no int(4) not null comment '权限编号',							/* 权限编号 */
	primary key(role_permissions_no)											/* 主键 */
) comment = '角色权限关系表';

# ======================================================================================================== #
# 类别表
# ======================================================================================================== #

create table t_board_space_category (											/* 【看板空间类别表】 */
	category_no int(4) not null auto_increment comment '看板空间类别编号',		/* 看板空间类别编号 */
	category_name varchar(20) not null comment '看板空间类别名称',				/* 看板空间类别名称 */
	primary key(category_no)													/* 主键 */
) comment = '看板空间类别表';

create table t_board_display_category (											/* 【看板可见性类别表】 */
	category_no int(4) not null auto_increment comment '看板空间类别编号',		/* 看板可见性类别编号 */
	category_name varchar(20) not null comment '看板空间类别名称',				/* 看板可见性类别名称 */
	primary key(category_no)													/* 主键 */
) comment = '看板可见性类别表';

# ======================================================================================================== #
# 基础数据表
# ======================================================================================================== #

create table t_department (														/* 【部门信息表】 */
	dept_no int(4) not null auto_increment comment '部门编号',					/* 部门编号 */
	dept_name varchar(20) not null comment '部门名称',							/* 部门名称 */
	user_no int(4) not null comment '部门所有者编号',							/* 部门所有者编号 */
	superior_dept_no int(4) comment '上级部门编号',								/* 上级部门编号 */
	t_board_space int(4) not null comment '部门所属看板空间编号',				/* 部门所属看板空间编号 */
	primary key(dept_no)														/* 主键 */
) comment = '部门信息表';

create table t_board_space (													/* 【看板空间信息表】 */
	board_space_no int(4) not null auto_increment comment '看板空间编号',		/* 看板空间编号 */
	board_space_name varchar(70) not null comment '看板空间名称',				/* 看板空间名称 */
	summary varchar(70) not null comment '看板空间摘要',						/* 看板空间摘要 */
	category_no int(4) not null comment '看板空间类型',							/* 看板空间类型 */
	user_no int(4) not null comment '看板空间所有者编号',						/* 看板空间所有者编号 */
	is_delete bit(1) not null comment '删除标记',								/* 删除标记 */
	primary key(board_space_no)													/* 主键 */
) comment = '看板空间信息表';

create table t_board (															/* 【看板信息表】 */
	board_no int(4) not null auto_increment comment '看板空间编号',				/* 看板编号 */
	board_name varchar(70) not null comment '看板空间名称',						/* 看板名称 */
	display_no int(4) not null comment '看板可见性编号',						/* 看板可见性编号 */
	start_time timestamp not null 
	default current_timestamp comment '看板有效起始时间',						/* 看板有效起始时间 */
	end_time datetime not null comment '看板有效截止时间',						/* 看板有效截止时间 */
	board_space_no int(4) not null comment '所属看板空间编号',					/* 所属看板空间编号 */
	is_delete bit(1) not null comment '删除标记',								/* 删除标记 */
	user_no int(4) not null comment '看板所有者编号',							/* 看板所有者编号 */
	primary key(board_no)														/* 主键 */
) comment = '看板信息表';

create table t_list (															/* 【列表信息表】 */
	list_no int(4) not null auto_increment comment '列表编号',					/* 列表编号 */
	list_name varchar(100) not null comment '列表名称',							/* 列表名称 */
	board_space_no int(4) not null comment '所属看板空间编号',					/* 所属看板空间编号 */
	board_no int(4) not null comment '所属看板编号',							/* 所属看板编号 */
	is_delete bit(1) not null comment '删除标记',								/* 删除标记 */
	primary key(list_no)														/* 主键 */
) comment = '列表信息表';

create table t_card (															/* 【卡片信息表】 */
	card_no int(4) not null auto_increment comment '卡片编号',					/* 卡片编号 */
	card_title varchar(4000) not null comment '卡片内容',						/* 卡片内容 */
	work_load double comment '工作量',											/* 工作量 */
	end_time datetime comment '截止时间',										/* 截止时间 */
	board_space_no int(4) not null comment '所属看板空间编号',					/* 所属看板空间编号 */
	board_no int(4) not null comment '所属看板编号',							/* 所属看板编号 */
	list_no int(4) not null comment '所属列表编号',								/* 所属列表编号 */
	list_name varchar(100) not null comment '所属的列表名称',					/* 所属的列表名称 */
	is_delete bit(1) not null comment '删除标记',								/* 删除标记 */
	primary key(card_no)														/* 主键 */
) comment = '卡片信息表';

# ======================================================================================================== #
# 拓展数据表
# ======================================================================================================== #

create table t_tag (															/* 【标签信息表】 */
	tag_no int(4) not null auto_increment comment '标签编号',					/* 标签编号 */
	tag_name varchar(20) not null comment '标签内容',							/* 标签内容 */
	board_space_no int(4) not null comment '所属看板空间编号',					/* 所属看板空间编号 */
	board_no int(4) not null comment '所属看板编号',							/* 所属看板编号 */
	primary key(tag_no)															/* 主键 */
) comment = '标签信息表';

create table t_comment (														/* 【评论信息表】 */
	comment_no int(4) not null auto_increment comment '评论编号',				/* 评论编号 */
	comment varchar(20) not null comment '评论内容',							/* 评论内容 */
	card_no int(4) not null comment '所属卡片编号',								/* 所属卡片编号 */
	user_no int(4) not null comment '评论发起用户编号',							/* 评论发起用户编号 */
	primary key(comment_no)														/* 主键 */
) comment = '评论信息表';

# ======================================================================================================== #
# 日志表
# ======================================================================================================== #

create table operation_log (													/* 【操作日志表】 */
	log_no int(4) not null auto_increment comment '操作日志编号',				/* 操作日志编号 */
	user_no int(4) comment '操作用户编号',										/* 操作用户编号 */
	operation varchar(20) not null comment '操作描述',							/* 操作描述 */
	exception varchar(4000) comment '操作异常信息',								/* 操作异常信息 */
	method_name varchar(50) not null comment '接口调用方法名',					/* 接口调用方法名 */
	params varchar(250) comment '传入参数',										/* 传入参数 */
	ip varchar(30) not null comment '客户端ip',									/* 客户端ip */
	begin_time datetime not null comment '操作起始时间',						/* 操作起始时间 */
	operation_time bigint(8) not null comment '操作时间',						/* 操作时间 */
	url varchar(250) not null comment '请求url',								/* 请求url */
	state bit not null default 0 comment '操作成功与否',						/* 操作成功与否 */
	primary key(log_no)															/* 主键 */
) comment = '操作日志表';

create table t_card_history (													/* 【卡片历史信息表】 */
	history_no int(4) not null auto_increment comment '卡片操作记录编号',		/* 卡片操作记录编号 */
	from_user_id int(4) not null comment '操作用户',							/* 操作用户 */
	to_user_id int(4) not null comment '被操作用户',							/* 被操作用户 */
	from_list_name varchar(100) not null comment '操作前所属列表名称',			/* 操作后所属列表名称 */
	to_list_name varchar(100) not null comment '操作后所属列表名称',			/* 操作后所属列表名称 */
	from_card_title varchar(4000) not null comment '操作前卡片内容',			/* 操作前卡片内容 */
	to_card_title varchar(4000) not null comment '操作后卡片内容',				/* 操作后卡片内容 */
	board_space_no int(4) not null comment '所属看板空间编号',					/* 所属看板空间编号 */
	board_no int(4) not null comment '所属看板编号',							/* 所属看板编号 */
	primary key(history_no)														/* 主键 */
) comment = '卡片历史信息表';

create table t_user_notice (													/* 【用户通知表】 */
	notice_no int(4) not null auto_increment comment '通知记录编号',			/* 通知记录编号 */
	from_user_id int(4) not null comment '操作用户',							/* 操作用户 */
	to_user_id int(4) not null comment '被操作用户',							/* 被操作用户 */
	list_name varchar(100) not null comment '所属列表名称',						/* 所属列表名称 */
	board_space_no int(4) comment '所属看板空间编号',							/* 所属看板空间编号 */
	board_space_name varchar(70) comment '所属看板空间名称',					/* 所属看板空间名称 */
	board_no int(4) comment '所属看板编号',										/* 所属看板编号 */
	board_name varchar(70) comment '所属看板名称',								/* 所属看板名称 */
	card_no int(4) comment '操作卡片编号',										/* 操作卡片编号 */
	card_title varchar(4000) comment '操作卡片内容',							/* 操作卡片内容 */
	primary key(notice_no)														/* 主键 */
) comment = '用户通知表';

# ======================================================================================================== #
# 初始化数据
# ======================================================================================================== #


/* 看板空间类别初始值 */
insert into t_board_space_category(category_no, category_name) 
	values(null, "个人空间"), (null, "普通项目"), (null, "标星项目");
/* 看板可见性类别初始值 */
insert into t_board_display_category(category_no, category_name) 
	values(null, "仅看板成员可见"), (null, "仅项目成员可见"), (null, "所有人可见");