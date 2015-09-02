
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
			}		%></td>
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
        <form name="seelawyer" action="./UpdateLawyerAction" method="post" onSubmit="return validate()">     
<table width=600 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="600" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="black"><center><b><font color="white">LAWYER DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
       
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> 
    </td></tr>
       
       
                
                <%
                int lawyerid=Integer.parseInt(request.getParameter("lawyerid").trim());
                
               // String loginname=(String)session.getAttribute("user"); 

       try{
       
        String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");
       
      LawyerModel  lawyermodel=null;
       lawyermodel=new LawyerDAO().getLawyersDetails(imagestorepath1,lawyerid);
         
          
         %> 
         
         
        <tr>
    
    <input type="hidden" name="lawyerid" value="<%=lawyermodel.getLawyerid()%>" readonly />
    <td>Lawyer Name </td>
    <td><input type="text"  name="lawyername"  value="<%=lawyermodel.getLawyerfstname()%>" readonly /></td>
     </tr>
     
      <tr>    
    <td>BAR Reg.Date</td>
    <td><input type="text"  name="barregdate"  value="<%=lawyermodel.getLawyerbarregdate()%>" readonly /></td>
     </tr>
     
     <tr>    
    <td>Qualification</td>
    <td><input type="text"  name="qualification"  value="<%=lawyermodel.getLawyerqualification()%>" /></td>
     </tr>
    
    <tr>    
    <td>Lawyer Photo</td>
    <td><input type="file"  name="photo"   value="<%=lawyermodel.getLawyerid() %>.gif " /> <img src="userimages/<%=lawyermodel.getLawyerid() %>.gif" height=30 width=50></td>
     </tr>
    
     <tr>
    <td>Address</td>
    <td><input type="text" name="address" value="<%=lawyermodel.getLawyeraddress()%>"/></td>
    </tr>
    
<tr>
    <td>Phone No</td>
    <td><input type="text" name="phoneno" value="<%=lawyermodel.getLawyerphno()%>"/></td>
    </tr>
    
    <tr>
    <td>E-Mailid</td>
    <td><input type="text" name="emailid" value="<%=lawyermodel.getLawyeremail()%>"/></td>
    </tr>
    
    
    <tr>
    <input type="hidden" name="lawtypeid" value="<%=lawyermodel.getLawyertypeid()%>"/>
    <td>Law Type Name</td>
    <td><input type="text" name="lawtypename" readonly  value="<%=lawyermodel.getLawtypename()%>"/></td>
   </tr>
    

     
         
        
    <%}catch(Exception e)
{e.printStackTrace();}%> 
        
        
         <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr><td colspan="2"><center>
     
      <%if(role.equalsIgnoreCase("admin")){ %>  
      <input type="submit" name="submit" value="Update"/>
<%--      <input type="submit" name="submit" value="Delete"/>     --%>
<%--      <input type="reset"  name="reset"  value="Clear"/>    --%>
      <%}else{ %>   
     <input type="button"  name="Submit" value="Back" onclick="javascript:history.back(-1)"/>
<%} %>
</center></td></tr>

      </table></td></tr></table>
</form>

          </td>
        <td width="5%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="3">&nbsp;</td>
  </tr>
 <tr>
    <td height="25" colspan="2" bgcolor="#0D4961" align="center"><font color="#ffffff"><span class="style1">&copy;All rights reserved</span></font></td>
  </tr>
</table>
</body>
</html>
