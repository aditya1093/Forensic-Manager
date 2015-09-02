package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dts.project.dao.UserDAO;

import com.dts.project.model.UserModel;

public class AddUserAction extends HttpServlet {

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
		
		
		String cday=request.getParameter("cday");
		String cmonth=request.getParameter("cmonth");
		String cyear=request.getParameter("cyear");
		String cdate=cday+"-"+cmonth+"-"+cyear;
		
		
		
		String target="AddUser.jsp?status=Adding  Is Invalid";
		try{
			UserModel userModel = new UserModel(); 
		userModel.setUsername(request.getParameter("username"));
		userModel.setDateofbirth(cdate);
		userModel.setDateofreg(request.getParameter("dor"));
		userModel.setFirstname(request.getParameter("firstname")); 
		userModel.setMiddlename(request.getParameter("middlename"));        
		userModel.setLastname(request.getParameter("lastname"));
		userModel.setAddress(request.getParameter("address")); 
		userModel.setPhno(request.getParameter("phoneno"));        
		userModel.setMailid(request.getParameter("mailid"));
		userModel.setPhoto(request.getParameter("photo")); 
		userModel.setPassword(request.getParameter("password"));        
		//userModel.setLogintype(request.getParameter("logintype")); 



		boolean flag=new UserDAO().adduser(userModel);

		if(flag) 
		   target = "AddUser.jsp?status1=Adding User Successfully Done"; 
		else  
		    target = "AddUser.jsp?status1=Adding User Is Failed"; 
		    }
		catch(Exception e)
		{
			e.printStackTrace();
			}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
		
	}

}
