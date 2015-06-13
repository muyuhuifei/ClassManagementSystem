package com.fonxian.StudentDAO;

import com.fonxian.ClassDAO.ClassDao;

public class DaoFactory {
	public static StudentDao getDao(){
		return new StudentDao();
	}
	public static ClassDao getClassDao(){
		return new ClassDao();
	}
}
