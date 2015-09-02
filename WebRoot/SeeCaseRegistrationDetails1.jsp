
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.LawTypeDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.LawTypeModel"%>
<%@page import="com.dts.project.dao.LawyerDAO"%>
<%@page import="com.dts.project.model.LawyerModel"%>
<%@page import="com.dts.project.dao.SectionDAO"%>
<%@page import="com.dts.project.model.SectionModel"%>
<%@page import="com.dts.project.model.CaseRegistrationModel"%>
<%@page import="com.dts.project.dao.CaseRegistrationDAO"%>
<%@page import="com.dts.project.dao.CaseTypeDAO"%>
<%@page import="com.dts.project.model.CaseTypeModel"%>
<%@page import="com.dts.project.dao.ClientDAO"%>
<%@page import="com.dts.project.model.ClientModel"%>
<%@page import="com.dts.project.dao.CourtDAO"%>
<%@page import="com.dts.project.model.CourtModel"%>
<%@page import="com.dts.project.dao.EvidenceTypeDAO"%>
<%@page import="com.dts.project.model.EvidenceTypeModel"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_health_nutr.css" type="text/css" />
<script language="JavaScript" type="text/javascript">
//--------------- LOCALIZEABLE GLOBALS ---------------
var d=new Date();
var monthname=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
//Ensure correct for language. English is "January 1, 2004"
var TODAY = monthname[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
//---------------   END LOCALIZEABLE   ---------------
</script>
<style type="text/css">
input {
width: 125px;
font-family: Verdana;
font-size: 8pt;
}
</style>
</head>
<body bgcolor="#F4FFE4">
<table width="103%" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#D5EDB3">
    <td height="51" colspan="2" bgcolor="#0D4961"><img src="images/Legal Management System.jpg" alt="s" width="800" height="139" /></td>
  </tr>


  <tr>
    <td colspan="2" bgcolor="#5C743D"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

  <tr>
    <td height="10" colspan="2" bgcolor="#000000">&nbsp;</td>
  </tr>

  
  
  <tr>
    <td width="100%" align="left" valign="top" bgcolor="#A4C2C2">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#A4C2C2">
  <tr>
    <td width="5%" bgcolor="#a4c2c2">&nbsp;</td>
    <td height="5%" colspan="0" align="left" valign="top" bgcolor="#a4c2c2" class="navText" id="navigation">
	<%
	String role=(String)session.getAttribute("role"); 
	if(role!=null){
   				if (role.equalsIgnoreCase("admin"))
		
					{%>
					<jsp:include page="adminoptions.html"/>
					<% }
				else if (role.equalsIgnoreCase("client"))
					{%>
					
					<jsp:include page="clientoptions.html"/>			
					<%}
				else {%>
						<jsp:include page="useroptions.html"/>
					<%}}
					else{
					response.sendRedirect("LoginForm.jsp?status=session expired login again...." );
			}		%>
    <td width="5%" bgcolor="#a4c2c2">&nbsp;</td>
  </tr>
</table>
</td>
  </tr>
  
  
  <tr>
    <td width="100%" align="left" valign="top" bgcolor="#A4C2C2">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#A4C2C2">
  <tr>
    <td width="5%" bgcolor="#a4c2c2">&nbsp;</td>
    <td height="5%" colspan="0" align="left" valign="top" bgcolor="#a4c2c2" class="navText" id="navigation"><br />
	
	
	
    <td width="5%" bgcolor="#a4c2c2">&nbsp;</td>
  </tr>
</table>
</td>
  </tr>
  
  
  

  <tr>
    <td colspan="2" bgcolor="#5C743D"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td valign="top" bgcolor="#F4FFE4"><table width="100%" border="0">
      <tr>
        <td width="17%"><table width="165" border="0" cellpadding="0" cellspacing="0" bgcolor="#0E4C65" id="navigation">
          <tr>
            <td width="165">&nbsp;<br />
              &nbsp;<br /></td>
          </tr>
          <tr>
            <td width="165"><a href="javascript:;" class="navText">topics</a></td>
          </tr>
          <tr>
            <td width="165"><a href="javascript:;" class="navText">guidelines</a></td>
          </tr>
          <tr>
            <td width="165"><a href="javascript:;" class="navText">educators</a></td>
          </tr>
          <tr>
            <td width="165"><a href="javascript:;" class="navText">special needs</a></td>
          </tr>
          <tr>
            <td width="165"><a href="javascript:;" class="navText">food science</a></td>
          </tr>
        </table></td>
        <td width="78%" align="left" valign="top"><br />
        <form name="seecasereg" action="./UpdateCaseRegAction1" method="post" onSubmit="return validate()">     
<table width=600 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="600" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="black"><center><b><font color="white">CASE REGISTRATION DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
       
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> 
    </td></tr>
       
       
                
                <%
                int caseid=Integer.parseInt(request.getParameter("caseid"));
                
                String loginname=(String)session.getAttribute("user"); 

String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");
       try{
      CaseRegistrationModel  caseregmodel=null;
       caseregmodel=new CaseRegistrationDAO().getCaseRegistrationDetails(imagestorepath1,audiostorepath1,vediostorepath1,caseid);
         
          
         %> 
         
       <tr><td> Case ID </td><td> <%=caseid%></td></tr>  
<%--       <tr><td> Case Number </td><td> <%=caseregmodel.getCaseno() %></td></tr>--%>
       <tr><td> Case Reg Date </td><td> <%=caseregmodel.getCaseregdate() %></td></tr>
   
      
       <tr><input type="hidden" name="casetypeid" value="<%=caseregmodel.getCasetypeid()%>"/> 
       <td>	Case Type Name  </td><td> <%=caseregmodel.getCasetypename() %></td></tr> 
        
     
     
         
        <tr><input type="hidden" name="clientid" value="<%=caseregmodel.getClientid()%>"  />
        <td> Client Name </td><td> 
                    <%=caseregmodel.getClientname() %></td></tr>
         
    <tr><td> Next Hearing Date </td><td><%=caseregmodel.getNexthearingdate() %>  </td></tr>    
     
    <tr><%=caseregmodel.getCourtid()%>
    <td>  Court Name  </td><td>          
          <%=caseregmodel.getCourtname() %> </td></tr>  
      
      <tr><input type="hidden" name="lawyerid" value="<%=caseregmodel.getLawerid()%>"  />
      <td> Lawyer Name </td><td> 
       <%=caseregmodel.getLawyername() %> </td></tr> 
        
    <tr><td>Section ID </td><td>      
        <%=caseregmodel.getSectionid() %> </td></tr>
   
               
             
    <tr><td> Lawyer Accepted Date </td><td><%=caseregmodel.getLawyeraceptdate() %> </td></tr>
    <tr><td> Lawyer Active State</td><td> <%=caseregmodel.getLawyeractivestate() %> </td></tr>
       
          
     <tr><td> Evidence Reg Date   </td><td> <%=caseregmodel.getEvidenceregdate() %> </td></tr>           
     
     
     <tr><td> Evidence Type Name </td>
     <input type="hidden" name="evidencetypeid" value="<%=caseregmodel.getEvidencetypeid()%>"  />
     <td> <%=caseregmodel.getEvidencetypename() %> </td></tr>
  <tr><td> Evidence  Description </td><td> <%=caseregmodel.getEvidencedesc() %></td> </tr>
  
  
  
  
  <tr><td>Evidence Image  </td><td><img src="userimages/<%=caseregmodel.getEvidenceid() %>.gif" height=30 width=50></td></tr>
     <tr><td>Evidence  Vedio   </td><td><font color="#660000"><b><a href="WindowMediaPlayer1.jsp?sampleVideo=<%=caseregmodel.getEvidencevedio() %>"><font color="#660000"><b><%=caseregmodel.getEvidencevedio() %></font></a></font></td></tr>
    <tr><td> Evidence Audio </td><td><font color="#660000"><b><a href="WindowMediaPlayer2.jsp?sampleAudio=<%=caseregmodel.getEvidenceaudio() %>"><font color="#660000"><b><%=caseregmodel.getEvidenceaudio() %></font></a></font></td></tr>      

      
           
       
     <tr> <input type="hidden" name="memberid" value="<%=caseregmodel.getMemid()%>"  />
     <td> Member Name</td><td><%=caseregmodel.getMemfstname() %></td></tr>        
     <tr><td>Member Type</td><td><%=caseregmodel.getMembertype() %></td></tr>
      
     <tr><td> Sequence Number</td><td><%=caseregmodel.getMemseqno() %>  </td></tr>    
     <tr><td> Father Fst Name</td><td><%=caseregmodel.getMemfstname() %></td></tr>     
     <tr><td> Member Address</td><td><%=caseregmodel.getMemaddress() %></td></tr>
     <tr><td> Member  Date Of Birth</td><td><%=caseregmodel.getMemdob() %></td></tr>
    
              
        
     <tr>
     
     <input type="hidden" name="witnessid" value="<%=caseregmodel.getWitnessid()%>"  />
     <td>Witness First Name  </td><td>  <%=caseregmodel.getWitfstname() %> </td> </tr>
     <tr><td>Witness Type  </td><td>
       <%=caseregmodel.getWitnesstype()%></td></tr>
       
    <tr><td> Witness Sequence Number </td><td> <%=caseregmodel.getWitnessseqno() %> </td> </tr>     
    <tr><td>  Date Of Birth </td><td> <%=caseregmodel.getWitnessdob() %></td></tr>
    <tr><td>  Address </td> <td><%=caseregmodel.getAddress() %> </td> </tr>
    <tr><td>Witness Record Statement</td><td> <%=caseregmodel.getWitnesrecordedstmt() %></td> </tr>
      
  <tr><td>Hearing ID</td><td><%=caseregmodel.getHearingid()%></td></tr>
       <tr><td> Case Hearing Date</td><td> <% if(caseregmodel.getHearingdate()!=null){out.print(caseregmodel.getHearingdate());}else out.print(""); %> </td> </tr>     
       <tr><td> Hearing Result </td>
       <td> <%if(caseregmodel.getHearingresult()!=null){out.print(caseregmodel.getHearingresult());}else out.print(""); %></td></tr>
       <tr><td>  Next Hearing Date </td><td><%if(caseregmodel.getNexthearingdate1()!=null){out.print(caseregmodel.getNexthearingdate1());}else out.print(""); %></td> </tr>
       <tr><td>Special Instruction</td><td><%if(caseregmodel.getAnyspecialinstructions()!=null){out.print(caseregmodel.getAnyspecialinstructions());}else out.print(""); %></td> </tr>
      
       
        
        
         <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr><td colspan="2"><center>
     
          <a href="SeeCaseRegistrationDetails1.jsp?caseid=<%=caseregmodel.getCaseid()%>">Update</a>
           
     <input type="button"  name="Submit" value="Back" onclick="javascript:history.back(-1)"/>

    
    <%}catch(Exception e)
{e.printStackTrace();}%> 
</center></td></tr>

      </table></td></tr></table>
</form>

          </td>
        <td width="5%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="3">&nbsp;</td>
  </tr>
 <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
    <tr></tr><tr></tr>
    
	<tr>
    <td height="25" colspan="2" bgcolor="#0D4961" align="center"><font color="#ffffff"><span class="style1">&copy;All rights reserved</span></font></td>
  </tr>
</table>
</body>
</html>
