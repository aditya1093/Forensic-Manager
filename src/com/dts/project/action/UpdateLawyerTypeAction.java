package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.LawTypeDAO;
import com.dts.project.dao.LawyerTypeDAO;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.LawyerTypeModel;

public class UpdateLawyerTypeAction extends HttpServlet {

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
			String target="ViewAllLawyerTypes.jsp?status=Update  Lawyer Type Details Is Invalid";
			try{
				LawyerTypeModel lawyertypemodel = new LawyerTypeModel();
				
				lawyertypemodel.setLawyertypeid(Integer.parseInt(request.getParameter("lawyertypeid")));					
				lawyertypemodel.setLawyertypeabbr(request.getParameter("abbr"));
				lawyertypemodel.setLawyertypedesc(request.getParameter("desc"));
				
				
				 flag=new LawyerTypeDAO().updatelawyertypedetails(lawyertypemodel);

			if(flag) 
			   target = "ViewAllLawyerTypes.jsp?status=Update  Lawyer Type Details Successfully Done"; 
			else  
			    target = "ViewAllLawyerTypes.jsp?status=Update  Lawyer Type Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllLawyerTypes.jsp?status=Delete  Lawyer Type Details Invalid";
				try{
					LawyerTypeModel lawyertypemodel = new LawyerTypeModel();
					
					lawyertypemodel.setLawyertypeid(Integer.parseInt(request.getParameter("lawyertypeid")));	
					flag=new LawyerTypeDAO().deletelawyertypedetails(lawyertypemodel);

				if(flag) 
				   target1 = "ViewAllLawyerTypes.jsp?status=Delete  Lawyer Type Details Successfully Done"; 
				else  
				    target1 = "ViewAllLawyerTypes.jsp?status=Delete  Lawyer Type Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
