package com.fonxian.StudentDAO;

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
import com.fonxian.Model.studentScore;

public class StudentDao implements StudentIDao{
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public void addStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql="select count(*) from student where sname=?";
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)>0){
					System.out.println("已存在");
					return ;
				}
			}
			sql = "insert into student(sid,sname,stel,classid,password) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getSid());
			ps.setString(2, stu.getSname());
			ps.setInt(3, stu.getStel());
			ps.setInt(4, stu.getClassid());
			ps.setString(5, stu.getPassword());
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
	public void delStudent(int id) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			String sql="delete from student where sid=?";
			try {
				Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
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
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		String sql="select count(*) from student where sname=?";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)>0){
					throw new ClassException("添加的学生已经存在，请勿重复添加");
				}
			}
			sql = "insert into teacher values(?,?,?)";
			//insert into teacher values(2001,"姜磊",1234);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, teacher.getTid());
			ps.setString(2, teacher.getTname());
			ps.setInt(3, teacher.getTtel());
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
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClass(Classes cl) {
		// TODO Auto-generated method stub
		
	}
	
	//班级成员列表
	@Override
	public List<Student> findStudent() {
		// TODO Auto-generated method stub
		String sql="select * from student";
		Student stu = null;
		List<Student> stus = new ArrayList<Student>();
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				stu = new Student();
				stu.setSid(rs.getInt("sid"));
				stu.setClassid(rs.getInt("classid"));
				stu.setSname(rs.getString("sname"));
				stu.setStel(rs.getInt("stel"));
				stus.add(stu);
			}
			return stus;
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
	
	//个人成绩
	
	@Override
	public List<studentScore> findScore(int id) {
		// TODO Auto-generated method stub
		String sql="select student.sname,course.cname,score,teacher.tname from sc,student,course,teacher where student.sid=sc.sid and course.cid = sc.cid and course.tid = teacher.tid and student.sid=?";
		
		studentScore studentScore = null;
		List<studentScore> scores = new ArrayList<studentScore>();
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				studentScore = new studentScore();
				studentScore.setSname(rs.getString("sname"));
				studentScore.setCname(rs.getString("cname"));
				studentScore.setScore(rs.getInt("score"));
				studentScore.setTname(rs.getString("tname"));
				scores.add(studentScore);
			}
			return scores;
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
	public List<studentScore> findScore(String sname) {
		// TODO Auto-generated method stub
		return null;
	}
	//加载某个学生信息

	@Override
	public Student load(int id) {
		// TODO Auto-generated method stub
		String sql="select * from student where sid=?";
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				stu = new Student();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setStel(rs.getInt("stel"));
				stu.setClassid(rs.getInt("classid"));
				stu.setPassword(rs.getString("password"));
			}
			return stu;
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

	//更新老师信息
	@Override
	public void updateStudent(Student stu) {
		// TODO Auto-generated method stub
		String sql="update student set sname=? ,stel= ? , classid=? ,password = ? where sid= ?;";
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setInt(2, stu.getStel());
			ps.setInt(3, stu.getClassid());
			ps.setString(4, stu.getPassword());
			ps.setInt(5, stu.getSid());
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
	public Student login(int sid,String password) {
		// TODO Auto-generated method stub
		String sql="select * from student where sid=? and password=?;";
		Student stu = null;
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, sid);
			 ps.setString(2,password);
			rs = ps.executeQuery();
			while(rs.next()){
				stu = new Student();
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setStel(rs.getInt("stel"));
				stu.setClassid(rs.getInt("classid"));
				stu.setPassword(rs.getString("password"));
				stu.setStatus(rs.getInt("status"));
			}
			return stu;
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
	public Teacher loginAdmin(int tid, String password) {
		// TODO Auto-generated method stub
		String sql="select * from teacher where tid=? and password=?;";
		Teacher teacher = null;
		try {
			conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, tid);
			 ps.setString(2,password);
			rs = ps.executeQuery();
			while(rs.next()){
				teacher = new Teacher();
				teacher.setTid(rs.getInt("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setTtel(rs.getInt("ttel"));
				teacher.setPassword(rs.getString("password"));
				teacher.setStatus(rs.getInt("status"));
			}
			return teacher;
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
