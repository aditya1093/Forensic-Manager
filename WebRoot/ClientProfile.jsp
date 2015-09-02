
<%@page import="com.dts.project.model.EmployeesModel"%>
<%@page import="com.dts.project.dao.ClientDAO"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_health_nutr.css" type="text/css" />
<link rel="stylesheet" href="css/input.css" type="text/css" />
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
 <script type="text/javascript" src="scripts/image.js"> </script>
<script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>
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
    <td colspan="2" bgcolor="#5C743D"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td valign="top" bgcolor="#F4FFE4"><table width="100%" border="0">
      <tr>
        <td width="17%"><table width="165" border="0" cellpadding="0" cellspacing="0" bgcolor="#0E4C65" id="navigation">
         
        </table></td>
        <td width="78%" align="left" valign="top"><br />
         <form name="clientprofile" action=" " method="post" onSubmit="return validate()" >     
<table align="center" WIDTH="330" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="6" bgcolor="#3179c8"><center><b><font color="white">CLIENT DETAILS</font></center></th>
      <tr rowspan="5"></tr>
     <tr></tr><tr></tr>
     
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> </td></tr>
     
     <%
     //session.setAttribute("clientprofile",request.getParameter("id"));   
     EmployeesModel p=new ClientDAO().getClientProfile(Integer.parseInt(request.getParameter("id")));
     session.setAttribute("getClass",p);
 %>
  
      <tr>
      <td> Client FirstName</td>
      <td><input type="text" name="firstname" value="<%p.getFirstname(); %>"/>
      </td>
      
      <td>Client Middle Name</td>
      <td><input type="text" name="middlename" value="<%p.getSurname(); %>"/>
      </td>
      
      <td>ClientLastName</td>
      <td><input type="text" name="lastname" value="<%p.getLastname(); %>"/>
      </td>
      </tr>
      
     <tr>
      <td> ClientFatherFirst Name</td>
      <td><input type="text" name="cffirstname" value="<%p.getFatherfstname(); %>"/>
      </td>
      
      <td>ClientFatherMiddle Name</td>
      <td><input type="text" name="cfmiddlename" value="<%p.getFathermidname(); %>"/>
      </td>
      
      <td>ClientFatherLast Name</td>
      <td><input type="text" name="cflastname" value="<%p.getFatherlstname(); %>"/>
      </td>
      </tr>
      
     
      <tr>
      <td>DateOfBirth Of Client </td>
      <td>     
    <input type="text" name="dob" value="<%p.getClientdateofbirt(); %>"/></td>
    
      <td>DateOfBirth Of Father </td>
      <td>
    <input type="text" name="dor" value="<%p.getClientftherdateofbirt(); %>"/>
        </td>
    
      
      <td>DateOfRegistration</td>
      <td><input type="text" name="dateofreg" value="<%p.getDateofreg(); %>"/>
      </td>
      </tr>
      
      
       <tr>
      <td>User Name</td>
      <td><input type="text" name="username" value="<%p.getUsername(); %>"/>
      </td>
      
      
      <td>E-MailID</td>
      <td><input type="text" name="mailid" onBlur="checkMailId(addclient.mailid.value)"  value="<%p.getEmail(); %>"/>
      </td>
      </tr>
      <tr></tr><tr></tr>
  
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="#FFFFCC"><center><span class=Title>Contact Details</span>
</center></th>

<tr rowspan="3">
</tr>
  <tr>
    <td bgcolor="#FF9900"><div align="center">Address Type </div>      </td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">HouseNo</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">Street</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">City</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">State</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">Country</div></td>
    <td bgcolor="#E0FEFD"><div align="center" class="style16">PhoneNo</div></td>
  </tr>
<%if(p.getHome()!=null){ %>
  <tr>
    <td bgcolor="#FFFF99"><span class="style16">Home</span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getHno() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getStreet() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getCity() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getState() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getCountry() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getHomePhoneType() %></span></td>
  </tr>
<%}if(p.getOffice()!=null){ %> 
  <tr>
    <td bgcolor="#FFFF99"><span class="style16">Office</span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOhno() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOstreet() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOcity() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOstate() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOcountry() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getOfficePhoneType() %></span></td>
  </tr>
 <%}if(p.getContact()!=null){ %>
  <tr>
    <td bgcolor="#FFFF99"><span class="style16">Personal</span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getChno() %></span></td>
    <td bordercolor="#000000" bgcolor="#FFFFCC"><%=p.getCstreet() %><span class="style16"></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getCcity() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getCstate() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getCcountry() %></span></td>
    <td bgcolor="#FFFFCC"><span class="style16"><%=p.getPersonalPhoneType() %></span></td>
  </tr>
  <%} %>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  
</table>
        
          </td>
        <td width="5%">&nbsp;</td>
      </tr>
    </table></td>
    <td width="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="25" colspan="2" bgcolor="#0D4961"><span class="style1">&copy;All rights reserved</span></td>
  </tr>
</table>
</body>
</html>
