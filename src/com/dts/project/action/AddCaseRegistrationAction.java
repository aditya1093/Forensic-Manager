package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseRegistrationDAO;
import com.dts.project.dao.CourtDAO;
import com.dts.project.model.CaseRegistrationModel;
import com.dts.project.model.CourtModel;

public class AddCaseRegistrationAction extends HttpServlet {

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
		
		String fday=request.getParameter("fday");
		String fmonth=request.getParameter("fmonth");
		String fyear=request.getParameter("fyear");
		String fdate=fday+"-"+fmonth+"-"+fyear;
		
		String target="AddCaseRegistration.jsp?status=Adding Case Registration Is Invalid";
		try{
			CaseRegistrationModel caseregModel = new CaseRegistrationModel();
			
			
			
			
		caseregModel.setCaseno(Integer.parseInt(request.getParameter("caseno")));
		System.out.println("---caseno--"+request.getParameter("caseno"));
		caseregModel.setCasetypeid(Integer.parseInt(request.getParameter("casetypename")));
		System.out.println("casetype name------->"+request.getParameter("casetypename"));
		caseregModel.setCaseregdate(request.getParameter("caseregistrationdate"));
		System.out.println("---case reg date---->"+request.getParameter("caseregistrationdate"));
		caseregModel.setClientid(Integer.parseInt(request.getParameter("clientname")));
		System.out.println("clientname ----->"+request.getParameter("clientname"));
		caseregModel.setNexthearingdate(request.getParameter("nexthearingdate"));
		System.out.println(" casehearong date -------"+request.getParameter("nexthearingdate"));
		caseregModel.setCourtid(Integer.parseInt(request.getParameter("courtname")));
		System.out.println("--court name---"+request.getParameter("courtname"));
		caseregModel.setLawerid(Integer.parseInt(request.getParameter("lawyername")));
		
		System.out.println("lawyername---->"+request.getParameter("lawyername"));
		caseregModel.setSectionid(Integer.parseInt(request.getParameter("sectionid")));	
		System.out.println("----sectionid---->"+request.getParameter("sectionid"));
		
		
		caseregModel.setLawyeraceptdate(request.getParameter("lawyeracceptdate"));
		System.out.println("layer accept date"+request.getParameter("lawyeracceptdate"));
		caseregModel.setLawyeractivestate(request.getParameter("lawyeractivestate"));
		System.out.println("-----activestate----->"+request.getParameter("lawyeractivestate"));
		
		caseregModel.setEvidenceregdate(request.getParameter("evidenceregdate"));		
		caseregModel.setEvidencetypeid(Integer.parseInt(request.getParameter("evidencetypename")));
		caseregModel.setEvidencedesc(request.getParameter("evidencetypedesc"));
		caseregModel.setEvidenceimage(request.getParameter("evidenceimage"));
		caseregModel.setEvidenceaudio(request.getParameter("evidenceaudio"));
		caseregModel.setEvidencevedio(request.getParameter("evidencevedio"));
		
		
		caseregModel.setWitfstname(request.getParameter("witnessfstname"));
		caseregModel.setWitlastname(request.getParameter("witnesslstname"));
		caseregModel.setWitmidname(request.getParameter("witnessmidname"));
		caseregModel.setWitnesstype(request.getParameter("witnesstype"));
		caseregModel.setWitnessseqno(request.getParameter("witnessseqno"));
		caseregModel.setAddress(request.getParameter("address"));
		caseregModel.setWitnessdob(fdate);
		caseregModel.setWitnesrecordedstmt(request.getParameter("witnessrecordstmt"));
		
		
		caseregModel.setMemfstname(request.getParameter("memberfstname"));
		caseregModel.setMemmidname(request.getParameter("membermidname"));
		caseregModel.setMemlastname(request.getParameter("memberlstname"));
		caseregModel.setMembertype(request.getParameter("membertype"));		
		caseregModel.setMemseqno(request.getParameter("sequenceno"));
		caseregModel.setMemftherfstname(request.getParameter("memberffstname"));
		caseregModel.setMemfthermidname(request.getParameter("memberfmidname"));
		caseregModel.setMemftherlastname(request.getParameter("memberflstname"));
		caseregModel.setMemaddress(request.getParameter("memaddress"));
		caseregModel.setMemdob(fdate);
		
		
		
		boolean flag=new CaseRegistrationDAO().addcaseregstration(caseregModel);

		if(flag) 
		   target = "AddCaseRegistration.jsp?status=Adding Case Registration Is Successfully Done"; 
		else  
		    target = "AddCaseRegistration.jsp?status=Adding Case Registration Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
