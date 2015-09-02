package com.dts.project.dao;

import java.sql.CallableStatement;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseTypeModel;
import com.dts.project.model.LawyerModel;
import com.dts.project.model.LawyerTypeModel;
import java.io.File;
public class LawyerDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public LawyerDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addlawyer(LawyerModel addlawyermodel)
	{
		
		String lawyerfstname=addlawyermodel.getLawyerfstname();	   
	    String lawyermidname=addlawyermodel.getLawyermidname();	   
	    String lawyerlastname=addlawyermodel.getLawyerlstname();
	    String lawyerbarregdate=DateWrapper.parseDate(addlawyermodel.getLawyerbarregdate());	   
	    String lawyerqualification=addlawyermodel.getLawyerqualification();	   
	    String lawyerphoto=addlawyermodel.getLawyerphoto();
	    String lawyeraddr=addlawyermodel.getLawyeraddress();	   
	    String lawyerphno=addlawyermodel.getLawyerphno();	   
	    String lawyermail=addlawyermodel.getLawyeremail();
	    int lawertypeid=addlawyermodel.getLawyertypeid();
	    
	  
	    try 
	    {
	    	File f=new File(lawyerphoto);
	    	FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  INSRT_LAWYERMSTR(?,?,?,?,?,?,?,?,?,?)}");
       
	       cstmt.setString(1,lawyerfstname);
	       cstmt.setString(2,lawyermidname);
	       cstmt.setString(3,lawyerlastname);
	       cstmt.setString(4,lawyerbarregdate);
	       cstmt.setString(5,lawyerqualification);
	       cstmt.setBinaryStream(6,fis,(int)f.length());
	       cstmt.setString(7,lawyeraddr);
	       cstmt.setString(8,lawyerphno);
	       cstmt.setString(9,lawyermail);
	       cstmt.setInt(10,lawertypeid);
	       
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

	public boolean updatelawyerdetails(LawyerModel updatelawyermodel)
	{
		 int lawyerid=updatelawyermodel.getLawyerid();
		//String lawyerfstname=updatelawyermodel.getLawyerfstname();	    
	    String lawyerbarregdate=DateWrapper.parseDate(updatelawyermodel.getLawyerbarregdate());	   
	    String lawyerqualification=updatelawyermodel.getLawyerqualification();	   
	    String lawyeraddr=updatelawyermodel.getLawyeraddress();	   
	    String lawyerphno=updatelawyermodel.getLawyerphno();	   
	    String lawyermail=updatelawyermodel.getLawyeremail();
	    int lawertypeid=updatelawyermodel.getLawyertypeid();
	    System.out.println("lawyerid--->"+lawyerid+"lawyerbarregdate--->"+lawyerbarregdate+" lawyerqualification------>"+lawyerqualification+"lawyeraddr---->"+lawyeraddr+"phoneno--->"+lawyerphno+"lawyermail-->"+lawyermail+"lawertypeid---->"+lawertypeid);
	  
	    try 
	    {
	    	//File f=new File(lawyerphoto);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  UPDATE_LAWYERMSTR(?,?,?,?,?,?)}");
	       
	       cstmt.setInt(1,lawyerid);	          
	       
	       cstmt.setString(2,lawyerqualification);	       
	       cstmt.setString(3,lawyeraddr);
	       cstmt.setString(4,lawyerphno);
	       cstmt.setString(5,lawyermail);
	       cstmt.setInt(6,lawertypeid);
	       
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
	
	public boolean deletelawyerdetails(LawyerModel deletelawyermodel)
	{
		 int lawyerid=deletelawyermodel.getLawyerid();
			    	  
	    try 
	    {
	    	         
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  DELETE_LAWYERMSTR(?)}");	       
	       cstmt.setInt(1,lawyerid);        
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
	
	
	public CoreHash getLawyerNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawyerModel  lawyermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  LAWYERID,INITCAP(LAWYERFSTNAME) FROM LAWYERMASTER");
           	 while(rs.next())
                {
           		lawyermodel=new LawyerModel();
             	  
           		lawyermodel.setLawyerid(rs.getInt(1));
           		lawyermodel.setLawyerfstname(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),lawyermodel);
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

	public CoreHash getAllLawyersDetails(String imagepath)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawyerModel  lawyermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  L.LAWYERID,L.LAWYERFSTNAME, TO_CHAR(L.LAWYERBARREGDATE,'DD-MM-YY'), L.LAWYERQUAL, L.LAWYERADDRESS, L.LAWYERPHONENO,L.LAWYEREMAILID,L.LAWYERTYPEID, LT.LAWTYPENAME,L.LAWYERMIDNAME,L.LAWYERLSTNAME,L.LAWYERPHOTO FROM  LAWYERMASTER L  ,LAWTYPEMASTER  LT WHERE  L.LAWYERTYPEID IN(SELECT LAWTYPEID  FROM  LAWTYPEMASTER)AND(L.LAWYERTYPEID =LT.LAWTYPEID)");
           	 while(rs.next())
                {
           		lawyermodel=new LawyerModel();
             	  
           		int lawyerid=rs.getInt(1);
           		lawyermodel.setLawyerid(lawyerid);
           		lawyermodel.setLawyerfstname(rs.getString(2));
           		lawyermodel.setLawyerbarregdate(rs.getString(3));
           		lawyermodel.setLawyerqualification(rs.getString(4));
           		lawyermodel.setLawyeraddress(rs.getString(5));
           		lawyermodel.setLawyerphno(rs.getString(6));
           		lawyermodel.setLawyeremail(rs.getString(7));
           		lawyermodel.setLawyertypeid(rs.getInt(8));
           		lawyermodel.setLawtypename(rs.getString(9));
           		lawyermodel.setLawyermidname(rs.getString(10));
           		lawyermodel.setLawyerlstname(rs.getString(11));
           		Blob bb =rs.getBlob(12);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+lawyerid+".gif");
				fout1.write(bb1);
				lawyermodel.setLawyerphoto(lawyerid+".gif");
           		
             	   
             	 aCoreHash.put(new Integer(sno),lawyermodel);
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
	
	
	
	public CoreHash getAllSameLawyersTypeDetails(String imagepath,String lawtype,String loginname)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		LawyerModel  lawyermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  L.LAWYERID,L.LAWYERFSTNAME, TO_CHAR(L.LAWYERBARREGDATE,'DD-MM-YY'), L.LAWYERQUAL, L.LAWYERADDRESS, L.LAWYERPHONENO,L.LAWYEREMAILID,L.LAWYERTYPEID, LT.LAWTYPENAME,L.LAWYERMIDNAME,L.LAWYERLSTNAME,L.LAWYERPHOTO FROM  LAWYERMASTER L  ,LAWTYPEMASTER  LT WHERE  L.LAWYERTYPEID IN(SELECT LAWTYPEID  FROM  LAWTYPEMASTER)AND(L.LAWYERTYPEID =LT.LAWTYPEID) AND UPPER(LT.LAWTYPENAME)=UPPER('"+lawtype+"') AND UPPER(L.LAWYERFSTNAME) NOT IN(UPPER('"+loginname+"'))");
           	 while(rs.next())
                {
           		lawyermodel=new LawyerModel();
             	  
           		int lawyerid=rs.getInt(1);
           		lawyermodel.setLawyerid(lawyerid);
           		lawyermodel.setLawyerfstname(rs.getString(2));
           		lawyermodel.setLawyerbarregdate(rs.getString(3));
           		lawyermodel.setLawyerqualification(rs.getString(4));
           		lawyermodel.setLawyeraddress(rs.getString(5));
           		lawyermodel.setLawyerphno(rs.getString(6));
           		lawyermodel.setLawyeremail(rs.getString(7));
           		lawyermodel.setLawyertypeid(rs.getInt(8));
           		lawyermodel.setLawtypename(rs.getString(9));
           		lawyermodel.setLawyermidname(rs.getString(10));
           		lawyermodel.setLawyerlstname(rs.getString(11));
           		Blob bb =rs.getBlob(12);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+lawyerid+".gif");
				fout1.write(bb1);
				lawyermodel.setLawyerphoto(lawyerid+".gif");
           		
             	   
             	 aCoreHash.put(new Integer(sno),lawyermodel);
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
	
	public LawyerModel getLawyersDetails(String imagepath,int lawyerid)
	{
		
		
		
		Statement st=null;
		LawyerModel  lawyermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  L.LAWYERID,L.LAWYERFSTNAME, TO_CHAR(L.LAWYERBARREGDATE,'DD-MM-YY'), L.LAWYERQUAL, L.LAWYERADDRESS, L.LAWYERPHONENO,L.LAWYEREMAILID,L.LAWYERTYPEID, LT.LAWTYPENAME,L.LAWYERMIDNAME,L.LAWYERLSTNAME,L.LAWYERPHOTO FROM  LAWYERMASTER L  ,LAWTYPEMASTER  LT WHERE  L.LAWYERTYPEID IN(SELECT LAWTYPEID  FROM  LAWTYPEMASTER)AND(L.LAWYERTYPEID =LT.LAWTYPEID) AND L.LAWYERID="+lawyerid);
           	 while(rs.next())
                {
           		lawyermodel=new LawyerModel();
             	  
           		int lawyeriid=rs.getInt(1);
           		lawyermodel.setLawyerid(lawyeriid);
           		lawyermodel.setLawyerfstname(rs.getString(2));
           		lawyermodel.setLawyerbarregdate(rs.getString(3));
           		lawyermodel.setLawyerqualification(rs.getString(4));
           		lawyermodel.setLawyeraddress(rs.getString(5));
           		lawyermodel.setLawyerphno(rs.getString(6));
           		lawyermodel.setLawyeremail(rs.getString(7));
           		lawyermodel.setLawyertypeid(rs.getInt(8));
           		lawyermodel.setLawtypename(rs.getString(9));
           		lawyermodel.setLawyermidname(rs.getString(10));
           		lawyermodel.setLawyerlstname(rs.getString(11));
           		
           		Blob bb =rs.getBlob(12);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+lawyeriid+".gif");
				fout1.write(bb1);
				lawyermodel.setLawyerphoto(lawyeriid+".gif");
             	
		  
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
		return lawyermodel;
	}
	
	
	
	
	public LawyerModel getLawyersProfile(String imagepath,String lawyername)
	{
		
		
		
		Statement st=null;
		LawyerModel  lawyermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  L.LAWYERID,L.LAWYERFSTNAME, TO_CHAR(L.LAWYERBARREGDATE,'DD-MM-YY'), L.LAWYERQUAL, L.LAWYERADDRESS, L.LAWYERPHONENO,L.LAWYEREMAILID,L.LAWYERTYPEID, LT.LAWTYPENAME,L.LAWYERMIDNAME,L.LAWYERLSTNAME,L.LAWYERPHOTO FROM  LAWYERMASTER L  ,LAWTYPEMASTER  LT WHERE  L.LAWYERTYPEID IN(SELECT LAWTYPEID  FROM  LAWTYPEMASTER)AND(L.LAWYERTYPEID =LT.LAWTYPEID) AND L.LAWYERFSTNAME='"+lawyername+"'");
           	 while(rs.next())
                {
           		lawyermodel=new LawyerModel();
             	  
           		int lawyeriid=rs.getInt(1);
           		lawyermodel.setLawyerid(lawyeriid);
           		lawyermodel.setLawyerfstname(rs.getString(2));
           		lawyermodel.setLawyerbarregdate(rs.getString(3));
           		lawyermodel.setLawyerqualification(rs.getString(4));
           		lawyermodel.setLawyeraddress(rs.getString(5));
           		lawyermodel.setLawyerphno(rs.getString(6));
           		lawyermodel.setLawyeremail(rs.getString(7));
           		lawyermodel.setLawyertypeid(rs.getInt(8));
           		lawyermodel.setLawtypename(rs.getString(9));
           		lawyermodel.setLawyermidname(rs.getString(10));
           		lawyermodel.setLawyerlstname(rs.getString(11));
           		
           		Blob bb =rs.getBlob(12);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+lawyeriid+".gif");
				fout1.write(bb1);
				lawyermodel.setLawyerphoto(lawyeriid+".gif");
             	
		  
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
		return lawyermodel;
	}
	
}
