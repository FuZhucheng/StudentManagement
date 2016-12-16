package com.fuzhu.studentmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

	private DAO dao = new DAO();
	public StudentDAOImpl() {
	}

	public Student findStudent(String name)  {
		
		String sql = "SELECT STID,STNAME,STSEX,STAGE,STPHONE " + "FROM student where STID=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Student student = null;
		
		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "123");
			resultSet = preparedStatement.executeQuery();
			student = new Student();
			while(resultSet.next()){
				student.setSTID(resultSet.getInt(1));
				student.setSTNAME(resultSet.getString(2));
				student.setSTSEX(resultSet.getString(3));
				student.setSTAGE(resultSet.getString(4));
				student.setSTPHONE(resultSet.getString(5));
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new DAOException(e.getMessage(),e);  
		}finally {
			JDBCTools.release(resultSet, preparedStatement, connection);
		}
		
		return student;
	}


	@Override
	public Student insertStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		String sql="INSERT INTO student(STID,STNAME,STSEX,STAGE,STPHONE) "+"VALUES(?,?,?,?,?)";
		this.dao.update(sql, student.getSTID(),student.getSTNAME(),student.getSTSEX(),student.getSTAGE(),student.getSTPHONE());
		return null;
	}

	@Override
	public Student deleteStudent(String name) throws Exception {
		// TODO Auto-generated method stub
		String sql="DELETE FROM student WHERE STNAME=?";
		this.dao.update(sql, name);
		return null;
	}

	@Override
	public Student updateStudent(String  proviousName,String nowName) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE student set STNAME=?  WHERE STNAME= ? ";
//		System.out.println(sql);

		this.dao.update(sql,nowName ,proviousName);
//		System.out.println(proviousName+"  "+nowName);
		return null;
	}

	@Override
	public List StSelect() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = JDBCTools.getConnection();
		String sql="SELECT * FROM student ";
		List list = new ArrayList();
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				int stId = rs.getInt("STID");
				String stName = rs.getString("STNAME");
				String stSex = rs.getString("STSEX");
				String stAge = rs.getString("STAGE");
				String stTel = rs.getString("STPHONE");

				Student stu = new Student(stId, stName, stSex, stAge, stTel);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
	

	

