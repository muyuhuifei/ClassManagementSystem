package com.fonxian.ClassDAO;

import java.util.List;

import com.fonxian.Model.Classes;
import com.fonxian.Model.Course;
import com.fonxian.Model.Student;
import com.fonxian.Model.Teacher;
import com.fonxian.Model.courseAllScore;
import com.fonxian.Model.studentScore;

public interface ClassIDao {
	//添加
	public void addCourse(Course course);
	public void addClass(Classes cl);
	//删除
	public void delCourse(int id);
	public void delClass(int id);
	//加载
	public Course loadCourse(int cid);
	public Class loadClass(int classid);
	//列表
	public List<Course> findCourse();
	public List<courseAllScore> findCourseAllScore(int cid);
	//更新
	public void updateCourse(Student stu);
}
