/*
 * SecurityDAO.java
 *
 * 
 */

package com.dts.dae.dao;


import com.dts.dae.model.Profile;

import com.dts.project.model.EmployeesModel;
import com.dts.project.model.UserModel;
import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
/**
 *
 * @author 
 */
public class SecurityDAO extends AbstractDataAccessObject
{
     Connection con;
     private String desc;
     private boolean flag;
     UserModel  usermodel;
    /** Creates a new instance of SecurityDAO */
    public SecurityDAO() 
    {
       
               //getting Database Connection
    	
      }
    
   
   
    //Login Check
    public String loginCheck(EmployeesModel regbean)
    {
        String loginid=regbean.getUsername();
        String password=regbean.getPassword();
        String role=null;        
        try
        {   con=getConnection();
        System.out.println("con"+con);
          //  con.setAutoCommit(true);
            CallableStatement cstmt=con.prepareCall("{call CHECK_USER_TYPE(?,?,?)}");
            cstmt.setString(1,loginid);
            cstmt.setString(2,password);
            cstmt.registerOutParameter(3,Types.VARCHAR);
             boolean flag= cstmt.execute();
           System.out.println("flag->"+flag);
            role=cstmt.getString(3);
               System.out.println("logintype="+role);
            
            
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            desc="Database Connection problem";
            flag=false;
        }
        //loginaudit(loginid,desc);
        return role;
    }
    
    
    //Method for login audit
    public void loginaudit(String loginid)
    {
        try 
        { con=getConnection();
        	
            CallableStatement cstmt=con.prepareCall("{call signoutprocedure(?)}");
            cstmt.setString(1,loginid);
            
            System.out.println("in loginaudit");
           cstmt.execute();
           
            con.close();
        }
        catch(Exception e)
        {
             
            e.printStackTrace();
            }
    }
    //Change Password
    public boolean changePassword(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String oldpassword=regbean.getPassword();
        String newpassword=regbean.getNewPassword();
        try 
        {con=getConnection();
        	con.setAutoCommit(false);
           
            CallableStatement cstmt=con.prepareCall("{call changePassword(?,?,?,?)}");
            
            
            cstmt.setString(1,loginid);
            cstmt.setString(2,oldpassword);
            cstmt.setString(3,newpassword);
            cstmt.registerOutParameter(4,Types.INTEGER);
            cstmt.execute();
            int i=cstmt.getInt(4);
            System.out.println("i="+i);
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
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {sex.printStackTrace();
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
    
     //Change Secret Question
    public boolean changeQuestion(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String secretquestid=regbean.getSecretQuestionID();
        
        String secretans=regbean.getSecretAnswer();
        
        CallableStatement cstmt;
        int i=0;
        try 
        {   
           
            	con=getConnection();
            	//con.setAutoCommit(false);
                
               
                cstmt=con.prepareCall("{call ChangeQuetion(?,?,?,?,?)}");
            
                cstmt.setString(1,loginid);
                cstmt.setString(2,password);
                cstmt.setString(3,secretquestid);
                cstmt.setString(4,secretans);
                cstmt.registerOutParameter(5,Types.INTEGER); 
                cstmt.execute();
                i=cstmt.getInt(5);
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
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        catch (Exception e) 
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
     //Recover Password using Existed Question
    public String recoverPasswordByQuestion(Profile regbean)
    {
        String password;
        String loginid=regbean.getLoginID();
        String secretquestid=regbean.getSecretQuestionID();
        String secretans=regbean.getSecretAnswer();
        try 
        {con=getConnection();
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall("{call RecoverPassword(?,?,?,?)}");
            cstmt.setString(1,loginid);
            cstmt.setString(2,secretquestid);
            cstmt.setString(3,secretans);
            cstmt.registerOutParameter(4,Types.VARCHAR);           
            cstmt.execute();
            password=cstmt.getString(4);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            password="";
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
            password="";
        }
        return password;        
    }
    public String  checkUser(String userName)
    {
 	   String user=null;
 	   System.out.println("username"+userName);
 	   try 
 	   
        {
 		    con=getConnection();
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall("{?=call LOGIN_CHECK_USER(?) }");
            cstmt.setString(2,userName);            
            cstmt.registerOutParameter(1,Types.VARCHAR);           
            cstmt.execute();
            user=cstmt.getString(1);
            System.out.println("------------user---->"+user);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            user=null;
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
        	user=null;
        }
        System.out.println("------------user---->"+user);
        return user;        
    }
    
    public UserModel getUserDetails(int  username)
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
           	 ResultSet rs=st.executeQuery("SELECT  USERNAME,FIRSTNAME,MIDDLENAME,LASTNAME,ADDRESS,PHONENO,EMAILID,PASSWORD,LOGINTYPE FROM USERMASTER  WHERE USERID="+username);
           	 while(rs.next())
                {
           		usermodel=new UserModel();
             	  
           		usermodel.setUsername(rs.getString(1));
           		System.out.println("rs.getString(1)--------"+rs.getString(1));
           		usermodel.setFirstname(rs.getString(2)); 
           		System.out.println("rs.getString(2)---------"+rs.getString(2));
           		usermodel.setMiddlename(rs.getString(3)); 
           		System.out.println(" rs.getString(3)--------"+rs.getString(3));
           		usermodel.setLastname(rs.getString(4));
           		System.out.println("rs.getString(4)-----"+rs.getString(4));
           		
           		usermodel.setAddress(rs.getString(5));
           		System.out.println("rs.getString(5)----"+rs.getString(5));
           		usermodel.setPhno(rs.getString(6));           		 
           		usermodel.setMailid(rs.getString(7));
           		//usermodel.setPhoto(rs.getString(8)); 
           		usermodel.setPassword(rs.getString(8));
           		usermodel.setLogintype(rs.getString(9)); 
           		System.out.println("rs.getString(9)----"+rs.getString(9));
             	   
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
		return usermodel;
	}
}
   
