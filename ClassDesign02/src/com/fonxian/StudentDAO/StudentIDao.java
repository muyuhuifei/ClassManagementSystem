package com.fonxian.StudentDAO;

import java.util.List;

import com.fonxian.Model.Classes;
import com.fonxian.Model.Course;
import com.fonxian.Model.Student;
import com.fonxian.Model.Teacher;
import com.fonxian.Model.studentScore;

public interface StudentIDao {
	//添加
	public void addStudent(Student stu);
	public void addTeacher(Teacher teacher);
	public void addCourse(Course course);
	public void addClass(Classes cl);
	//删除
	public void delStudent(int id);
	//加载
	public Student load(int id);
	//登录
	public Student login(int sid,String password);
	public Teacher loginAdmin(int tid,String password);
	//列表
	public List<Student> findStudent();
	public List<studentScore> findScore(int id);
	public List<studentScore> findScore(String sname);
	//更新
	public void updateStudent(Student stu);
}
