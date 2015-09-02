
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.CaseRegistrationDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.CaseRegistrationModel"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
function checkfuturedate() {

var temp = document.addcasehearing;

var start_date = temp.nexthearingdate.value; 
  
// Break up the start date - using the delimiter "/" - into an array of strings  
start_date = start_date.split("-"); 
  
// Access each element in the array. 
year = start_date[2];  
month = start_date[1]; 
day = start_date[0];  
   
/// Some basic date validation /// 
// did they enter number?  
if (isNaN(day) || isNaN(month) || isNaN(year)) { 
   alert("Invalid number. Please ensure the day, month and    year are valid numbers.");  
   return false;  
} 
  
// check month range 
if (month < 1 || month > 12) {  
   alert("Invalid Month. Please ensure that the month is    between 1 and 12 inclusive.");  
   return false;  
} 
  
// check day range 
if (day < 1 || day > 31) {  
   alert("Invalid Day. Please ensure that the day is between    1 and 31 inclusive.");  
   return false;  
} 
  
// check day/month combination 
if ((month==4 || month==6 || month==9 || month==11) && day==31) { 
   alert("Invalid Day/Month combination. Please ensure that    you have a valid day/month combination."); 
   return false; 
} 
   
// check for february 29th 
if (month == 2) {  
   var isleap = (year % 4 == 0 && (year % 100 != 0 || year %    400 == 0)); 
   if (day>29 || (day==29 && !isleap)) {  
      alert("Invalid Day. This year is not a leap year.       Please enter a value less than 29 for the day."); 
      return false; 
   } 
} 


  
// Set the start date using the Date object and pass it our date parameters. 
// NOTE: when passing the month as a number, remember that the array starts at 0. // So Jan = 0, Feb = 1 ... Dec = 11 
var sDate = new Date(year,month-1,day);  
  
// get the current date based on client's computer clock 
var today = new Date();  
  
// what is the difference between the start date and today's date 
diff = sDate-today; 
  
// get the difference in days 
diff1 = Math.ceil(diff/1000/60/60/24); 
  
if ((diff1) <0) { 
   alert("Invalid Start Date. Please specify a date that is    in the future and not the past.");  
   return false; 
} 
  
// the date is valid!!!  
else
 //alert("It Is Correct."); 

return true; 
}
function inDate(){

  var date=new Date();
  document.addcasehearing.hearingdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}
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
	<jsp:include page="adminoptions.html"/></td>
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
          
        </table></td>
        <td width="78%" align="left" valign="top"><br />
        <form name="addcasehearing" action="./AddCaseHearingAction" method="post" onSubmit="return validate()" >     
<table width=430 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="430" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="black"><center><b><font color="white">CASE HEARING DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
       <tr></tr><tr></tr>
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> </td></tr>
     
     <tr>
      <td>Case ID</td>
      <td><select  name="caseid" value="">
      <option value="">-Select-</option>
      <% 
         CoreHash ch1=new CaseRegistrationDAO().getCaseID();
         Enumeration em1=ch1.elements();
          CaseRegistrationModel caseregmodel=null;
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
      
      <tr>
      <td>Hearing Date</td>
      <td><input type="text" name="hearingdate" onfocus="inDate()" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>Hearing Result</td>
      <td><textarea rows=3 columns=3  name="hearingresult" value=""></textarea>
      </td>
      </tr>
      
      <tr>
      <td>Next Hearing Date</td>
      <td><input type="text" name="nexthearingdate"  onblur="checkfuturedate() "/>     
      <span ><sup><font color="red">(DD-MM-YY)Format Only *</font></sup></span></td>      

      </tr>
      
      <tr>
      <td>Any Special Instruction</td>
      <td><textarea rows=3 columns=3 type=text name="anyspecialinstruction" value=""></textarea>
      
      </td>
      </tr>
      
      
      <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr>
      <td colspan="2"><center><input type="submit" name="submit" value="Add"/>
      <input type="reset" name="reset" value="Clear"></center></td>
      </tr>
      </table></td></tr></table>
</form>
<script>

var frmvalidator  = new Validator("addcasehearing");
    
  frmvalidator.addValidation("caseid","dontselect=0");
  frmvalidator.addValidation("hearingdate","req","Please Enter Hearing Date");
  frmvalidator.addValidation("hearingresult","req","Please Enter Hearing Result");  
  frmvalidator.addValidation("nexthearingdate","req","Please Enter Next Hearing Date");
  frmvalidator.addValidation("anyspecialinstruction","req","Please Enter Any Special Instruction");
  
  
</script>
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
