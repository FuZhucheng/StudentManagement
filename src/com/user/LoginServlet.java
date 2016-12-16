package com.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String success_path="studentdata.jsp";
		String fail_path="login.jsp";
		String userid=request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		List<String> info = new ArrayList<>();
		if(userid==null || "".equals(userid)){
			info.add("用户ID不能为空");
			request.setAttribute("info", info);
			request.getRequestDispatcher(fail_path).forward(request, response);
		}
		if(userpass == null || "".equals(userpass)){
			info.add("密码不能为空");
			request.setAttribute("info", info);
			request.getRequestDispatcher(fail_path).forward(request, response);
		}
		if(info.size()==0){
			Userstudent user = new Userstudent();
			user.setUserid(userid);
			user.setPassword(userpass);
			try {
				if(DAOFactory.getIUserInstance().findLogin(user)){
					info.add("用户登录成功，欢迎你的到来 "+ user.getName());
					request.setAttribute("info", info);
					request.getRequestDispatcher(success_path).forward(request, response);
				}else{
					info.add("用户登录失败，请检查您的用户名与密码");
					request.setAttribute("info", info);
					request.getRequestDispatcher(fail_path).forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
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
