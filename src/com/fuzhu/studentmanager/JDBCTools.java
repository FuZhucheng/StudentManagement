package com.fuzhu.studentmanager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Connection;

/**
 * 操作JDBC的工具类，其中封装一些工具方法
 * 
 * @author asus
 *
 */
public class JDBCTools {
	/**
	 * 	执行SQL语句，使用PreparedStatement
	 * @param sql
	 * @param args	:填写SQL占位符的可变参数
	 */
	public static void update(String sql,Object ...args){
		Connection connection =null;
		PreparedStatement preparedstatement = null;
		try{
			connection = JDBCTools.getConnection();
			preparedstatement = connection.prepareStatement(sql);
			for(int i=0; i<args.length;i++){
				 	preparedstatement.setObject(i+1, args[i]);
			}
			preparedstatement.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCTools.release(preparedstatement, connection);
		}
	}
	/*
	 * 执行SQL的方法
	 * 通用的更新的方法：包括INSERT、UPDATE、DELETE 而不包含SELECT
	 */
	public void update(String sql) {

		Connection conn = null;
		Statement statement = null;
		try {
			// 1. 获取Connection
			conn = JDBCTools.getConnection();
//			System.out.println(conn);

			// 2. 获取Statement
			statement = conn.createStatement();
//			System.out.println(statement);

			// 3.发送SQL语句，调用Statement对象的executeUpdate(sql)方法。向数据库发送SQL语句
			statement.executeQuery(sql);
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 6. 关闭数据库资源
			JDBCTools.release(statement, conn);
		}

	}
	public static void release(ResultSet rs,Statement statement, java.sql.Connection connection) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void release(Statement statement, Connection conn) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void release(ResultSet rs,PreparedStatement statement, Connection conn) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 1. 获取连接的方法。 通过读取配置文件葱数据库服务器获取一个连接
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	// 缺点就是：每次用这个方法都要读那个配置文件
	public static Connection getConnection() throws Exception {
		// 1. 准备链接数据库的4个字符串
		// (1). 创建Properties对象
		Properties properties = new Properties();
		// (2). 获取jdbc.properties 对应的输入流
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		// (3). 加载（2）对应的输入流
		properties.load(in);
		// (4). 为具体决定user，password等4个字符串。
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");

		// 2. 加载数据库驱动程序（对应的Driver 实现类中有注册驱动的静态代码块）。
		Class.forName(driver);
		// 3. 通过DriverManager 的getConnection()方法获取数据库连接。
		return (Connection) DriverManager.getConnection(jdbcUrl, user, password);
	}
}
