package com.fonxian.ClassDAO;

import java.util.List;

import com.fonxian.Model.Classes;
import com.fonxian.Model.Course;
import com.fonxian.Model.Student;
import com.fonxian.Model.Teacher;
import com.fonxian.Model.courseAllScore;
import com.fonxian.Model.studentScore;

public interface ClassIDao {
	//���
	public void addCourse(Course course);
	public void addClass(Classes cl);
	//ɾ��
	public void delCourse(int id);
	public void delClass(int id);
	//����
	public Course loadCourse(int cid);
	public Class loadClass(int classid);
	//�б�
	public List<Course> findCourse();
	public List<courseAllScore> findCourseAllScore(int cid);
	//����
	public void updateCourse(Student stu);
}
