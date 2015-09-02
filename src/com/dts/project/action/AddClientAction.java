package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dts.project.model.ClientModel;
import com.dts.project.dao.ClientDAO;
import com.dts.project.dao.UserDAO;
import com.dts.project.model.UserModel;

public class AddClientAction extends HttpServlet {

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

		String target="?status=Adding  Is Invalid";
		try{
			ClientModel clientModel = new ClientModel(); 
			clientModel.setClientfstname(request.getParameter(""));
		clientModel.setClientlstname(request.getParameter(""));
		clientModel.setClientmidname(request.getParameter(""));
		clientModel.setClientftherfstname(request.getParameter("")); 
		clientModel.setClientftherlstname(request.getParameter(""));        
		clientModel.setClientfthermidname(request.getParameter(""));
		clientModel.setDobofclient(request.getParameter("")); 
		clientModel.setDobofclientfather(request.getParameter(""));        
		clientModel.setDoregistration(request.getParameter(""));
		clientModel.setUserid(Integer.parseInt(request.getParameter(""))); 
		clientModel.setEmailid(request.getParameter(""));        
		



		boolean flag=new ClientDAO().addclient(clientModel);

		if(flag) 
		   target = "?status=Adding Successfully Done"; 
		else  
		    target = "?status=Adding  Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
