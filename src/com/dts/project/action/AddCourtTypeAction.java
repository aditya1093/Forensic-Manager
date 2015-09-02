package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CourtTypeDAO;
import com.dts.project.dao.LawTypeDAO;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.LawTypeModel;

public class AddCourtTypeAction extends HttpServlet {

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
		String target="AddCourtType.jsp?status=Adding Court Type Is Invalid";
		try{
			CourtTypeModel courttypeModel = new CourtTypeModel(); 
		courttypeModel.setCourttypename(request.getParameter("courttypename"));
		courttypeModel.setCourttypeabbr(request.getParameter("courttypeabbr"));
		courttypeModel.setCourttypedesc(request.getParameter("courttypedesc"));
		
		boolean flag=new CourtTypeDAO().addcourttype(courttypeModel);

		if(flag) 
		   target = "AddCourtType.jsp?status=Adding Court Type Is Successfully Done"; 
		else  
		    target = "AddCourtType.jsp?status=Adding Court Type Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
		
	}

}
