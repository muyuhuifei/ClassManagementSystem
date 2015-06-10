package com.fonxian.StudentDAO;

import java.util.List;

import com.fonxian.Model.Classes;
import com.fonxian.Model.Course;
import com.fonxian.Model.Student;
import com.fonxian.Model.Teacher;
import com.fonxian.Model.studentScore;

public interface StudentIDao {
	public void addStudent(Student stu);
	public void addTeacher(Teacher teacher);
	public void addCourse(Course course);
	public void addClass(Classes cl);
	public void delStudent(int id);
	public Student load(int id);
	public List<Student> findStudent();
	public void updateStudent(Student stu);
	public List<studentScore> findScore(int id);
	public List<studentScore> findScore(String sname);

}
