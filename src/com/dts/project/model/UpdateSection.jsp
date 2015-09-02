<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        <form name="updatesection" action="./" method="post" onSubmit="return validate()" >     
<table align="center" WIDTH="430" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="#3179c8"><center><b><font color="white">SECTION DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
       
     
      
      <tr>
      <td>Actual Section Number</td>
      <td><input type="text" name="sectionno" value=""/>
      </td>
      </tr>
      
      
      
      <tr>
      <td>Section Description</td>
      <td><input type="text" name="sectiondesc" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>Type Of Law Name</td>
      <td><select name="lawtypename" >
      </select>
      </td>
      </tr>
      
      
      <tr>
      <td>Section Commence Date</td>
      <td><input type="text" name="sectioncommencedate" value=""/>
      </td>
      </tr>
      
       <tr>
      <td>Section Active State</td>
      <td><input type="text" name="sectionactivestate" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Section or SubSection Bit</td>
      <td><input type="text" name="subsectionbit" value=""/>
      </td>
      </tr>
      
      <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr>
      <td colspan="2"><center><input type="submit" name="submit" value="Add"/>
      <input type="reset" name="reset" value="Clear"></center></td>
      </tr>
      </table>
</form>
<script>

var frmvalidator  = new Validator("updatesection");
  frmvalidator.addValidation("sectionno","req","Please Enter Section Number");  
  frmvalidator.addValidation("sectiondesc","req","Please Enter Section Description");
  frmvalidator.addValidation("lawtypename","dontselect=0");
  frmvalidator.addValidation("sectioncommencedate","req","Please Section Commence Date");  
  frmvalidator.addValidation("sectionactivestate","req","Please Enter Section Active State");
  frmvalidator.addValidation("subsectionbit","req","Please Enter Section/SubSection Bit");
  
  
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
