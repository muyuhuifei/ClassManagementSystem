create database classweb;

use  classweb;
#老师
create table teacher(
	tid int(10) not null ,
	tname varchar(20) not null,
	ttel int(20),
	primary key(tid)
);
#班级
create table class(
	classid int(10) not null primary key,
	classname varchar(20) not null,
	classtid int(10) not null,
	foreign key (classtid) references teacher(tid)
);

#学生
create table student(
	sid int(10) not null ,
	sname varchar(20) not null,
	stel int(20),
	classid int(10),
	primary key(sid),
	foreign key(classid)references class(classid)
);

#课程
create table course(
	cid int(10) not null ,
	cname varchar(20) not null,
	tid int(10) not null ,
	primary key(cid),
	foreign key (tid) references teacher(tid)
);
#学生和课程的关系
create table sc(
	sid int(10) not null ,
	cid int(10) not null ,
	score int(10) not null,
	foreign key(sid)references student(sid),
	foreign key(cid)references course(cid)
);
#在班级中插入记录、查询
insert into class values(1,"计算机一班",2001);
insert into class values(2,"计算机二班",2001);
insert into class values(3,"计算机三班",2002);
insert into class values(4,"计算机四班",2002);

select * from class;
#在老师中插入记录、查询
insert into teacher values(2001,"姜磊",1234);
insert into teacher values(2002,"廖祝华",1234);

select * from teacher;
#在学生中插入记录
insert into student values(1201,"方志杰",1234,1);
insert into student values(1202,"杨争伟",1234,1);
insert into student values(1203,"杨洪松",1234,1);
insert into student values(1204,"陈刚",1234,1);

select * from student;
#在课程中插入记录
insert into course values(1000,"软件工程",2001);
insert into course values(1001,"计算机网络",2002);
select * from course;
#在学生和课程中插入记录
select * from sc;
insert into sc values(1201,1000,89);
insert into sc values(1202,1000,80);
insert into sc values(1203,1000,85);
insert into sc values(1204,1000,86);

insert into sc values(1201,1001,78);
insert into sc values(1202,1001,75);
insert into sc values(1203,1001,78);
insert into sc values(1204,1001,61);

#查找学生的所有成绩，通过学生姓名
select course.cname,score from sc,student,course where student.sid=sc.sid and course.cid = sc.cid and student.sname='方志杰';
#查找学生的所有成绩，通过学生学号
select course.cname,score from sc,student,course where student.sid=sc.sid and course.cid = sc.cid and student.sid=1204;