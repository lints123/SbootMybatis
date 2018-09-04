【8/20】
要实现的功能点：
登录拦截、权限控制、
日志记录输出（AOP）、过滤器拦截器监听器定时器、
定义BaseController，做日志记录处理
定义BaseParams，做数据传输处理（JSON）
已实现的功能：
分页拦截器，请求的时候，直接往map里面带一个Page对象即可（测试成功，需多次测试）
主要实现步骤
1、拦截执行SQL的请求，判断该SQL是否是select查询
不是，直接跳过
是，判断是否存在page对象
存在，获取page对象，之后查询共有多少条数据，再获取page对象里面的pageNum和pageSize对sql进行拼接。之后执行sql语句

【8/22】
新增配置拦截器，实现HandlerInterceptor，自定义拦截器，可以在内容体对拦截请求做处理，
1、可在拦截器内对请求进行解密，判断是否是恶意攻击
2、可在拦截器内对请求进行保存，防止恶意点击
3、登录用户存放到session中，存放到redis缓存中
4、在拦截器中查询到用户所有的权限，之后存放到session或者缓存中

【8/23】
权限管理
1、js使用tree
2、表：
用户表，角色表，菜单表，部门表

【8/24】
想要做的功能点
QQ、微信登录
登录重设机制
支付接口，微信支付
二维码处理、日志处理

【8/27】
学习了Shiro，明白了Realm相当于数据源
1、需要继承AuthorizingRealm，实现两个方法，一个授权一个认证，之后需要配置SecurityManger。

【8/29】
1、项目单纯加入了Shiro做用户登录控制，目前没有使用数据库，只是在代码中使用map做了数据源
2、接下来新增页面，做权限控制管理

【9/4】
1、学习Shiro，主要功能有，认证，授权，加密，会话管理...
2、使用Shiro做菜单管理，CRUD的管理
   2.1、在Relam中，继承AuthorizingRealm，做身份认证和授权管理，并且授权管理存放到Shiro的StringPermission中
   2.2、在Controller中，定义注解@RequestPermission，并且权限标签，为用户是否具备访问该方法做权限控制
   2.3、在页面中，使用Shiro的标签：<shiro:hasPermission name="">  name中定义的是权限标签，做按钮控制处理
   2.4、参考网站：http://412887952-qq-com.iteye.com/blog/2299777

