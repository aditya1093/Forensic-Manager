package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.LawyerDAO;

import com.dts.project.model.LawyerModel;


public class UpdateLawyerAction extends HttpServlet {

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
			String target="ViewAllLawyers.jsp?status=Update  Lawyer Details Is Invalid";
			try{
				LawyerModel lawyermodel = new LawyerModel();
				
				lawyermodel.setLawyerid(Integer.parseInt(request.getParameter("lawyerid")));					
				lawyermodel.setLawyerbarregdate(request.getParameter("barregdate"));
				lawyermodel.setLawyerqualification(request.getParameter("qualification"));
				lawyermodel.setLawyeraddress(request.getParameter("address"));
				lawyermodel.setLawyerphno(request.getParameter("phoneno"));
				lawyermodel.setLawyeremail(request.getParameter("emailid"));
				lawyermodel.setLawyertypeid(Integer.parseInt(request.getParameter("lawtypeid")));
				System.out.println("lawyerid---->"+request.getParameter("lawyerid")+"barregdate---->"+request.getParameter("barregdate")+"qualification---->"+request.getParameter("qualification")+"address---->"+request.getParameter("address")+"phoneno---->"+request.getParameter("phoneno")+"emailid---->"+request.getParameter("emailid")+"lawyerid--->"+request.getParameter("lawtypeid"));
				 flag=new LawyerDAO().updatelawyerdetails(lawyermodel);
				 System.out.println(" before flag--->"+flag);
			if(flag){ 
			   target = "ViewAllLawyers.jsp?status=Update Lawyer Details  Successfully Done"; 
			   System.out.println(" after flag--->"+flag);
			}
			   else  
			    target = "ViewAllLawyers.jsp?status=Update Lawyer Details Is Failed"; 
			    }catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			}
			
			if(button.equalsIgnoreCase("Delete")){
				String target1="ViewAllLawyers.jsp?status=Delete Lawyer Details Invalid";
				try{
					LawyerModel lawyermodel = new LawyerModel();
					
					lawyermodel.setLawyerid(Integer.parseInt(request.getParameter("lawyerid")));					
					
				flag=new LawyerDAO().deletelawyerdetails(lawyermodel);

				if(flag) 
				   target1 = "ViewAllLawyers.jsp?status=Delete Lawyer Details Successfully Done"; 
				else  
				    target1 = "ViewAllLawyers.jsp?status=Delete Lawyer Details Is Failed"; 
				    }catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target1);
				rd.forward(request,response);
				}
	}

}
