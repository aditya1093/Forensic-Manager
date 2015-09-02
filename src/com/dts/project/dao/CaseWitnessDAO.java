package com.dts.project.dao;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseEvidenceModel;
import com.dts.project.model.CaseMemberModel;
import com.dts.project.model.CaseWitnessModel;

public class CaseWitnessDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseWitnessDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcasewitness(CaseWitnessModel addcasewitnessmodel)
	{
		
	    int caseid=addcasewitnessmodel.getCaseid();
	    System.out.println("flag---------"+caseid);
	    String witnessfstname=addcasewitnessmodel.getWitnessfstname();	   
	    System.out.println("witnessfstname---------"+witnessfstname);
	    String witnessmidname=addcasewitnessmodel.getWitnessmidname();
	    System.out.println("witnessmidname---------"+witnessmidname);
	    String witnesslstname=addcasewitnessmodel.getWitnesslstname();	
	    System.out.println("witnesslstname---------"+witnesslstname);
	    String witnesstype=addcasewitnessmodel.getWitnesstype();
	    System.out.println("witnesstype---------"+witnesstype);
	    int witnessseqno=addcasewitnessmodel.getWitnessseqno();
	    System.out.println("witnessseqno---------"+witnessseqno);
	    String address=addcasewitnessmodel.getAddress();
	    String dob=DateWrapper.parseDate(addcasewitnessmodel.getDob());
	    String witnessrecordstmt=addcasewitnessmodel.getWitnessrecordedstatement();
	    System.out.println("witnessrecordstmt---------"+witnessrecordstmt);
	  
	    try 
	    {
	    	//File f=new File(photo);
	    	//FileInputStream fis=new FileInputStream(f); 
	    	//System.out.println("fole="+f.length());            
	    	con=getConnection();
	       con.setAutoCommit(false);
	       CallableStatement cstmt=con.prepareCall("{call INSRT_CASEWITNESSMSTR(?,?,?,?,?,?,?,?,?)}");

	       cstmt.setInt(1,caseid);
	       cstmt.setString(2,witnessfstname);
	       cstmt.setString(3,witnessmidname);
	       cstmt.setString(4,witnesslstname);
	       cstmt.setString(5,witnesstype);
	       cstmt.setInt(6,witnessseqno);
	       cstmt.setString(7,address);
	       cstmt.setString(8,dob);
	       cstmt.setString(9,witnessrecordstmt);
	       
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
	
	
	public CoreHash getWitnessID()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseWitnessModel  casewitnessmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEWITNESID,WITNESNAME FROM CASEWITNESSMASTER ");
           	 while(rs.next())
                {
           		casewitnessmodel=new CaseWitnessModel();
             	  
           		casewitnessmodel.setCasewitnessid(rs.getInt(1));
           		casewitnessmodel.setWitnessfstname(rs.getString(2));
           		
           		 	   
             	 aCoreHash.put(new Integer(sno),casewitnessmodel);
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
	
	
	public CoreHash getAllCaseWitnessDetails(int caseid)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseWitnessModel  casewitnessmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery(" SELECT  CASEWITNESID, CASEID, WITNESNAME,WITNESSMIDNAME, WITNESSLSTNAME, WITNESTYPE, WITNESSEQNO, WITNESADDRESS, TO_CHAR(WITNESDOB,'DD-MM-YY'), WITNESRECORDEDSTATEMNT FROM CASEWITNESSMASTER WHERE CASEID ="+caseid);           	
           	 while(rs.next())
                {
           		casewitnessmodel=new CaseWitnessModel();
             	  
           		
				casewitnessmodel.setCasewitnessid(rs.getInt(1));
				casewitnessmodel.setCaseid(rs.getInt(2));
				casewitnessmodel.setWitnessfstname(rs.getString(3));
				casewitnessmodel.setWitnessmidname(rs.getString(4));
				casewitnessmodel.setWitnesslstname(rs.getString(5));
				casewitnessmodel.setWitnesstype(rs.getString(6));
				casewitnessmodel.setWitnessseqno(rs.getInt(7));
				casewitnessmodel.setAddress(rs.getString(8));
				casewitnessmodel.setDob(rs.getString(9));
				casewitnessmodel.setWitnessrecordedstatement(rs.getString(10));
				
           		
           		
             	 aCoreHash.put(new Integer(sno),casewitnessmodel);
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
