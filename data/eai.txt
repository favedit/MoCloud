修改服务器： /MySQL/my.ini
============================================================
[client] default-character-set=utf8
[mysqld] character-set-server=utf8

链接数据库：
============================================================
mysql -uroot -pwebjet_test
mysql -ucloud -pcloud

查看编码：
============================================================
SHOW VARIABLES LIKE 'character%';

创建数据库：
============================================================
CREATE DATABASE `AI_CACHE` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
CREATE DATABASE `AI_DATA`  CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
x
创建用户：
============================================================
CREATE USER 'cloud'@'%' IDENTIFIED BY 'cloud';
CREATE USER 'cloud'@'%' IDENTIFIED BY 'Iamcloud1503';
CREATE USER 'cloud'@'localhost' IDENTIFIED BY 'Iamcloud1503';

用户授权：
============================================================
GRANT ALL PRIVILEGES ON *.* TO 'cloud'@'%';
GRANT ALL ON *.* TO 'cloud'@'%' IDENTIFIED BY "cloud";
GRANT ALL ON *.* TO 'cloud'@'%' IDENTIFIED BY "Iamcloud1503";
GRANT ALL ON *.* TO 'cloud'@'localhost' IDENTIFIED BY "Iamcloud1503";

修改最大链接数：
============================================================
SHOW VARIABLES LIKE 'MAX_CONNECTIONS';
SET GLOBAL max_connections=500;


mysqldump -h127.0.0.1 -uroot -pwebjet_test GR_DATA > gr_data.sql

DROP DATABASE `GC_DATA`;
CREATE DATABASE `GC_DATA`       CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

show processlist;


SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE `DT_RES_RESOURCE`;
SET FOREIGN_KEY_CHECKS = 1;


安装MongoDB服务
============================================================
C:
CD C:\Program Files\MongoDB\Server\3.0\bin
mongod --install --serviceName MoContent --serviceDisplayName MoContent --logpath D:\Database\MongoDB.Log --dbpath D:\Database\MongoDB --directoryperdb
