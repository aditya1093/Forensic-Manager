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
import com.dts.project.model.CaseMemberModel;
import com.dts.project.model.LawyerModel;

public class CaseMemberDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseMemberDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcasemember(CaseMemberModel addcasemembermodel)
	{
		
		int caseid=addcasemembermodel.getCaseid();	   
	    String casemembrfirstname=addcasemembermodel.getCasememberfstname();	   
	    String casemembrmidname=addcasemembermodel.getCasemembermidname();
	    String casemembrlastname=addcasemembermodel.getCasememberlstname();	   
	    String membertype=addcasemembermodel.getMembertype();	   
	    String casemembrftherfstname=addcasemembermodel.getCasememberftherfstname();
	    String casemembrfthermidlname=addcasemembermodel.getCasememberfthermidname();	   
	    String casemembrftherlastname=addcasemembermodel.getCasememberftherlstname();	   
	    String casemembraddr=addcasemembermodel.getCasememberaddress();
	    String dob=DateWrapper.parseDate(addcasemembermodel.getDob());
	    String memberseqno=addcasemembermodel.getSequenceno();
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_CASEMEMBERMSTR(?,?,?,?,?,?,?,?,?,?,?)}");
       
	       cstmt.setInt(1,caseid);
	       cstmt.setString(2,casemembrfirstname);
	       cstmt.setString(3,casemembrmidname);
	       cstmt.setString(4,casemembrlastname);
	       cstmt.setString(5,membertype);
	       cstmt.setString(6,casemembrftherfstname);
	       cstmt.setString(7,casemembrfthermidlname);
	       cstmt.setString(8,casemembrftherlastname);
	       cstmt.setString(9,casemembraddr);
	       cstmt.setString(10,dob);
	       cstmt.setString(11,memberseqno);
	       
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
	
	public boolean updatecasememberdetails(CaseMemberModel updatecasemembermodel)
	{
		 int memberid=updatecasemembermodel.getCasememberid();
		 int caseid=updatecasemembermodel.getCaseid();
		String memtype=updatecasemembermodel.getMembertype();	    
	    String sequenceno=(String)updatecasemembermodel.getSequenceno();	   
	    String fatherfstname=updatecasemembermodel.getCasememberftherfstname();	   
	    String address=updatecasemembermodel.getCasememberaddress();	   
	    String dob=DateWrapper.parseDate(updatecasemembermodel.getDob());	   
	   
	      
	  
	    try 
	    {
	    	         
	    	con=getConnection();	     
	       CallableStatement cstmt=con.prepareCall("{call  UPDATE_CASEMEMBERMSTR(?,?,?,?,?,?,?) }");
	       
	       cstmt.setInt(1,memberid);	          
	       cstmt.setInt(2,caseid);			
	       cstmt.setString(3,memtype);	       
	       cstmt.setString(4,sequenceno);
	       cstmt.setString(5,fatherfstname);
	       cstmt.setString(6,address);
	       cstmt.setString(7,dob);
	       
	       int i= cstmt.executeUpdate();
	         if(i>0)
	         {
	          flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	        // con.close();
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
	
	
	
	public boolean deletecasememberdetails(CaseMemberModel deletecasemembermodel)
	{
		 int casememberid=deletecasemembermodel.getCasememberid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call DELETE_CASEMEMBERMSTR(?)}");	       
	       cstmt.setInt(1,casememberid);        
	       int i= cstmt.executeUpdate();
	         if(i>0)
	         {
	          flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }
	         //con.close();
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
	
	
	public CoreHash getAllCaseMembersDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseMemberModel  casemembermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CM.CASEMEMBRID, CM.CASEID, CM.MEMBERFSTNAME, CM.MEMBERTYPE,CM.SEQUENCENO,CM.MEMBERFATHERFSTNAME,CM.MEMBERADDRESS,TO_CHAR(CM.MEMBERDOB,'DD-MM-YY') FROM CASEMEMBERMASTER  CM");
           	 while(rs.next())
                {
           		casemembermodel=new CaseMemberModel();
             	  
           		casemembermodel.setCasememberid(rs.getInt(1));
           		casemembermodel.setCaseid(rs.getInt(2));
           		casemembermodel.setCasememberfstname(rs.getString(3));
           		casemembermodel.setMembertype(rs.getString(4));
           		casemembermodel.setSequenceno(rs.getString(5));
           		casemembermodel.setCasememberftherfstname(rs.getString(6));
           		casemembermodel.setCasememberaddress(rs.getString(7));
           		casemembermodel.setDob(rs.getString(8));
           		
           		 	   
             	 aCoreHash.put(new Integer(sno),casemembermodel);
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
	
	public CaseMemberModel getCaseMemberDetails(int casememberid)
	{
		
		
		
		Statement st=null;
		CaseMemberModel  casemembermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CM.CASEMEMBRID, CM.CASEID, CM.MEMBERFSTNAME, CM.MEMBERTYPE,CM.SEQUENCENO,CM.MEMBERFATHERFSTNAME,CM.MEMBERADDRESS,TO_CHAR(CM.MEMBERDOB,'DD-MM-YY') FROM CASEMEMBERMASTER  CM  WHERE CM.CASEMEMBRID="+casememberid);
           	 while(rs.next())
                {
           		casemembermodel=new CaseMemberModel();
             	  
           		casemembermodel.setCasememberid(rs.getInt(1));
           		casemembermodel.setCaseid(rs.getInt(2));
           		casemembermodel.setCasememberfstname(rs.getString(3));
           		casemembermodel.setMembertype(rs.getString(4));
           		casemembermodel.setSequenceno(rs.getString(5));
           		casemembermodel.setCasememberftherfstname(rs.getString(6));
           		casemembermodel.setCasememberaddress(rs.getString(7));
           		casemembermodel.setDob(rs.getString(8));
           		
           		
		  
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
		return casemembermodel;
	}
	
	
	
	public CoreHash getCaseMemberID()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseMemberModel  casemembermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEMEMBRID,MEMBERFSTNAME FROM CASEMEMBERMASTER ");
           	 while(rs.next())
                {
           		casemembermodel=new CaseMemberModel();
             	  
           		casemembermodel.setCasememberid(rs.getInt(1));
           		casemembermodel.setCasememberfstname(rs.getString(2));
           		
           		 	   
             	 aCoreHash.put(new Integer(sno),casemembermodel);
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
	
	public CoreHash ViewAllCaseMembersDetails(int caseid)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseMemberModel  casemembermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEMEMBRID, CASEID, MEMBERFSTNAME, MEMBERTYPE,SEQUENCENO,MEMBERFATHERFSTNAME,MEMBERADDRESS,TO_CHAR(MEMBERDOB,'DD-MM-YY') FROM CASEMEMBERMASTER  WHERE CASEID="+caseid);
           	 while(rs.next())
                {
           		casemembermodel=new CaseMemberModel();
             	  
           		casemembermodel.setCasememberid(rs.getInt(1));
           		casemembermodel.setCaseid(rs.getInt(2));
           		casemembermodel.setCasememberfstname(rs.getString(3));
           		casemembermodel.setMembertype(rs.getString(4));
           		casemembermodel.setSequenceno(rs.getString(5));
           		casemembermodel.setCasememberftherfstname(rs.getString(6));
           		casemembermodel.setCasememberaddress(rs.getString(7));
           		casemembermodel.setDob(rs.getString(8));
           		
           		 	   
             	 aCoreHash.put(new Integer(sno),casemembermodel);
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
