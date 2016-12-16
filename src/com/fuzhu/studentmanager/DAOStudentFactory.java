package com.fuzhu.studentmanager;

public class DAOStudentFactory {
	public static IStudentDAO getIStudentInstance(){
		return new StudentDAOProxy();
	}
}
