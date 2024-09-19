## 基于若依的美业智慧平台网页端管理系统

基于若依的美业智慧平台网页端管理系统

* 前端采用Vue、Element UI。
* 后端采用Spring Boot、Spring Security、Redis & Jwt。
* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。

## 功能概述

1.  商品管理：商品、商品分类和商品订单的管理，特别包含**发货**功能，可以通过扫码枪扫码快递条码录入或输入快递单号，发货后小程序端可以查看实时物流详情
2.  小程序页面内容管理：包含小程序中的轮播图、滚动通知、九宫格导航都可以修改其图片、名称、跳转页面地址（目的是尽可能让小程序的数据都可以修改，可以一个管理系统**实现多个不同类型的小程序的管理**，比如美容预约、博物馆预约、景点预约等等）
3.  预约管理：包含服务项目分类、美容师排班、服务项目及订单管理，特别指出服务项目订单管理可以**核验预约券码**（小程序端的），核验成功后的订单状态变为待评价
4.  用户管理：可以查看所有已经注册登录的用户信息，包括昵称，手机号等信息，以便于后续的客户回访联系
5.  若依原生的导出Excel功能等

## 演示图

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214331484.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214400437.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214424330.png)

**发货**

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214448508.png)

小程序页面内容管理：

**尽可能让所有的小程序里面的数据都可以进行修改**，这里轮播图、滚动通知、九宫格导航都可以修改图片、名字以及跳转类型，跳转地址都可以进行修改，并且可以实现真正的跳转

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919215437456.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214519305.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214943304.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919215559379.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919214927984.png)

**预约管理**

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919215800316.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919215841165.png)

**新增美容师排班：**

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919215939516.png)

**核验美容项目订单券码：**

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919220214872.png)

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919220255330.png)

核验成功之后，订单状态改为 待评价：

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919220404098.png)

用户管理：

可以查看所有已经注册登录的用户信息，包括昵称，手机号等信息，以便于后续的客户回访联系

![Image text](https://github.com/luoping123/MeiYeAdmin/blob/main/README.assets/image-20240919220537614.png)
