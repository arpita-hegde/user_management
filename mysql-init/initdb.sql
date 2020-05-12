DROP DATABASE IF EXISTS dockerdemo;
CREATE DATABASE dockerdemo;
GRANT ALL PRIVILEGES ON dockerdemo.* TO 'root'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON dockerdemo.* TO 'root'@'localhost' IDENTIFIED BY 'root';