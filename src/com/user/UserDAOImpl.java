package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fuzhu.studentmanager.JDBCTools;

public class UserDAOImpl implements IUserDao {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;

	public UserDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean findLogin(Userstudent user) throws Exception {
		boolean flag = false;
		try {
			String sql = "SELECT name FROM userstudent  where userid=? AND password=?";
			this.preparedStatement = this.conn.prepareStatement(sql);
			this.preparedStatement.setString(1, user.getUserid());
			this.preparedStatement.setString(2, user.getPassword());
			ResultSet rs = this.preparedStatement.executeQuery();
			if (rs.next()) {
				user.setName(rs.getString(1));
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			if (this.preparedStatement != null) {
				try {
					this.preparedStatement.close();
				} catch (Exception e2) {
					// TODO: handle exception
					throw e2;
				}
			}
		}
		return flag;
	}

	// ×¢²á--²åÈëÊý¾Ý
	@Override
	public void update(Userstudent user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO userstudent(userid,name,password) " + "VALUES(?,?,?)";

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, user.getUserid());
			preparedStatement.setObject(2, user.getName());
			preparedStatement.setObject(3, user.getPassword());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(null, preparedStatement, connection);
		}
	}
}
