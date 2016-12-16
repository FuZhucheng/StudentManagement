package com.fuzhu.studentmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInformation
 */
@WebServlet("/StudentInformation")
public class StudentInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDAO studentproxy=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fail_path="studentdata.jsp";

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		List<String> info = new ArrayList<>();
		studentproxy = DAOStudentFactory.getIStudentInstance();
		if(name==null || "".equals(name)){
			info.add("查询姓名不能为空");
		}
		if(info.size()==0){
			Student student = new Student();
			student.setSTNAME(name);
			try{
				student = studentproxy.findStudent(student.getSTNAME());
				if( student!=null){
					info.add("学生信息如下： "+"姓名- "+student.getSTNAME()+"性别-"+student.getSTSEX()+"年龄-"+student.getSTAGE()+"电话： "+student.getSTPHONE());
				}else{
					info.add("没有该学生的信息");
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			request.setAttribute("info", info);
			request.getRequestDispatcher(fail_path).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
