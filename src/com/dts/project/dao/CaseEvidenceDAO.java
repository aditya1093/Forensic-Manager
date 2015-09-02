package com.dts.project.dao;

import java.sql.CallableStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseEvidenceModel;
import com.dts.project.model.CaseHearingModel;
import com.dts.project.model.CourtModel;
import com.dts.project.model.EvidenceTypeModel;

public class CaseEvidenceDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseEvidenceDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcaseevidence(CaseEvidenceModel addcaseevidencemodel)
	{
		
	    int caseid=addcaseevidencemodel.getCaseid();	   
	    String evidenceregdate=DateWrapper.parseDate(addcaseevidencemodel.getEvidenceregdate());	   
	    int evidencetypeid=addcaseevidencemodel.getEvidencetypeid();
	    String evidencedesc=addcaseevidencemodel.getEvidencedesc();	   
	    String evidenceimage=addcaseevidencemodel.getEvidenceImage();	   
	    String evidenceaudio=addcaseevidencemodel.getEvidenceaudio();
	    String evidencevideo=addcaseevidencemodel.getEvidencevideo();	   
	    
	  PreparedStatement pst=null;
	    try 
	    {
	    	File f1=new File(evidenceimage);
	    	FileInputStream fis1=new FileInputStream(f1);
	    	
	    	File f2=new File(evidenceaudio);
	    	FileInputStream fis2=new FileInputStream(f2);
	    	
	    	File f3=new File(evidencevideo);
	    	FileInputStream fis3=new FileInputStream(f3);
	    	           
	    	con=getConnection();
	       con.setAutoCommit(false);
	      // CallableStatement cstmt=con.prepareCall("{call (?,?,?,?,?,?,?)}");
	       pst=con.prepareStatement(" INSERT INTO CASEEVIDENCEMSTR  VALUES((SELECT NVL(MAX(CASEEVIDENCEID),100)+1 FROM  CASEEVIDENCEMSTR),?,?,?,?,?,?,?)");
 
	       pst.setInt(1,caseid);
	       pst.setString(2,evidenceregdate);
	       pst.setInt(3,evidencetypeid);
	       pst.setString(4,evidencedesc);
	       pst.setBinaryStream(5,fis1,(int)f1.length());
	       pst.setBinaryStream(6,fis3,(int)f3.length());
	       pst.setBinaryStream(7,fis2,(int)f2.length());
	       
	       
	       int i= pst.executeUpdate();
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
	
	public CoreHash getAllCaseEvidencesDetails(String imagepath,String audio,String vedio,int caseid)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseEvidenceModel  caseevidencemodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT   E.CASEEVIDENCEID,E.CASEID,E.EVEDNCEREGDATE,E.EVDENCETYPEID,ET.EVIDENCETYPENAME,E.EVEDNCEDESCRIPTION,E.EVIDENCEIMAGE,E.EVIDENCEVIDEO,E.EVIDENCEAUDIO  FROM CASEEVIDENCEMSTR E,EVIDENCETYPEMASTER ET  WHERE (E.EVDENCETYPEID=ET.EVIDENCETYPEID) AND  E.CASEID="+caseid);
           	
           	 while(rs.next())
                {
           		caseevidencemodel=new CaseEvidenceModel();
             	  
           		int evdid=rs.getInt(1);
				caseevidencemodel.setCaseevedenceid(evdid);
				caseevidencemodel.setCaseid(rs.getInt(2));
				caseevidencemodel.setEvidenceregdate(rs.getString(3));
				caseevidencemodel.setEvidencetypeid(rs.getInt(4));
				caseevidencemodel.setEvidencetypename(rs.getString(5));
				caseevidencemodel.setEvidencedesc(rs.getString(6));
				
           		
           		Blob bb =rs.getBlob(7);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+evdid+".gif");
				fout1.write(bb1);
				caseevidencemodel.setEvidenceImage(evdid+".gif");
				
				
				
				
				
				Blob b =rs.getBlob(8);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];				
				OutputStream fout=new FileOutputStream(vedio+"/"+evdid+".wmv");
				fout.write(b1);      
				
				caseevidencemodel.setEvidencevideo(evdid+".wmv");
				
				
				
				Blob c =rs.getBlob(9);
				byte c1[]=c.getBytes(1,(int)c.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout2=new FileOutputStream(audio+"/"+evdid+".mp3");
				fout2.write(c1);      
				
				caseevidencemodel.setEvidenceaudio(evdid+".mp3");
           		
             	 aCoreHash.put(new Integer(sno),caseevidencemodel);
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
