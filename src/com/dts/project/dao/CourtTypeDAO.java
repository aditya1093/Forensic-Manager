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
import com.dts.project.model.CourtModel;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.SectionModel;

public class CourtTypeDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CourtTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcourttype(CourtTypeModel addcourttypemodel)
	{
		
	    String courttypename=addcourttypemodel.getCourttypename();	   
	    String courttypeabbr=addcourttypemodel.getCourttypeabbr();	   
	    String courttypedesc=addcourttypemodel.getCourttypedesc();
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_COURTTYPEMSTR(?,?,?)}");

	       cstmt.setString(1,courttypename);
	       cstmt.setString(2,courttypeabbr);
	       cstmt.setString(3,courttypedesc);	       
	       
	       
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
	
	
	
	public boolean updatecourttypedetails(CourtTypeModel updatecourttypemodel)
	{
		 int courttypeid=updatecourttypemodel.getCourttypeid();
		String courttypename=updatecourttypemodel.getCourttypename();	    	   
	    String courttypeabbr=updatecourttypemodel.getCourttypeabbr();	   
	    String courttypedesc=updatecourttypemodel.getCourttypedesc();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call UPDATE_COURTTYPEMSTR(?,?,?)}");
	       
	       cstmt.setInt(1,courttypeid);	          
	       //cstmt.setString(2,courttypename);
	       cstmt.setString(2,courttypeabbr);       
	       cstmt.setString(3,courttypedesc);
	       
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
	
	public boolean deletecourttypedetails(CourtTypeModel deletecourttypemodel)
	{
		 int courttypeid=deletecourttypemodel.getCourttypeid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_COURTTYPEMSTR(?)}");	       
	       cstmt.setInt(1,courttypeid);        
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
	public CoreHash getAllCourtsTypeDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CourtTypeModel  courttypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM COURTTYPEMASTER");
           	 while(rs.next())
                {
           		courttypemodel=new CourtTypeModel();
             	  
           		courttypemodel.setCourttypeid(rs.getInt(1));
           		courttypemodel.setCourttypename(rs.getString(2));
           		courttypemodel.setCourttypeabbr(rs.getString(3));
           		courttypemodel.setCourttypedesc(rs.getString(4));
           		
           		
             	   
             	 aCoreHash.put(new Integer(sno),courttypemodel);
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
	
	
	
	public CourtTypeModel getCourtTypeDetails(int courttypeid)
	{
		
		
		
		Statement st=null;
		CourtTypeModel  courttypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM COURTTYPEMASTER WHERE COURTTYPEID="+courttypeid);
           	 while(rs.next())
                {
           		courttypemodel=new CourtTypeModel();
             	  
           		courttypemodel.setCourttypeid(rs.getInt(1));
           		courttypemodel.setCourttypename(rs.getString(2));
           		courttypemodel.setCourttypeabbr(rs.getString(3));
           		courttypemodel.setCourttypedesc(rs.getString(4));
           		       		  		        		     		
             	
		  
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
		return courttypemodel;
	}
	
	public CoreHash getCourtTypeNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CourtTypeModel  courtypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  COURTTYPEID,INITCAP(COURTTYPENAME) FROM COURTTYPEMASTER");
           	 while(rs.next())
                {
           		courtypemodel=new CourtTypeModel();
             	  
           		courtypemodel.setCourttypeid(rs.getInt(1));
           		courtypemodel.setCourttypename(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),courtypemodel);
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
