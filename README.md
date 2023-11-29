## 本项目实现的最终作用是基于JSP植物知识分享论坛系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 帖子管理
 - 用户管理
 - 管理员登录
 - 评论管理
### 第2个角色为用户角色，实现了如下功能：
 - 个人中心
 - 发布帖子
 - 我的帖子
 - 我的评论
 - 查看帖子
 - 用户注册
 - 用户登录
 - 用户首页
 - 评论文章
## 数据库设计如下：
# 数据库设计文档

**数据库名：** zhiwu_bbs

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [hf_info](#hf_info) |  |
| [hospital](#hospital) |  |
| [predict](#predict) |  |
| [question](#question) |  |
| [quick](#quick) |  |
| [t_sys_log](#t_sys_log) |  |
| [t_sys_manager](#t_sys_manager) | 用户管理表 |
| [t_sys_menu](#t_sys_menu) | 菜单表 |
| [t_sys_operate](#t_sys_operate) | 操作表 |
| [t_sys_role](#t_sys_role) |  |
| [t_sys_role_operate](#t_sys_role_operate) |  |
| [user](#user) |  |
| [user_info](#user_info) |  |
| [zt_info](#zt_info) |  |

**表名：** <a id="hf_info">hf_info</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | hf_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | user_id |   varchar   | 255 |   0    |    N     |  N   |       | 用户ID  |
|  3   | zt_id |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | hf_content |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | hf_time |   datetime   | 19 |   0    |    N     |  N   |       |   |
|  6   | user_img |   varchar   | 255 |   0    |    N     |  N   |       |   |

**表名：** <a id="hospital">hospital</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | chcek |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | illness |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | suggestion |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | pet_type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | age |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | predict_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  8   | doctor_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  9   | medical |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | create_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="predict">predict</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | user_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  3   | doctor_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  4   | predict_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  5   | create_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  6   | statu |   int   | 10 |   0    |    Y     |  N   |   NULL    | 0未加急1加急  |
|  7   | deal |   int   | 10 |   0    |    Y     |  N   |   NULL    | 0未就诊1已就诊  |

**表名：** <a id="question">question</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  2   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | desription |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="quick">quick</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | user_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  3   | describe |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | doctor_id |   bigint   | 20 |   0    |    Y     |  N   |   NULL    |   |
|  5   | suggestion |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | create_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  7   | res_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  8   | title |   varchar   | 200 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_sys_log">t_sys_log</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增ID  |
|  2   | account |   varchar   | 50 |   0    |    Y     |  N   |   NULL    | 账号  |
|  3   | title |   varchar   | 40 |   0    |    Y     |  N   |   NULL    | 标题  |
|  4   | methods |   varchar   | 128 |   0    |    Y     |  N   |   NULL    | 执行的方法  |
|  5   | message |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 消息  |
|  6   | ip |   varchar   | 15 |   0    |    Y     |  N   |   NULL    | IP  |
|  7   | duration |   smallint   | 6 |   0    |    Y     |  N   |   NULL    | 执行时间  |
|  8   | params |   longtext   | 2147483647 |   0    |    Y     |  N   |   NULL    | 请求参数  |
|  9   | url |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 请求地址  |
|  10   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  11   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="t_sys_manager">t_sys_manager</a>

**说明：** 用户管理表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增ID  |
|  2   | account |   varchar   | 50 |   0    |    N     |  N   |       | 账号  |
|  3   | password |   varchar   | 50 |   0    |    N     |  N   |       | 密码  |
|  4   | role_id |   tinyint   | 4 |   0    |    Y     |  N   |   NULL    | 角色  |
|  5   | name |   varchar   | 50 |   0    |    Y     |  N   |   NULL    | 姓名  |
|  6   | credential |   varchar   | 100 |   0    |    Y     |  N   |   NULL    | 验证凭证  |
|  7   | locked |   bit   | 1 |   0    |    Y     |  N   |   b'1'    | 是否启用0=禁用1=启用  |
|  8   | email |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  9   | phone |   varchar   | 64 |   0    |    Y     |  N   |   NULL    | 电话  |
|  10   | sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 性别  |
|  11   | type |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 类型  |
|  12   | photo |   varchar   | 266 |   0    |    Y     |  N   |   NULL    | 头像  |
|  13   | last_login_ip |   varchar   | 15 |   0    |    Y     |  N   |   NULL    | 登陆IP  |
|  14   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  15   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="t_sys_menu">t_sys_menu</a>

**说明：** 菜单表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增ID  |
|  2   | name |   varchar   | 50 |   0    |    N     |  N   |       | 名称  |
|  3   | remark |   varchar   | 2000 |   0    |    Y     |  N   |   NULL    | 备注  |
|  4   | icon |   varchar   | 100 |   0    |    Y     |  N   |   NULL    | 图标  |
|  5   | channel |   varchar   | 100 |   0    |    Y     |  N   |   NULL    | 渠道  |
|  6   | param |   varchar   | 200 |   0    |    Y     |  N   |   NULL    |   |
|  7   | locked |   bit   | 1 |   0    |    Y     |  N   |   b'1'    | 是否启用0=禁用1=启用  |
|  8   | pater_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 父级编号  |
|  9   | ordno |   int   | 10 |   0    |    Y     |  N   |   NULL    | 排序编号  |
|  10   | n_level |   int   | 10 |   0    |    Y     |  N   |   NULL    | 级别  |
|  11   | scort |   varchar   | 100 |   0    |    Y     |  N   |   NULL    | tree所需  |
|  12   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  13   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="t_sys_operate">t_sys_operate</a>

**说明：** 操作表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | menu_id |   int   | 10 |   0    |    N     |  N   |       | 菜单ID  |
|  3   | op |   varchar   | 30 |   0    |    N     |  N   |       | 选项  |
|  4   | name |   varchar   | 64 |   0    |    N     |  N   |       | 名字  |
|  5   | icon |   varchar   | 50 |   0    |    Y     |  N   |   NULL    | 图标  |
|  6   | remark |   varchar   | 2000 |   0    |    Y     |  N   |   NULL    | 备注  |
|  7   | ordno |   int   | 10 |   0    |    Y     |  N   |   NULL    | 排序号  |
|  8   | display |   int   | 10 |   0    |    N     |  N   |       | 是否显示出来  |
|  9   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  10   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="t_sys_role">t_sys_role</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | name |   varchar   | 50 |   0    |    N     |  N   |       | 角色名  |
|  3   | code |   varchar   | 50 |   0    |    Y     |  N   |   NULL    | 编号  |
|  4   | remark |   varchar   | 200 |   0    |    Y     |  N   |   NULL    | 备注  |
|  5   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  6   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="t_sys_role_operate">t_sys_role_operate</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | role_id |   int   | 10 |   0    |    N     |  Y   |       | 角色ID  |
|  2   | operate_id |   int   | 10 |   0    |    N     |  Y   |       | 操作表ID  |
|  3   | gmt_create |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | gmt_modified |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    | 最后修改时间  |

**表名：** <a id="user">user</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   bigint   | 20 |   0    |    N     |  Y   |       |   |
|  2   | account |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | lock |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | create_time |   timestamp   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  6   | nickname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="user_info">user_info</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user_id |   varchar   | 255 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | user_password |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  3   | user_nickname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | user_sex |   int   | 10 |   0    |    N     |  N   |   0    |   |
|  5   | user_modificationtime |   timestamp   | 19 |   0    |    N     |  N   |   current_timestamp()    |   |
|  6   | user_del |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  7   | user_level |   int   | 10 |   0    |    N     |  N   |   0    |   |
|  8   | user_regdate |   datetime   | 19 |   0    |    Y     |  N   |   NULL    |   |
|  9   | user_img |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="zt_info">zt_info</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | zt_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | user_id |   varchar   | 255 |   0    |    N     |  N   |       | 用户ID  |
|  3   | zt_theme |   varchar   | 255 |   0    |    Y     |  N   |   '植物'    |   |
|  4   | zt_title |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  5   | zt_content |   varchar   | 10000 |   0    |    Y     |  N   |   NULL    |   |
|  6   | zt_hfl |   int   | 10 |   0    |    Y     |  N   |   0    |   |
|  7   | zt_time |   datetime   | 19 |   0    |    N     |  N   |       |   |
|  8   | user_img |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**运行不出来可以微信 javape 我的公众号：源码码头**
