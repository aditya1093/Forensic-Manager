package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CourtTypeDAO;
import com.dts.project.dao.EvidenceTypeDAO;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.EvidenceTypeModel;

public class UpdateEvidenceTypeAction extends HttpServlet {

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

		String button=request.getParameter("submit");	
		  boolean flag=false;
			
			if(button.equalsIgnoreCase("Update")){
			String target="ViewAllEvidences.jsp?status=Update  Evidence Type Details Is Invalid";
			try{
				EvidenceTypeModel evidencetypemodel = new EvidenceTypeModel();
				
				evidencetypemodel.setEvidencetypeid(Integer.parseInt(request.getParameter("evidencetypeid")));					
				evidencetypemodel.setEvidencetypeabbr(request.getParameter("abbr"));
				evidencetypemodel.setEvidencetypedesc(request.getParameter("desc"));
				
				
				 flag=new EvidenceTypeDAO().updateevidencetypedetails(evidencetypemodel);

			if(flag) 
			   target = "ViewAllEvidences.jsp?status=Update  Evidence Type Details Successfully Done"; 
			else  
			    target = "ViewAllEvidences.jsp?status=Update  Evidence Type Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllEvidences.jsp?status=Delete  Evidence Type Details Invalid";
				try{
					EvidenceTypeModel evidencetypemodel = new EvidenceTypeModel();
					
					evidencetypemodel.setEvidencetypeid(Integer.parseInt(request.getParameter("evidencetypeid")));					
				flag=new EvidenceTypeDAO().deleteevidencetypedetails(evidencetypemodel);

				if(flag) 
				   target1 = "ViewAllEvidences.jsp?status=Delete  Evidence Type Details Successfully Done"; 
				else  
				    target1 = "ViewAllEvidences.jsp?status=Delete  Evidence Type Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
