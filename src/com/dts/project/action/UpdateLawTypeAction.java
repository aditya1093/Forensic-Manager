package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseTypeDAO;
import com.dts.project.dao.LawTypeDAO;
import com.dts.project.model.CaseTypeModel;
import com.dts.project.model.LawTypeModel;

public class UpdateLawTypeAction extends HttpServlet {

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
			String target="ViewAllLawTypes.jsp?status=Update  Law Type Details Is Invalid";
			try{
				LawTypeModel lawtypemodel = new LawTypeModel();
				
				lawtypemodel.setLawtypeid(Integer.parseInt(request.getParameter("lawtypeid")));					
				lawtypemodel.setLawtypeabbr(request.getParameter("abbr"));
				lawtypemodel.setDesc(request.getParameter("desc"));
				
				
				 flag=new LawTypeDAO().updatelawtypedetails(lawtypemodel);

			if(flag) 
			   target = "ViewAllLawTypes.jsp?status=Update  Law Type Details Successfully Done"; 
			else  
			    target = "ViewAllLawTypes.jsp?status=Update  Law Type Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllLawTypes.jsp?status=Delete  Law Type Details Invalid";
				try{
					LawTypeModel lawtypemodel = new LawTypeModel();
					
					lawtypemodel.setLawtypeid(Integer.parseInt(request.getParameter("lawtypeid")));					
				
					flag=new LawTypeDAO().deletelawtypedetails(lawtypemodel);

				if(flag) 
				   target1 = "ViewAllLawTypes.jsp?status=Delete  Law Type Details Successfully Done"; 
				else  
				    target1 = "ViewAllLawTypes.jsp?status=Delete  Law Type Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
