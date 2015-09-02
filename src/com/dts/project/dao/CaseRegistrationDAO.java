package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CaseRegistrationModel;
import com.dts.project.model.LawTypeModel;
import com.dts.project.model.LawyerModel;


public class CaseRegistrationDAO extends AbstractDataAccessObject {
	public Connection con;
	public boolean flag=false;
	public CaseRegistrationDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean addcaseregstration(CaseRegistrationModel addcaseregmodel)
	{
		
	    int caseno=addcaseregmodel.getCaseno();	   
	    String caseregdate=DateWrapper.parseDate(addcaseregmodel.getCaseregdate());	   
	    int casetypeid=addcaseregmodel.getCasetypeid();
	    int clientid=addcaseregmodel.getClientid();	   
	    String nexthearingdate=DateWrapper.parseDate(addcaseregmodel.getNexthearingdate());	   
	    int courtid=addcaseregmodel.getCourtid();
	    int lawyerid=addcaseregmodel.getLawerid();
	    
	    int sectionid=addcaseregmodel.getSectionid();
	    
	    String lawyeraccptdate=DateWrapper.parseDate(addcaseregmodel.getLawyeraceptdate());	
	    String lawyeractstate=addcaseregmodel.getLawyeractivestate();
	    
	    
	    String memfstname=addcaseregmodel.getMemfstname();
	    String memmidtname=addcaseregmodel.getMemmidname();
	    String memlstname=addcaseregmodel.getMemlastname();
	    String memtype=addcaseregmodel.getMembertype();
	    String memseqno=addcaseregmodel.getMemseqno();
	    String memftherfstname=addcaseregmodel.getMemftherfstname();
	    String memfthermidname=addcaseregmodel.getMemfthermidname();
	    String memftherlstname=addcaseregmodel.getMemftherlastname();
	    String memaddress=addcaseregmodel.getMemaddress();
	    String memdob=DateWrapper.parseDate(addcaseregmodel.getMemdob());
	    
	    
	    String evidenceregdate=DateWrapper.parseDate(addcaseregmodel.getEvidenceregdate());	
	    int evidencetypeid=addcaseregmodel.getEvidencetypeid();
	    String evidencedesc=addcaseregmodel.getEvidencedesc();
	    String evidenceimage=addcaseregmodel.getEvidenceimage();
	    String evidenceaudio=addcaseregmodel.getEvidenceaudio();
	    String evidencevedio=addcaseregmodel.getEvidencevedio();
	    
	    String witnesfirstname=addcaseregmodel.getWitfstname();
	    String witnesmidname=addcaseregmodel.getWitmidname();
	    String witneslstname=addcaseregmodel.getWitlastname();
	    String witnesstype=addcaseregmodel.getWitnesstype();	    
	    String witseqno=addcaseregmodel.getWitnessseqno();
	    String address=addcaseregmodel.getAddress();
	    String dob=DateWrapper.parseDate(addcaseregmodel.getWitnessdob());
	    String witnstatement=addcaseregmodel.getWitnesrecordedstmt();
	    
	    
	    PreparedStatement cstmt=null;
	    try 
	    {
	    	
	    	
	    	File f1=new File(evidenceimage);
	    	FileInputStream fis1=new FileInputStream(f1);
	    	
	    	File f2=new File(evidenceaudio);
	    	FileInputStream fis2=new FileInputStream(f2);
	    	
	    	File f3=new File(evidencevedio);
	    	FileInputStream fis3=new FileInputStream(f3);
	    	          
	    	con=getConnection();
	       con.setAutoCommit(false);
	       cstmt=con.prepareStatement("INSERT INTO CASEREGISTRATIONMASTER  VALUES((SELECT NVL(MAX(CASEID),100)+1  FROM  CASEREGISTRATIONMASTER),?,?,?,?,?,?,?)");
	       
	       // CallableStatement cstmt=con.prepareCall("{call INSRT_CASEREGMSTR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	       cstmt.setInt(1,caseno);	      
	       cstmt.setString(2,caseregdate);
	       cstmt.setInt(3,casetypeid);
	       cstmt.setInt(4,clientid);
	       cstmt.setString(5,nexthearingdate);
	       cstmt.setInt(6,courtid);	
	       cstmt.setInt(7,lawyerid);
	       System.out.println("casce Reg"+caseno+caseregdate+casetypeid+clientid+nexthearingdate+courtid+lawyerid);
	       int i= cstmt.executeUpdate();
	       System.out.println("i----->"+i);
	         if(i==1)
	         {
	        	 PreparedStatement cstmt2=null;
	        	 
	        	
	        		 cstmt2=con.prepareStatement("INSERT INTO CASESECTIONMASTER  VALUES((SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?)"); 
	        		 cstmt2.setInt(1,sectionid);
	        		 int j= cstmt2.executeUpdate();
	        	
	        	 if(j==1){
	        		 System.out.println("j----->"+j);
	        		 PreparedStatement cstmt3=null; 
	        		 cstmt3=con.prepareStatement("INSERT INTO CASELAWYERMASTER(CASEID, LAWYERID, LAWYERACCEPTEDDATE,LAWYERACTIVESTATE)  VALUES((SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?,?,?)");
	        		 cstmt3.setInt(1,lawyerid);
	        		 cstmt3.setString(2,lawyeraccptdate);
	      	         cstmt3.setString(3,lawyeractstate);
	      	         System.out.println("Lawyer-------->"+lawyerid+lawyeraccptdate+lawyeractstate);
	        		 int k=cstmt3.executeUpdate(); 
	        		 System.out.println("k----->"+k);
	        		 if(k==1){
		        		 
		        		 PreparedStatement cstmt4=null; 
		        	   cstmt4=con.prepareStatement("INSERT INTO  CASEMEMBERMASTER  VALUES((SELECT NVL(MAX(CASEMEMBRID),100)+1  FROM  CASEMEMBERMASTER ),(SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?,?,?,?,?,?,?,?,?,?)");
		        	   cstmt4.setString(1,memfstname);
		      	       cstmt4.setString(2,memmidtname);
		      	       cstmt4.setString(3,memlstname);
		      	       cstmt4.setString(4,memtype);
		      	       cstmt4.setString(5,memseqno);
		      	       cstmt4.setString(6,memftherfstname);
		      	       cstmt4.setString(7,memfthermidname);
		      	       cstmt4.setString(8,memftherlstname);
		      	       cstmt4.setString(9,memaddress);
		      	       cstmt4.setString(10,memdob);
		      	       System.out.println("Members------->"+memfstname+memmidtname+memlstname+memtype+memseqno+memftherfstname+memfthermidname+memftherlstname+memaddress+memdob);
		        		 int l= cstmt4.executeUpdate(); 
		        		 System.out.println("l----->"+l);
		        		if(l==1){
		        			
		        			 PreparedStatement cstmt5=null; 
			        		 cstmt5=con.prepareStatement("INSERT INTO CASEEVIDENCEMSTR  VALUES((SELECT NVL(MAX(CASEEVIDENCEID),100)+1  FROM  CASEEVIDENCEMSTR ),(SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?,?,?,?,?,?)");
			        		 cstmt5.setString(1,evidenceregdate);
			      	         cstmt5.setInt(2,evidencetypeid);
			      	         cstmt5.setString(3,evidencedesc);
			      	         cstmt5.setBinaryStream(4,fis1,(int)f1.length());
			      	         cstmt5.setBinaryStream(5,fis3,(int)f3.length());
			      	         cstmt5.setBinaryStream(6,fis2,(int)f2.length());
			      	       System.out.println("Evidences------->"+evidenceregdate+evidencetypeid+evidencedesc);
			        		 int m= cstmt5.executeUpdate();
			        		 System.out.println("m----->"+m);
		        			if(m==1){
		        				
		        				PreparedStatement cstmt6=null; 
				        		 cstmt6=con.prepareStatement("INSERT INTO  CASEWITNESSMASTER   VALUES((SELECT NVL(MAX(CASEWITNESID),100)+1  FROM  CASEWITNESSMASTER),(SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?,?,?,?,?,?,?,?)");
				        		 
				        		   cstmt6.setString(1,witnesfirstname);
				        		   cstmt6.setString(2,witnesstype);
					      	       cstmt6.setString(3,witseqno);
					      	       cstmt6.setString(4,address);
					      	       cstmt6.setString(5,dob);
					      	       cstmt6.setString(6,witnstatement);
				      	           cstmt6.setString(7,witnesmidname);
				      	           cstmt6.setString(8,witneslstname);
				      	      
				      	       System.out.println("witness--------->"+witnesfirstname+witnesstype+witseqno+address+dob+witnstatement+witnesmidname+witneslstname);
				      	      
				      	     int n= cstmt6.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	         
				      	   
				      	 if(n==1){
		        				
		        				PreparedStatement cstmt7=null; 
				        		 cstmt7=con.prepareStatement("INSERT INTO CASEHEARINGMASTER(CASEHEARINGID,CASEID,HEARINGDATE) VALUES((SELECT NVL(MAX(CASEHEARINGID),100)+1 FROM CASEHEARINGMASTER),(SELECT MAX(CASEID)  FROM  CASEREGISTRATIONMASTER),?)");
				        		 
				        		 cstmt7.setString(1,nexthearingdate);
				        		  
				      	       System.out.println("CASEHEARING---------->"+nexthearingdate);
				      	      
				      	     int p= cstmt7.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	   
				      	      if(p==1)
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
				      	else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
		        			}
		        			
		        			else
			      	         {
			      	        	 flag=false;
			      	        	 con.rollback();
			      	         }
		        		}
		        		else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
	        	 }
	        		 else
	      	         {
	      	        	 flag=false;
	      	        	 con.rollback();
	      	         }
	        	 
	         }
	      
	        	 else
      	         {
      	        	 flag=false;
      	        	 con.rollback();
      	         }
	        
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
	    
	    finally
        {
          try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
	    return flag;
	}
	
	
	
	
	public boolean 	updatecaseregstration(CaseRegistrationModel updatecaseregmodel)
	{
		
	    int caseid=updatecaseregmodel.getCaseid();	   
	    String caseregdate=DateWrapper.parseDate(updatecaseregmodel.getCaseregdate());	   
	    int casetypeid=updatecaseregmodel.getCasetypeid();
	    int clientid=updatecaseregmodel.getClientid();	   
	    String nexthearingdate=DateWrapper.parseDate(updatecaseregmodel.getNexthearingdate());	   
	    int courtid=updatecaseregmodel.getCourtid();
	    int lawyerid=updatecaseregmodel.getLawerid();
	    
	    int sectionid=updatecaseregmodel.getSectionid();
	    
	    String lawyeraccptdate=DateWrapper.parseDate(updatecaseregmodel.getLawyeraceptdate());
	    //String lawyerenddate=DateWrapper.parseDate(updatecaseregmodel.getLawyerenddate());
	    String lawyeractstate=updatecaseregmodel.getLawyeractivestate();
	    
	    int memberid=updatecaseregmodel.getMemid();
	    //String memfstname=updatecaseregmodel.getMemfstname();
	   // String memmidtname=updatecaseregmodel.getMemmidname();
	    //String memlstname=updatecaseregmodel.getMemlastname();
	    String memtype=updatecaseregmodel.getMembertype();
	    String memseqno=updatecaseregmodel.getMemseqno();
	    String memftherfstname=updatecaseregmodel.getMemftherfstname();
	    //String memfthermidname=updatecaseregmodel.getMemfthermidname();
	    //String memftherlstname=updatecaseregmodel.getMemftherlastname();
	    String memaddress=updatecaseregmodel.getMemaddress();
	    String memdob=DateWrapper.parseDate(updatecaseregmodel.getMemdob());
	    
	    
	    int evidenceid=updatecaseregmodel.getEvidenceid();
	    String evidenceregdate=DateWrapper.parseDate(updatecaseregmodel.getEvidenceregdate());	
	    int evidencetypeid=updatecaseregmodel.getEvidencetypeid();
	    String evidencedesc=updatecaseregmodel.getEvidencedesc();
	    String evidenceimage=updatecaseregmodel.getEvidenceimage();
	    String evidenceaudio=updatecaseregmodel.getEvidenceaudio();
	    String evidencevedio=updatecaseregmodel.getEvidencevedio();
	    
	    
	    
	    int witnessid=updatecaseregmodel.getWitnessid();
	    String witnesfirstname=updatecaseregmodel.getWitfstname();
	    //String witnesmidname=updatecaseregmodel.getWitmidname();
	    //String witneslstname=updatecaseregmodel.getWitlastname();
	    String witnesstype=updatecaseregmodel.getWitnesstype();	    
	    String witseqno=updatecaseregmodel.getWitnessseqno();
	    String address=updatecaseregmodel.getAddress();
	    String dob=DateWrapper.parseDate(updatecaseregmodel.getWitnessdob());
	    String witnstatement=updatecaseregmodel.getWitnesrecordedstmt();
	    
	    int hearingid=updatecaseregmodel.getHearingid();
	    String hearingdate=updatecaseregmodel.getHearingdate();
	    String hearingresult=updatecaseregmodel.getHearingresult();
	    //String nexthearingdate1=updatecaseregmodel.getNexthearingdate1();
	    String instruction=updatecaseregmodel.getAnyspecialinstructions();
	    
	    
	    PreparedStatement cstmt=null;
	    try 
	    {
	    	
	    	
	    	File f1=new File(evidenceimage);
	    	FileInputStream fis1=new FileInputStream(f1);
	    	
	    	File f2=new File(evidenceaudio);
	    	FileInputStream fis2=new FileInputStream(f2);
	    	
	    	File f3=new File(evidencevedio);
	    	FileInputStream fis3=new FileInputStream(f3);
	    	          
	    	con=getConnection();
	       con.setAutoCommit(false);
	       cstmt=con.prepareStatement("UPDATE   CASEREGISTRATIONMASTER  SET  CASETYPEID=?,CLIENTID=?,NEXTHEARINGDATE=?,COURTID=?,LAWYERID=? WHERE CASEID=?");
	       
	       	      
	       //cstmt.setString(1,caseregdate);
	       cstmt.setInt(1,casetypeid);
	       cstmt.setInt(2,clientid);
	       cstmt.setString(3,nexthearingdate);
	       cstmt.setInt(4,courtid);	
	       cstmt.setInt(5,lawyerid);
	       cstmt.setInt(6,caseid);
	       System.out.println("casce Reg"+caseid+casetypeid+clientid+nexthearingdate+courtid+lawyerid);
	       int i= cstmt.executeUpdate();
	       System.out.println("i----->"+i);
	         if(i==1)
	         {
	        	 PreparedStatement cstmt2=null;
	        	 
	        	
	        		 cstmt2=con.prepareStatement("UPDATE CASESECTIONMASTER SET SECTIONID=? WHERE CASEID=?"); 
	        		 cstmt2.setInt(1,sectionid);
	        		 cstmt2.setInt(2,caseid);
	        		 int j= cstmt2.executeUpdate();
	        	
	        	 if(j==1){
	        		 System.out.println("j----->"+j);
	        		 PreparedStatement cstmt3=null; 
	        		 cstmt3=con.prepareStatement("UPDATE CASELAWYERMASTER  SET LAWYERACCEPTEDDATE=?,LAWYERACTIVESTATE=? WHERE CASEID=? AND LAWYERID=?");
	        		 
	        		 cstmt3.setString(1,lawyeraccptdate);
	        		 cstmt3.setString(2,lawyeractstate);
	      	         cstmt3.setInt(3,caseid);
	      	         cstmt3.setInt(4,lawyerid);
	      	         System.out.println("Lawyer-------->"+lawyerid+lawyeraccptdate+lawyeractstate+caseid);
	        		 int k=cstmt3.executeUpdate(); 
	        		 System.out.println("k----->"+k);
	        		 if(k==1){
		        		 
		        		 PreparedStatement cstmt4=null; 
		        		 System.out.println("Members------->"+memtype+memseqno+memftherfstname+memaddress+memdob+memberid+caseid); 
		        	   cstmt4=con.prepareStatement("UPDATE   CASEMEMBERMASTER  SET  MEMBERTYPE=?,SEQUENCENO=?,MEMBERFATHERFSTNAME=?, MEMBERADDRESS=?,MEMBERDOB=? WHERE CASEMEMBRID=? AND CASEID=?");
		        	   
		        	   		      	       
		      	       cstmt4.setString(1,memtype);
		      	       cstmt4.setString(2,memseqno);
		      	       cstmt4.setString(3,memftherfstname);		      	       
		      	       cstmt4.setString(4,memaddress);
		      	       cstmt4.setString(5,memdob);
		      	       cstmt4.setInt(6,memberid);		      	       
		      	       cstmt4.setInt(7,caseid);
		      	        
		      	        
		      	       System.out.println("Members------->"+memtype+memseqno+memftherfstname+memaddress+memdob+memberid+caseid);
		        		 int l= cstmt4.executeUpdate(); 
		        		 System.out.println("l----->"+l);
		        		if(l==1){
		        			
		        			 PreparedStatement cstmt5=null; 
		        			 System.out.println("Evidences------->"+evidenceregdate+evidencetypeid+evidencedesc+evidenceid+caseid);
			        		 cstmt5=con.prepareStatement(" UPDATE  CASEEVIDENCEMSTR SET  EVEDNCEREGDATE=?,EVDENCETYPEID=?,EVEDNCEDESCRIPTION=?,EVIDENCEIMAGE=?,EVIDENCEVIDEO=?,EVIDENCEAUDIO=? WHERE   CASEID=?");
			        		 cstmt5.setString(1,evidenceregdate);
			      	         cstmt5.setInt(2,evidencetypeid);
			      	         cstmt5.setString(3,evidencedesc);
			      	         cstmt5.setBinaryStream(4,fis1,(int)f1.length());
			      	         cstmt5.setBinaryStream(5,fis3,(int)f3.length());
			      	         cstmt5.setBinaryStream(6,fis2,(int)f2.length());
			      	        // cstmt5.setInt(7,evidenceid);
			      	          cstmt5.setInt(7,caseid);
			      	         
			      	       System.out.println("Evidences------->"+evidenceregdate+evidencetypeid+evidencedesc+evidenceid+caseid);
			        		 int m= cstmt5.executeUpdate();
			        		 System.out.println("m----->"+m);
		        			if(m==1){
		        				
		        				PreparedStatement cstmt6=null; 
				        		 cstmt6=con.prepareStatement("UPDATE  CASEWITNESSMASTER SET WITNESTYPE=?,WITNESSEQNO=?,WITNESADDRESS=?,WITNESDOB=?,WITNESRECORDEDSTATEMNT=? WHERE  CASEWITNESID=? AND CASEID=?");
				        		 
				        		  // cstmt6.setString(1,witnesfirstname);
				        		   cstmt6.setString(1,witnesstype);
					      	       cstmt6.setString(2,witseqno);
					      	       cstmt6.setString(3,address);
					      	       cstmt6.setString(4,dob);
					      	       cstmt6.setString(5,witnstatement);
				      	           cstmt6.setInt(6,witnessid);
				      	           cstmt6.setInt(7,caseid);
				      	      
				      	       //System.out.println("witness--------->"+witnesfirstname+witnesstype+witseqno+address+dob+witnstatement+witnesmidname+witneslstname);
				      	      
				      	     int n= cstmt6.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	         
				      	   
				      	 if(n==1){
		        				
		        				PreparedStatement cstmt7=null; 
				        		 cstmt7=con.prepareStatement("UPDATE CASEHEARINGMASTER SET HEARINGDATE=?, HEARINGRESULT=?, ANYSPECIALINSTRUCTION=? WHERE CASEHEARINGID=? AND CASEID=?");
				        		 
				        		 cstmt7.setString(1,nexthearingdate);
				        		 cstmt7.setString(2,hearingresult);
				        		 cstmt7.setString(3,instruction);				        		 				        		 
				        		 cstmt7.setInt(4,hearingid);
				        		 cstmt7.setInt(5,caseid);
				        		 
				        		  
				      	       System.out.println("CASEHEARING---------->"+nexthearingdate);
				      	      
				      	     int p= cstmt7.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	   
				      	      if(p==1)
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
				      	else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
		        			}
		        			
		        			else
			      	         {
			      	        	 flag=false;
			      	        	 con.rollback();
			      	         }
		        		}
		        		else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
	        	 }
	        		 else
	      	         {
	      	        	 flag=false;
	      	        	 con.rollback();
	      	         }
	        	 
	         }
	      
	        	 else
      	         {
      	        	 flag=false;
      	        	 con.rollback();
      	         }
	        
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
	    
	    finally
        {
          try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
	    return flag;
	}
	
	public boolean 	updatecasereg1(CaseRegistrationModel updatecaseregmodel)
	{
		
	    int caseid=updatecaseregmodel.getCaseid();	   
	    String caseregdate=DateWrapper.parseDate(updatecaseregmodel.getCaseregdate());	   
	    int casetypeid=updatecaseregmodel.getCasetypeid();
	    int clientid=updatecaseregmodel.getClientid();	   
	    String nexthearingdate=DateWrapper.parseDate(updatecaseregmodel.getNexthearingdate());	   
	    int courtid=updatecaseregmodel.getCourtid();
	    int lawyerid=updatecaseregmodel.getLawerid();
	    
	    int sectionid=updatecaseregmodel.getSectionid();
	    
	    String lawyeraccptdate=DateWrapper.parseDate(updatecaseregmodel.getLawyeraceptdate());
	    //String lawyerenddate=DateWrapper.parseDate(updatecaseregmodel.getLawyerenddate());
	    String lawyeractstate=updatecaseregmodel.getLawyeractivestate();
	    
	    int memberid=updatecaseregmodel.getMemid();
	    //String memfstname=updatecaseregmodel.getMemfstname();
	   // String memmidtname=updatecaseregmodel.getMemmidname();
	    //String memlstname=updatecaseregmodel.getMemlastname();
	    String memtype=updatecaseregmodel.getMembertype();
	    String memseqno=updatecaseregmodel.getMemseqno();
	    String memftherfstname=updatecaseregmodel.getMemftherfstname();
	    //String memfthermidname=updatecaseregmodel.getMemfthermidname();
	    //String memftherlstname=updatecaseregmodel.getMemftherlastname();
	    String memaddress=updatecaseregmodel.getMemaddress();
	    String memdob=DateWrapper.parseDate(updatecaseregmodel.getMemdob());
	    
	    
	    int evidenceid=updatecaseregmodel.getEvidenceid();
	    String evidenceregdate=DateWrapper.parseDate(updatecaseregmodel.getEvidenceregdate());	
	    int evidencetypeid=updatecaseregmodel.getEvidencetypeid();
	    String evidencedesc=updatecaseregmodel.getEvidencedesc();
	    String evidenceimage=updatecaseregmodel.getEvidenceimage();
	    String evidenceaudio=updatecaseregmodel.getEvidenceaudio();
	    String evidencevedio=updatecaseregmodel.getEvidencevedio();
	    
	    
	    
	    int witnessid=updatecaseregmodel.getWitnessid();
	    String witnesfirstname=updatecaseregmodel.getWitfstname();
	    //String witnesmidname=updatecaseregmodel.getWitmidname();
	    //String witneslstname=updatecaseregmodel.getWitlastname();
	    String witnesstype=updatecaseregmodel.getWitnesstype();	    
	    String witseqno=updatecaseregmodel.getWitnessseqno();
	    String address=updatecaseregmodel.getAddress();
	    String dob=DateWrapper.parseDate(updatecaseregmodel.getWitnessdob());
	    String witnstatement=updatecaseregmodel.getWitnesrecordedstmt();
	    
	    int hearingid=updatecaseregmodel.getHearingid();
	    String hearingdate=updatecaseregmodel.getHearingdate();
	    String hearingresult=updatecaseregmodel.getHearingresult();
	    //String nexthearingdate1=updatecaseregmodel.getNexthearingdate1();
	    String instruction=updatecaseregmodel.getAnyspecialinstructions();
	    
	    
	    PreparedStatement cstmt=null;
	    try 
	    {
	    	
	    	
	    	File f1=new File(evidenceimage);
	    	FileInputStream fis1=new FileInputStream(f1);
	    	
	    	File f2=new File(evidenceaudio);
	    	FileInputStream fis2=new FileInputStream(f2);
	    	
	    	File f3=new File(evidencevedio);
	    	FileInputStream fis3=new FileInputStream(f3);
	    	          
	    	con=getConnection();
	       con.setAutoCommit(false);
	       cstmt=con.prepareStatement("UPDATE   CASEREGISTRATIONMASTER  SET  CASETYPEID=?,CLIENTID=?,NEXTHEARINGDATE=?,COURTID=?,LAWYERID=? WHERE CASEID=?");
	       
	       	      
	       //cstmt.setString(1,caseregdate);
	       cstmt.setInt(1,casetypeid);
	       cstmt.setInt(2,clientid);
	       cstmt.setString(3,nexthearingdate);
	       cstmt.setInt(4,courtid);	
	       cstmt.setInt(5,lawyerid);
	       cstmt.setInt(6,caseid);
	       System.out.println("casce Reg"+caseid+casetypeid+clientid+nexthearingdate+courtid+lawyerid);
	       int i= cstmt.executeUpdate();
	       System.out.println("i----->"+i);
	         if(i==1)
	         {
	        	 PreparedStatement cstmt2=null;
	        	 
	        	
	        		 cstmt2=con.prepareStatement("UPDATE CASESECTIONMASTER SET SECTIONID=? WHERE CASEID=?"); 
	        		 cstmt2.setInt(1,sectionid);
	        		 cstmt2.setInt(2,caseid);
	        		 int j= cstmt2.executeUpdate();
	        	
	        	 if(j==1){
	        		 System.out.println("j----->"+j);
	        		 PreparedStatement cstmt3=null; 
	        		 cstmt3=con.prepareStatement("UPDATE CASELAWYERMASTER  SET LAWYERACCEPTEDDATE=?,LAWYERACTIVESTATE=? WHERE CASEID=? AND LAWYERID=?");
	        		 
	        		 cstmt3.setString(1,lawyeraccptdate);
	        		 cstmt3.setString(2,lawyeractstate);
	      	         cstmt3.setInt(3,caseid);
	      	         cstmt3.setInt(4,lawyerid);
	      	         System.out.println("Lawyer-------->"+lawyerid+lawyeraccptdate+lawyeractstate+caseid);
	        		 int k=cstmt3.executeUpdate(); 
	        		 System.out.println("k----->"+k);
	        		 if(k==1){
		        		 
		        		 PreparedStatement cstmt4=null; 
		        		 System.out.println("Members------->"+memtype+memseqno+memftherfstname+memaddress+memdob+memberid+caseid); 
		        	   cstmt4=con.prepareStatement("UPDATE   CASEMEMBERMASTER  SET  MEMBERTYPE=?,SEQUENCENO=?,MEMBERFATHERFSTNAME=?, MEMBERADDRESS=?,MEMBERDOB=? WHERE CASEMEMBRID=? AND CASEID=?");
		        	   
		        	   		      	       
		      	       cstmt4.setString(1,memtype);
		      	       cstmt4.setString(2,memseqno);
		      	       cstmt4.setString(3,memftherfstname);		      	       
		      	       cstmt4.setString(4,memaddress);
		      	       cstmt4.setString(5,memdob);
		      	       cstmt4.setInt(6,memberid);		      	       
		      	       cstmt4.setInt(7,caseid);
		      	        
		      	        
		      	       System.out.println("Members------->"+memtype+memseqno+memftherfstname+memaddress+memdob+memberid+caseid);
		        		 int l= cstmt4.executeUpdate(); 
		        		 System.out.println("l----->"+l);
		        		if(l==1){
		        			
		        			 PreparedStatement cstmt5=null; 
		        			 System.out.println("Evidences------->"+evidenceregdate+evidencetypeid+evidencedesc+evidenceid+caseid);
			        		 cstmt5=con.prepareStatement(" UPDATE  CASEEVIDENCEMSTR SET  EVEDNCEREGDATE=?,EVDENCETYPEID=?,EVEDNCEDESCRIPTION=?,EVIDENCEIMAGE=?,EVIDENCEVIDEO=?,EVIDENCEAUDIO=? WHERE   CASEID=?");
			        		 cstmt5.setString(1,evidenceregdate);
			      	         cstmt5.setInt(2,evidencetypeid);
			      	         cstmt5.setString(3,evidencedesc);
			      	         cstmt5.setBinaryStream(4,fis1,(int)f1.length());
			      	         cstmt5.setBinaryStream(5,fis3,(int)f3.length());
			      	         cstmt5.setBinaryStream(6,fis2,(int)f2.length());
			      	        // cstmt5.setInt(7,evidenceid);
			      	          cstmt5.setInt(7,caseid);
			      	         
			      	       System.out.println("Evidences------->"+evidenceregdate+evidencetypeid+evidencedesc+evidenceid+caseid);
			        		 int m= cstmt5.executeUpdate();
			        		 System.out.println("m----->"+m);
		        			if(m==1){
		        				
		        				PreparedStatement cstmt6=null; 
				        		 cstmt6=con.prepareStatement("UPDATE  CASEWITNESSMASTER SET WITNESTYPE=?,WITNESSEQNO=?,WITNESADDRESS=?,WITNESDOB=?,WITNESRECORDEDSTATEMNT=? WHERE  CASEWITNESID=? AND CASEID=?");
				        		 
				        		  // cstmt6.setString(1,witnesfirstname);
				        		   cstmt6.setString(1,witnesstype);
					      	       cstmt6.setString(2,witseqno);
					      	       cstmt6.setString(3,address);
					      	       cstmt6.setString(4,dob);
					      	       cstmt6.setString(5,witnstatement);
				      	           cstmt6.setInt(6,witnessid);
				      	           cstmt6.setInt(7,caseid);
				      	      
				      	       //System.out.println("witness--------->"+witnesfirstname+witnesstype+witseqno+address+dob+witnstatement+witnesmidname+witneslstname);
				      	      
				      	     int n= cstmt6.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	         
				      	   
				      	 if(n==1){
		        				
		        				PreparedStatement cstmt7=null; 
				        		 cstmt7=con.prepareStatement("UPDATE CASEHEARINGMASTER SET HEARINGDATE=?, HEARINGRESULT=?, ANYSPECIALINSTRUCTION=? WHERE CASEHEARINGID=? AND CASEID=?");
				        		 
				        		 cstmt7.setString(1,nexthearingdate);
				        		 cstmt7.setString(2,hearingresult);
				        		 cstmt7.setString(3,instruction);				        		 				        		 
				        		 cstmt7.setInt(4,hearingid);
				        		 cstmt7.setInt(5,caseid);
				        		 
				        		  
				      	       System.out.println("CASEHEARING---------->"+nexthearingdate);
				      	      
				      	     int p= cstmt7.executeUpdate();
				      	   System.out.println("n----->"+n);
				      	   
				      	      if(p==1)
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
				      	else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
		        			}
		        			
		        			else
			      	         {
			      	        	 flag=false;
			      	        	 con.rollback();
			      	         }
		        		}
		        		else
		      	         {
		      	        	 flag=false;
		      	        	 con.rollback();
		      	         }
	        	 }
	        		 else
	      	         {
	      	        	 flag=false;
	      	        	 con.rollback();
	      	         }
	        	 
	         }
	      
	        	 else
      	         {
      	        	 flag=false;
      	        	 con.rollback();
      	         }
	        
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
	    
	    finally
        {
          try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
	    return flag;
	}
	
	
	public CoreHash getAllCaseRegistrationDetails(String imagepath,String audio,String vedio)
	{
		CoreHash acorehash=new CoreHash();
		try{
			con=getConnection();
			Statement st=con.createStatement();
	
			
			
			String sql="SELECT  CRM.CASEID,CRM.ACTUALCASENO,TO_CHAR(CRM.CASEREGDATE,'DD-MM-YY'),CRM.CASETYPEID,CTYPM.CASETYPENAME,CRM.CLIENTID,CLNM.CLIENTFSTNAME,TO_CHAR(CRM.NEXTHEARINGDATE,'DD-MM-YY'),CRM.COURTID,CRT.COURTNAME,CRM.LAWYERID,LM.LAWYERFSTNAME,CSM.SECTIONID,TO_CHAR(CLM.LAWYERACCEPTEDDATE,'DD-MM-YY'),TO_CHAR(CLM.LAWYERENDDATE,'DD-MM-YY'),CLM.LAWYERACTIVESTATE ,CMM.CASEMEMBRID,CMM.MEMBERFSTNAME,CMM.MEMBERTYPE,CMM.SEQUENCENO,CMM.MEMBERFATHERFSTNAME,CMM.MEMBERADDRESS,TO_CHAR(CMM.MEMBERDOB,'DD-MM-YY'),CEM.CASEEVIDENCEID,TO_CHAR(CEM.EVEDNCEREGDATE,'DD-MM-YY'),CEM.EVDENCETYPEID ,ETM.EVIDENCETYPENAME,CEM.EVEDNCEDESCRIPTION,CEM.EVIDENCEIMAGE,CEM.EVIDENCEVIDEO,CEM.EVIDENCEAUDIO,CWM.CASEWITNESID,CWM.WITNESNAME,CWM.WITNESTYPE,CWM.WITNESSEQNO,CWM.WITNESADDRESS,TO_CHAR(CWM.WITNESDOB,'DD-MM-YY'),CWM.WITNESRECORDEDSTATEMNT,CHM.CASEHEARINGID,TO_CHAR(CHM.HEARINGDATE,'DD-MM-YY'),CHM.HEARINGRESULT,TO_CHAR(CHM.NEXTHEARINGDATE,'DD-MM-YY'),CHM.ANYSPECIALINSTRUCTION FROM CASEREGISTRATIONMASTER CRM,CASETYPEMASTER CTYPM,CASESECTIONMASTER CSM,CASELAWYERMASTER CLM,LAWYERMASTER LM,CASEMEMBERMASTER CMM,CASEEVIDENCEMSTR CEM,EVIDENCETYPEMASTER ETM,CASEWITNESSMASTER CWM,CASEHEARINGMASTER CHM,CLIENTMASTER CLNM,COURTMASTER CRT WHERE CRM.CASEID=CSM.CASEID AND CRM.CASETYPEID=CTYPM.CASETYPEID AND CRM.CASEID=CLM.CASEID AND CLM.LAWYERID=LM.LAWYERID AND CRM.CASEID=CEM.CASEID AND CEM.EVDENCETYPEID=ETM.EVIDENCETYPEID AND CRM.CASEID=CMM.CASEID AND CRM.CASEID=CWM.CASEID AND CRM.CASEID=CHM.CASEID AND CRM.CLIENTID=CLNM.CLIENTID AND CRT.COURTID=CRM.COURTID";
			ResultSet rs=st.executeQuery(sql);
			
			CaseRegistrationModel caseregmodel=null;
			System.out.println("uuuuuu----------->");
			int i=0;
			while(rs.next())
			{
			
				caseregmodel=new CaseRegistrationModel();
				
				caseregmodel.setCaseid(rs.getInt(1));
				caseregmodel.setCaseno(rs.getInt(2));
				
				caseregmodel.setCaseregdate(rs.getString(3));				
				caseregmodel.setCasetypeid(rs.getInt(4));				
				caseregmodel.setCasetypename(rs.getString(5));
				caseregmodel.setClientid(rs.getInt(6));
				caseregmodel.setClientname(rs.getString(7));
				caseregmodel.setNexthearingdate(rs.getString(8));				
				caseregmodel.setCourtid(rs.getInt(9));					
				caseregmodel.setCourtname(rs.getString(10));				
				caseregmodel.setLawerid(rs.getInt(11));
				caseregmodel.setLawyername(rs.getString(12));
				
				
				caseregmodel.setSectionid(rs.getInt(13));
				
				caseregmodel.setLawyeraceptdate(rs.getString(14));
				caseregmodel.setLawyerenddate(rs.getString(15));
				caseregmodel.setLawyeractivestate(rs.getString(16));
				
				
				
				caseregmodel.setMemid(rs.getInt(17));
				caseregmodel.setMemfstname(rs.getString(18));
				caseregmodel.setMembertype(rs.getString(19));
				caseregmodel.setMemseqno(rs.getString(20));
				caseregmodel.setMemftherfstname(rs.getString(21));
				caseregmodel.setMemaddress(rs.getString(22));
				caseregmodel.setMemdob(rs.getString(23));
				
				
				
				int evdid=rs.getInt(24);
				caseregmodel.setEvidenceid(evdid);
				caseregmodel.setEvidenceregdate(rs.getString(25));
				caseregmodel.setEvidencetypeid(rs.getInt(26));
				caseregmodel.setEvidencetypename(rs.getString(27));
				caseregmodel.setEvidencedesc(rs.getString(28));
				
				
				Blob bb =rs.getBlob(29);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+evdid+".gif");
				fout1.write(bb1);
				caseregmodel.setEvidenceimage(evdid+".gif");
				
				
				
				
				
				Blob b =rs.getBlob(30);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];				
				OutputStream fout=new FileOutputStream(vedio+"/"+evdid+".wmv");
				fout.write(b1);      
				
				caseregmodel.setEvidencevedio(evdid+".wmv");
				
				
				
				Blob c =rs.getBlob(31);
				byte c1[]=c.getBytes(1,(int)c.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout2=new FileOutputStream(audio+"/"+evdid+".mp3");
				fout2.write(c1);      
				
				caseregmodel.setEvidenceaudio(evdid+".mp3");		
				
				
				caseregmodel.setWitnessid(rs.getInt(32));
				caseregmodel.setWitfstname(rs.getString(33));
				caseregmodel.setWitnesstype(rs.getString(34));
				caseregmodel.setWitnessseqno(rs.getString(35));
				caseregmodel.setAddress(rs.getString(36));
				caseregmodel.setWitnessdob(rs.getString(37));
				caseregmodel.setWitnesrecordedstmt(rs.getString(38));	
				
				
				
				caseregmodel.setHearingid(rs.getInt(39));
				caseregmodel.setHearingdate(rs.getString(40));				
				caseregmodel.setHearingresult(rs.getString(41));
				caseregmodel.setNexthearingdate1(rs.getString(42));
				caseregmodel.setAnyspecialinstructions(rs.getString(43));
				
				
				
				
	 			acorehash.put(new Integer(i),caseregmodel);
				i++;
			
		   }//while
			
		}//try
			
		
			catch(Exception e)
			{
				e.printStackTrace();
				LoggerManager.writeLogInfo(e);
			}
			finally
			{
				try
				{
					con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
			return acorehash;
			
	}
	
	
	
	public CoreHash getAllCaseRegistrationOfPerticularLawyer(String imagepath,String audio,String vedio,int lawyerid)
	{
		CoreHash acorehash=new CoreHash();
		try{
			con=getConnection();
			Statement st=con.createStatement();
	
			
			
			String sql="SELECT  CRM.CASEID,CRM.ACTUALCASENO,TO_CHAR(CRM.CASEREGDATE,'DD-MM-YY'),CRM.CASETYPEID,CTYPM.CASETYPENAME,CRM.CLIENTID,CLNM.CLIENTFSTNAME,TO_CHAR(CRM.NEXTHEARINGDATE,'DD-MM-YY'),CRM.COURTID,CRT.COURTNAME,CRM.LAWYERID,LM.LAWYERFSTNAME,CSM.SECTIONID,TO_CHAR(CLM.LAWYERACCEPTEDDATE,'DD-MM-YY'),TO_CHAR(CLM.LAWYERENDDATE,'DD-MM-YY'),CLM.LAWYERACTIVESTATE ,CMM.CASEMEMBRID,CMM.MEMBERFSTNAME,CMM.MEMBERTYPE,CMM.SEQUENCENO,CMM.MEMBERFATHERFSTNAME,CMM.MEMBERADDRESS,TO_CHAR(CMM.MEMBERDOB,'DD-MM-YY'),CEM.CASEEVIDENCEID,TO_CHAR(CEM.EVEDNCEREGDATE,'DD-MM-YY'),CEM.EVDENCETYPEID ,ETM.EVIDENCETYPENAME,CEM.EVEDNCEDESCRIPTION,CEM.EVIDENCEIMAGE,CEM.EVIDENCEVIDEO,CEM.EVIDENCEAUDIO,CWM.CASEWITNESID,CWM.WITNESNAME,CWM.WITNESTYPE,CWM.WITNESSEQNO,CWM.WITNESADDRESS,TO_CHAR(CWM.WITNESDOB,'DD-MM-YY'),CWM.WITNESRECORDEDSTATEMNT,CHM.CASEHEARINGID,TO_CHAR(CHM.HEARINGDATE,'DD-MM-YY'),CHM.HEARINGRESULT,TO_CHAR(CHM.NEXTHEARINGDATE,'DD-MM-YY'),CHM.ANYSPECIALINSTRUCTION FROM CASEREGISTRATIONMASTER CRM,CASETYPEMASTER CTYPM,CASESECTIONMASTER CSM,CASELAWYERMASTER CLM,LAWYERMASTER LM,CASEMEMBERMASTER CMM,CASEEVIDENCEMSTR CEM,EVIDENCETYPEMASTER ETM,CASEWITNESSMASTER CWM,CASEHEARINGMASTER CHM,CLIENTMASTER CLNM,COURTMASTER CRT WHERE (CRM.CASEID=CSM.CASEID AND CRM.CASETYPEID=CTYPM.CASETYPEID AND CRM.CASEID=CLM.CASEID AND CLM.LAWYERID=LM.LAWYERID AND CRM.CASEID=CEM.CASEID AND CEM.EVDENCETYPEID=ETM.EVIDENCETYPEID AND CRM.CASEID=CMM.CASEID AND CRM.CASEID=CWM.CASEID AND CRM.CASEID=CHM.CASEID AND CRM.CLIENTID=CLNM.CLIENTID AND CRT.COURTID=CRM.COURTID) AND CRM.LAWYERID="+lawyerid;
			ResultSet rs=st.executeQuery(sql);
			
			CaseRegistrationModel caseregmodel=null;
			System.out.println("uuuuuu----------->");
			int i=0;
			while(rs.next())
			{
			
				caseregmodel=new CaseRegistrationModel();
				
				caseregmodel.setCaseid(rs.getInt(1));
				caseregmodel.setCaseno(rs.getInt(2));
				
				caseregmodel.setCaseregdate(rs.getString(3));				
				caseregmodel.setCasetypeid(rs.getInt(4));				
				caseregmodel.setCasetypename(rs.getString(5));
				caseregmodel.setClientid(rs.getInt(6));
				caseregmodel.setClientname(rs.getString(7));
				caseregmodel.setNexthearingdate(rs.getString(8));				
				caseregmodel.setCourtid(rs.getInt(9));					
				caseregmodel.setCourtname(rs.getString(10));				
				caseregmodel.setLawerid(rs.getInt(11));
				caseregmodel.setLawyername(rs.getString(12));
				
				
				caseregmodel.setSectionid(rs.getInt(13));
				
				caseregmodel.setLawyeraceptdate(rs.getString(14));
				caseregmodel.setLawyerenddate(rs.getString(15));
				caseregmodel.setLawyeractivestate(rs.getString(16));
				
				
				
				caseregmodel.setMemid(rs.getInt(17));
				caseregmodel.setMemfstname(rs.getString(18));
				caseregmodel.setMembertype(rs.getString(19));
				caseregmodel.setMemseqno(rs.getString(20));
				caseregmodel.setMemftherfstname(rs.getString(21));
				caseregmodel.setMemaddress(rs.getString(22));
				caseregmodel.setMemdob(rs.getString(23));
				
				
				
				int evdid=rs.getInt(24);
				caseregmodel.setEvidenceid(evdid);
				caseregmodel.setEvidenceregdate(rs.getString(25));
				caseregmodel.setEvidencetypeid(rs.getInt(26));
				caseregmodel.setEvidencetypename(rs.getString(27));
				caseregmodel.setEvidencedesc(rs.getString(28));
				
				
				Blob bb =rs.getBlob(29);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+evdid+".gif");
				fout1.write(bb1);
				caseregmodel.setEvidenceimage(evdid+".gif");
				
				
				
				
				
				Blob b =rs.getBlob(30);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];				
				OutputStream fout=new FileOutputStream(vedio+"/"+evdid+".wmv");
				fout.write(b1);      
				
				caseregmodel.setEvidencevedio(evdid+".wmv");
				
				
				
				Blob c =rs.getBlob(31);
				byte c1[]=c.getBytes(1,(int)c.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout2=new FileOutputStream(audio+"/"+evdid+".mp3");
				fout2.write(c1);      
				
				caseregmodel.setEvidenceaudio(evdid+".mp3");		
				
				
				caseregmodel.setWitnessid(rs.getInt(32));
				caseregmodel.setWitfstname(rs.getString(33));
				caseregmodel.setWitnesstype(rs.getString(34));
				caseregmodel.setWitnessseqno(rs.getString(35));
				caseregmodel.setAddress(rs.getString(36));
				caseregmodel.setWitnessdob(rs.getString(37));
				caseregmodel.setWitnesrecordedstmt(rs.getString(38));	
				
				
				
				caseregmodel.setHearingid(rs.getInt(39));
				caseregmodel.setHearingdate(rs.getString(40));				
				caseregmodel.setHearingresult(rs.getString(41));
				caseregmodel.setNexthearingdate1(rs.getString(42));
				caseregmodel.setAnyspecialinstructions(rs.getString(43));
				
				
				
				
	 			acorehash.put(new Integer(i),caseregmodel);
				i++;
			
		   }//while
			
		}//try
			
		
			catch(Exception e)
			{
				e.printStackTrace();
				LoggerManager.writeLogInfo(e);
			}
			finally
			{
				try
				{
					con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
			return acorehash;
			
	}
	
	public CaseRegistrationModel getCaseRegistrationDetails(String imagepath,String audio,String vedio,int caseid)
	{
		CaseRegistrationModel caseregmodel=null;
		
		
		try{
			con=getConnection();
			Statement st=con.createStatement();
	
			
			
			String sql="SELECT  CRM.CASEID,CRM.ACTUALCASENO,TO_CHAR(CRM.CASEREGDATE,'DD-MM-YY'),CRM.CASETYPEID,CTYPM.CASETYPENAME,CRM.CLIENTID,CLNM.CLIENTFSTNAME,TO_CHAR(CRM.NEXTHEARINGDATE,'DD-MM-YY'),CRM.COURTID,CRT.COURTNAME,CRM.LAWYERID,LM.LAWYERFSTNAME,CSM.SECTIONID,TO_CHAR(CLM.LAWYERACCEPTEDDATE,'DD-MM-YY'),TO_CHAR(CLM.LAWYERENDDATE,'DD-MM-YY'),CLM.LAWYERACTIVESTATE ,CMM.CASEMEMBRID,CMM.MEMBERFSTNAME,CMM.MEMBERTYPE,CMM.SEQUENCENO,CMM.MEMBERFATHERFSTNAME,CMM.MEMBERADDRESS,TO_CHAR(CMM.MEMBERDOB,'DD-MM-YY'),CEM.CASEEVIDENCEID,TO_CHAR(CEM.EVEDNCEREGDATE,'DD-MM-YY'),CEM.EVDENCETYPEID ,ETM.EVIDENCETYPENAME,CEM.EVEDNCEDESCRIPTION,CEM.EVIDENCEIMAGE,CEM.EVIDENCEVIDEO,CEM.EVIDENCEAUDIO,CWM.CASEWITNESID,CWM.WITNESNAME,CWM.WITNESTYPE,CWM.WITNESSEQNO,CWM.WITNESADDRESS,TO_CHAR(CWM.WITNESDOB,'DD-MM-YY'),CWM.WITNESRECORDEDSTATEMNT,CHM.CASEHEARINGID,TO_CHAR(CHM.HEARINGDATE,'DD-MM-YY'),CHM.HEARINGRESULT,TO_CHAR(CHM.NEXTHEARINGDATE,'DD-MM-YY'),CHM.ANYSPECIALINSTRUCTION FROM CASEREGISTRATIONMASTER CRM,CASETYPEMASTER CTYPM,CASESECTIONMASTER CSM,CASELAWYERMASTER CLM,LAWYERMASTER LM,CASEMEMBERMASTER CMM,CASEEVIDENCEMSTR CEM,EVIDENCETYPEMASTER ETM,CASEWITNESSMASTER CWM,CASEHEARINGMASTER CHM,CLIENTMASTER CLNM,COURTMASTER CRT WHERE CRM.CASEID=CSM.CASEID AND CRM.CASETYPEID=CTYPM.CASETYPEID AND CRM.CASEID=CLM.CASEID AND CLM.LAWYERID=LM.LAWYERID AND CRM.CASEID=CEM.CASEID AND CEM.EVDENCETYPEID=ETM.EVIDENCETYPEID AND CRM.CASEID=CMM.CASEID AND CRM.CASEID=CWM.CASEID AND CRM.CASEID=CHM.CASEID AND CRM.CLIENTID=CLNM.CLIENTID AND CRT.COURTID=CRM.COURTID AND CRM.CASEID="+caseid;
			ResultSet rs=st.executeQuery(sql);
			
			       
	            
	            
	            
	            System.out.println("uuuuuu----------->");
			//int i=0;
			while(rs.next())
			{
			
				caseregmodel=new CaseRegistrationModel();
				
				caseregmodel.setCaseid(rs.getInt(1));
				caseregmodel.setCaseno(rs.getInt(2));
				
				caseregmodel.setCaseregdate(rs.getString(3));				
				caseregmodel.setCasetypeid(rs.getInt(4));				
				caseregmodel.setCasetypename(rs.getString(5));
				caseregmodel.setClientid(rs.getInt(6));
				caseregmodel.setClientname(rs.getString(7));
				
				
				caseregmodel.setNexthearingdate(rs.getString(8));				
				caseregmodel.setCourtid(rs.getInt(9));					
				caseregmodel.setCourtname(rs.getString(10));				
				caseregmodel.setLawerid(rs.getInt(11));
				caseregmodel.setLawyername(rs.getString(12));
				
				
				caseregmodel.setSectionid(rs.getInt(13));
				
				caseregmodel.setLawyeraceptdate(rs.getString(14));
				caseregmodel.setLawyerenddate(rs.getString(15));
				caseregmodel.setLawyeractivestate(rs.getString(16));
				
				
				
				caseregmodel.setMemid(rs.getInt(17));
				caseregmodel.setMemfstname(rs.getString(18));
				caseregmodel.setMembertype(rs.getString(19));
				caseregmodel.setMemseqno(rs.getString(20));
				caseregmodel.setMemftherfstname(rs.getString(21));
				caseregmodel.setMemaddress(rs.getString(22));
				caseregmodel.setMemdob(rs.getString(23));
				
				
				
				int evdid=rs.getInt(24);
				caseregmodel.setEvidenceid(evdid);
				caseregmodel.setEvidenceregdate(rs.getString(25));
				caseregmodel.setEvidencetypeid(rs.getInt(26));
				caseregmodel.setEvidencetypename(rs.getString(27));
				caseregmodel.setEvidencedesc(rs.getString(28));
				
				
				Blob bb =rs.getBlob(29);
				byte bb1[]=bb.getBytes(1,(int)bb.length());
				OutputStream fout1=new FileOutputStream(imagepath+"/"+evdid+".gif");
				fout1.write(bb1);
				caseregmodel.setEvidenceimage(evdid+".gif");
				
				
				
				
				
				Blob b =rs.getBlob(30);
				byte b1[]=b.getBytes(1,(int)b.length());//new byte[(int)b.length()];				
				OutputStream fout=new FileOutputStream(vedio+"/"+evdid+".wmv");
				fout.write(b1);      
				
				caseregmodel.setEvidencevedio(evdid+".wmv");
				
				
				
				Blob c =rs.getBlob(31);
				byte c1[]=c.getBytes(1,(int)c.length());//new byte[(int)b.length()];
				//InputStream in=photo.getBinaryStream();
				OutputStream fout2=new FileOutputStream(audio+"/"+evdid+".mp3");
				fout2.write(c1);      
				
				caseregmodel.setEvidenceaudio(evdid+".mp3");		
				
				
				caseregmodel.setWitnessid(rs.getInt(32));
				caseregmodel.setWitfstname(rs.getString(33));
				caseregmodel.setWitnesstype(rs.getString(34));
				caseregmodel.setWitnessseqno(rs.getString(35));
				caseregmodel.setAddress(rs.getString(36));
				caseregmodel.setWitnessdob(rs.getString(37));
				caseregmodel.setWitnesrecordedstmt(rs.getString(38));	
				
				
				
				caseregmodel.setHearingid(rs.getInt(39));
				caseregmodel.setHearingdate(rs.getString(40));				
				caseregmodel.setHearingresult(rs.getString(41));
				caseregmodel.setNexthearingdate1(rs.getString(42));
				caseregmodel.setAnyspecialinstructions(rs.getString(43));
				
				
				
				
	 			//acorehash.put(new Integer(i),caseregmodel);
				//i++;
			
		   }//while
			
		}//try
			
		
			catch(Exception e)
			{
				e.printStackTrace();
				LoggerManager.writeLogInfo(e);
			}
			finally
			{
				try
				{
					con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		}
			return caseregmodel;
			
	}
	
	public CoreHash getCaseID()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseRegistrationModel  caseregmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEID FROM CASEREGISTRATIONMASTER");
           	
           	 while(rs.next())
                {
           		caseregmodel=new CaseRegistrationModel();
             	  
           		caseregmodel.setCaseid(rs.getInt(1));
           		
             	 aCoreHash.put(new Integer(sno),caseregmodel);
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
	
	
	public CoreHash getLawyerCaseIDs(int lawyerid)
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		CaseRegistrationModel  caseregmodel=null;
		try {
			 con = getConnection();
			   
           	 st=con.createStatement();
           	 ResultSet rs=st.executeQuery("SELECT  CASEID FROM CASEREGISTRATIONMASTER WHERE LAWYERID="+lawyerid);
           	
           	 while(rs.next())
                {
           		caseregmodel=new CaseRegistrationModel();
             	  
           		caseregmodel.setCaseid(rs.getInt(1));
           		
             	 aCoreHash.put(new Integer(sno),caseregmodel);
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
