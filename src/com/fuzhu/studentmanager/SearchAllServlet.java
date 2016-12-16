package com.fuzhu.studentmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAllServlet
 */
@WebServlet("/SearchAllServlet")
public class SearchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStudentDAO studentproxy=null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		studentproxy = DAOStudentFactory.getIStudentInstance();
		try {
			List list = studentproxy.StSelect();
//			System.out.println(list);
			request.setAttribute("list", list);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("studentdata.jsp");
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
