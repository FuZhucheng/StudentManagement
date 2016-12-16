package com.user;

import java.sql.PreparedStatement;

import com.fuzhu.studentmanager.JDBCTools;
import com.mysql.jdbc.Connection;

public class UserDAOProxy implements IUserDao{
		private Connection conn;
		private IUserDao dao = null;
		public UserDAOProxy() throws Exception{
			conn = JDBCTools.getConnection();
			this.dao = new UserDAOImpl(conn);
		}
		public boolean findLogin(Userstudent user) throws Exception{
			boolean flag = false;
			try {
				flag = this.dao.findLogin(user);
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}finally {
				JDBCTools.release(null, conn);			
			}
			return flag;
		}
		@Override
		public void update(Userstudent user) {
			// TODO Auto-generated method stub
			this.dao.update(user);

		}
		
}
