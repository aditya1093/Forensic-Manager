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

public class AddSectionAction extends HttpServlet {

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

		String target="AddSection.jsp?status=Adding Section Is Invalid";
		try{
			SectionModel sectionModel = new SectionModel(); 
		sectionModel.setActualsectionno(request.getParameter("sectionno"));
		sectionModel.setSectiondesc(request.getParameter("sectiondesc"));
		sectionModel.setTypeoflawid(Integer.parseInt(request.getParameter("lawtypename")));
		sectionModel.setSectioncommendate(request.getParameter("sectioncommencedate"));
		sectionModel.setSectionactivestate(request.getParameter("sectionactivestate"));
		sectionModel.setSectionandsubsecbit(request.getParameter("subsectionbit"));
		
		boolean flag=new SectionDAO().addsection(sectionModel);

		if(flag) 
		   target = "AddSection.jsp?status=Adding Section Is Successfully Done"; 
		else  
		    target = "AddSection.jsp?status=Adding Section Is Failed"; 
		    }catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

}
