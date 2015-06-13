package com.fonxian.ClassDAO;

import com.fonxian.ClassDAO.ClassDao;

public class DaoFactory {
	
	public static ClassDao getClassDao(){
		return new ClassDao();
	}
}
