package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseRegistrationModel;
import com.dts.project.model.CourtModel;
import com.dts.project.model.CourtTypeModel;
import com.dts.project.model.EvidenceTypeModel;
import com.dts.project.model.LawyerTypeModel;

public class EvidenceTypeDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public EvidenceTypeDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addevidencetype(EvidenceTypeModel addevidencetypemodel)
	{
		
		String evidentypename=addevidencetypemodel.getEvidencetypename();	   
	    String evidentypeabbr=addevidencetypemodel.getEvidencetypeabbr();	   
	    String evidentypedesc=addevidencetypemodel.getEvidencetypedesc();
	    
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_EVIDENCETYPEMSTR(?,?,?)}");

	       cstmt.setString(1,evidentypename);
	       cstmt.setString(2,evidentypeabbr);
	       cstmt.setString(3,evidentypedesc);
	       
	       
	       
	       
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
	
	public boolean updateevidencetypedetails(EvidenceTypeModel updateevidencetypemodel)
	{
		 int evidencetypeid=updateevidencetypemodel.getEvidencetypeid();
		 	   
	    String evidencetypeabbr=updateevidencetypemodel.getEvidencetypeabbr();	   
	    String evidencetypedesc=updateevidencetypemodel.getEvidencetypedesc();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();	     
	       CallableStatement cstmt=con.prepareCall("{call (?,?,?)}");	       
	       cstmt.setInt(1,evidencetypeid);	          
	       
	       cstmt.setString(2,evidencetypeabbr);       
	       cstmt.setString(3,evidencetypedesc);
	       
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
	public boolean deleteevidencetypedetails(EvidenceTypeModel deleteevidencetypemodel)
	{
		 int evidencetypeid=deleteevidencetypemodel.getEvidencetypeid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  (?)}");	       
	       cstmt.setInt(1,evidencetypeid);        
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
	
	public EvidenceTypeModel getEvidenceTypeDetails(int evidencetypeid)
	{
		
		
		
		Statement st=null;
		EvidenceTypeModel  evidencetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM EVIDENCETYPEMASTER WHERE EVIDENCETYPEID="+evidencetypeid);
           	 while(rs.next())
                {
           		evidencetypemodel=new EvidenceTypeModel();
             	  
           		evidencetypemodel.setEvidencetypeid(rs.getInt(1));
           		evidencetypemodel.setEvidencetypename(rs.getString(2));
           		evidencetypemodel.setEvidencetypeabbr(rs.getString(3));
           		evidencetypemodel.setEvidencetypedesc(rs.getString(4));
           		
           		
           		       		  		        		     		
             	
		  
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
		return evidencetypemodel;
	}
	public CoreHash getAllEvidenceDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		EvidenceTypeModel  evidencetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT *FROM EVIDENCETYPEMASTER");
           	 while(rs.next())
                {
           		evidencetypemodel=new EvidenceTypeModel();
             	  
           		evidencetypemodel.setEvidencetypeid(rs.getInt(1));
           		evidencetypemodel.setEvidencetypename(rs.getString(2));
           		evidencetypemodel.setEvidencetypeabbr(rs.getString(3));
           		evidencetypemodel.setEvidencetypedesc(rs.getString(4));
           		
           		
             	   
             	 aCoreHash.put(new Integer(sno),evidencetypemodel);
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
	public CoreHash getEvidenceTypeNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		EvidenceTypeModel  evidencetypemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  EVIDENCETYPEID,INITCAP(EVIDENCETYPENAME) FROM EVIDENCETYPEMASTER");
           	 while(rs.next())
                {
           		evidencetypemodel=new EvidenceTypeModel();
             	  
           		evidencetypemodel.setEvidencetypeid(rs.getInt(1));
           		evidencetypemodel.setEvidencetypename(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),evidencetypemodel);
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
