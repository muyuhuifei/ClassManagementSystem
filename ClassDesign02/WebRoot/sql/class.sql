create database classweb;

use  classweb;
#��ʦ
create table teacher(
	tid int(10) not null ,
	tname varchar(20) not null,
	ttel int(20),
	primary key(tid)
);
#�༶
create table class(
	classid int(10) not null primary key,
	classname varchar(20) not null,
	classtid int(10) not null,
	foreign key (classtid) references teacher(tid)
);

#ѧ��
create table student(
	sid int(10) not null ,
	sname varchar(20) not null,
	stel int(20),
	classid int(10),
	primary key(sid),
	foreign key(classid)references class(classid)
);

#�γ�
create table course(
	cid int(10) not null ,
	cname varchar(20) not null,
	tid int(10) not null ,
	primary key(cid),
	foreign key (tid) references teacher(tid)
);
#ѧ���Ϳγ̵Ĺ�ϵ
create table sc(
	sid int(10) not null ,
	cid int(10) not null ,
	score int(10) not null,
	foreign key(sid)references student(sid),
	foreign key(cid)references course(cid)
);
#�ڰ༶�в����¼����ѯ
insert into class values(1,"�����һ��",2001);
insert into class values(2,"���������",2001);
insert into class values(3,"���������",2002);
insert into class values(4,"������İ�",2002);

select * from class;
#����ʦ�в����¼����ѯ
insert into teacher values(2001,"����",1234);
insert into teacher values(2002,"��ף��",1234);

select * from teacher;
#��ѧ���в����¼
insert into student values(1201,"��־��",1234,1);
insert into student values(1202,"����ΰ",1234,1);
insert into student values(1203,"�����",1234,1);
insert into student values(1204,"�¸�",1234,1);

select * from student;
#�ڿγ��в����¼
insert into course values(1000,"�������",2001);
insert into course values(1001,"���������",2002);
select * from course;
#��ѧ���Ϳγ��в����¼
select * from sc;
insert into sc values(1201,1000,89);
insert into sc values(1202,1000,80);
insert into sc values(1203,1000,85);
insert into sc values(1204,1000,86);

insert into sc values(1201,1001,78);
insert into sc values(1202,1001,75);
insert into sc values(1203,1001,78);
insert into sc values(1204,1001,61);

#����ѧ�������гɼ���ͨ��ѧ������
select course.cname,score from sc,student,course where student.sid=sc.sid and course.cid = sc.cid and student.sname='��־��';
#����ѧ�������гɼ���ͨ��ѧ��ѧ��
select course.cname,score from sc,student,course where student.sid=sc.sid and course.cid = sc.cid and student.sid=1204;