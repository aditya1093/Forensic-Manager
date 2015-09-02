package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;
import com.dts.project.model.EmployeesModel;

public class LoginAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "LoginForm.jsp?status=Invalid username and password";
		try
		{HttpSession session=request.getSession();
		EmployeesModel rb = new EmployeesModel();
			String username = request.getParameter("username");
			rb.setUsername(username);
			String pass=request.getParameter("password");
			rb.setPassword(pass);
             
			String role = new SecurityDAO().loginCheck(rb);

			if (role.equalsIgnoreCase("admin"))
			{
				target = "AdminHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else if (role.equalsIgnoreCase("user"))
			{
				
					target = "UserHome.jsp?status=Welcome " + username;
				
					target = "UserHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			
			else if (role.equalsIgnoreCase("client"))
			{
				
					//target = "ClientHome.jsp?status=Welcome " + username;
				
					target = "ClientHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else
				target = "LoginForm.jsp?status=Invalid username and password";
		}
		catch (Exception e)
		{
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
