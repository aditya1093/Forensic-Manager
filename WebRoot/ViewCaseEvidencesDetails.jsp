
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.LawTypeDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.LawTypeModel"%>
<%@page import="com.dts.project.dao.LawyerDAO"%>
<%@page import="com.dts.project.model.LawyerModel"%>
<%@page import="com.dts.project.dao.SectionDAO"%>
<%@page import="com.dts.project.model.SectionModel"%>
<%@page import="com.dts.project.dao.CourtDAO"%>
<%@page import="com.dts.project.model.CourtModel"%>
<%@page import="com.dts.project.model.CaseRegistrationModel"%>
<%@page import="com.dts.project.dao.CaseRegistrationDAO"%>
<%@page import="com.dts.project.dao.CaseHearingDAO"%>
<%@page import="com.dts.project.model.CaseHearingModel"%>
<%@page import="com.dts.project.model.CaseEvidenceModel"%>
<%@page import="com.dts.project.dao.CaseEvidenceDAO"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <td colspan="2" bgcolor="#5C743D"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td valign="top" bgcolor="#F4FFE4"><table width="100%" border="0">
      <tr>
        <td width="17%"><table width="165" border="0" cellpadding="0" cellspacing="0" bgcolor="#0E4C65" id="navigation">
          
        </table></td>
        <td width="78%" align="left" valign="top"><br />
   
   
   
  <form name="viewcasehearing" action="ViewCaseEvidencesDetails.jsp" method="post" onSubmit="return validate()" >  
           
<table align="center" WIDTH="700" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="10" bgcolor="black"><b><center><font color="white">CASE EVIDENCES DETAILS</font></center></b></th>
      <tr rowspan="5"></tr>
       
       <%try{
        String loginname=(String)session.getAttribute("user");
                
                LawyerModel  lawyermodel=null;
               
           String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");
                
            lawyermodel=new LawyerDAO().getLawyersProfile(imagestorepath1,loginname);
           int lawyerid=lawyermodel.getLawyerid();
           //int caseid=lawyermodel.getLawyerCaseIDs(lawyerid);
     CaseRegistrationModel caseregmodel=null;
      CoreHash ch1=new CaseRegistrationDAO().getLawyerCaseIDs(lawyerid);
         Enumeration em1=ch1.elements();
           
        %>
     
         <tr>
      <td>Case ID</td>
      <td><select  name="caseid" >
      <option value="">-Select-</option>
      <% 
       
         while(em1.hasMoreElements()){
             caseregmodel=(CaseRegistrationModel)em1.nextElement();
         %>
         <option value="<%=caseregmodel.getCaseid() %>"><%=caseregmodel.getCaseid() %></option>
        <%             
         }         
        %>
      </select>
      </td>
      </tr>
       <%}catch(Exception e){e.printStackTrace();} %>
       
       
       
       
          <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr>
      <td colspan="2"><center><input type="submit" name="submit" value="Search"/>
      </center></td>
      </tr>
      </table>
</form>      
            
        <%if(request.getParameter("submit")!=null){ %>    
            
          <form  name="viewcaseevidencesdetails" action="" method=""> 
          
           <table align="center" WIDTH="700" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="10" bgcolor="black"><b><center><font color="white">CASE EVIDENCES DETAILS</font></center></b></th>
      <tr rowspan="5"></tr> 
      <%
               CaseEvidenceModel  caseevidencesmodel=null;
 //String loginname=(String)session.getAttribute("user"); 
 //lawyermodel=new LawyerDAO().getLawyersProfile(loginname);
       //   String lawtype=(String)lawyermodel.getLawtypename();
       //   int lawyerid=lawyermodel.getLawyerid();
        //  int lawtypeid=lawyermodel.getLawyertypeid();
          

       try{
       
       
       int caseid=Integer.parseInt(request.getParameter("caseid"));
       
        String loginname=(String)session.getAttribute("user"); 
String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");
       CoreHash ch=new CaseEvidenceDAO().getAllCaseEvidencesDetails(imagestorepath1,audiostorepath1,vediostorepath1,caseid);
         Enumeration em=ch.elements();
         
                                
         %> 
         
    <tr>         
    <td>Case Evidence ID </td>
     <td>Case ID</td>
     <td>Evidence Reg Date</td>
     <td>Evidence Type Name</td>
      <td>Evidence Description</td>
     <td>Evidence Image</td>
     <td>Evidence Vedio</td> 
     <td>Evidence Audio</td>     
      </tr>   
         <% while(em.hasMoreElements()){
             caseevidencesmodel=(CaseEvidenceModel)em.nextElement();
             
             %>
        <tr> 
        
   <td  value="<%=caseevidencesmodel.getCaseevedenceid()%>"><%=caseevidencesmodel.getCaseevedenceid() %> </td>

         <td><%=caseevidencesmodel.getCaseid()%></td> 
         <td><%=caseevidencesmodel.getEvidenceregdate()%></td>
         <td value="<%=caseevidencesmodel.getEvidencetypeid() %>"><%=caseevidencesmodel.getEvidencetypename()%></td> 
         <td><%=caseevidencesmodel.getEvidencedesc()%></td>
         
         <td><img src="userimages/<%=caseevidencesmodel.getCaseevedenceid() %>.gif" height=30 width=50></td>
          <td><font color="#660000"><b><a href="WindowMediaPlayer1.jsp?sampleVideo=<%=caseevidencesmodel.getEvidencevideo() %>"><font color="#660000"><b><%=caseevidencesmodel.getEvidencevideo() %></b></font></a></b></font></td>
          <td><font color="#660000"><b><a href="WindowMediaPlayer2.jsp?sampleAudio=<%=caseevidencesmodel.getEvidenceaudio() %>"><font color="#660000"><b><%=caseevidencesmodel.getEvidenceaudio() %></b></font></a></b></font></td>
         
         </tr>
        <%             
         } }catch(Exception e){e.printStackTrace();}        
        %>  
   </table></form></td></tr></table></td></tr></table>
<%} %>
      
        <td width="5%">&nbsp;</td>
      
   <td></td>
    <td width="3">&nbsp;</td>
  
  
   <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
 
  <tr>
    <td height="25" colspan="2" bgcolor="#0D4961" align="center"><font color="#ffffff"><span class="style1">&copy;All rights reserved</span></font></td>
  </tr>

</body>
</html>
