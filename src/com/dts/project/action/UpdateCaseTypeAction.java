package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseTypeDAO;
import com.dts.project.dao.CourtTypeDAO;
import com.dts.project.model.CaseTypeModel;
import com.dts.project.model.CourtTypeModel;

public class UpdateCaseTypeAction extends HttpServlet {

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
			String target="ViewAllCaseTypes.jsp?status=Update  Case Type Details Is Invalid";
			try{
				CaseTypeModel casetypemodel = new CaseTypeModel();
				
				casetypemodel.setCasetypeid(Integer.parseInt(request.getParameter("casetypeid")));					
				casetypemodel.setCasetypeabbr(request.getParameter("abbr"));
				casetypemodel.setCasetypedesc(request.getParameter("desc"));
				
				
				 flag=new CaseTypeDAO().updatecasetypedetails(casetypemodel);

			if(flag) 
			   target = "ViewAllCaseTypes.jsp?status=Update  Case Type Details Successfully Done"; 
			else  
			    target = "ViewAllCaseTypes.jsp?status=Update  Case Type Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllCaseTypes.jsp?status=Detete  Case Type Details Invalid";
				try{
					CaseTypeModel casetypemodel = new CaseTypeModel();
					
					casetypemodel.setCasetypeid(Integer.parseInt(request.getParameter("courttypeid")));	
				
					flag=new CaseTypeDAO().deletecasetypedetails(casetypemodel);

				if(flag) 
				   target1 = "ViewAllCaseTypes.jsp?status=Detete  Case Type Details Successfully Done"; 
				else  
				    target1 = "ViewAllCaseTypes.jsp?status=Detete  Case Type Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
