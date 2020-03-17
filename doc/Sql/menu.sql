


-- 用户信息表
create table menu_user
( 
			menu_user_id int primary key AUTO_INCREMENT,-- 唯一ID   格式:100001
			 menu_user_name varchar(50) null, -- 昵称
			 menu_user_sex int null, -- 性别
			 menu_user_birthday date null, -- 生日
			 menu_user_hometown varchar(50) null, -- 家乡
			 menu_user_location varchar(100) null, -- 所在地
			 menu_user_occupation varchar(20) null, -- 职业
			 menu_user_autograph varchar(200) null, -- 个性签名
			 menu_user_email varchar(50) null, -- 邮箱 用作登录
		   menu_user_tel varchar(50) null, -- 电话
		 	 menu_user_fans varchar(50) null, -- 粉丝
			 menu_user_follow varchar(50) null, -- 关注
			 menu_user_image varchar(50) null -- 头像	
);

-- 用户关注 粉丝表
create table menu_user_follow
(
	menu_user_follow_id int primary key AUTO_INCREMENT, --唯一ID   格式:100001
	menu_user_follow int not null, -- 关注用户ID
	 menu_user int not null -- 用户ID
);

 -- 用户收藏表
create table menu_user_collection
(
	menu_user_collection_id int primary key AUTO_INCREMENT, --唯一ID   格式:100001
    menu_user_id int not null, -- 收藏用户ID
	--menu_collection_id varchar(50) not null -- 收藏ID ：菜谱ID  文章ID  视频ID
	menu_food_id int, -- 菜谱ID
	menu_article_id int, -- 文章ID
	
);

-- 用户菜谱表
create table menu_user_food
( 
	menu_user_food_id int primary key AUTO_INCREMENT, --唯一ID   格式:100001
    menu_user_id varchar(50) not null, -- 用户ID
		menu_food_id varchar(50) not null -- 菜谱ID
);


-- 用户文章表
create table menu_user_article
(
	menu_user_article_id int primary key AUTO_INCREMENT, --唯一ID   格式:100001
    menu_user_id varchar(50) not null, -- 用户ID
		menu_article_id int not null -- 文章ID
);

-- -- 用户视频表
-- create table menu_user_video
-- (
--      menu_user_id varchar(50) not null, -- 用户ID
-- 		 menu_video_id varchar(50) not null -- 视频ID
-- );

-- 用户动态表
create table menu_user_dynamic
(
	menu_user_dynamic_id int primary key AUTO_INCREMENT, --唯一ID   格式:100001
     menu_user_id int not null, -- 用户ID
		 menu_dynamic_content varchar(200) null , -- 内容
		 menu_sender_id int, -- 发送者ID 
		 menu_dynamic_time date -- 发送时间
);




-- 菜谱表
create table menu_food
(
        menu_food_id int primary key AUTO_INCREMENT, -- 菜谱ID 格式：1000001 唯一
		menu_food_name varchar(50) null, -- 菜名
		menu_food_cuisine varchar(50) null, -- 菜系
		menu_food_classified varchar(50) null, -- 菜品
		menu_food_technology varchar(50) null , -- 工艺
		menu_food_flavor varchar(50) null, -- 口味
		menu_food_difficulty varchar(50) null, -- 难度
		menu_food_reparation_time date null, -- 准备时间
		menu_food_number varchar(50) null, -- 人数
		menu_food_cooking_time date null, -- 烹饪时间
		menu_food_step varchar(50) null , -- 步骤表 关联ID为菜谱ID
		menu_food_ingredients varchar(50) null, -- 材料表 管关联ID为菜谱ID
		menu_food_image varchar(50) null , -- 成品图表 管理ID为菜谱ID
		menu_user_id int null, -- 作者ID
		menu_food_introduce varchar(200) null, -- 简介
		menu_food_label varchar(50) null , -- 标签 审核后添加
		menu_food_story varchar(200) null, -- 故事
		menu_food_comment int null, -- 评论 关联于菜谱ID
		menu_food_state varchar(50) null -- 状态 是否审核
);


-- 菜系表
create table menu_cuisine
(
    menu_cuisine_id int primary key AUTO_INCREMENT, -- ID 格式：1000001 唯一
    menu_cuisine_name varchar(50) not null -- 菜系名称
);

-- 菜品表
create table menu_classified
(
    menu_classified_id int primary key AUTO_INCREMENT, -- ID 格式：1000001 唯一
  menu_classified_name varchar(50) not null -- 菜品名称
);

-- 食材表
create table menu_food_ingredients
(
   menu_food_ingredients_id int primary key AUTO_INCREMENT, -- 唯一ID 格式: 1000001
	 menu_ingredients_name varchar(50) null, -- 食材名
	 menu_ingredients_alias varchar(50) null, -- 别名
	 menu_ingredients_proposal varchar(50) null, -- 食量建议
	 menu_ingredients_suitable varchar(50) null, -- 适应人群
	 menu_ingredients_taboo varchar(50)	null, -- 禁忌人群
	 menu_ingredients_label varchar(50) null, -- 标签
	 menu_ingredients_remarks varchar(50) null -- 备注
);

