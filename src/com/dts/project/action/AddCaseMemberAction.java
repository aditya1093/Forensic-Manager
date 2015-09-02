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

public class AddCaseMemberAction extends HttpServlet {

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
		
		
		String target="AddCaseMember.jsp?status=Adding Case Member Is Invalid";
		try{
			CaseMemberModel casememberModel = new CaseMemberModel(); 
		casememberModel.setCaseid(Integer.parseInt(request.getParameter("caseid")));
		casememberModel.setCasememberfstname(request.getParameter("memberfstname"));
		casememberModel.setCasemembermidname(request.getParameter("membermidname"));
		casememberModel.setCasememberlstname(request.getParameter("memberlstname"));
		casememberModel.setCasememberftherfstname(request.getParameter("memberffstname"));
		casememberModel.setCasememberfthermidname(request.getParameter("memberfmidname"));
		casememberModel.setCasememberftherlstname(request.getParameter("memberflstname"));
		casememberModel.setMembertype(request.getParameter("membertype"));
		casememberModel.setCasememberaddress(request.getParameter("address"));
		casememberModel.setSequenceno(request.getParameter("sequenceno"));
		casememberModel.setDob(cdate);
		
		boolean flag=new CaseMemberDAO().addcasemember(casememberModel);

		if(flag) 
		   target = "AddCaseMember.jsp?status=Adding Case Member Is Successfully Done"; 
		else  
		    target = "AddCaseMember.jsp?status=Adding Case Member Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
