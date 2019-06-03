# HTTPHeadModifer
一款快速修改HTTP数据包头的Burp Suite插件

![HTTPHeadModifer插件菜单](HTTPHeadModifer.png)

## 一、插件功能
#### 1.添加IP相关的HTTP头
作用：方便测试IP伪造，WAF绕过，HTTP盲攻击等等

|id|head|description|
|:---:|:---|:---|
|1|X-Forwarded-For||
|2|X-Forwarded-Host||
|3|X-Remote-IP||
|4|X-Remote-Addr||
|5|X-Originating-IP||
|6|True-Client-IP||
|7|Client-IP||
|8|X-Client-IP||
|9|X-Real-IP||
|10|All-IP(懒人)||

#### 2.切换User-Agent
作用：快速切换各大浏览器在不同平台下的User-Agetn。

|id|head|description|
|:---:|:---|:---|
|1|Firefox UserAgent|包含Firefox浏览器在安卓，Mac，Ubuntu，Windows平台下的UserAgent|
|2|Chorme UserAgent|包含Chorme浏览器在安卓，Mac，Ubuntu，Windows，iPhone等平台下的UserAgent|
|3|Edge UserAgent|包含Edge浏览器11和12版本的UserAgent|
|4|IE UserAgent|包含IE浏览器6，7，8，9，10，11版本的UserAgent|
|5|Opera UserAgent|包含Opera浏览器在Mac和Windows平台的UserAgent|
|6|Safari UserAgent|包含Safari浏览器在Mac，Windows，iPad和iPhone平台的UserAgent|
|7|Android UserAgent|包含Android平台下Nexus7，AndroidGalaxyS3和AndroidGalaxyTab的UserAgent|
|8|Windows phone UserAgent|包含Windows phone手机7，7.5，8版本的UserAgent|
|9|IOS UserAgent|包含IOS平台下iPad，iPhone和iPod的UserAgent|
|10|Spider UserAgent|包含百度，谷歌，必应，Slurp等搜索引擎爬虫的UserAgent|

PS：数据来源于Chrome浏览器插件`User-Agent Switcher for Google Chrome`和自己补充。

#### 3.添加Origin
作用：方便测试CROS跨域漏洞

|id|head|description|
|:---:|:---|:---|
|1|Origin|跨域资源共享头|

#### 4.更新Cookie
作用：方便更新数据包为最新可用Cookie。
