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
import com.dts.project.model.ClientModel;
import com.dts.project.model.CourtModel;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.SectionModel;
import com.dts.project.model.UserModel;

public class CourtDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CourtDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcourt(CourtModel addcourtmodel)
	{
		
	    String courtname=addcourtmodel.getCourtname();	   
	    int courttypeid=addcourtmodel.getCourttypeid();	   
	    String courtaddr=addcourtmodel.getCourtaddress();
	    String courtphno=addcourtmodel.getCourtphno();	   
	    String courtemail=addcourtmodel.getCourtemail();	   
	    String courtweblink=addcourtmodel.getCourtweblink();
	       
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_COURTMSTR(?,?,?,?,?,?)}");

	       cstmt.setString(1,courtname);
	       cstmt.setInt(2,courttypeid);
	       cstmt.setString(3,courtaddr);	       
	       cstmt.setString(4,courtphno);
	       cstmt.setString(5,courtemail);
	       cstmt.setString(6,courtweblink);
	       
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
	
	
	public CoreHash getCourtNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CourtModel  courtmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  COURTID,INITCAP(COURTNAME) FROM COURTMASTER");
           	 while(rs.next())
                {
           		courtmodel=new CourtModel();
             	  
           		courtmodel.setCourtid(rs.getInt(1));
           		courtmodel.setCourtname(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),courtmodel);
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
	
	public boolean updatecourtdetails(CourtModel updatecourtmodel)
	{
		 int courtid=updatecourtmodel.getCourtid();
		 int courttypeid=updatecourtmodel.getCourttypeid();
		String address=updatecourtmodel.getCourtaddress();    	   
	    String phno=updatecourtmodel.getCourtphno();	  	    	   
	    String email=updatecourtmodel.getCourtemail();	   
	    String weblink=updatecourtmodel.getCourtweblink();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  UPDATE_COURTMSTR(?,?,?,?,?,?)}");
	       
	       cstmt.setInt(1,courtid);	
	       cstmt.setInt(2,courttypeid);
	       cstmt.setString(3,address);
	       cstmt.setString(4,phno);	        
	       cstmt.setString(5,email);
	       cstmt.setString(6,weblink);
	       
	       
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
	
	
	
	
	public boolean deletecourtdetails(CourtModel deletecourtmodel)
	{
		 int courtid=deletecourtmodel.getCourtid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call DELETE_COURTMSTR(?)}");	       
	       cstmt.setInt(1,courtid);        
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
	
	
	public CourtModel getCourtDetails(int courtid)
	{
		
		
		
		Statement st=null;
		CourtModel  courtmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT CM.COURTID,CM.COURTNAME, CM.COURTTYPEID,CTM.COURTTYPENAME,CM.COURTADDRESS,CM.PHONENO,CM.EMAIL,CM.WEBLINK FROM  COURTMASTER  CM,COURTTYPEMASTER CTM WHERE CM.COURTTYPEID  IN(SELECT  COURTTYPEID FROM COURTTYPEMASTER)AND(CM.COURTTYPEID=CTM.COURTTYPEID) AND CM.COURTID="+courtid);
           	 while(rs.next())
                {
           		courtmodel=new CourtModel();
             	  
           		courtmodel.setCourtid(rs.getInt(1));
           		courtmodel.setCourtname(rs.getString(2));
           		courtmodel.setCourttypeid(rs.getInt(3));
           		courtmodel.setCourttypename(rs.getString(4));
           		courtmodel.setCourtaddress(rs.getString(5));
           		courtmodel.setCourtphno(rs.getString(6));
           		courtmodel.setCourtemail(rs.getString(7));
           		courtmodel.setCourtweblink(rs.getString(8));         		  		        		     		
             	
		  
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
		return courtmodel;
	}
	
	
	public CoreHash getAllCourtsDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CourtModel  courtmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT CM.COURTID,CM.COURTNAME, CM.COURTTYPEID,CTM.COURTTYPENAME,CM.COURTADDRESS,CM.PHONENO,CM.EMAIL,CM.WEBLINK FROM  COURTMASTER  CM,COURTTYPEMASTER CTM WHERE CM.COURTTYPEID  IN(SELECT  COURTTYPEID FROM COURTTYPEMASTER)AND(CM.COURTTYPEID=CTM.COURTTYPEID)");
           	 while(rs.next())
                {
           		courtmodel=new CourtModel();
             	  
           		courtmodel.setCourtid(rs.getInt(1));
           		courtmodel.setCourtname(rs.getString(2));
           		courtmodel.setCourttypeid(rs.getInt(3));
           		courtmodel.setCourttypename(rs.getString(4));
           		courtmodel.setCourtaddress(rs.getString(5));
           		courtmodel.setCourtphno(rs.getString(6));
           		courtmodel.setCourtemail(rs.getString(7));
           		courtmodel.setCourtweblink(rs.getString(8));
           		  		
           		
             	   
             	 aCoreHash.put(new Integer(sno),courtmodel);
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
