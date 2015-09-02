package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.SecurityDAO;
import com.dts.project.dao.ClientDAO;
import com.dts.project.dao.UserDAO;
import com.dts.project.model.ClientModel;
import com.dts.project.model.UserModel;

public class GetClientAction extends HttpServlet {

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
		String target = "AddClient.jsp?status=Invalid username ";
UserModel usermodel;
		try
		{	
			usermodel = new UserDAO().getUserID(username);
			 
			 
			 
			if (usermodel!=null){
			
				target = "AddClient.jsp?userid="+usermodel.getUserid()+"&firstname="+usermodel.getFirstname()+"&lastname="+usermodel.getLastname()+"&midname="+usermodel.getMiddlename()+"&mailid="+usermodel.getMailid()+"&clientdob="+usermodel.getDateofbirth()+"&regdate="+usermodel.getDateofreg();
			}
			else
				target = "AddClient.jsp?status=<font color=red>No ClientIs  Not Available With Name</font>&username="+username+"Try Again,.....";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		        RequestDispatcher rd = request.getRequestDispatcher(target);
		         rd.forward(request, response);
	}

}
