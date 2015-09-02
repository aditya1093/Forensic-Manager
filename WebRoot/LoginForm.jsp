<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_health_nutr.css" type="text/css" />
<link rel="stylesheet" href="css/input.css" type="text/css" />



 <script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
 <script language="JavaScript1.1" src="scripts/gen_validatorv31.js"></script>
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



<%--<script language="JavaScript" type="text/javascript">--%>
<%--function validate()--%>
<%--{--%>
<%--alert('validation ');--%>
<%--   var temp = document.register;--%>
<%--   if(temp.username.value=="" || temp.password.value=="")--%>
<%--   {--%>
<%--       alert("All Fields are manditory");--%>
<%--       return false;--%>
<%--   }--%>
<%--   if(temp.ch.checked && temp.ownquest.value=="")--%>
<%--   {--%>
<%--       alert("All Fields are manditory");--%>
<%--       return false;--%>
<%--   }--%>
<%--   return true;--%>
<%--   alert('validation ');--%>
<%--}--%>
<%----%>
<%--</script>--%>
<script type="text/javascript">

function inDate(){

  var date=new Date();
  document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  document.getElementById('exprId').innerHTML=0;
}
function offDate(){

var day=document.forms.register.elements("day");
var dayvalue=day.options[day.selectedIndex].value;
var month=document.forms.register.elements("month");
var monthvalue=month.options[month.selectedIndex].value;
var year=document.forms.register.elements("year");
var yearvalue=year.options[year.selectedIndex].value;

 var append1=dayvalue+"-"+monthvalue+"-"+yearvalue;

 var append=append1.split("-");

born = new Date(bD[2], bD[1]*1-1, bD[0]);
years = Math.floor((now.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));

 if(years>21){
 document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();;
}
 else{
   document.register.doj.value="";
   alert('Date Of Join Must Be Greater Then 21');
   
 }
<%--  var date=new Date();--%>
<%--  var checkdate=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();--%>
<%--      bD=checkdate.split("-");--%>
<%--      --%>
<%--      born = new Date(bD[2], bD[1]*1-1, bD[0]);--%>
<%--	  years = Math.floor((date.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));--%>
<%--  if(years>21){--%>
<%--  document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();--%>
<%--  document.getElementById('exprId').innerHTML=0;--%>
<%--  }--%>
<%--  else{--%>
<%--  alert ('Date Of Join Must Be Greater Than 21');--%>
<%--  }--%>
}

function calAgeTo(){

  var day=document.forms.register.elements("day");
var dayvalue=day.options[day.selectedIndex].value;
var month=document.forms.register.elements("month");
var monthvalue=month.options[month.selectedIndex].value;
var year=document.forms.register.elements("year");
var yearvalue=year.options[year.selectedIndex].value;

 var append=dayvalue+"-"+monthvalue+"-"+yearvalue;

 
 now = new Date()
 bD = append.split('-');

 if(bD.length!=3){
   alert('Date Is Not Valid'); 
  document.getElementById('AgeId').innerHTML="";
  
 }
 else if(bD.length==3){
	 	born = new Date(bD[2], bD[1]*1-1, bD[0]);
	  years = Math.floor((now.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));
    
   document.getElementById('AgeId').innerHTML=years; 
 }
}
function DOBcalc() {

<%--if(!register.doj.value==""){--%>
<%--  var DOjmdy = (register.doj.value).split('-'); --%>
<%--  Bjdate = new Date(DOjmdy[2],DOjmdy[0]-1,DOjmdy[1]); --%>
<%--  var bb=Bjdate.getFullYear();--%>
<%--  var DOBmdy = (register.dobirth.value).split('-'); --%>
<%--  --%>
<%--  Bdate = new Date(DOBmdy[2],DOBmdy[0]-1,DOBmdy[1]); --%>
<%--  var bDate=Bdate.getFullYear();--%>
<%--   var AgeValue=21;--%>
<%--    var Final=bb-AgeValue;--%>
<%--    if(Final>=bDate){}--%>
<%--	else{--%>
<%--  alert('Check The Joining Date Plz\n Must Be Greater Than ');--%>
<%--  --%>
<%--  }--%>
<%--  	}--%>
var date=new Date();
register.doj.value=date;

}
function disEnable(){
  register.hQual.disabled=false;
}
</script>

<style type="text/css">

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
<jsp:include page="useroptions.html"/></td>
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
          
         
          <p> <marquee behavior="scroll" direction="up" style="padding: 200px 0pt;">
            <img src="images/images9.jpg" width="150" height="200" alt="smile" scrollamount="3" /><br/>
             <img src="images/images10.jpg" width="150" height="200" alt="smile" scrollamount="5"/><br/>
             <img src="images/images11.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images12.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images13.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images14.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images15.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images16.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images17.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images18.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images19.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images20.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images21.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images22.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             <img src="images/images23.jpg" width="150" height="200" alt="smile" scrollamount="3"/><br/>
             
          </marquee></p>
          

          </tr>
         
        </table></td>
        <td width="78%" align="left" valign="top"><br />
        
        
        
      <form name="register"  action="./LoginAction" method="post"  onSubmit="return validate()">        
     
     <table width=330 align=center border=2 bordercolor=red ><tr><td>  <table cellpadding="2px" cellspacing="1px" bgcolor="#F4F5F7" width="400px" class="tableBorder" align="center">
    <tr>
        <td colspan="2" bgcolor="#0066FF">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2" class="label">&nbsp;</td>
    </tr>
    
    <tr>
        <td align="center" colspan="2">
            <img src="images/arrow.png" border="0" align="absbottom"/>&nbsp;
            <span class="message">Login  Panel</span>
        </td>
    </tr> 
    <tr>
    <td>
     <center>  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%></center>
    </td>
    </tr>                  
    <tr>
        <td colspan="2" class="label">&nbsp;</td>
    </tr>
    <tr>
        
        <td class="label" align="right" width="40%">User Name:</td>
        <td align="left" width="60%"><input type="text" name="username" maxlength="40"/>
        <span class="message"></span></td>
    </tr>
    <tr>
        
        <td class="label" align="right">PassWord:</td>
        <td align="left"><input type="password" name="password" maxlength="40" /></td>
    </tr>
    
    <tr>
        <td class="label" align="right">&nbsp;</td>
        <td align="left"><input type="submit" name="submit" value="Login" /></td>
    </tr>  
                     
    <tr>
        <td colspan="2" class="label">&nbsp;</td>
    </tr>                   
</table></td></tr></table>
 

  
</form>
<script>

var frmvalidator  = new Validator("register");  
  frmvalidator.addValidation("username","req","Please Enter User Name");
  frmvalidator.addValidation("password","req","Please Enter Password"); 
  
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