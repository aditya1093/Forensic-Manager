
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
<%@page import="com.dts.project.dao.CaseEvidenceDAO"%>
<%@page import="com.dts.project.model.CaseWitnessModel"%>
<%@page import="com.dts.project.dao.CaseWitnessDAO"%>
<%@page import="com.dts.project.model.CaseMemberModel"%>
<%@page import="com.dts.project.dao.CaseMemberDAO"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
   
   
   
  <form name="viewcasemember" action="ViewCaseMembersDetails.jsp" method="post" onSubmit="return validate()" >  
           
<table align="center" WIDTH="700" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="10" bgcolor="black"><b><center><font color="white">CASE MEMBERS DETAILS</font></center></b></th>
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
            
          <form  name="viewcasemembersdetails" action="" method=""> 
          
           <table align="center" WIDTH="900" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="15" bgcolor="black"><b><center><font color="white">CASE MEMBERS DETAILS</font></center></b></th>
      <tr rowspan="5"></tr> 
      <%
               CaseMemberModel  casemembersmodel=null;
          

       try{
       
       
       int caseid=Integer.parseInt(request.getParameter("caseid"));
       
     
       CoreHash ch=new CaseMemberDAO().ViewAllCaseMembersDetails(caseid);
         Enumeration em=ch.elements();
         
                                
         %> 
         
    <tr>         
    <td>Case Member ID </td>
     <td>Case ID</td>
     <td>Member Fst Name</td>
     <td>Member Mid Name</td>
      <td>Member Lst Name</td>      
     <td>Member  Type</td>
     <td>  Seq No</td> 
     <td>Father Fst Name</td>
     <td>Father Mid Name</td>
      <td>Father Lst Name</td>
     <td>Address</td>
     <td>DOB</td>  
          
      </tr>   
         <% while(em.hasMoreElements()){
             casemembersmodel=(CaseMemberModel)em.nextElement();
             
             %>
        <tr> 
        
   <td><%=casemembersmodel.getCasememberid()%> </td>

         <td><%=casemembersmodel.getCaseid()%></td> 
         <td><%=casemembersmodel.getCasememberfstname()%></td>
         <td ><%=casemembersmodel.getCasemembermidname() %></td>
         <td><%=casemembersmodel.getCasememberlstname()%></td> 
         <td><%=casemembersmodel.getMembertype()%></td>
         <td><%=casemembersmodel.getSequenceno()%></td>
         <td><%=casemembersmodel.getCasememberftherfstname()%></td>
         <td ><%=casemembersmodel.getCasememberfthermidname() %></td>
         <td><%=casemembersmodel.getCasememberftherlstname()%></td> 
         <td><%=casemembersmodel.getCasememberaddress()%></td>
         <td><%=casemembersmodel.getDob()%></td>
        
         
         
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