-- 食材类别表
create table menu_ingredients_classified
(
   menu_ingredients_classified_id int primary key AUTO_INCREMENT, -- 唯一ID 格式: 1000001
   menu_ingredients_classified_name varchar(50) not null -- 食材类别
);

-- 标签表
create table menu_label
(
   menu_label_id int primary key AUTO_INCREMENT, -- 唯一ID 格式: 1000001
	menu_label_name varchar(50) not null , -- 标签名字
	menu_label_category varchar(50) not null , -- 标签类别 文章标签、菜谱标签、视频标签
	menu_label_image varchar(50) not null -- 标签图片
);




-- 文章表
create table  menu_atricle
(
   menu_article_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
	 menu_article_title varchar(50) null, -- 标题
	 menu_article_content varchar(2000) not null, -- 内容
	 menu_atricle_image varchar(50) null, -- 图片
	 menu_user_id int null, -- 作者ID
	 menu_user_comment varchar(50), -- 评论ID 关联为文章ID
	 menu_user_time date not null, -- 上传时间
	 menu_user_state varchar(50) null, -- 状态
	 menu_user_classified varchar(50) null -- 审核后可添加
);


-- 文章类别表
create table menu_atricle_classified
(
  menu_atricle_classified_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
  menu_article_classified_name varchar(50) -- 文章类别
);

-- 评论表
create table menu_comment
(
   menu_comment_id int primary key AUTO_INCREMENT, -- 评论ID 唯一ID 格式：100001
	 menu_comment_content varchar(200) null , -- 评论内容
	 menu_user_id int null -- 用户ID 
);

-- 回复表
create table menu_reply
(
	menu_reply_id int primary key AUTO_INCREMENT, -- 回复ID 唯一ID 格式：100001
	menu_comment_id varchar(50) not null, -- 绑定评论表
	menu_reply_text varchar(200) not null , -- 回复内容
	menu_reply_user_id int not null , -- 用户ID
	menu_reply_lastid int not null-- 上一条回复ID
);


-- 内容展示(三餐)
create table menu_floor_one
(
	menu_floor_one_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_food_id varchar(50) not null -- 展示内容
);

-- 内容展示(菜)
create table menu_floor_two
(
	menu_floor_two_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_food_id varchar(50) not null -- 展示内容
);

-- 内容展示(文章)
create table menu_floor_three
(
   menu_floor_three_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_article_id int not null -- 展示内容 文章ID
);

-- 内容展示(热门)
create table menu_floor_four
(
   menu_floor_four_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_content_label int not null -- 展示内容
);


-- 工艺表
create table menu_technology
(
	menu_technology_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_echnology_name varchar(50) not null -- 工艺名称
);

-- 口味表
create table menu_flavor
(
	menu_flavor_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_flavor_name varchar(50) not null -- 口味名称
);

-- 难度表
create table menu_difficulty
(
	menu_difficulty_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_difficulty_name varchar(50) not null -- 难度名称
);

-- 准备时间表
create table menu_reparation_time
(
	menu_reparation_time_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
  menu_reparation_time varchar(50) not null -- 准备时间表
);


-- 人数表
create table menu_number
(
 menu_number_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_number_name varchar(50) not null -- 人数级别
);

-- 烹饪时间表
create table menu_cooking_time
(
	menu_cooking_time_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
  menu_cooking_time varchar(50) not null -- 烹饪时间
);

-- 原材料表
create table menu_ingredients
(
	menu_ingredients_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
   menu_food_id int not null, -- 菜谱ID
	 menu_ingredients_name varchar(50) not null, -- 材料名称
	 menu_ingredients_number varchar(50) not null, -- 用量
	 menu_ingredients_nickname varchar(50) not null -- 分类
);

-- 步骤表
create table menu_food_step
(
	menu_food_step_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：100001
	menu_food_id int not null, -- 菜谱ID
	 menu_step_order int not null, -- 步骤顺序
	 menu_step_image varchar(50) null, -- 步骤图
	 menu_step_nickname varchar(50) null, -- 主料或者辅料
	 menu_step_number varchar(50) null, -- 用量
	 menu_step_text varchar(100) null, -- 介绍
	 menu_step_time varchar(100) null -- 所需时间
);


-- 菜谱草稿
create table menu_food_draft
(
menu_food_draft_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：10000
   menu_food_id int not null, -- 菜谱ID
	 menu_draft_user varchar(50) not null, -- 用户ID
	 menu_draft_state varchar(50) null -- 状态
	
);

