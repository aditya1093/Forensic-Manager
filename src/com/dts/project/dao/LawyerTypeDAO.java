package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseEvidenceModel;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.LawyerTypeModel;

public class LawyerTypeDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public LawyerTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addlayertype(LawyerTypeModel addlawyertypemodel)
	{
		
		String lawyertypename=addlawyertypemodel.getLawyertypename();	   
	    String lawyertypeabbr=addlawyertypemodel.getLawyertypeabbr();	   
	    String lawyertypedesc=addlawyertypemodel.getLawyertypedesc();
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_LAWYERTYPEMSTR(?,?,?)}");
       
	       cstmt.setString(1,lawyertypename);
	       cstmt.setString(2,lawyertypeabbr);
	       cstmt.setString(3,lawyertypedesc);
	       
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
	
	public boolean updatelawyertypedetails(LawyerTypeModel updatelawyertypemodel)
	{
		 int lawyertypeid=updatelawyertypemodel.getLawyertypeid();
		String lawyertypeabbr=updatelawyertypemodel.getLawyertypeabbr();    
	    String lawyertypedesc=updatelawyertypemodel.getLawyertypedesc();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call UPDATE_LAWYERTYPEMSTR(?,?,?)}");
	       
	       cstmt.setInt(1,lawyertypeid);	      
	       cstmt.setString(2,lawyertypeabbr);       
	       cstmt.setString(3,lawyertypedesc);
	       
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
	
	
	public boolean deletelawyertypedetails(LawyerTypeModel deletelawyertypemodel)
	{
		 int lawyertypeid=deletelawyertypemodel.getLawyertypeid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_LAWYERTYPEMSTR(?)}");	       
	       cstmt.setInt(1,lawyertypeid);        
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
	
	
	public LawyerTypeModel getLawyerTypeDetails(int lawyertypeid)
	{
		
		
		
		Statement st=null;
		LawyerTypeModel  lawyertypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM LAWYERTYPEMASTER WHERE LAWERTYPEID="+lawyertypeid);
           	 while(rs.next())
                {
           		lawyertypemodel=new LawyerTypeModel();
             	  
           		lawyertypemodel.setLawyertypeid(rs.getInt(1));
           		lawyertypemodel.setLawyertypename(rs.getString(2));
           		lawyertypemodel.setLawyertypeabbr(rs.getString(3));
           		lawyertypemodel.setLawyertypedesc(rs.getString(4));
           		
           		       		  		        		     		
             	
		  
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
		return lawyertypemodel;
	}
	
	
	public CoreHash getAllLawyerTypeDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawyerTypeModel  lawyertypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM LAWYERTYPEMASTER");
           	 while(rs.next())
                {
           		lawyertypemodel=new LawyerTypeModel();
             	  
           		lawyertypemodel.setLawyertypeid(rs.getInt(1));
           		lawyertypemodel.setLawyertypename(rs.getString(2));
           		lawyertypemodel.setLawyertypeabbr(rs.getString(3));
           		lawyertypemodel.setLawyertypedesc(rs.getString(4));
           		
           		
             	   
             	 aCoreHash.put(new Integer(sno),lawyertypemodel);
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
