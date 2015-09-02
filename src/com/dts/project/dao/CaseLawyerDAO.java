package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.project.model.CaseLawyerModel;
import com.dts.project.model.CaseRegistrationModel;

public class CaseLawyerDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseLawyerDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcaselawyer(CaseLawyerModel addcaselawyermodel)
	{
		
	    int caseid=addcaselawyermodel.getCaseid();	   
	    int lawyerid=addcaselawyermodel.getLawyerid();	   
	    String accepteddate=DateWrapper.parseDate(addcaselawyermodel.getLaweraccepteddate());
	    //int clientid=addcaselawyermodel.getClientid();	   
	    String activestate=addcaselawyermodel.getLaweractivestate();	   
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_CASELAWYERMSTR(?,?,?,?)}");

	       cstmt.setInt(1,caseid);	       
	       cstmt.setInt(2,lawyerid);
	       cstmt.setString(3,accepteddate);
	       cstmt.setString(4,activestate);
	      
	       
	       
	       
	       int i= cstmt.executeUpdate();
	         if(i==1)
	         {
	             flag=true;
	             con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	         con.close();
	    } 
	    catch(SQLException e)
		{
		System.out.println(e.toString());
		if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
			{
			flag=true;
			System.out.println("n==="+flag);
			}
	System.out.println(e);

		}
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    return flag;
	}
}
