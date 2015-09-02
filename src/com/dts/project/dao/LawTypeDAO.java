package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.UserModel;

public class LawTypeDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public LawTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addlawtype(LawTypeModel addlawtypemodel)
	{
		
	    String lawtypename=addlawtypemodel.getLawtypename();	   
	    String lawtypeabbr=addlawtypemodel.getLawtypeabbr();	   
	    String lawtypedesc=addlawtypemodel.getDesc();
	    
	  
	    try 
	    {
	    	           
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_LAWTYPEMSTR(?,?,?)}");

	       cstmt.setString(1,lawtypename);
	       cstmt.setString(2,lawtypeabbr);
	       cstmt.setString(3,lawtypedesc);	       
	       
	       
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
	
	public boolean updatelawtypedetails(LawTypeModel updatelawtypemodel)
	{
		 int lawtypeid=updatelawtypemodel.getLawtypeid();
		String lawtypeabbr=updatelawtypemodel.getLawtypeabbr();    
	    String lawtypedesc=updatelawtypemodel.getDesc();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call UPDATE_LAWTYPEMSTR(?,?,?)}");
	       
	       cstmt.setInt(1,lawtypeid);	      
	       cstmt.setString(2,lawtypeabbr);       
	       cstmt.setString(3,lawtypedesc);
	       
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
	
	
	
	
	public boolean deletelawtypedetails(LawTypeModel deletelawtypemodel)
	{
		 int lawtypeid=deletelawtypemodel.getLawtypeid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_LAWTYPEMSTR(?)}");	       
	       cstmt.setInt(1,lawtypeid);        
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
	
	
	public LawTypeModel getLawTypeDetails(int lawtypeid)
	{
		
		
		
		Statement st=null;
		LawTypeModel  lawtypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM LAWTYPEMASTER WHERE LAWTYPEID="+lawtypeid);
           	 while(rs.next())
                {
           		lawtypemodel=new LawTypeModel();
             	  
           		lawtypemodel.setLawtypeid(rs.getInt(1));
           		lawtypemodel.setLawtypename(rs.getString(2));
           		lawtypemodel.setLawtypeabbr(rs.getString(3));
           		lawtypemodel.setDesc(rs.getString(4));
           		       		  		        		     		
             	
		  
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
		return lawtypemodel;
	}
	
	
	
	public LawTypeModel getPerticularLawType(String lawtypename)
	{
		
		
		
		Statement st=null;
		LawTypeModel  lawtypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM LAWTYPEMASTER WHERE LAWTYPENAME="+lawtypename);
           	 while(rs.next())
                {
           		lawtypemodel=new LawTypeModel();
             	  
           		lawtypemodel.setLawtypeid(rs.getInt(1));
           		lawtypemodel.setLawtypename(rs.getString(2));
           		lawtypemodel.setLawtypeabbr(rs.getString(3));
           		lawtypemodel.setDesc(rs.getString(4));
           		       		  		        		     		
             	
		  
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
		return lawtypemodel;
	}
	
	
	public CoreHash getAllLawTypeDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawTypeModel  lawtypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM LAWTYPEMASTER");
           	 while(rs.next())
                {
           		lawtypemodel=new LawTypeModel();
             	  
           		lawtypemodel.setLawtypeid(rs.getInt(1));
           		lawtypemodel.setLawtypename(rs.getString(2));
           		lawtypemodel.setLawtypeabbr(rs.getString(3));
           		lawtypemodel.setDesc(rs.getString(4));
           		
           		
             	   
             	 aCoreHash.put(new Integer(sno),lawtypemodel);
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
	
	
	
	public CoreHash getLawTypeNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawTypeModel  lawtypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  LAWTYPEID,INITCAP(LAWTYPENAME) FROM LAWTYPEMASTER");
           	 while(rs.next())
                {
           		lawtypemodel=new LawTypeModel();
             	  
           		lawtypemodel.setLawtypeid(rs.getInt(1));
           		lawtypemodel.setLawtypename(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),lawtypemodel);
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
