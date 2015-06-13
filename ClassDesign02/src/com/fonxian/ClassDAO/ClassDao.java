package com.fonxian.ClassDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fonxian.DBUtil.DBUtil;
import com.fonxian.Model.ClassException;
import com.fonxian.Model.Classes;
import com.fonxian.Model.Course;
import com.fonxian.Model.Student;
import com.fonxian.Model.Teacher;
import com.fonxian.Model.courseAllScore;
import com.fonxian.Model.studentScore;

public class ClassDao implements ClassIDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void delCourse(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delClass(int id) {
		// TODO Auto-generated method stub
		
	}
	//课程列表
	@Override
	public List<Course> findCourse() {
		// TODO Auto-generated method stub
		String sql="select * from course;";
		Course course = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				course = new Course();
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setTid(rs.getInt("tid"));
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public void updateCourse(Student stu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		String sql="select count(*) from course where cid=?";
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			ps.setInt(1, course.getCid());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)>0){
					System.out.println("已存在");
					return ;
				}
			}
			sql = "insert into course(cid,cname,tid) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, course.getCid());
			ps.setString(2, course.getCname());
			ps.setInt(3, course.getTid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
	}

	@Override
	public void addClass(Classes cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course loadCourse(int cid) {
		// TODO Auto-generated method stub
		String sql="select * from Course where cid=?";
		Course course = null;
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, cid);
			rs = ps.executeQuery();
			while(rs.next()){
				course = new Course();
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setTid(rs.getInt("tid"));
			}
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public Class loadClass(int classid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//查看该科全部学生成绩
	@Override
	public List<courseAllScore> findCourseAllScore(int cid) {
		// TODO Auto-generated method stub
		String sql="select course.cid,course.cname,student.sname,sc.score,teacher.tname from course,"+
		"sc,student,teacher where teacher.tid = course.tid and student.sid = sc.sid and course.cid = sc.cid and course.cid = ?;";
		courseAllScore course = null;
		List<courseAllScore> courses = new ArrayList<courseAllScore>();
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, cid);
			rs = ps.executeQuery();
			while(rs.next()){
				course = new courseAllScore();
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setSname(rs.getString("sname"));
				course.setTname(rs.getString("tname"));
				course.setScore(rs.getInt("score"));
				courses.add(course);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(conn);
		}
		return null;
	}
}
