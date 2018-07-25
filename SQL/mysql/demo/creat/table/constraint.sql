-- 主键约束PRIMARY KEY
-- auto_increment自增，AUTO_INCREMENT=100从100开始

CREATE TABLE student(
	
	id int(4) not null primary key auto_increment,
	stuname varchar(32) unique not null,
  age int(4)),
  sex char(2) default'女',
  grade decimal(4,2)
)Engine=InnoDB AUTO_INCREMENT=100 default CHARSET=utf8;