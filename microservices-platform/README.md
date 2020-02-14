

<p align="center">
  <img src='https://img.shields.io/badge/license-Apache%202-4EB1BA.svg' alt='License'/>
  <img src="https://img.shields.io/badge/Spring%20Boot-2.1.12.RELEASE-blue" alt="Downloads"/>
  <img src="https://img.shields.io/badge/Spring%20Cloud-Greenwich.SR5-blue" alt="Downloads"/>
  <img src="https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2.1.1.RELEASE-blue" alt="Downloads"/>
  <img src="https://img.shields.io/badge/Layui-EasyWeb-yellowgreen" alt="Downloads"/>
</p>

## 项目描述
1、整体项目基于SpringBoot2.x、SpringCloud和SpringCloudAlibaba并采用前后端分离的企业级微服务多租户系统架构。
2、 引入组件化的思想实现高内聚低耦合，将db、redis、log、ribbon等通用化，可以更方便对项目组件进行调整和优化
3、实现基于RBAC、jwt和oauth2的无状态统一权限认证的解决方案，面向互联网设计同时适合B端和C端用户.
4、支持CI/CD多环境部署，并提供应用管理方便第三方系统接入；同时集合各种微服务治理功能和监控功能。
5、 增加代码生成服务，可以大大缩减基础代码编写的过程
##  模块说明

```lua
microservice-platform -- 父项目，公共依赖
│  ├─zlt-business -- 业务模块一级工程
│  │  ├─user-center -- 用户中心[7000]
│  │  ├─code-generator -- 代码生成器[7300]
│  │  ├─search-center -- 搜索中心
│  │  │  ├─search-client -- 搜索中心客户端
│  │  │  ├─search-server -- 搜索中心服务端[7100]
│  │─zlt-commons -- 通用工具一级工程
│  │  ├─zlt-auth-client-spring-boot-starter -- 封装spring security client端的通用操作逻辑
│  │  ├─zlt-common-core -- 封装通用操作逻辑
│  │  ├─zlt-common-spring-boot-starter -- 封装通用操作逻辑
│  │  ├─zlt-db-spring-boot-starter -- 封装数据库通用操作逻辑
│  │  ├─zlt-log-spring-boot-starter -- 封装log通用操作逻辑
│  │  ├─zlt-redis-spring-boot-starter -- 封装Redis通用操作逻辑
│  │  ├─zlt-ribbon-spring-boot-starter -- 封装Ribbon和Feign的通用操作逻辑
│  │  ├─zlt-sentinel-spring-boot-starter -- 封装Sentinel的通用操作逻辑
│  │  ├─zlt-swagger2-spring-boot-starter -- 封装Swagger通用操作逻辑
│  ├─zlt-config -- 配置中心
│  ├─zlt-doc -- 项目文档
│  ├─zlt-gateway -- api网关一级工程
│  │  ├─sc-gateway -- spring-cloud-gateway[9900]
│  │  ├─zuul-gateway -- netflix-zuul[9900]
│  ├─zlt-monitor -- 监控一级工程
│  │  ├─sc-admin -- 应用监控[6500]
│  │  ├─log-center -- 日志中心[6200]
│  ├─zlt-uaa -- spring-security认证中心[8000]
│  ├─zlt-register -- 注册中心Nacos[8848]
```

&nbsp;

### 权限
*1  验证码获取接口
9900 为getway 网关入口
GET
> http://localhost:9900/api-uaa/validata/code/admin
*2  通过用户名验证码获取token
```
deviceId 为登录设备名称（可以是人名或者设备名称）
validCode 为获取的验证码
```
POST
>http://localhost:9900/api-uaa/oauth/user/token?deviceId=admin&validCode=yrmu&username=admin&password=admin
>头 Authorization: Basic d2ViQXBwOndlYkFwcA==

response:
```
{
  "datas": {
    "access_token": "83a96f84-5fc5-4019-8314-daa83cba472b",
    "token_type": "bearer",
    "refresh_token": "916dd4e9-2771-4e72-a410-db2d843c71be",
    "expires_in": 3599,
    "scope": "app"
  },
  "resp_code": 0,
  "resp_msg": ""
}
```