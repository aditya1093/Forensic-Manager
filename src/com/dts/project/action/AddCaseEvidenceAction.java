package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseEvidenceDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.CaseEvidenceModel;
import com.dts.project.model.LawyerModel;

public class AddCaseEvidenceAction extends HttpServlet {

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

		String target="AddCaseEvidence.jsp?status=Adding Case Evidence Is Invalid";
		try{
			CaseEvidenceModel caseevidenceModel = new CaseEvidenceModel(); 
		caseevidenceModel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
		caseevidenceModel.setEvidenceregdate(request.getParameter("evidenceregdate"));
		caseevidenceModel.setEvidencetypeid(Integer.parseInt(request.getParameter("evidencetypename")));
		caseevidenceModel.setEvidencedesc(request.getParameter("evidencetypedesc"));
		caseevidenceModel.setEvidenceImage(request.getParameter("evidenceimage"));
		caseevidenceModel.setEvidencevideo(request.getParameter("evidencevedio"));
		caseevidenceModel.setEvidenceaudio(request.getParameter("evidenceaudio"));
		
		
		boolean flag=new CaseEvidenceDAO().addcaseevidence(caseevidenceModel);

		if(flag) 
		   target = "AddCaseEvidence.jsp?status=Adding Case Evidence Is Successfully Done"; 
		else  
		    target = "AddCaseEvidence.jsp?status=Adding Case Evidence Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
