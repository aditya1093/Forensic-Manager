package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseHearingModel;
import com.dts.project.model.CaseRegistrationModel;
import com.dts.project.model.CaseTypeModel;

public class CaseHearingDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseHearingDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcasehearing(CaseHearingModel addcasehearingmodel)
	{
		
	    int caseid=addcasehearingmodel.getCaseid();		    
	    String hearingdate=DateWrapper.parseDate(addcasehearingmodel.getHearingdate());	   
	    String result=addcasehearingmodel.getHearingresult();
	    String nexthearingdate=DateWrapper.parseDate(addcasehearingmodel.getNexthearingdate());	   
	    String anyspecialinstruction=addcasehearingmodel.getAnyspecialinstruction();	   
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_CASEHEARINGMSTR(?,?,?,?,?)}");

	       cstmt.setInt(1,caseid);
	       cstmt.setString(2,hearingdate);
	       cstmt.setString(3,result);
	       cstmt.setString(4,nexthearingdate);
	       cstmt.setString(5,anyspecialinstruction);
	       
	       
	       
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
	
	
	public CoreHash getCaseHearingID()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseHearingModel  casehearingmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEHEARINGID FROM CASEHEARINGMASTER");
           	 while(rs.next())
                {
           		casehearingmodel=new CaseHearingModel();
             	  
           		casehearingmodel.setCasehearingid(rs.getInt(1));         		 
             	   
             	 aCoreHash.put(new Integer(sno),casehearingmodel);
			    sno++;
		  
                }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
	
	
	public CoreHash getAllCaseHearingDetails(int caseid)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseHearingModel  casehearmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT    CASEHEARINGID, CASEID, TO_CHAR(HEARINGDATE,'DD-MM-YYYY'), HEARINGRESULT, NEXTHEARINGDATE, ANYSPECIALINSTRUCTION FROM  CASEHEARINGMASTER WHERE CASEID="+caseid);
           	
           	 while(rs.next())
                {
           		casehearmodel=new CaseHearingModel();
             	  
           		casehearmodel.setCasehearingid(rs.getInt(1));
           		casehearmodel.setCaseid(rs.getInt(2));
           		casehearmodel.setHearingdate(rs.getString(3));
           		casehearmodel.setHearingresult(rs.getString(4));
           		casehearmodel.setNexthearingdate(rs.getString(5));
           		casehearmodel.setAnyspecialinstruction(rs.getString(6));
           		
           		
           		
             	 aCoreHash.put(new Integer(sno),casehearmodel);
			    sno++;
		  
                }
		}
		catch(Exception e)
		{e.printStackTrace();
			LoggerManager.writeLogWarning(e);
		}
		finally
		{
		 try{
			 if(con!=null)
				 con.close();
			 
		 }
		 catch(Exception e){}
		}
		return aCoreHash;
	}
	
	
}
