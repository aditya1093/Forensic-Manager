/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;
import oracle.jdbc.driver.*;
import com.dts.project.model.EmployeesModel;
import com.dts.core.dao.AbstractDataAccessObject; 
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author 
 */
public class ProfileDAO extends AbstractDataAccessObject{
    
    public Connection con;

    private boolean flag;
    /** Creates a new instance of ProfileDAO */
    public ProfileDAO() 
    {
           //getting Database Connection
           
    }
    
       
    //User Registration
    public boolean registration(EmployeesModel regbean)
    {
    	
    	
        String firstname=regbean.getFirstname();
        String lastname=regbean.getLastname();
        String surname=regbean.getSurname();       
        String clientdob=DateWrapper.parseDate(regbean.getClientdateofbirt());
        
        
        String ffstname=regbean.getFatherfstname();
        String fsurname=regbean.getFathermidname();
        String flstname=regbean.getFatherlstname(); 
        String clientfatherdob=DateWrapper.parseDate(regbean.getClientftherdateofbirt());
        
        String dateofreg=DateWrapper.parseDate(regbean.getDateofreg());
        int userid=regbean.getUserid();
        String emailid=regbean.getEmail();
        
       //home
        String hno=regbean.getHno();        
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String landmark=regbean.getLandmark();
        String pin=regbean.getPin(); 
        String homeaddr=regbean.getHome();
        String homephno=regbean.getPhone();
        String homephonetype=regbean.getHomePhoneType();
        
        
        
        //office
        
        String ohno=regbean.getOhno();       
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String olandmark=regbean.getOlandmark();
        String opin=regbean.getOpin();
        String officeaddr=regbean.getOffice();
        String ophoneno=regbean.getOphone();
        String oPhonetype=regbean.getOfficePhoneType();
        
        
        
        String phno=regbean.getChno();       
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String plandmark=regbean.getClandmark();
        String ppin=regbean.getCpin();
        String contact=regbean.getContact();
        String pphoneno=regbean.getCphone();               
        String pPhonetype=regbean.getPersonalPhoneType();
        
        
        try 
        {
        	
            
        	con=getConnection();
          
           CallableStatement cstmt=con.prepareCall("{call INSRT_CLIENTMSTR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    
           
           cstmt.setString(1,firstname);
           cstmt.setString(2,surname);
           cstmt.setString(3,lastname);
           
           cstmt.setString(4,ffstname);
           cstmt.setString(5,fsurname);           
           cstmt.setString(6,flstname);
           cstmt.setString(7,clientdob);
           cstmt.setString(8,clientfatherdob);
           cstmt.setString(9,dateofreg);
           cstmt.setInt(10,userid);           
           cstmt.setString(11,emailid);
           
           
          
           
           
           //home
           cstmt.setString(12,hno);
           cstmt.setString(13,street);
           cstmt.setString(14,city);           
           cstmt.setString(15,state);
           cstmt.setString(16,country);
           cstmt.setString(17,landmark);
           cstmt.setString(18,pin);           
           cstmt.setString(19,homeaddr);
           
           //office
           cstmt.setString(20,ohno);
           cstmt.setString(21,ostreet);
           cstmt.setString(22,ocity);          
           cstmt.setString(23,ostate);
           cstmt.setString(24,ocountry);
           cstmt.setString(25,olandmark);
           cstmt.setString(26,opin);
           cstmt.setString(27,officeaddr);
         
         
           //personal
           cstmt.setString(28,phno);
           cstmt.setString(29,pstreet);                     
           cstmt.setString(30,pcity);           
           cstmt.setString(31,pstate);   
           cstmt.setString(32,pcountry);
           cstmt.setString(33,plandmark);           
           cstmt.setString(34,ppin);
           cstmt.setString(35,contact);
           
           
          
           cstmt.setString(36,homephno);
           cstmt.setString(37,homephonetype);
           
           cstmt.setString(38,ophoneno);
           cstmt.setString(39,oPhonetype);
           
           cstmt.setString(40,pphoneno);
           cstmt.setString(41,pPhonetype);
           
           
        
           boolean  switchvar= cstmt.execute();
             if(switchvar)
             {
              flag=true;
             }
             else
             {
            	 flag=false;
            	 
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
    
    //Getting profile
    public Profile getProfile(String loginname)
    {
        Profile rb=new Profile();
        try
        {
        	con=getConnection();
        	CallableStatement cs=con.prepareCall("{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		    
		    /*
		1 logid userdetails.loginid%type,
		2 pass out userdetails.PASSWORD%type,
		3 fname OUT userdetails.FIRSTNAME%type,
		4 lname OUT  userdetails.LASTNAME%type,
		5 db OUT varchar2,
		 
		6 email OUT  userdetails.EMAILID%type,
		7 fax OUT userdetails.FAXNO%type,
		8 addresshome OUT addresses.ADDRESSTYPE%type,
		9 housenohome OUT addresses.HOUSENO%type,
		10 streethome OUT addresses.STREET%type,
		11 cityhome OUT addresses.CITY%type,
		12 statehome OUT addresses.STATE%type,
		13 countryhome OUT addresses.COUNTRY%type,
		14 pincodehome OUT addresses.PINCODE%type,
		15 addressoffice OUT addresses.ADDRESSTYPE%type,
		16 housenooffice OUT addresses.HOUSENO%type,
		17 streetoffice OUT addresses.STREET%type,
		18 cityoffice OUT  addresses.CITY%type,
		19 stateoffice OUT addresses.STATE%type,
		20 countryoffice OUT addresses.COUNTRY%type,
		21 pincodeoffice OUT addresses.PINCODE%type,
		22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		23 housenopersonal OUT addresses.HOUSENO%type,
		24 streetpersonal OUT addresses.STREET%type,
		25 citypersonal OUT addresses.CITY%type,
		26 statepersonal OUT addresses.STATE%type,
		27 countrypersonal OUT addresses.COUNTRY%type,
		28 pincodepersonal OUT addresses.PINCODE%type,
		29 phonehome OUT phones.PHONETYPE%type,
		30 phonenohome OUT phones.PHONENO%type,
		31 phoneoffice OUT  phones.PHONETYPE%type,
		32 phonenooffice OUT phones.PHONENO%type,
		33 phonepersonal OUT phones.PHONETYPE%type,
		34 phonenopersonal OUT phones.PHONENO%type,
		35 photo OUT  userdetails.PHOTOGRAPH%type 
		     */
		    		
		    
		    cs.setString(1,loginname);
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
			cs.registerOutParameter(35,Types.BLOB);
			cs.execute();
			rb.setPassword(cs.getString(2));
			rb.setFirstname(cs.getString(3));
			rb.setLastname(cs.getString(4));
			
			rb.setBdate(cs.getString(5));
			//rb.setPhoto(cs.getString());
			rb.setEmail(cs.getString(6));
			rb.setFax(cs.getString(7));
			rb.setHome(cs.getString(8));
			rb.setHno(cs.getString(9));
			rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(11));
			rb.setState(cs.getString(12));
			//rb.setPin(cs.getString(13));
			rb.setCountry(cs.getString(13));
			rb.setPin(cs.getString(14));
			rb.setOffice(cs.getString(15));
			rb.setOhno(cs.getString(16));
			rb.setOstreet(cs.getString(17));
			rb.setOcity(cs.getString(18));
			
			rb.setOstate(cs.getString(19));
		/*
		 20 countryoffice OUT addresses.COUNTRY%type,
		21 pincodeoffice OUT addresses.PINCODE%type,
		22 addresspersonal OUT addresses.ADDRESSTYPE%type,
		23 housenopersonal OUT addresses.HOUSENO%type,
		24 streetpersonal OUT addresses.STREET%type,
		25 citypersonal OUT addresses.CITY%type,
		26 statepersonal OUT addresses.STATE%type,
		27 countrypersonal OUT addresses.COUNTRY%type,
		28 pincodepersonal OUT addresses.PINCODE%type,
		
		 
		     */
			rb.setOcountry(cs.getString(20));
			rb.setOpin(cs.getString(21));
			rb.setContact(cs.getString(22));
			rb.setChno(cs.getString(23));
			rb.setCstreet(cs.getString(24));
			rb.setCcity(cs.getString(25));
			rb.setCstate(cs.getString(26));
			//rb.setCpin(cs.getString(27));
			rb.setCcountry(cs.getString(27));
			rb.setCpin(cs.getString(28));
			/*
			 	29 phonehome OUT phones.PHONETYPE%type,
				30 phonenohome OUT phones.PHONENO%type,
				31 phoneoffice OUT  phones.PHONETYPE%type,
				32 phonenooffice OUT phones.PHONENO%type,
				33 phonepersonal OUT phones.PHONETYPE%type,
				34 phonenopersonal OUT phones.PHONENO%type, 
				35 photo OUT  userdetails.PHOTOGRAPH%type
					 */
			rb.setHomePhoneType(cs.getString(29));
			rb.setPhone(cs.getString(30));
			rb.setOfficePhoneType(cs.getString(31));
			String o=cs.getString(32);
			rb.setOphone(o);
			rb.setPersonalPhoneType(cs.getString(33));
		String s=cs.getString(34);
		rb.setCphone(s);
		System.out.println("personal phone="+s+"  officeph= "+o);
		 /*FileOutputStream fs = null;
         InputStream is = null;
         fs = new FileOutputStream("photo.jpg");
        
         is = cs.getBlob(35).getBinaryStream();
         byte[] buf = new byte[16384];
         int bytes;
         while ((bytes = is.read(buf)) != -1) {
             fs.write(buf, 0, bytes);
			
         }*/
		Blob b =cs.getBlob(35);
		byte b1[]=b.getBytes(1,(int)b.length());
		OutputStream fout=new FileOutputStream("C:/photo.jpg");
		fout.write(b1);

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
    }     // Modify Profile
    public boolean modifyProfile(Profile regbean)
    {
    	String loginid=regbean.getLoginID();
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
       // String bdate=DateWrapper.parseDate(regbean.getBirthDate());
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
        String Phonetype=regbean.getHomePhoneType();
        String phone=regbean.getPhone();
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        String oPhonetype=regbean.getOfficePhoneType();
        String ophone=regbean.getOphone();
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        String pPhonetype=regbean.getPersonalPhoneType();
        String pphone=regbean.getCphone();
       
        String fax=regbean.getFax();
        String email=regbean.getEmail();
        String photo=regbean.getPhoto();
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
        	con=getConnection();
          // con.setAutoCommit(false);
        	CallableStatement cs=con.prepareCall("{call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    
        	/*
    
		   1 fname userdetails.FIRSTNAME%type,
		   2 lname userdetails.LASTNAME%type,
		   3 logid userdetails.LOGINID%type,
		   4 photo userdetails.photograph%type,
		   5 email userdetails.EMAILID%type,
		   6 fax userdetails.FAXNO%type,
		    
        	 */
        	cs.setString(1,firstname);
    		cs.setString(2,lastname);
    		cs.setString(3,loginid);
    		cs.setBinaryStream(4, fis,(int)f.length());
    		// cs.setBinaryStream(4, fis,999);
    		cs.setString(5,email);
    		cs.setString(6,fax);
    
    		/*
    	    7 addresshome addresses.ADDRESSTYPE%type,
		    8 housenohome addresses.HOUSENO%type,
		    9 streethome addresses.STREET%type,
		    10 cityhome addresses.CITY%type,
		    11 statehome addresses.STATE%type,
		    12 countryhome addresses.COUNTRY%type,
		    13 pincodehome addresses.PINCODE%type,
		     
    		 */
    		
    		cs.setString(7,home);
    		cs.setString(8,hno);
    		cs.setString(9,street);
    		cs.setString(10,city);
    		cs.setString(11,state);
    		cs.setString(12,country);
    		cs.setString(13,pin);
    		
    
    		/*
    		 14  addressoffice addresses.ADDRESSTYPE%type,
			 15  housenooffice addresses.HOUSENO%type,
			 16  streetoffice addresses.STREET%type,
			 17  cityoffice addresses.CITY%type,
			 18  stateoffice addresses.STATE%type,
			 19  countryoffice addresses.COUNTRY%type,
			 20 pincodeoffice addresses.PINCODE%type,
			    
    		 */
    		cs.setString(14,office);
    		
    		cs.setString(15,ohno);
    		cs.setString(16,ostreet);
    		cs.setString(17,ocity);
    		cs.setString(18,ostate);
    		cs.setString(19,ocountry);
    		cs.setString(20,opin);
    		
    		/*
    
    		21 addresspersonal addresses.ADDRESSTYPE%type,
		    22 housenopersonal addresses.HOUSENO%type,
		    23 streetpersonal addresses.STREET%type,
		    24 citypersonal  addresses.CITY%type,
		    25 statepersonal addresses.STATE%type,
		    26 countrypersonal addresses.COUNTRY%type,
		    27 pincodepersonal addresses.PINCODE%type,
		    
    		 */
    		cs.setString(21,contact);
    		cs.setString(22,phno);
    		cs.setString(23,pstreet);
    		cs.setString(24,pcity);
    		cs.setString(25,pstate);
    		cs.setString(26,pcountry);
    		cs.setString(27,ppin);
    
    		/*
    	    28 phonehome phones.PHONETYPE%type,
    	    29 phonenohome phones.PHONENO%type,
    	    30 phoneoffice phones.PHONETYPE%type,
    	    31 phonenooffice phones.PHONENO%type,
    	    32 phonepersonal phones.PHONETYPE%type,
    	    33 phonenopersonal phones.PHONENO%type,
    	    34 flag out number
    	          
    	    */ 
    	    
    		cs.setString(28,Phonetype);
    		cs.setString(29,phone);
    		cs.setString(30,oPhonetype);
    		cs.setString(31,ophone);
    		cs.setString(32,pPhonetype);
    		cs.setString(33,pphone);
    		cs.registerOutParameter(34,Types.INTEGER);
    			cs.execute();
    		int n=cs.getInt(34);
    		if(n>0)
    		{
    			flag=true;
    	}
           
            else
            {
                flag=false;
            con.rollback();
            }
            con.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
                sex.printStackTrace();
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
            catch (SQLException se) 
            {
                se.printStackTrace();
            }
        }
        return flag;
    }
}
   
    