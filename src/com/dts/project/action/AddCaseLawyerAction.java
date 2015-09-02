package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseLawyerDAO;
import com.dts.project.dao.LawTypeDAO;
import com.dts.project.model.CaseLawyerModel;
import com.dts.project.model.LawTypeModel;

public class AddCaseLawyerAction extends HttpServlet {

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

		String target="AddCaseLawyer.jsp?status=Adding CaseLawer Is Invalid";
		try{
			CaseLawyerModel caselawyerModel = new CaseLawyerModel(); 
			
			
		caselawyerModel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
		caselawyerModel.setLawyerid(Integer.parseInt(request.getParameter("lawyername")));
		caselawyerModel.setLaweraccepteddate(request.getParameter("lawyeraccepteddate"));
		//caselawyerModel.setLawerenddate(request.getParameter(""));
		caselawyerModel.setLaweractivestate(request.getParameter("lawyeractivestate"));
		
		boolean flag=new CaseLawyerDAO().addcaselawyer(caselawyerModel);

		if(flag) 
		   target = "AddCaseLawyer.jsp?status=Adding CaseLawer Is Successfully Done"; 
		else  
		    target = "AddCaseLawyer.jsp?status=Adding CaseLawer Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
