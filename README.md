# firefox-bookmarks-parser

一个基于Grails框架开发的解析FireFox浏览器的places.sqlite（后文简称书签文件）并以HTTP方式对外提供查询功能的工具。

可通过`gradle bootRun`命令启动。

## 默认设置

默认端口为8080，默认解析当前目录下的书签文件。

## 参数覆盖

--server.port.：侦听端口号

--dataSource.url：SQLite JDBC连接串

## 数据格式

### 请求

http://host:port/bookmark?kw=xyz

> kw参数的值为搜索关键词（不区分大小写），置空或无此参数表示不执行筛选，将返回所有书签条目

### 响应

[{"title": "foo", "url": "bar"}, ...]
