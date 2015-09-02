package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseWitnessDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.CaseWitnessModel;
import com.dts.project.model.LawyerModel;

public class AddCaseWitnessAction extends HttpServlet {

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
		
		String target="AddCaseWitness.jsp?status=Adding Case Witness Is Invalid";
		try{
			CaseWitnessModel casewitnessModel = new CaseWitnessModel(); 
		casewitnessModel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
		casewitnessModel.setWitnessfstname(request.getParameter("witnessfstname"));
		casewitnessModel.setWitnessmidname(request.getParameter("witnessmidname"));
		casewitnessModel.setWitnesslstname(request.getParameter("witnesslstname"));
		casewitnessModel.setWitnesstype(request.getParameter("witnesstype"));
		casewitnessModel.setWitnessseqno(Integer.parseInt(request.getParameter("witnessseqno")));
		casewitnessModel.setAddress(request.getParameter("address"));
		casewitnessModel.setDob(cdate);
		casewitnessModel.setWitnessrecordedstatement(request.getParameter("witnessrecordstmt"));
		
		
		boolean flag=new CaseWitnessDAO().addcasewitness(casewitnessModel);
          System.out.println("flag----------"+flag);
		if(flag) 
		   target = "AddCaseWitness.jsp?status=Adding Case Witness Is Successfully Done"; 
		else  
		    target = "AddCaseWitness.jsp?status=Adding Case Witness Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
