package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CourtDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.CourtModel;
import com.dts.project.model.LawyerModel;

public class AddLawyerAction extends HttpServlet {

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
		String fday=request.getParameter("fday");
		String fmonth=request.getParameter("fmonth");
		String fyear=request.getParameter("fyear");
		String fdate=fday+"-"+fmonth+"-"+fyear;
		String target="AddLawyer.jsp?status=Adding Lawyer Is Invalid";
		try{
			LawyerModel lawyerModel = new LawyerModel(); 
		lawyerModel.setLawyerfstname(request.getParameter("lawyerfstname"));
		lawyerModel.setLawyermidname(request.getParameter("lawyermidname"));
		lawyerModel.setLawyerlstname(request.getParameter("lawyerlstname"));
		lawyerModel.setLawyerbarregdate(fdate);
		lawyerModel.setLawyerqualification(request.getParameter("lawyerqualification"));
		lawyerModel.setLawyerphoto(request.getParameter("lawyerphoto"));
		lawyerModel.setLawyeraddress(request.getParameter("lawyeraddress"));
		lawyerModel.setLawyerphno(request.getParameter("lawyerphno"));
		lawyerModel.setLawyeremail(request.getParameter("lawyeremailid"));
		lawyerModel.setLawyertypeid(Integer.parseInt(request.getParameter("lawyertypename")));
		
		boolean flag=new LawyerDAO().addlawyer(lawyerModel);

		if(flag) 
		   target = "AddLawyer.jsp?status=Adding Lawyer Is Successfully Done"; 
		else  
		    target = "AddLawyer.jsp?status=Adding Lawyer Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
