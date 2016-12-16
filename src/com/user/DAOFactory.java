package com.user;

public class DAOFactory {
	
		public static IUserDao getIUserInstance() throws Exception{
			return new UserDAOProxy();
		}
}
