����ѧ����student����Ҫ������ֶΣ�ѧ�š����������䡢�Ա�ѧԺ��
1) �������ѧԱ����Ϣ
�ֱ��ǣ� 
    1��������18 , �У���ϢѧԺ
    2�����ģ�20���У���ѧԺ
    3��С�죬28��Ů������ѧԺ
2) ɾ�����ڡ��������ļ�¼
3) �������ġ����Ա��Ϊ��Ů��
4) ��ѯ���е�ѧ����Ϣ��


create table student(
	id int AUTO_INCREMENT,
	name varchar(50),
	age int ,
	sex char(1),
	school varchar(50),
	PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

insert into student(name,age,sex,school) values("����",18,"��","��ϢѧԺ");
insert into student(name,age,sex,school) values("����",20,"��","��ѧԺ");
insert into student(name,age,sex,school) values("С��",18,"Ů","����ѧԺ");

insert into student(name,age,sex,school) values
("����",18,"��","��ϢѧԺ"),
("����",20,"��","��ѧԺ"),
("С��",18,"Ů","����ѧԺ");

update student set sex = "Ů" where name = "����";

select * from student;

