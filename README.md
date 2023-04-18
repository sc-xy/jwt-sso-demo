# jwt-sso-demo
基于Oauth2和Jwt实现基础的SSO（单点登录功能）
# 快速开始
> 执行`sso-server`目录下`data.sql`并正确配置`application.yml`数据
> 依次启动`sso-server` `sso-client1` `sso-client2`
> 访问`http://localhost:8081/client1/index`即可跳转到登陆界面，在`http://localhost:8080/server/login`登陆后授权即可访问`sso-client1`和`sso-client2`

具体实现思路欢迎到我的博客上查看[某洋の博客 (sc-xy.top)](http://springblog.sc-xy.top/) [XY Blog - 某洋的博客 (sc-xy.top)](https://sc-xy.top/)