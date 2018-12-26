# AS of Drug related Cases —— JavaWeb

AS of Drug related Cases-浙江省涉毒案件分析系统

## 结构图
![结构图](https://github.com/lychs1998/AS-of-Drug-related-Cases/blob/master/img/sys.jpg?raw=true)

## 可视化
![浙江省涉毒案件分布图](https://github.com/lychs1998/AS-of-Drug-related-Cases/blob/master/img/map.jpg?raw=true)


![平行坐标系图](https://github.com/lychs1998/AS-of-Drug-related-Cases/blob/master/img/spzb.jpg?raw=true)


![知识图谱(关系图)](https://github.com/lychs1998/AS-of-Drug-related-Cases/blob/master/img/km.jpg?raw=true)

## 依赖环境

Tomcat

Java

### 服务器不需要安装Neo4j？
Yes！neo4j.graphdb库是一个对本地的由neo4j创建的数据库进行操作的库。

你只需要将graph.db文件夹上传到你的生产环境，在CaseSearch类中配置好类的初始化函数的数据库文件夹路径就可以了。

## 查询功能
你可以在主页的右上角搜索如 冰毒（毒品类型）、陈伟（人名）、贩卖毒品罪（罪名）、有期徒刑（刑期）等各个实体。最下方会生成相应的关系图。
