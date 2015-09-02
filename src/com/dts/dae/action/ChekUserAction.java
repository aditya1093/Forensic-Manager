package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.core.util.LoggerManager;
import com.dts.dae.dao.SecurityDAO;
import com.dts.dae.model.Profile;

public class ChekUserAction extends HttpServlet {
	
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
String username1 = request.getParameter("username");
System.out.println("------------username---->"+username1);
String target = "AddUser.jsp?status=Invalid username and password";

try
{	
	String user = new SecurityDAO().checkUser(username1);
	System.out.println("------------user---->"+user);
	if (user.equals(username1))	
		target = "AddUser.jsp?status=<font color=red> Alreadyexist Try for another</font>&username="+username1;
	else
		target = "AddUser.jsp?status=<font color=green> <img src='images/no.png' height=17 width=40/>Available</font>";
}
catch (Exception e) 
{
	    target = "AddUser.jsp?status=<font color=green> <img src='images/verisign.gif' height=17 width=40/>Available</font>";
}

        RequestDispatcher rd = request.getRequestDispatcher(target);
         rd.forward(request, response);
}

}
