package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CaseMemberDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.CaseMemberModel;
import com.dts.project.model.LawyerModel;

public class UpdateCaseMemberAction extends HttpServlet {

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
			String target="ViewAllCaseMembers.jsp?status=Update  Case Members Is Invalid";
			try{
				CaseMemberModel  casemembermodel = new CaseMemberModel();
				
				casemembermodel.setCasememberid(Integer.parseInt(request.getParameter("memberid")));					
				casemembermodel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
				casemembermodel.setMembertype(request.getParameter("membertype"));
				casemembermodel.setSequenceno(request.getParameter("sdequenceno"));
				casemembermodel.setCasememberftherfstname(request.getParameter("fathername"));
				casemembermodel.setCasememberaddress(request.getParameter("address"));
				casemembermodel.setDob(request.getParameter("dob"));
				
				 flag=new CaseMemberDAO().updatecasememberdetails(casemembermodel);

			if(flag) 
			   target = "ViewAllCaseMembers.jsp?status=Update  Case Members Successfully Done"; 
			else  
			    target = "ViewAllCaseMembers.jsp?status=Update  Case Members Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllCaseMembers.jsp?status=Delete  Case Members Invalid";
				try{
					CaseMemberModel casemembermodel = new CaseMemberModel();
					
					casemembermodel.setCasememberid(Integer.parseInt(request.getParameter("memberid")));					
					
				flag=new CaseMemberDAO().deletecasememberdetails(casemembermodel);

				if(flag) 
				   target1 = "ViewAllCaseMembers.jsp?status=Delete  Case Members Successfully Done"; 
				else  
				    target1 = "ViewAllCaseMembers.jsp?status=Delete  Case Members Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}
	}

}
