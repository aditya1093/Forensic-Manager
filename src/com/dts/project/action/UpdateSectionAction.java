package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.LawyerDAO;
import com.dts.project.dao.SectionDAO;
import com.dts.project.model.LawyerModel;
import com.dts.project.model.SectionModel;

public class UpdateSectionAction extends HttpServlet {

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
			String target="ViewAllSections.jsp?status=Update  Section Details Is Invalid";
			try{
				SectionModel sectionmodel = new SectionModel();
				
				sectionmodel.setSectionid(Integer.parseInt(request.getParameter("sectionid")));					
				sectionmodel.setActualsectionno(request.getParameter("actualsecno"));
				sectionmodel.setSectiondesc(request.getParameter("sectiondesc"));
				sectionmodel.setTypeoflawid(Integer.parseInt(request.getParameter("lawtypeid")));
				sectionmodel.setSectioncommendate(request.getParameter("sectioncommdate"));
				sectionmodel.setSectionactivestate(request.getParameter("sectionactstate"));
				sectionmodel.setSectionandsubsecbit(request.getParameter("sectionbit"));
				
				 flag=new SectionDAO().updatesectiondetails(sectionmodel);

			if(flag) 
			   target = "ViewAllSections.jsp?status=Update  Section Details Successfully Done"; 
			else  
			    target = "ViewAllSections.jsp?status=Update  Section Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllSections.jsp?status=Delete Section Details Invalid";
				try{
					SectionModel sectionmodel = new SectionModel();
					
					sectionmodel.setSectionid(Integer.parseInt(request.getParameter("sectionid")));					
				flag=new SectionDAO().deletesectiondetails(sectionmodel);

				if(flag) 
				   target1 = "ViewAllSections.jsp?status=Delete  Section Details Successfully Done"; 
				else  
				    target1 = "ViewAllSections.jsp?status=Delete  Section Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
