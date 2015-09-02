package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.LawTypeDAO;
import com.dts.project.dao.LawyerTypeDAO;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.LawyerTypeModel;

public class AddLawyerTypeAction extends HttpServlet {

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

		String target="AddLawyerType.jsp?status=Adding Lawer Type Is Invalid";
		try{
			LawyerTypeModel lawyertypeModel = new LawyerTypeModel(); 
		lawyertypeModel.setLawyertypename(request.getParameter("lawyertypename"));
		lawyertypeModel.setLawyertypeabbr(request.getParameter("lawyertypeabbr"));
		lawyertypeModel.setLawyertypedesc(request.getParameter("lawyertypedesc"));
		
		boolean flag=new LawyerTypeDAO().addlayertype(lawyertypeModel);

		if(flag) 
		   target = "AddLawyerType.jsp?status=Adding Lawer Type Is Successfully Done"; 
		else  
		    target = "AddLawyerType.jsp?status=Adding Lawer Type Is  Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