-- 文章草稿
create table menu_article_draft
(
	menu_article_draft_id int primary key AUTO_INCREMENT, -- 唯一ID 格式：1000
   menu_article_id int not null, -- 文章ID
	 menu_draft_user int not null, -- 用户ID
	 menu_draft_state varchar(50) null  -- 状态
	 
);


-- -- 视频草稿
-- create table menu_video_draft
-- (
--    menu_video_id varchar(50) not null, -- 视频ID
-- 	 menu_draft_user varchar(50) not null, -- 用户ID
-- 	 menu_draft_state varchar(50) null  -- 状态
--    menu_admin_user varchar(50) null -- 审核人
-- );


-- 菜谱视频
create table menu_food_video
(
	menu_food_video_id int primary key AUTO_INCREMENT, -- 视频ID 格式： 100001
	 menu_video_name varchar(50) not null , -- 视频名称
	 menu_video_label varchar(50) not null, -- 标签
	 menu_video_classified varchar(50) not null , -- 分类
	 menu_video_admin int not null , -- 上传者
	 menu_video_time date not null , -- 发布时间
	 menu_video_play varchar(50) -- 播放量
	 
);


-- 视频做法表

create table menu_video_step
(
	menu_video_step_id int primary key AUTO_INCREMENT, -- ID 格式： 100001
    menu_food_video_id int not null , -- 视频ID
		menu_video_practice varchar(200) not null , -- 做法
	  menu_video_order int not null  -- 顺序	
);


-- 消息推送表
create table menu_message_push
(
   menu_message_push_id int primary key AUTO_INCREMENT, -- ID 格式： 100001
   menu_push_admin int not null , -- 推送人 管理员
	 menu_push_content varchar(500) not null , -- 推送内容
	 menu_push_user int not null , -- 接收人 用户
	 menu_push_time date not null , -- 推送时间
	 menu_push_file varchar(200) -- 附件  
 );
 
 
 -- 文章审核表
create table menu_examine_article
 (
	menu_examine_article_id int primary key AUTO_INCREMENT, -- ID 格式： 100001
    menu_article_id int not null , -- 文章ID
		menu_examine_state varchar(50) not null, -- 审核状态
		menu_examine_admin int not null , -- 审核人 管理员
		menu_examine_time date not null  -- 审核时间
 );
 
  -- 菜谱审核表
create table menu_examine_food
 (
	menu_examine_food_id int primary key AUTO_INCREMENT, -- ID 格式： 100001
    menu_food_id int not null , -- 菜谱ID
		menu_examine_state varchar(50) not null, -- 审核状态
		menu_examine_admin int not null , -- 审核人 管理员
		menu_examine_time date not null  -- 审核时间
 );
 
 

-- 角色表
create table menu_role
(
  
);

-- 资源表
create table menu_module
(
  
);


-- 网页数据显示表
create table menu_data
(
);


alter table menu_user AUTO_INCREMENT=100001
alter table menu_user_follow AUTO_INCREMENT=100001
alter table menu_user_collection AUTO_INCREMENT=100001
alter table menu_user_food AUTO_INCREMENT=100001
alter table menu_user_article AUTO_INCREMENT=100001
alter table menu_user_dynamic AUTO_INCREMENT=100001
alter table menu_cuisine AUTO_INCREMENT=100001
alter table menu_classified AUTO_INCREMENT=100001
alter table menu_food_ingredients AUTO_INCREMENT=100001
alter table menu_ingredients_classified AUTO_INCREMENT=100001
alter table menu_label AUTO_INCREMENT=100001
alter table menu_atricle AUTO_INCREMENT=100001
alter table menu_atricle_classified AUTO_INCREMENT=100001
alter table menu_comment AUTO_INCREMENT=100001
alter table menu_reply AUTO_INCREMENT=100001
alter table menu_floor_one AUTO_INCREMENT=100001
alter table menu_floor_two AUTO_INCREMENT=100001
alter table menu_floor_three AUTO_INCREMENT=100001
alter table menu_floor_four AUTO_INCREMENT=100001
alter table menu_technology AUTO_INCREMENT=100001
alter table menu_flavor AUTO_INCREMENT=100001
alter table menu_difficulty AUTO_INCREMENT=100001
alter table menu_reparation_time AUTO_INCREMENT=100001
alter table menu_number AUTO_INCREMENT=100001
alter table menu_cooking_time AUTO_INCREMENT=100001
alter table menu_ingredients AUTO_INCREMENT=100001
alter table menu_food_step AUTO_INCREMENT=100001
alter table menu_food_draft AUTO_INCREMENT=100001
alter table menu_article_draft AUTO_INCREMENT=100001
alter table menu_food_video AUTO_INCREMENT=100001
alter table menu_video_step AUTO_INCREMENT=100001
alter table menu_message_push AUTO_INCREMENT=100001
alter table menu_examine_article AUTO_INCREMENT=100001
alter table menu_examine_food AUTO_INCREMENT=100001







