package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;
import com.dts.project.model.ClientModel;
import com.dts.project.model.EmployeesModel;
import com.dts.project.model.UserModel;

public class ClientDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public ClientDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addclient(ClientModel addclientmodel)
	{
		
	    String clientfstname=addclientmodel.getClientfstname();	    
	    String clientmidname=addclientmodel.getClientmidname();
        String clientlstname=addclientmodel.getClientlstname();	    
	    String clientfathefstname=addclientmodel.getClientftherfstname();
        String clientftherlstname=addclientmodel.getClientftherlstname();	    
	    String clientfthermidname=addclientmodel.getClientfthermidname();
	    
	    
	    String dobofclientfather=DateWrapper.parseDate(addclientmodel.getDobofclientfather());
	    String doreg=DateWrapper.parseDate(addclientmodel.getDoregistration());
	    String dobofclient=DateWrapper.parseDate(addclientmodel.getDobofclient());
	    int userid=addclientmodel.getUserid();
	    String emailid=addclientmodel.getEmailid();
	    
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call (?,?,?,?,?,?,?,?,?,?,?)}");

	       cstmt.setString(1,clientfstname);
	       cstmt.setString(2,clientmidname);
	       cstmt.setString(3,clientlstname);	       
	       cstmt.setString(4,clientfathefstname);
	       cstmt.setString(5,clientfthermidname);
	       cstmt.setString(6,clientftherlstname);
	       cstmt.setString(7,dobofclient);
	       cstmt.setString(8,dobofclientfather);
	       cstmt.setString(9,doreg);
	       cstmt.setInt(10,userid);	      	       
	       cstmt.setString(11,emailid);
	       
	       
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
	
	public CoreHash getClientNames()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		ClientModel  clientmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CLIENTID,INITCAP(CLIENTFSTNAME) FROM CLIENTMASTER");
           	 while(rs.next())
                {
           		clientmodel=new ClientModel();
             	  
           		clientmodel.setClientid(rs.getInt(1));
           		clientmodel.setClientfstname(rs.getString(2));  
             	   
             	 aCoreHash.put(new Integer(sno),clientmodel);
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


	 public EmployeesModel getClientProfile(int loginname)
	    {
		 EmployeesModel rb=new EmployeesModel();
	        try
	        {
	        	con=getConnection();
	        	CallableStatement cs=con.prepareCall("{call  VIEW_CLIENTMSTR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			    System.out.println(cs);
			    cs.setInt(1,loginname);
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.registerOutParameter(6,Types.VARCHAR);
				cs.registerOutParameter(7,Types.VARCHAR);
				cs.registerOutParameter(8,Types.VARCHAR);
				cs.registerOutParameter(9,Types.VARCHAR);
				cs.registerOutParameter(10,Types.VARCHAR);
				cs.registerOutParameter(11,Types.VARCHAR);
				cs.registerOutParameter(12,Types.VARCHAR);
				
				cs.registerOutParameter(13,Types.VARCHAR);
				cs.registerOutParameter(14,Types.VARCHAR);
				cs.registerOutParameter(15,Types.VARCHAR);
				cs.registerOutParameter(16,Types.VARCHAR);
				cs.registerOutParameter(17,Types.VARCHAR);
				cs.registerOutParameter(18,Types.VARCHAR);
				cs.registerOutParameter(19,Types.VARCHAR);
				cs.registerOutParameter(20,Types.VARCHAR);
				
				
				cs.registerOutParameter(21,Types.VARCHAR);
				cs.registerOutParameter(22,Types.VARCHAR);
				cs.registerOutParameter(23,Types.VARCHAR);
				cs.registerOutParameter(24,Types.VARCHAR);
				cs.registerOutParameter(25,Types.VARCHAR);
				cs.registerOutParameter(26,Types.VARCHAR);
				cs.registerOutParameter(27,Types.VARCHAR);
				cs.registerOutParameter(28,Types.VARCHAR);
				
				
				cs.registerOutParameter(29,Types.VARCHAR);			
				cs.registerOutParameter(30,Types.VARCHAR);
				cs.registerOutParameter(31,Types.VARCHAR);
				cs.registerOutParameter(32,Types.VARCHAR);
				cs.registerOutParameter(33,Types.VARCHAR);
				cs.registerOutParameter(34,Types.VARCHAR);
				cs.registerOutParameter(35,Types.VARCHAR);
				cs.registerOutParameter(36,Types.VARCHAR);
				
				
				cs.registerOutParameter(37,Types.VARCHAR);
				cs.registerOutParameter(38,Types.VARCHAR);
				
				cs.registerOutParameter(39,Types.VARCHAR);
				cs.registerOutParameter(40,Types.VARCHAR);
				
				cs.registerOutParameter(41,Types.VARCHAR);
				cs.registerOutParameter(42,Types.VARCHAR);
				cs.execute();
				
				rb.setFirstname(cs.getString(2));				
				rb.setSurname(cs.getString(3));
				rb.setLastname(cs.getString(4));				
				rb.setFatherfstname(cs.getString(5));				
				rb.setFathermidname(cs.getString(6));
				rb.setFatherlstname(cs.getString(7));				
				rb.setClientdateofbirt(cs.getString(8));
				rb.setClientftherdateofbirt(cs.getString(9));
				rb.setDateofreg(cs.getString(10));
				rb.setUserid(cs.getInt(11));
				rb.setEmail(cs.getString(12));
				
				
			//Home
				rb.setHno(cs.getString(13));				
				rb.setStreet(cs.getString(14));				
				rb.setCity(cs.getString(15));
				rb.setLandmark(cs.getString(16));
				rb.setState(cs.getString(17));				
				rb.setCountry(cs.getString(18));
				rb.setPin(cs.getString(19));
				rb.setHome(cs.getString(20));
				
				//Office
				rb.setOhno(cs.getString(21));
				rb.setOstreet(cs.getString(22));
				rb.setOcity(cs.getString(23));
				rb.setOlandmark(cs.getString(24));
				rb.setOstate(cs.getString(25));				
				rb.setOcountry(cs.getString(26));
				rb.setOpin(cs.getString(27));
				rb.setOffice(cs.getString(28));
				
				//Personal
				rb.setChno(cs.getString(29));
				rb.setCstreet(cs.getString(30));
				rb.setCcity(cs.getString(31));
				rb.setClandmark(cs.getString(32));
				rb.setCstate(cs.getString(33));			
				rb.setCcountry(cs.getString(34));
				rb.setCpin(cs.getString(35));
				rb.setContact(cs.getString(36));
				
				rb.setPhone(cs.getString(37));
				rb.setHomePhoneType(cs.getString(38));
				
				rb.setOphone(cs.getString(39));
				rb.setOfficePhoneType(cs.getString(40));
				
				rb.setCphone(cs.getString(41));
				rb.setPersonalPhoneType(cs.getString(42));
				
			    
			 /*FileOutputStream fs = null;
	         InputStream is = null;
	         fs = new FileOutputStream("photo.jpg");
	        
	         is = cs.getBlob(35).getBinaryStream();
	         byte[] buf = new byte[16384];
	         int bytes;
	         while ((bytes = is.read(buf)) != -1) {
	             fs.write(buf, 0, bytes);
				
	         }*/
//			Blob b =cs.getBlob(9);
//			byte b1[]=b.getBytes(1,(int)b.length());
//			OutputStream fout=new FileOutputStream("photo.jpg");
//			fout.write(b1);

		}
		
	        catch(Exception e)
	        {e.printStackTrace();
	        	LoggerManager.writeLogSevere(e);
	        }
	        finally
	        {
	        	try{
	        		con.close();
	        	}catch(Exception e)
	        	{
	        		LoggerManager.writeLogSevere(e);
	            }
	        	
	        }
	        return rb;
	    }    

	 public ClientModel getClientsId(String username){
	    	
		 System.out.println("in getclientid");
		 Statement st=null;
			ClientModel cModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				   st=con.createStatement();
	            	
	            	ResultSet rs = st.executeQuery("select clientid from clientmaster where clientfstname='"+username+"'");

	            	 if(rs.next())
	                 {
	              	   cModel=new ClientModel();
	              	   
	              	 cModel.setClientid(rs.getInt(1));
	               	   
	 		  
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
			return cModel;
	    }

	 public ClientModel getClientDetails(int  username)
		{
			
			
			CoreHash aCoreHash = new CoreHash();
			aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement st;
			ClientModel  clientmodel=null;
			try {
				 con = getConnection();
				   
	           	 st=con.createStatement();
	           	 ResultSet rs=st.executeQuery("SELECT  CLIENTID,CLIENTFSTNAME,CLIENTFATHERFSTNAME,CLIENTFATHERMIDNAME,CLIENTFATHERLSTNAME,CLIENTDOB,CLIENTFATHERDOB,EMAILID,CLIENTMIDNAME,CLIENTLSTNAME FROM CLIENTMASTER  WHERE CLIENTID="+username);
	           	 while(rs.next())
	                {
	           		clientmodel=new ClientModel();
	             	  
	           		clientmodel.setClientid(rs.getInt(1));
	           		
	           		clientmodel.setClientfstname(rs.getString(2)); 
	           		
	           		clientmodel.setClientftherfstname(rs.getString(3)); 
	           		
	           		clientmodel.setClientfthermidname(rs.getString(4));
	           		
	           		
	           		clientmodel.setClientftherlstname(rs.getString(5));
	           		
	           		clientmodel.setDobofclient(rs.getString(6));           		 
	           		clientmodel.setDobofclientfather(rs.getString(7));
	           		clientmodel.setEmailid(rs.getString(8)); 
	           		clientmodel.setClientmidname(rs.getString(8));
	           		clientmodel.setClientlstname(rs.getString(9)); 
	           		
	             	   
	             	 aCoreHash.put(new Integer(sno),clientmodel);
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
			return clientmodel;
		}


}
