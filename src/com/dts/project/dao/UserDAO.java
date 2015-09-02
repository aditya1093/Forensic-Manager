package com.dts.project.dao;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import com.dts.project.model.UserModel;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserDAO extends AbstractDataAccessObject {
public Connection con;
public boolean flag=false;
UserModel usermodel=null;
	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean adduser(UserModel addusermodel)
	{
		
	    String username=addusermodel.getUsername();
	    System.out.println("-----------username"+username);
	    String firstname=addusermodel.getFirstname();
	    System.out.println("-----------firstname"+firstname);
	    String middlename=addusermodel.getMiddlename();
	    String dob=DateWrapper.parseDate(addusermodel.getDateofbirth());
	    String dor=DateWrapper.parseDate(addusermodel.getDateofreg());
	    String lastname=addusermodel.getLastname();
	    String address=addusermodel.getAddress();
	    System.out.println("--------------address"+address);
	    String phno=addusermodel.getPhno();
	    System.out.println("-----------------phno"+phno);
	    String emailid=addusermodel.getMailid();
	    System.out.println("------------------emailid"+emailid);
	    String photo=addusermodel.getPhoto();
	    System.out.println("--------------------photo"+photo);
	    String password=addusermodel.getPassword();
	    System.out.println("-------------------password"+password);
	    //String logintype=addusermodel.getLogintype();
	    //System.out.println("logintype"+logintype);
	  
	    try 
	    {
	    	File f=new File(photo);
	    	FileInputStream fis=new FileInputStream(f); 
	    	System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_USERMSTR(?,?,?,?,?,?,?,?,?,?,?)}");

	       cstmt.setString(1,username);
	       cstmt.setString(2,password);
	       cstmt.setString(3,dob);	       
	       cstmt.setString(4,firstname);
	       cstmt.setString(5,middlename);
	       cstmt.setString(6,lastname);
	       cstmt.setString(7,dor);
	       cstmt.setString(8,address);
	       cstmt.setString(9,phno);
	       cstmt.setString(10,emailid);
	       cstmt.setBinaryStream(11,fis,(int)f.length());	       
	       //cstmt.setString(12,logintype);
	       
	       
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
	
	
	public boolean updateuser(UserModel updateusermodel)
	{
		int userid=updateusermodel.getUserid();
	    String username=updateusermodel.getUsername();	    
	    String firstname=updateusermodel.getFirstname();	    
	    String middlename=updateusermodel.getMiddlename();
	    String dob=updateusermodel.getDateofbirth();
	    String doj=updateusermodel.getDateofreg();
	    String lastname=updateusermodel.getLastname();
	    String address=updateusermodel.getAddress();	   
	    String phno=updateusermodel.getPhno();	   
	    String emailid=updateusermodel.getMailid();	   
	    String photo=updateusermodel.getPhoto();	    
	    String password=updateusermodel.getPassword();
	    
	    
	    try 
	    {
	    	File f=new File(photo);
	    	FileInputStream fis=new FileInputStream(f); 
	    	System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call  UPDATE_USERMSTR(?,?,?,?,?,?,?,?,?,?,?,?)}");
	       cstmt.setInt(1,userid);
	       cstmt.setString(2,username);
	       cstmt.setString(3,password);
	       cstmt.setString(4,dob);
	       cstmt.setString(5,firstname);
	       cstmt.setString(6,middlename);
	       cstmt.setString(7,lastname);
	       cstmt.setString(8,doj);
	       cstmt.setString(9,address);
	       cstmt.setString(10,phno);
	       cstmt.setString(11,emailid);
	       cstmt.setBinaryStream(12,fis,(int)f.length());
	      
	       
	       
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
	
	
	public CoreHash getUserNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		UserModel  usermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  USERID,INITCAP(USERNAME) FROM USERMASTER");
           	 while(rs.next())
                {
           		usermodel=new UserModel();
             	  
           		usermodel.setUserid(rs.getInt(1));
           		usermodel.setUsername(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),usermodel);
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
	
	
	public UserModel getUserID(String user){
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		int sno=1;
		
		Statement st;
		UserModel  usermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 usermodel=new UserModel();
           	 ResultSet rs=st.executeQuery("SELECT USERID,USERNAME,PASSWORD,TO_CHAR(DOB,'DD-MON-YY'),FIRSTNAME,MIDDLENAME,LASTNAME,TO_CHAR(DOR,'DD-MON-YY'),ADDRESS,PHONENO,EMAILID,PHOTOGRAPH FROM USERMASTER  WHERE USERNAME='"+user+"'");
           	
           	 while(rs.next())
            {
           		
       		usermodel=new UserModel();
         	  
       		usermodel.setUserid(rs.getInt(1));
       		usermodel.setUsername(rs.getString(2));  
       		usermodel.setPassword(rs.getString(3));
       		usermodel.setDateofbirth(rs.getString(4));  
       		usermodel.setFirstname(rs.getString(5)); 
       		usermodel.setMiddlename(rs.getString(6));  
       		usermodel.setLastname(rs.getString(7)); 
       		usermodel.setDateofreg(rs.getString(8));  
       		usermodel.setAddress(rs.getString(9)); 
       		usermodel.setPhno(rs.getString(10));  
       		usermodel.setMailid(rs.getString(11)); 
       		
       		usermodel.setPhoto(rs.getString(12));  
       		
         	 aCoreHash.put(new Integer(sno),usermodel);
		    sno++;
	  
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return usermodel;
	}
	
	
	
public UserModel getUserID(int user){
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		int sno=1;
		
		Statement st;
		UserModel  usermodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 usermodel=new UserModel();
           	 ResultSet rs=st.executeQuery("SELECT USERID,USERNAME,PASSWORD,TO_CHAR(DOB,'DD-MON-YY'),FIRSTNAME,MIDDLENAME,LASTNAME,TO_CHAR(DOR,'DD-MON-YY'),ADDRESS,PHONENO,EMAILID,PHOTOGRAPH FROM USERMASTER  WHERE USERID='"+user+"'");
           	
           	 while(rs.next())
            {
           		
       		usermodel=new UserModel();
         	  
       		usermodel.setUserid(rs.getInt(1));
       		usermodel.setUsername(rs.getString(2));  
       		usermodel.setPassword(rs.getString(3));
       		usermodel.setDateofbirth(rs.getString(4));  
       		usermodel.setFirstname(rs.getString(5)); 
       		usermodel.setMiddlename(rs.getString(6));  
       		usermodel.setLastname(rs.getString(7)); 
       		usermodel.setDateofreg(rs.getString(8));  
       		usermodel.setAddress(rs.getString(9)); 
       		usermodel.setPhno(rs.getString(10));  
       		usermodel.setMailid(rs.getString(11)); 
       		
       		usermodel.setPhoto(rs.getString(12));  
       		
         	 aCoreHash.put(new Integer(sno),usermodel);
		    sno++;
	  
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
		return usermodel;
	}
}
