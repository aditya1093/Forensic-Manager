
<%@page import="com.dts.project.model.UserModel"%>
<%@page import="com.dts.project.dao.UserDAO"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <td colspan="2" bgcolor="#5C743D"><img src="images/mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
  </tr>

 <tr>
    <td valign="top" bgcolor="#F4FFE4"><table width="100%" border="0">
      <tr>
        <td width="17%"><table width="165" border="0" cellpadding="0" cellspacing="0" bgcolor="#0E4C65" id="navigation">
         
        </table></td>
        <td width="78%" align="left" valign="top"><br />
        <form name="updateuser" action="./UpdateUserAction" onSubmit="return validate()" method="post" >     
<table align="center" WIDTH="430" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="#3179c8"><center><b><font color="white">UPDATE USERS DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
       
     <tr>
    <td width="212"><span class="style3"><strong>User Name</strong></span> </td>
     <% 
   UserModel umodel=null;
      String user=(String)session.getAttribute("user");
       umodel=new UserDAO().getUserID(user);
       session.setAttribute("umodel",umodel);
   %>
    <td><input type="hidden" name="uid" value="<%=umodel.getUserid()%>"/>
    <input type="text" name="username" value="<%=umodel.getUsername()%>"/>
    
    </td>
  </tr>
    
      <tr>
      <td>PassWord </td>
      <td><input type="password" name="password" value="<%=umodel.getPassword()%> "  />
      </td>
      </tr>
      
      <tr>
      <td>First Name</td>
      <td><input type="text" name="firstname" value="<%=umodel.getFirstname()%>" readonly size="20"  STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;"/>
      </td>
      </tr>
      
      
      <tr>
      <td>Middle Name</td>
      <td><input type="text" name="middlename" value="<%=umodel.getMiddlename()%>" readonly size="20"  STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;"/>
      </td>
      </tr>
      
      <tr>
      <td>Last Name</td>
      <td><input type="text" name="lastname" value="<%=umodel.getLastname()%>" readonly size="20"  STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;"/>
      </td>
      </tr>
      
       <tr>
      <td>Date Of Birth </td>
      <td><input type="text" name="dob" value="<%=umodel.getDateofbirth()%>" readonly size="20"  STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;"/>
           </tr>
      
      <tr>
      <td>Date Of Registration </td>
      <td><input type="text" name="dor" value="<%=umodel.getDateofreg()%>" readonly size="20"  STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;"/>    
   
      </tr>
      
      
      
      <tr>
      <td>Address</td>
      <td><textarea columns="2" rows="2" name="address"><%=umodel.getAddress()%></textarea>
      </td>
      </tr>
      
      
       <tr>
      <td>Phone No</td>
      <td><input type="text" name="phoneno" onBlur="ValidatePnoneNumber()" value="<%=umodel.getPhno()%>"/>
      </td>
      </tr>
      
      <tr>
      <td>E-MailID</td>
      <td><input type="text" name="mailid" onBlur="checkMailId(updateuser.mailid.value)"  value="<%=umodel.getMailid()%>"/>
      </td>
      </tr>
      
      
      <tr>
      <td>PhotoGraph </td>
      <td><input type="file" name="photo" "/><%=umodel.getPhoto()%>
      </td>
      </tr>
      
      
      
      <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr>
      <td colspan="2"><center><input type="submit" name="submit" value="Update"/>
      <input type="reset" name="reset" value="Clear"></center></td>
      </tr>
      </table>
</form>
<script>

var frmvalidator  = new Validator("updateuser");
   frmvalidator.addValidation("username","req","Please Enter User Name");
  
  frmvalidator.addValidation("firstname","req","Please Enter First Name");
  frmvalidator.addValidation("middlename","req","Please Enter Middle Name Value");
  frmvalidator.addValidation("lastname","req","Please Enter Last Nmae");
  frmvalidator.addValidation("password","req","Please Enter Password ");
  frmvalidator.addValidation("logintype","dontselect=0");
  frmvalidator.addValidation("address","req","Please Enter Address");
  frmvalidator.addValidation(" phoneno","req","Please Enter Maximum Value");
  frmvalidator.addValidation(" mailid","req","Please Enter Installment");  
  frmvalidator.addValidation("photo","req","Please Enter PhotoGraph ");
  
  
</script>
        
        
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
