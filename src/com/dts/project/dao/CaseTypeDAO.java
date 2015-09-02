package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseTypeModel;
import com.dts.project.model.CourtModel;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.LawTypeModel;

public class CaseTypeDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcasetype(CaseTypeModel addcasetypemodel)
	{
		
	    String casetypename=addcasetypemodel.getCasetypename();	   
	    String casetypeabbr=addcasetypemodel.getCasetypeabbr();	   
	    String casetypedesc=addcasetypemodel.getCasetypedesc();
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  INSRT_CASETYPEMSTR(?,?,?)}");

	       cstmt.setString(1,casetypename);
	       cstmt.setString(2,casetypeabbr);
	       cstmt.setString(3,casetypedesc);	       
	       
	       
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
	
	
	
	public boolean updatecasetypedetails(CaseTypeModel updatecasetypemodel)
	{
		 int casetypeid=updatecasetypemodel.getCasetypeid();
		String casetypeabbr=updatecasetypemodel.getCasetypeabbr();	    	   
	    String casetypedesc=updatecasetypemodel.getCasetypedesc();	   
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call UPDATE_CASETYPEMSTR(?,?,?)}");
	       
	       cstmt.setInt(1,casetypeid);	      
	       
	       cstmt.setString(2,casetypeabbr);       
	       cstmt.setString(3,casetypedesc);
	       
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
	public boolean deletecasetypedetails(CaseTypeModel deletecasetypemodel)
	{
		 int casetypeid=deletecasetypemodel.getCasetypeid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_CASETYPEMSTR(?)}");	       
	       cstmt.setInt(1,casetypeid);        
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
	
	public CoreHash getAllCaseTypeDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseTypeModel  casetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM CASETYPEMASTER");
           	 while(rs.next())
                {
           		casetypemodel=new CaseTypeModel();
             	  
           		casetypemodel.setCasetypeid(rs.getInt(1));
           		casetypemodel.setCasetypename(rs.getString(2));
           		casetypemodel.setCasetypeabbr(rs.getString(3));
           		casetypemodel.setCasetypedesc(rs.getString(4));
           		
           		
             	   
             	 aCoreHash.put(new Integer(sno),casetypemodel);
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
	public CoreHash getCaseTypeNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseTypeModel  casetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASETYPEID,INITCAP(CASETYPENAME) FROM CASETYPEMASTER");
           	 while(rs.next())
                {
           		casetypemodel=new CaseTypeModel();
             	  
           		casetypemodel.setCasetypeid(rs.getInt(1));
           		casetypemodel.setCasetypename(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),casetypemodel);
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
	public CaseTypeModel getCaseTypeDetails(int casetypeid)
	{
		
		
		
		Statement st=null;
		CaseTypeModel  casetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM CASETYPEMASTER WHERE CASETYPEID="+casetypeid);
           	 while(rs.next())
                {
           		casetypemodel=new CaseTypeModel();
             	  
           		casetypemodel.setCasetypeid(rs.getInt(1));
           		casetypemodel.setCasetypename(rs.getString(2));
           		casetypemodel.setCasetypeabbr(rs.getString(3));
           		casetypemodel.setCasetypedesc(rs.getString(4));
           		        		  		        		     		
             	
		  
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
		return casetypemodel;
	}
	
	
}
