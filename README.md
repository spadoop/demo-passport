用户登录模块
===================
#### <i class="icon-file"></i>用户表（t_user）
-------------
| 字段        | 类型           | 是否为空  |
| ------------- |:-------------:| -----:|
| <kbd>id</kbd>      | varchar(32) | primary key not null |
| <kbd>username</kbd>      | varchar(50)      |   not null |
| <kbd>passwd</kbd> | varchar(32)      |    not null |
| <kbd>displayname</kbd> | varchar(50)      |    not null |