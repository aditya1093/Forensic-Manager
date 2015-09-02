
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.LawTypeDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.LawTypeModel"%>
<%@page import="com.dts.project.dao.LawyerDAO"%>
<%@page import="com.dts.project.model.LawyerModel"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        <form name="viewlawyer" action="" method="post" onSubmit="return validate()" >  
        
        <span class="style13">Export to : <a href="ExportXLS" target="_blank"><font color="brown">XLS</font></a></span><br/>   
<table width=600 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="600" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="10" bgcolor="black"><b><center><font color="white">LAWYER DETAILS</font></center></b></th>
      <tr rowspan="5"></tr>
       
       
       <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> 
    </td></tr>  
       
       
                
                <%
                String loginname=(String)session.getAttribute("user"); 
String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");

       try{
       CoreHash ch=new LawyerDAO().getAllLawyersDetails(imagestorepath1);
         Enumeration em=ch.elements();
         LawyerModel  lawyermodel=null;
          
          String report="";
          report+=" <table align='center' WIDTH='730' border='0' bordercolor='black' bgcolor='#F4F5F7'>";
      report+=" <th colspan='15' bgcolor='black'><center><b><font color='white'>LAWYER DETAILS</font></center></th>";
       report+="<tr rowspan='4'></tr>";
          
     report+="<tr><td><span class=Title>";
     if(request.getParameter("status")!=null)
					  {
                           report+="<strong><font color=red>"+request.getParameter("status")+"</font></strong>";
                      }
                      
      report+="</center></td></tr> <tr><td>Lawyer Name </td> <td>Bar Reg.Date</td><td>Qualification</td><td>Photo</td><td>Address </td><td>Phone No</td> <td>Email-Id</td> <td>LawType Name </td></tr>";    
                  
         %> 
         
    <tr>         
    <td>Lawyer Name </td>
     <td>Bar Reg.Date</td>
     <td>Qualification</td>
     <td>Photo</td>
      <td>Address </td>
     <td>Phone No</td>
     <td>Email-Id</td>
      <td>LawType Name </td></tr>   
         <% while(em.hasMoreElements()){
             lawyermodel=(LawyerModel)em.nextElement();
             
            report+="<tr><td value="+lawyermodel.getLawyerid()+">"+lawyermodel.getLawyerfstname()+"</td>";

         report+="<td>"+lawyermodel.getLawyerbarregdate()+"</td>"; 
         report+="<td>"+lawyermodel.getLawyerqualification()+"</td>";
          report+="<td><img src='userimages/"+lawyermodel.getLawyerid()+".gif' height=20 width=20></td>";
         report+="<td>"+lawyermodel.getLawyeraddress()+"</td>"; 
         report+="<td>"+lawyermodel.getLawyerphno()+"</td>";
         report+="<td>"+lawyermodel.getLawyeremail()+"</td>"; 
         report+="<td value="+lawyermodel.getLawyertypeid()+">"+lawyermodel.getLawtypename()+"</td></tr>"; 
          session.setAttribute("Report",report);    
         %>
        <tr> 
        
   <td><a href="SeeLawyerDetails.jsp?lawyerid=<%=lawyermodel.getLawyerid()%>"><%=lawyermodel.getLawyerfstname() %> </a></td>

         <td> <%=lawyermodel.getLawyerbarregdate()%></td> 
         <td><%=lawyermodel.getLawyerqualification()%></td>
          <td><img src="userimages/<%=lawyermodel.getLawyerid() %>.gif" height=30 width=50></td>
         <td> <%=lawyermodel.getLawyeraddress()%></td> 
         <td><%=lawyermodel.getLawyerphno()%></td>
         <td><%=lawyermodel.getLawyeremail()%></td> 
         <td value="<%=lawyermodel.getLawyertypeid()%>"><%=lawyermodel.getLawtypename() %></td>
         </tr>
        <%             
         } }catch(Exception e){e.printStackTrace();}        
        %>  
      </table></td></tr></table>
</form>
<script>

<%--var frmvalidator  = new Validator("addlawyer");--%>
<%--    --%>
<%--  frmvalidator.addValidation("lawyerfstname","req","Please Enter Lawyer Name");--%>
<%--  frmvalidator.addValidation("lawyerbarregdate","req","Please Enter Lawyer BAR Registration Date");--%>
<%--  frmvalidator.addValidation("lawyerqualification","req","Please Enter Lawyer Qualification");  --%>
<%--  frmvalidator.addValidation("lawyerphoto","req","Please Enter Lawyer Photo");--%>
<%--  frmvalidator.addValidation("lawyeraddress","req","Please Enter Lawyer Address");--%>
<%--  frmvalidator.addValidation("lawyerphno","req","Please Enter Lawyer Phoneno");  --%>
<%--  frmvalidator.addValidation("lawyeremailid","req","Please Enter Lawyer E-MailID");--%>
<%--  frmvalidator.addValidation("lawyertypename","dontselect=0");--%>
<%--  --%>
<%--  --%>
</script>
          </td>
        <td width="5%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="3">&nbsp;</td>
  </tr>
  
    
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
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  
 <tr>
    <td height="25" colspan="2" bgcolor="#0D4961" align="center"><font color="#ffffff"><span class="style1">&copy;All rights reserved</span></font></td>
  </tr>
</table>
</body>
</html>
