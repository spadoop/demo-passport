用户登录模块
===================
> 系统用户登录、登出模块

#### <i class="icon-file"></i>用户表（t_user）
-------------
| 字段        | 类型           | 是否为空  | 中文名  |
| ------------- |:-------------:| -----:| -----:|
| <kbd>id</kbd>      | varchar(32) | primary key not null |	id |
| <kbd>username</kbd>      | varchar(50)      |   not null |   登录名 |
| <kbd>passwd</kbd> | varchar(32)      |    not null |    密码 |
| <kbd>displayname</kbd> | varchar(50)      |    not null |    姓名 |

#### <i class="icon-cog"></i>功能模块
-------------
#### RESTFUL接口
* **用户登录**

<kbd>暴露的接口及类型</kbd>
```
url:/login
type: post
```

<kbd>返回数据的JSON格式</kbd>
```
{
"code":200,
"message":"后台返回处理结果消息",
"data":"如果不传入数据则留空"
}
```
* **用户登出**

<kbd>暴露的接口及类型</kbd>
```
url: /logout
type: get
```

<kbd>返回数据的JSON格式</kbd>
```
{
"code":200,
"message":"后台返回处理结果消息",
"data":"如果不传入数据则留空"
}
```
