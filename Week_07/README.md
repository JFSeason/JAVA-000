学习笔记

# 按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率，在项目mysql-demo中
##用订单sql创建了三个订单表
##1.PreparedStatement 
###插入数据到SALESORDER
###测试结果
####批量插入数据成功，花费时间：202744毫秒

##2.减少SQL解析 Multiple Values/Add Batch 
###插入数据到SALESORDER2
###测试结果：
####批量插入数据成功，花费时间：21382毫秒
####批量插入数据成功，花费时间：260415毫秒

##3.load Data 
###插入数据到SALESORDER3
###测试结果：
####mysql> load data infile 'D:/win10_soft/mysql-8.0.16-winx64/var/lib/mysql-files/salesorder2.txt' into table salesorder3;
Query OK, 1000000 rows affected (22.36 sec)
####mysql> load data infile 'D:/win10_soft/mysql-8.0.16-winx64/var/lib/mysql-files/salesorder2.txt' into table salesorder3;
Query OK, 1000000 rows affected (39.18 sec)

##综上所述，效率大小比较：第一种<第三种<第二种

#读写分离 - 动态切换数据源版本 1.0，在datasouce-switch-demo中


