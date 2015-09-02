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
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.LawyerModel;
import com.dts.project.model.SectionModel;

public class SectionDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public SectionDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addsection(SectionModel addsectionmodel)
	{
		
	    String sectionno=addsectionmodel.getActualsectionno();	   
	    String sectiondesc=addsectionmodel.getSectiondesc();	   
	    int lawtypeid=addsectionmodel.getTypeoflawid();
	    String sectioncommdate=DateWrapper.parseDate(addsectionmodel.getSectioncommendate());	   
	    String secactivstate=addsectionmodel.getSectionactivestate();	   
	    String secandsubsecbit=addsectionmodel.getSectionandsubsecbit();
	    
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_SECTIONMSTR(?,?,?,?,?,?)}");

	       cstmt.setString(1,sectionno);
	       cstmt.setString(2,sectiondesc);
	       cstmt.setInt(3,lawtypeid);
	       cstmt.setString(4,sectioncommdate);
	       cstmt.setString(5,secactivstate);
	       cstmt.setString(6,secandsubsecbit);
	       
	       
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

	
	public boolean updatesectiondetails(SectionModel updatesectionmodel)
	{
		 int sectionid=updatesectionmodel.getSectionid();
		String actualsecno=updatesectionmodel.getActualsectionno();	    
	    String seccommdate=DateWrapper.parseDate(updatesectionmodel.getSectioncommendate());	   
	    String secdesc=updatesectionmodel.getSectiondesc();	   
	    int lawtypeid=updatesectionmodel.getTypeoflawid();	   
	    String secactivestate=updatesectionmodel.getSectionactivestate();	   
	    String subsecbit=updatesectionmodel.getSectionandsubsecbit();
	    
	    
	  
	    try 
	    {
	    	         
	    	con=getConnection();
	      // con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  UPDATE_SECTIONMSTR(?,?,?,?,?,?,?)}");
	       
	       cstmt.setInt(1,sectionid);	          
	       cstmt.setString(2,actualsecno);
	       cstmt.setString(3,secdesc);	       
	       cstmt.setInt(4,lawtypeid);
	       cstmt.setString(5,seccommdate);
	       cstmt.setString(6,secactivestate);
	       cstmt.setString(7,subsecbit);
	       
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
	
	public boolean deletesectiondetails(SectionModel deletesectionmodel)
	{
		 int sectionid=deletesectionmodel.getSectionid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       //con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_SECTIONMSTR(?)}");	       
	       cstmt.setInt(1,sectionid);        
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
	public SectionModel getSectionDetails(int sectionid)
	{
		
		
		
		Statement st=null;
		SectionModel  sectionmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  S.SECTIONID, S.ACTUALSECTIONNO, S.SECTIONDESC, S.TYPEOFLAWID,L. LAWTYPENAME, TO_CHAR(S.SECTIONCOMMENCEDATE,'DD-MM-YY'),S.SECTIONACTIVESTATE, S.SECTIONORSUBSECBIT FROM SECTIONMASTER S,LAWTYPEMASTER  L WHERE S.TYPEOFLAWID IN(SELECT  LAWTYPEID  FROM  LAWTYPEMASTER) AND (S.TYPEOFLAWID=L.LAWTYPEID) AND S.SECTIONID="+sectionid);
           	 while(rs.next())
                {
           		sectionmodel=new SectionModel();
             	  
           		sectionmodel.setSectionid(rs.getInt(1));
           		sectionmodel.setActualsectionno(rs.getString(2));
           		sectionmodel.setSectiondesc(rs.getString(3));
           		sectionmodel.setTypeoflawid(rs.getInt(4));
           		sectionmodel.setLawtypename(rs.getString(5));
           		sectionmodel.setSectioncommendate(rs.getString(6));
           		sectionmodel.setSectionactivestate(rs.getString(7));
           		sectionmodel.setSectionandsubsecbit(rs.getString(8));
           		     		
             	
		  
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
		return sectionmodel;
	}
	
	public CoreHash getAllSectionDetails()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		SectionModel  sectionmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  S.SECTIONID, S.ACTUALSECTIONNO, S.SECTIONDESC, S.TYPEOFLAWID,L. LAWTYPENAME,TO_CHAR(S.SECTIONCOMMENCEDATE,'DD-MM-YY'),S.SECTIONACTIVESTATE, S.SECTIONORSUBSECBIT FROM SECTIONMASTER S,LAWTYPEMASTER  L WHERE S.TYPEOFLAWID IN(SELECT  LAWTYPEID  FROM  LAWTYPEMASTER) AND (S.TYPEOFLAWID=L.LAWTYPEID)");
           	 while(rs.next())
                {
           		sectionmodel=new SectionModel();
             	  
           		sectionmodel.setSectionid(rs.getInt(1));
           		sectionmodel.setActualsectionno(rs.getString(2));
           		sectionmodel.setSectiondesc(rs.getString(3));
           		sectionmodel.setTypeoflawid(rs.getInt(4));
           		sectionmodel.setLawtypename(rs.getString(5));
           		sectionmodel.setSectioncommendate(rs.getString(6));
           		sectionmodel.setSectionactivestate(rs.getString(7));
           		sectionmodel.setSectionandsubsecbit(rs.getString(8));  		
           		
             	   
             	 aCoreHash.put(new Integer(sno),sectionmodel);
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
	
	
	public CoreHash getAllSections()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		SectionModel  sectionmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  SECTIONID  FROM SECTIONMASTER");
           	 while(rs.next())
                {
           		sectionmodel=new SectionModel();             	  
           		sectionmodel.setSectionid(rs.getInt(1));	
           		System.out.println("section id"+rs.getInt(1));
             	   
             	 aCoreHash.put(new Integer(sno),sectionmodel);
             	 
			    sno++;
			    System.out.println("sno "+sno);
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
	
	
	public CoreHash getSectionsOfPerticularLawTypes(String lawtype)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		SectionModel  sectionmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 
           	 //String sql="SELECT  * FROM SECTIONMASTER WHERE  SECTIONID  IN (SELECT  SECTIONID  FROM CASESECTIONMASTER  WHERE CASEID IN(SELECT CASEID FROM  CASEREGISTRATIONMASTER   WHERE  CASETYPEID IN(SELECT CASETYPEID FROM CASETYPEMASTER  WHERE  UPPER(CASETYPENAME)=UPPER('"+lawtype+"'))))";
           	 //String sql="SELECT  S.SECTIONID, S.ACTUALSECTIONNO, S.SECTIONDESC, S.TYPEOFLAWID,L. LAWTYPENAME,TO_CHAR(S.SECTIONCOMMENCEDATE,'DD-MM-YY'),S.SECTIONACTIVESTATE, S.SECTIONORSUBSECBIT FROM SECTIONMASTER S,LAWTYPEMASTER  L WHERE S.TYPEOFLAWID IN(SELECT  LAWTYPEID  FROM  LAWTYPEMASTER) AND (S.TYPEOFLAWID=L.LAWTYPEID)AND UPPER(L.LAWTYPENAME)=UPPER('"+lawtype+"')";
           	String sql="SELECT  S.SECTIONID, S.ACTUALSECTIONNO, S.SECTIONDESC, S.TYPEOFLAWID,L. LAWTYPENAME,TO_CHAR(S.SECTIONCOMMENCEDATE,'DD-MM-YY'),S.SECTIONACTIVESTATE, S.SECTIONORSUBSECBIT FROM SECTIONMASTER S,LAWTYPEMASTER  L WHERE S.TYPEOFLAWID IN(SELECT  LAWTYPEID  FROM  LAWTYPEMASTER) AND (S.TYPEOFLAWID=L.LAWTYPEID)";
           	 ResultSet rs=st.executeQuery(sql);
           	 while(rs.next())
                {
           		sectionmodel=new SectionModel();             	  
           		sectionmodel.setSectionid(rs.getInt(1));
           		sectionmodel.setActualsectionno(rs.getString(2));
           		sectionmodel.setSectiondesc(rs.getString(3));
           		sectionmodel.setTypeoflawid(rs.getInt(4));
           		sectionmodel.setLawtypename(rs.getString(5));
           		sectionmodel.setSectioncommendate(rs.getString(6));
           		sectionmodel.setSectionactivestate(rs.getString(7));
           		sectionmodel.setSectionandsubsecbit(rs.getString(8));  		
             	   
             	 aCoreHash.put(new Integer(sno),sectionmodel);
             	 
			    sno++;
			    System.out.println("sno "+sno);
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
