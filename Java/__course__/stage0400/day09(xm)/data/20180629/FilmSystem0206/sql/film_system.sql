-- ������ڣ�ɾ��
DROP DATABASE IF EXISTS `film_system0206`;

-- �������ݿ�
create database film_system0206;

-- ʹ�����ݿ�
use film_system0206;

-- �û���
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '�˺�',
  `password` varchar(20) DEFAULT NULL COMMENT '����',
  `sex` char(2) DEFAULT NULL COMMENT '�Ա�:�У�Ů',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '����',
  `mobile` varchar(20) DEFAULT NULL COMMENT '�ֻ���',
  `auth` tinyint(4) DEFAULT NULL COMMENT '�û���1������Ա��2',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
