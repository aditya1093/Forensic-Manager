package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CourtDAO;
import com.dts.project.dao.SectionDAO;
import com.dts.project.model.CourtModel;
import com.dts.project.model.SectionModel;

public class UpdateCourtAction extends HttpServlet {

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
			String target="ViewAllCourts.jsp?status=Update  Court Details Is Invalid";
			try{
				CourtModel courtmodel = new CourtModel();
				
				courtmodel.setCourtid(Integer.parseInt(request.getParameter("courtid")));					
				courtmodel.setCourttypeid(Integer.parseInt(request.getParameter("courttypeid")));
				courtmodel.setCourtaddress(request.getParameter("courtaddress"));
				courtmodel.setCourtphno(request.getParameter("phoneno"));
				courtmodel.setCourtemail(request.getParameter("email"));
				courtmodel.setCourtweblink(request.getParameter("weblink"));
				
				
				 flag=new CourtDAO().updatecourtdetails(courtmodel);

			if(flag) 
			   target = "ViewAllCourts.jsp?status=Update  Court Details Successfully Done"; 
			else  
			    target = "ViewAllCourts.jsp?status=Update  Court Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllCourts.jsp?status=Delete  Court Details Invalid";
				try{
					CourtModel courtmodel = new CourtModel();
					
					courtmodel.setCourtid(Integer.parseInt(request.getParameter("courtid")));									
				flag=new CourtDAO().deletecourtdetails(courtmodel);

				if(flag) 
				   target1 = "ViewAllCourts.jsp?status=Delete Court Details Successfully Done"; 
				else  
				    target1 = "ViewAllCourts.jsp?status=Delete Court Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}	
	}

}
