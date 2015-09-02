package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.ProfileDAO;
import com.dts.project.model.EmployeesModel;

public class RegisterAction extends HttpServlet {

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

		String target="AddClient.jsp?status=Registration Is Invalid Plz,..Try again";
		
		String cday=request.getParameter("cday");
		String cmonth=request.getParameter("cmonth");
		String cyear=request.getParameter("cyear");
		String cdate=cday+"-"+cmonth+"-"+cyear;
		
		
		String fday=request.getParameter("fday");
		String fmonth=request.getParameter("fmonth");
		String fyear=request.getParameter("fyear");
		String fdate=fday+"-"+fmonth+"-"+fyear;
		
		
		
		try{
			
			
			EmployeesModel  eModel = new EmployeesModel();
			
			eModel.setFirstname(request.getParameter("firstname"));
			eModel.setSurname(request.getParameter("middlename"));
			eModel.setLastname(request.getParameter("lastname"));			
			eModel.setClientdateofbirt(cdate);
			
			eModel.setFatherfstname(request.getParameter("cffirstname"));
			eModel.setFathermidname(request.getParameter("cfmiddlename"));
			eModel.setFatherlstname(request.getParameter("cflastname"));
			eModel.setClientftherdateofbirt(fdate);
			
			
			eModel.setDateofreg(request.getParameter("dateofreg"));
			eModel.setUserid(Integer.parseInt(request.getParameter("username")));
			eModel.setEmail(request.getParameter("mailid"));
			
			
	        //home
			System.out.println(request.getParameter("firstname"));
			System.out.println(request.getParameter("middlename"));
			System.out.println(request.getParameter("lastlame"));
			
        //home
        String home=request.getParameter("homeaddresstype");
        if(home!=null)
        {
        eModel.setHome(home);	
        eModel.setHno(request.getParameter("homehouseno"));
        eModel.setStreet(request.getParameter("homestreet"));
        eModel.setCity(request.getParameter("homecity")); 
        eModel.setState(request.getParameter("homestate")); 
        eModel.setCountry(request.getParameter("homecountry"));
        eModel.setLandmark(request.getParameter("homelandmark"));
        eModel.setPin(request.getParameter("homepin"));       
        eModel.setHomePhoneType(request.getParameter("homephonetype"));
        eModel.setPhone(request.getParameter("homephoneno"));
        }
        //office
        String office=request.getParameter("officeaddresstype");
        if(office!=null)
        {
        eModel.setOffice(office);	
        eModel.setOhno(request.getParameter("officehouseno"));
        eModel.setOstreet(request.getParameter("officestreet"));
        eModel.setOcity(request.getParameter("officecity")); 
        eModel.setOstate(request.getParameter("officestate")); 
        eModel.setOcountry(request.getParameter("officecountry"));
        eModel.setOlandmark(request.getParameter("officelandmark"));
        eModel.setOpin(request.getParameter("officepin"));
        eModel.setOfficePhoneType(request.getParameter("officephonetype"));
        eModel.setOphone(request.getParameter("officephoneno"));
        }
        //contact
        String contact=request.getParameter("personaladdresstype");
        if(contact!=null)
        {
        	eModel.setContact(contact);	
        	eModel.setChno(request.getParameter("personalhouseno"));
        	eModel.setCstreet(request.getParameter("personalstreet"));
        	eModel.setCcity(request.getParameter("personalcity")); 
        	eModel.setCstate(request.getParameter("personalstate")); 
        	eModel.setCcountry(request.getParameter("personalcountry"));
        	eModel.setClandmark(request.getParameter("personallandmark"));
        	eModel.setCpin(request.getParameter("personalpin"));
        	eModel.setPersonalPhoneType(request.getParameter("personalphonetype"));
        	eModel.setCphone(request.getParameter("personalphoneno"));
        }
        
       
        boolean flag=new ProfileDAO().registration(eModel);
        
        if(!flag) 
           target = "AddClient.jsp?status=Registration Is Success"; 
        else  
            target = "AddClient.jsp?status=Registration Is Failed"; 
            }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}

}
