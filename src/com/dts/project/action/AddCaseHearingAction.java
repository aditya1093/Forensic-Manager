package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseHearingDAO;
import com.dts.project.dao.CaseWitnessDAO;
import com.dts.project.model.CaseHearingModel;
import com.dts.project.model.CaseWitnessModel;

public class AddCaseHearingAction extends HttpServlet {

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

		String target="AddCaseHearing.jsp?status=Adding CaseHearing Is Invalid";
		try{
			CaseHearingModel casehearingModel = new CaseHearingModel(); 
		casehearingModel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
		casehearingModel.setHearingdate(request.getParameter("hearingdate"));
		casehearingModel.setHearingresult(request.getParameter("hearingresult"));
		casehearingModel.setNexthearingdate(request.getParameter("nexthearingdate"));
		casehearingModel.setAnyspecialinstruction(request.getParameter("anyspecialinstruction"));
		
		
		boolean flag=new CaseHearingDAO().addcasehearing(casehearingModel);
System.out.println("---Fag-------------------------"+flag);
		if(flag) 
		   target = "AddCaseHearing.jsp?status=Adding CaseHearing Is Successfully Done"; 
		else  
		    target = "AddCaseHearing.jsp?status=Adding CaseHearing Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
