package com.fonxian.StudentDAO;

public class DaoFactory {
	public static StudentDao getDao(){
		return new StudentDao();
	}
	public static ClassDao getClassDao(){
		return new ClassDao();
	}
}
