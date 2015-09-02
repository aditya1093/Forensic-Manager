package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import com.dts.project.model.ClientAddressModel;
import com.dts.project.model.ClientModel;
import  com.dts.core.dao.AbstractDataAccessObject;
public class ClientAddressDAO  extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public ClientAddressDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addclientaddress(ClientAddressModel addclientaddressmodel)
	{
		
	    String hno=addclientaddressmodel.getHno();	    
	    String street=addclientaddressmodel.getStreet();
        String city=addclientaddressmodel.getCity();	    
	    String state=addclientaddressmodel.getState();
        String country=addclientaddressmodel.getCountry();	    
	    String landmark=addclientaddressmodel.getLandmark();
	    
	    
	    String pin=addclientaddressmodel.getPin();
	    int clientid=addclientaddressmodel.getClientid();
	    String addresstype=addclientaddressmodel.getAddresstype();
	    
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call (?,?,?,?,?,?,?,?,?)}");

	       cstmt.setString(1,hno);
	       cstmt.setString(2,street);
	       cstmt.setString(3,city);	       
	       cstmt.setString(4,state);
	       cstmt.setString(5,country);
	       cstmt.setString(6,landmark);
	       cstmt.setString(7,pin);
	       cstmt.setInt(8,clientid);
	       cstmt.setString(9,addresstype);
	      
	       
	       
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
}
