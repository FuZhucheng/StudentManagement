package com.fuzhu.studentmanager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataUpdateServlet
 */
@WebServlet("/DataUpdateServlet")
public class DataUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDAO studentproxy = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		studentproxy = DAOStudentFactory.getIStudentInstance();

		String delete_name = request.getParameter("delete_name");
		
//		String STID = request.getParameter("STID");			Duplicate entry '9' for key 'PRIMARY' 		设置了STID为主键，也就是自增长，不能手动设置
		String STNAME = request.getParameter("STNAME");
		String STSEX = request.getParameter("STSEX");
		String STAGE = request.getParameter("STAGE");
		String STPHONE = request.getParameter("STPHONE");
		Student student = new Student();
//		student.setSTID(Integer.parseInt(STID));
		student.setSTNAME(STNAME);
		student.setSTSEX(STSEX);
		student.setSTAGE(STAGE);
		student.setSTPHONE(STPHONE);
		
		String proviousName = request.getParameter("proviousName");
		String nowName = request.getParameter("nowName");
		

		if (delete_name != null) {
				delete( request,delete_name,response);
		}
		if(student != null){
				insert(request,student,response);
		}
		if(proviousName !=null && nowName !=null){
				update(request,proviousName, nowName,response);
//				System.out.println("DataUpdateServlet检测"+proviousName+nowName);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void delete(HttpServletRequest request,String delete_name, HttpServletResponse response) {
			try {
				studentproxy.deleteStudent(delete_name);
				request.setAttribute("deletename", delete_name);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	private void insert(HttpServletRequest request,Student student, HttpServletResponse response){
		try {
			studentproxy.insertStudent(student);
			request.setAttribute("insertstudentID", student.getSTID());
			request.setAttribute("insertstudentName", student.getSTNAME());
			request.setAttribute("insertstudentPhone", student.getSTPHONE());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void update(HttpServletRequest request,String  proviousName,String nowName, HttpServletResponse response){
		try {
			studentproxy.updateStudent(proviousName, nowName);
//			System.out.println("DataUpdateServlet.java"+proviousName+nowName);
			request.setAttribute("updatename", nowName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
