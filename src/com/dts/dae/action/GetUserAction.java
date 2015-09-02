package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.SecurityDAO;
import com.dts.project.model.UserModel;

public class GetUserAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

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

		int username = Integer.parseInt(request.getParameter("username"));
		System.out.println("------------username---->"+username);
		String target = "UpdateUser.jsp?status=Invalid username and password";
UserModel usermodel;
		try
		{	
			 usermodel = new SecurityDAO().getUserDetails(username);
			 System.out.println("--usermodel.getUsername()---"+usermodel.getUsername());
			 System.out.println("--usermodel.getFirstname()---"+usermodel.getFirstname());
			 System.out.println("--usermodel.getLastname()---"+usermodel.getLastname());
			 System.out.println("--usermodel.getMiddlename()---"+usermodel.getMiddlename());
			 System.out.println("--usermodel.getAddress()---"+usermodel.getAddress());
			 System.out.println("--usermodel.getUsername()---"+usermodel.getUsername());
			 System.out.println("--usermodel.getUsername()---"+usermodel.getUsername());
			 System.out.println("--usermodel.getUsername()---"+usermodel.getUsername());
			 System.out.println("--usermodel.getUsername()---"+usermodel.getUsername());
			 System.out.println("--usermodel.getLogintype()---"+usermodel.getLogintype());
			 
			 
			if (usermodel!=null){
			
				target = "UpdateUser.jsp?username="+usermodel.getUsername()+"&firstname="+usermodel.getFirstname()+"&lastname="+usermodel.getLastname()+"&middlename="+usermodel.getMiddlename()+"&address="+usermodel.getAddress()+"&phno="+usermodel.getPhno()+"&emailid="+usermodel.getMailid()+"&password="+usermodel.getPassword()+"&logintype="+usermodel.getLogintype();
			}
			else
				target = "UpdateUser.jsp?status=<font color=red>UserDate is Not Available.for</font>&username="+username+"Try Again,.....";
		}
		catch (Exception e)
		{
			target = "AddUser.jsp?status=<font color=green>_/<b>Available User Is</b></font>&username="+username;
		}
		        RequestDispatcher rd = request.getRequestDispatcher(target);
		         rd.forward(request, response);
	}

}
