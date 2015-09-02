package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseRegistrationDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.CaseRegistrationModel;
import com.dts.project.model.LawyerModel;

public class UpdateCaseRegAction extends HttpServlet {

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
		
		String nday=request.getParameter("nday");
		String nmonth=request.getParameter("nmonth");
		String nyear=request.getParameter("nyear");
		String ndate=nday+"-"+nmonth+"-"+nyear;
		
		 String button=request.getParameter("submit");	
		  boolean flag=false;
			
			//if(button.equalsIgnoreCase("Update")){
			String target="UpdateCaseRegistration.jsp?status=Update  Case Registration Details Is Invalid";
			try{
				CaseRegistrationModel caseregModel = new CaseRegistrationModel();
				
				
				
				
				caseregModel.setCaseid(Integer.parseInt(request.getParameter("caseno")));
				
				//caseregModel.setCaseregdate(request.getParameter("caseregistrationdate"));
				caseregModel.setCasetypeid(Integer.parseInt(request.getParameter("casetypename")));
				
				caseregModel.setClientid(Integer.parseInt(request.getParameter("clientname")));			
				caseregModel.setNexthearingdate(request.getParameter("nexthearingdate"));				
				caseregModel.setCourtid(Integer.parseInt(request.getParameter("courtname")));				
				caseregModel.setLawerid(Integer.parseInt(request.getParameter("lawyername")));
				
				System.out.println("caseno--->"+request.getParameter("caseno")+" casetype---->"+request.getParameter("casetypename")+"clienid--->"+request.getParameter("clientname")+"nexthearingdate--->"+request.getParameter("nexthearingdate")+"courtname---->"+request.getParameter("courtname"));
				caseregModel.setSectionid(Integer.parseInt(request.getParameter("sectionid")));		
				System.out.println("sectionid---->"+request.getParameter("sectionid"));				
				caseregModel.setLawyeraceptdate(request.getParameter("lawyeracceptdate"));				
				System.out.println("accept date---->"+request.getParameter("lawyeracceptdate"));
				caseregModel.setLawyeractivestate(request.getParameter("lawyeractivestate"));				
				System.out.println("active state---->"+request.getParameter("lawyeractivestate"));
				
				
				caseregModel.setEvidenceregdate(request.getParameter("evidenceregdate"));
				
				caseregModel.setEvidencetypeid(Integer.parseInt(request.getParameter("evidencetypename")));
				
				
				caseregModel.setEvidencedesc(request.getParameter("evidencetypedesc"));
			
				caseregModel.setEvidenceimage(request.getParameter("evidenceimage"));
				
				caseregModel.setEvidenceaudio(request.getParameter("evidenceaudio"));
				
				caseregModel.setEvidencevedio(request.getParameter("evidencevedio"));
				
				System.out.println("EVREGDATE-->"+ request.getParameter("evidenceregdate")+"evetype----> "+request.getParameter("evidencetypename")+"evetypedesc----->"+request.getParameter("evidencetypedesc"));   
				System.out.println(" witness");	
				
				caseregModel.setWitnessid(Integer.parseInt(request.getParameter("witnessfstname")));	
				System.out.println(""+request.getParameter("witnessfstname"));
				
				caseregModel.setWitnesstype(request.getParameter("witnesstype"));
				System.out.println("   "+request.getParameter("witnesstype"));
				caseregModel.setWitnessseqno(request.getParameter("witnessseqno"));
				System.out.println("  "+request.getParameter("witnessseqno"));
				caseregModel.setAddress(request.getParameter("address"));
				System.out.println("  "+request.getParameter("address"));
				caseregModel.setWitnessdob(cdate);
				caseregModel.setWitnesrecordedstmt(request.getParameter("witnessrecordstmt"));
				
				
				System.out.println("witfstname--->"+request.getParameter("witnessfstname")+"wittype--->"+request.getParameter("witnesstype")+"witseqno--> "+request.getParameter("witnessseqno")+"  address"+request.getParameter("address"));
				System.out.println(" cdate--->"+cdate+"wit record state--->"+request.getParameter("witnessrecordstmt"));
				
				
				
				caseregModel.setMemid(Integer.parseInt(request.getParameter("memberfstname")));
				caseregModel.setMembertype(request.getParameter("membertype"));		
				caseregModel.setMemseqno(request.getParameter("sequenceno"));
				caseregModel.setMemftherfstname(request.getParameter("memberffstname"));
				caseregModel.setMemaddress(request.getParameter("memaddress"));
				caseregModel.setMemdob(fdate);
				
				
				System.out.println("membername-->"+request.getParameter("memberfstname")+"membertype --->"+request.getParameter("membertype")+"seqno--->"+request.getParameter("sequenceno")+" father fst name--> "+request.getParameter("memberffstname")+"memberaddress--->"+request.getParameter("memaddress")+"fdate---->"+fdate);
				caseregModel.setHearingid(Integer.parseInt(request.getParameter("hearingid")));
				caseregModel.setHearingresult(request.getParameter("hearingresult"));				
				caseregModel.setNexthearingdate1(ndate);				
				caseregModel.setAnyspecialinstructions(request.getParameter("anyinstruction"));		
				
				System.out.println("hearingid ----->"+request.getParameter("hearingid")+ " Any Instruction-------->"+request.getParameter("anyinstruction"));
				System.out.println("hearing Result ----->" +request.getParameter("hearingresult")); 
				System.out.println("Next hearing Date ----->"+ndate);
				flag=new CaseRegistrationDAO().updatecaseregstration(caseregModel);

				 System.out.println("after  flag----------------->" +flag);

			if(flag) 
			   target = "UpdateCaseRegistration.jsp?status=Update  Case Registration Details Successfully Done"; 
			else  
			    target = "UpdateCaseRegistration.jsp?status=Update  Case Registration Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			//}
			
			//if(button.equalsIgnoreCase("Delete")){
				//String target1="ViewAllCaseRegistration.jsp?status=Delete  Case Registration Details Invalid";
				//try{
					//LawyerModel lawyermodel = new LawyerModel();
					
					//lawyermodel.setLawyerid(Integer.parseInt(request.getParameter("lawyerid")));					
					
				//flag=new LawyerDAO().deletelawyerdetails(lawyermodel);

				//if(flag) 
				  // target1 = "ViewAllCaseRegistration.jsp?status=Delete  Case Registration Details Successfully Done"; 
				//else  
				  //  target1 = "ViewAllCaseRegistration.jsp?status=Delete  Case Registration Details Is Failed"; 
				  //  }catch(Exception e){e.printStackTrace();}
				//RequestDispatcher rd = request.getRequestDispatcher(target1);
				//rd.forward(request,response);
				//}
	}

}
