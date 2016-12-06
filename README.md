用户登录模块
===================
#### <i class="icon-file"></i>用户表（t_user）
-------------
| 字段        | 类型           | 是否为空  | 中文名  |
| ------------- |:-------------:| -----:|
| <kbd>id</kbd>      | varchar(32) | primary key not null |	id |
| <kbd>username</kbd>      | varchar(50)      |   not null |   登录名 |
| <kbd>passwd</kbd> | varchar(32)      |    not null |    密码 |
| <kbd>displayname</kbd> | varchar(50)      |    not null |    姓名 |

#### <i class="icon-cog"></i>功能模块
-------------
####RESTFUL接口
* **用户登录**
```sh
url: /login
type: post
```
* **用户登出**
```sh
url: /logout
type: get
```