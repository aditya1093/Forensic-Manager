package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.EvidenceTypeDAO;
import com.dts.project.dao.LawyerDAO;
import com.dts.project.model.EvidenceTypeModel;
import com.dts.project.model.LawyerModel;

public class AddEvidenceTypeAction extends HttpServlet {

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

		String target="AddEvidenceType.jsp?status=Adding Evidence Type Is Invalid";
		try{
			EvidenceTypeModel evidencetypeModel = new EvidenceTypeModel(); 
		evidencetypeModel.setEvidencetypename(request.getParameter("evidencetypename"));
		evidencetypeModel.setEvidencetypeabbr(request.getParameter("evidencetypeabbr"));
		evidencetypeModel.setEvidencetypedesc(request.getParameter("evidencetypedesc"));
		
		boolean flag=new EvidenceTypeDAO().addevidencetype(evidencetypeModel);

		if(flag) 
		   target = "AddEvidenceType.jsp?status=Adding Evidence Type Is Successfully Done"; 
		else  
		    target = "AddEvidenceType.jsp?status=Adding Evidence Type Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
