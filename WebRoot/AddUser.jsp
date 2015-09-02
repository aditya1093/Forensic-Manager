<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js"></script>
 <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>
 
<script language="JavaScript" type="text/javascript">

function inDate(){

  var date=new Date();
  document.adduser.dor.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
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

<script>
//var x_win = window.self; 

function goOn() {
var port=document.adduser.port.value;
var host=document.adduser.host.value;
var username=document.adduser.username.value;
window.location.href='http://'+host+':'+port+'/LegalManagementSystem/ChekUserAction?username='+username;

} 
function trim(str){
while(str.chatAt(str.length-1)==" ")
str=str.substring(0,str.length-1);
while(str.chatAt(0)==" ")
str=str.substring(1,str.length);

return str;
}



  
  function checkUserName(){
  var temp = document.adduser;
  
 if ( temp.username.value.length <5 || temp.username.value.length >20) {
  alert(" a username should contain between 8 and 20 character");
       
        return false;
  } 
  return true;
  }
  
  
  function checkPass(){
  var temp = document.adduser;
   if (temp.password.value.length <5 || temp.password.value.length >25) {
  alert("a password should contain between 5  and  25 character");
    
    return false;
  } 
  return true;
   }
   
   
</script>



<script language=javascript>
function checkMailId(mailids)
{
var arr = new Array('.com','.net','.org','.biz','.coop','.info','.museum','.name','.pro'
,'.edu','.gov','.int','.mil','.ac','.ad','.ae','.af','.ag','.ai','.al',
'.am','.an','.ao','.aq','.ar','.as','.at','.au','.aw','.az','.ba','.bb',
'.bd','.be','.bf','.bg','.bh','.bi','.bj','.bm','.bn','.bo','.br','.bs',
'.bt','.bv','.bw','.by','.bz','.ca','.cc','.cd','.cf','.cg','.ch','.ci',
'.ck','.cl','.cm','.cn','.co','.cr','.cu','.cv','.cx','.cy','.cz','.de',
'.dj','.dk','.dm','.do','.dz','.ec','.ee','.eg','.eh','.er','.es','.et',
'.fi','.fj','.fk','.fm','.fo','.fr','.ga','.gd','.ge','.gf','.gg','.gh',
'.gi','.gl','.gm','.gn','.gp','.gq','.gr','.gs','.gt','.gu','.gv','.gy',
'.hk','.hm','.hn','.hr','.ht','.hu','.id','.ie','.il','.im','.in','.io',
'.iq','.ir','.is','.it','.je','.jm','.jo','.jp','.ke','.kg','.kh','.ki',
'.km','.kn','.kp','.kr','.kw','.ky','.kz','.la','.lb','.lc','.li','.lk',
'.lr','.ls','.lt','.lu','.lv','.ly','.ma','.mc','.md','.mg','.mh','.mk',
'.ml','.mm','.mn','.mo','.mp','.mq','.mr','.ms','.mt','.mu','.mv','.mw',
'.mx','.my','.mz','.na','.nc','.ne','.nf','.ng','.ni','.nl','.no','.np',
'.nr','.nu','.nz','.om','.pa','.pe','.pf','.pg','.ph','.pk','.pl','.pm',
'.pn','.pr','.ps','.pt','.pw','.py','.qa','.re','.ro','.rw','.ru','.sa',
'.sb','.sc','.sd','.se','.sg','.sh','.si','.sj','.sk','.sl','.sm','.sn',
'.so','.sr','.st','.sv','.sy','.sz','.tc','.td','.tf','.tg','.th','.tj',
'.tk','.tm','.tn','.to','.tp','.tr','.tt','.tv','.tw','.tz','.ua','.ug',
'.uk','.um','.us','.uy','.uz','.va','.vc','.ve','.vg','.vi','.vn','.vu',
'.ws','.wf','.ye','.yt','.yu','.za','.zm','.zw');

var mai = mailids;
var val = true;
var beforeat="";
var afterat="";
var afterat2="";

var dot=mai.lastIndexOf(".");
var con=mai.substring(dot, mai.length);
con=con.toLowerCase();
con=con.toString();

for(var i=0;i<(arr.length);i++)
{
	if(con == arr[i])
	{
		val=true;
		break;
	}
	else
	{
		val=false;
	}
}

var att=mai.lastIndexOf("@");
beforeat=mai.substring(0,att);
beforeat=beforeat.toLowerCase();
beforeat=beforeat.toString();
var asci1=beforeat.charCodeAt(0);

afterat=mai.substring(att+1, dot);
afterat=afterat.toLowerCase();
afterat=afterat.toString();

afterat2=mai.substring(att+1, mai.length);
afterat2=afterat2.toLowerCase();
afterat2=afterat2.toString();

if(beforeat=="" || afterat=="" || beforeat.length>30)
	val=false;

if(afterat2.length>64 || afterat.length<2)
	val=false;

if((afterat.charCodeAt(0))==45 || (afterat.charCodeAt(afterat.length-1))==45)
	val=false;

if(val==true)
{
	if(asci1 > 47 && asci1 < 58)
		val=false;
		
	if(asci1 < 48 || asci1 > 57)
	{
		for(var i=0; i<=beforeat.length-1; i++)
		{
			var asci2=beforeat.charCodeAt(i);
			if((asci2<=44 || asci2==47) || (asci2>=58 && asci2<=94) || (asci2==96) || (asci2>=123 && asci2<=127))
			{
				val=false;
				break;
			}
		}
		
		for(var j=0; j<=afterat.length-1; j++)
		{
			var asci3=afterat.charCodeAt(j);
			if((asci3<=44) || (asci3==46) || (asci3==47) || (asci3>=58 && asci3<=96) || (asci3>=123 && asci3<=127))
			{
				val=false;
				break;
			}
		}	
	}
}

if(val==false)
{
	alert("Your maild "+mai+" is not valid");
	return false;
}
else
{
	return true;
}
}
</script>
<script language = "Javascript">
/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 10;

function isInteger(s)
{   var i;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (c != " ") returnString += c;
    }
    return returnString;
}
function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
var bracket=3
strPhone=trim(strPhone)
if(strPhone.indexOf("+")>1) return false
if(strPhone.indexOf("-")!=-1)bracket=bracket+1
if(strPhone.indexOf("(")!=-1 && strPhone.indexOf("(")>bracket)return false
var brchr=strPhone.indexOf("(")
if(strPhone.indexOf("(")!=-1 && strPhone.charAt(brchr+2)!=")")return false
if(strPhone.indexOf("(")==-1 && strPhone.indexOf(")")!=-1)return false
s=stripCharsInBag(strPhone,validWorldPhoneChars);
return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function ValidatePnoneNumber(){

	var Phone=document.adduser.phoneno;
	
	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
		Phone.value=""
		Phone.focus()
		return false
	}
	return true
 }
</script>
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
          
        </table></td>
        <td width="78%" align="left" valign="top"><br />
        <form name="adduser" action="./AddUserAction" method="post" onSubmit="return validate()" >     
<table width=430 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="430" border="1" bordercolor="black" bgcolor="#F4F5F7">
    
     <input type="hidden" name="port" value="<%=request.getLocalPort() %>"/>
 <input type="hidden" name="host" value="<%=request.getServerName() %>"/>
    
      <th colspan="2" bgcolor="black"><center><b><font color="white">USERS DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
      <tr><td><span class=Title>
    <%if(request.getParameter("status1")!=null)out.print(request.getParameter("status1"));    %> </span> </td></tr>
     
     <tr>
    <td><span class=Title>    User Name</span></td>
    <td width="303"><input type="text" name="username" value="<%if(request.getParameter("username")!=null)
    out.print(request.getParameter("username")); %>" size="20" onBlur="goOn(),checkUserName()"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class=Title>
    <%if(request.getParameter("status")!=null)
        out.print(request.getParameter("status"));    %>
        </span>
    </td>
</tr>
     
      <tr>
      <td>PassWord </td>
      <td><input type="password" name="password" onfocus="checkPass()" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>First Name</td>
      <td><input type="text" name="firstname" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>Middle Name</td>
      <td><input type="text" name="middlename" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Last Name</td>
      <td><input type="text" name="lastname" value=""/>
      </td>
      </tr>
      
       <tr>
      <td>Date Of Birth </td>
      <td>
      
    <SELECT name=cday size=1 > 
          <OPTION selected value="00">DD</OPTION> 
          <OPTION  value="01">01</OPTION> 
          <OPTION value="02">02</OPTION> 
          <OPTION value="03">03</OPTION> 
          <OPTION value="04">04</OPTION> 
          <OPTION value="05">05</OPTION> 
          <OPTION value="06">06</OPTION> 
          <OPTION value="07">07</OPTION> 
          <OPTION value="08">08</OPTION> 
          <OPTION value="09">09</OPTION> 
          <OPTION value="10">10</OPTION> 
          <OPTION value="11">11</OPTION> 
          <OPTION value="12">12</OPTION> 
          <OPTION value="13">13</OPTION> 
          <OPTION value="14">14</OPTION> 
          <OPTION value="15">15</OPTION> 
          <OPTION value="16">16</OPTION> 
          <OPTION value="17">17</OPTION> 
          <OPTION value="18">18</OPTION> 
          <OPTION value="19">19</OPTION> 
          <OPTION value="20">20</OPTION> 
          <OPTION value="21">21</OPTION> 
          <OPTION value="22">22</OPTION> 
          <OPTION value="23">23</OPTION> 
          <OPTION value="24">24</OPTION> 
          <OPTION value="25">25</OPTION> 
          <OPTION value="26">26</OPTION> 
          <OPTION value="27">27</OPTION> 
          <OPTION value="28">28</OPTION> 
          <OPTION value="29">29</OPTION> 
          <OPTION value="30">30</OPTION> 
          <OPTION value="31">31</OPTION> 
        </SELECT> 
        <SELECT name=cmonth size=1> 
          <OPTION selected value="00">MM</OPTION> 
          <OPTION  value="01">Jan</OPTION> 
          <OPTION value="02">Feb</OPTION> 
          <OPTION value="03">Mar</OPTION> 
          <OPTION value="04">Apr</OPTION> 
          <OPTION value="05">May</OPTION> 
          <OPTION value="06">Jun</OPTION> 
          <OPTION value="07">Jul</OPTION> 
          <OPTION value="08">Aug</OPTION> 
          <OPTION value="09">Sep</OPTION> 
          <OPTION value="10">Oct</OPTION> 
          <OPTION value="11">Nov</OPTION> 
          <OPTION value="12">Dec</OPTION> 
        </SELECT> 
        <SELECT name=cyear size=1 > 
          <OPTION selected value="0000">YYYY</OPTION> 
          <OPTION value="1901">1901</OPTION> 
          <OPTION value="1902">1902</OPTION> 
          <OPTION value="1903">1903</OPTION> 
          <OPTION value="1904">1904</OPTION> 
          <OPTION value="1905">1905</OPTION> 
          <OPTION value="1906">1906</OPTION> 
          <OPTION value="1907">1907</OPTION> 
          <OPTION value="1908">1908</OPTION> 
          <OPTION value="1909">1909</OPTION> 
          <OPTION value="1910">1910</OPTION> 
          <OPTION value="1911">1911</OPTION> 
          <OPTION value="1912">1912</OPTION> 
          <OPTION value="1913">1913</OPTION> 
          <OPTION value="1914">1914</OPTION> 
          <OPTION value="1915">1915</OPTION> 
          <OPTION value="1916">1916</OPTION> 
          <OPTION value="1917">1917</OPTION> 
          <OPTION value="1918">1918</OPTION> 
          <OPTION value="1919">1919</OPTION> 
          <OPTION value="1920">1920</OPTION> 
          <OPTION value="1921">1921</OPTION> 
          <OPTION value="1922">1922</OPTION> 
          <OPTION value="1923">1923</OPTION> 
          <OPTION value="1924">1924</OPTION> 
          <OPTION value="1925">1925</OPTION> 
          <OPTION value="1926">1926</OPTION> 
          <OPTION value="1927">1927</OPTION> 
          <OPTION value="1928">1928</OPTION> 
          <OPTION value="1929">1929</OPTION> 
          <OPTION value="1930">1930</OPTION> 
          <OPTION value="1931">1931</OPTION> 
          <OPTION value="1932">1932</OPTION> 
          <OPTION value="1933">1933</OPTION> 
          <OPTION value="1934">1934</OPTION> 
          <OPTION value="1935">1935</OPTION> 
          <OPTION value="1936">1936</OPTION> 
          <OPTION value="1937">1937</OPTION> 
          <OPTION value="1938">1938</OPTION> 
          <OPTION value="1939">1939</OPTION> 
          <OPTION value="1940">1940</OPTION> 
          <OPTION value="1941">1941</OPTION> 
          <OPTION value="1942">1942</OPTION> 
          <OPTION value="1943">1943</OPTION> 
          <OPTION value="1944">1944</OPTION> 
          <OPTION value="1945">1945</OPTION> 
          <OPTION value="1946">1946</OPTION> 
          <OPTION value="1947">1947</OPTION> 
          <OPTION value="1948">1948</OPTION> 
          <OPTION value="1949">1949</OPTION> 
          <OPTION value="1950">1950</OPTION> 
          <OPTION value="1951">1951</OPTION> 
          <OPTION value="1952">1952</OPTION> 
          <OPTION value="1953">1953</OPTION> 
          <OPTION value="1954">1954</OPTION> 
          <OPTION value="1955">1955</OPTION> 
          <OPTION value="1956">1956</OPTION> 
          <OPTION value="1957">1957</OPTION> 
          <OPTION value="1958">1958</OPTION> 
          <OPTION value="1959">1959</OPTION> 
          <OPTION value="1960">1960</OPTION> 
          <OPTION value="1961">1961</OPTION> 
          <OPTION value="1962">1962</OPTION> 
          <OPTION value="1963">1963</OPTION> 
          <OPTION value="1964">1964</OPTION> 
          <OPTION value="1965">1965</OPTION> 
          <OPTION value="1966">1966</OPTION> 
          <OPTION value="1967">1967</OPTION> 
          <OPTION value="1968">1968</OPTION> 
          <OPTION value="1969">1969</OPTION> 
          <OPTION value="1970">1970</OPTION> 
          <OPTION value="1971">1971</OPTION> 
          <OPTION value="1972">1972</OPTION> 
          <OPTION value="1973">1973</OPTION> 
          <OPTION value="1974">1974</OPTION> 
          <OPTION value="1975">1975</OPTION> 
          <OPTION value="1976">1976</OPTION> 
          <OPTION value="1977">1977</OPTION> 
          <OPTION value="1978">1978</OPTION> 
          <OPTION value="1979">1979</OPTION> 
          <OPTION value="1980">1980</OPTION> 
          <OPTION value="1981">1981</OPTION> 
          <OPTION value="1982">1982</OPTION> 
          <OPTION value="1983">1983</OPTION> 
          <OPTION value="1984">1984</OPTION> 
          <OPTION value="1985">1985</OPTION> 
          <OPTION value="1986">1986</OPTION> 
          <OPTION value="1987">1987</OPTION> 
          <OPTION value="1988">1988</OPTION> 
          <OPTION value="1989">1989</OPTION> 
          <OPTION value="1990">1990</OPTION> 
          <OPTION value="1991">1991</OPTION> 
          <OPTION value="1992">1992</OPTION> 
          <OPTION value="1993">1993</OPTION> 
          <OPTION value="1994">1994</OPTION> 
          <OPTION value="1995">1995</OPTION> 
          <OPTION value="1996">1996</OPTION> 
          <OPTION value="1997">1997</OPTION> 
          <OPTION value="1998">1998</OPTION> 
          <OPTION value="1999">1999</OPTION> 
          <OPTION value="2000">2000</OPTION> 
          <OPTION value="2001">2001</OPTION> 
          <OPTION value="2002">2002</OPTION> 
          <OPTION value="2003">2003</OPTION> 
          <OPTION value="2004">2004</OPTION> 
          <OPTION value="2005">2005</OPTION> 
          <OPTION value="2006">2006</OPTION> 
          <OPTION value="2007">2007</OPTION> 
          <OPTION value="2008">2008</OPTION> 
          
        </SELECT> 
        <span ><sup><font color="red"> *</font></sup></span>  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
           </tr>
      
      <tr>
      <td>Date Of Registration </td>
      <td><input type=text name="dor"  onfocus="inDate()" /></td>    
   
      </tr>
      
      
      <tr>
      <td>Address</td>
      <td><textarea columns="1" rows="1" name="address" ></textarea>
      </td>
      </tr>
      
      
       <tr>
      <td>Phone No</td>
      <td><input type="text" name="phoneno" onBlur="ValidatePnoneNumber()" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>E-MailID</td>
      <td><input type="text" name="mailid" onBlur="checkMailId(adduser.mailid.value)"  value=""/>
      </td>
      </tr>
      
      <tr>
      <td>PhotoGraph </td>
      <td><input type="file" name="photo" value=""/>
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

var frmvalidator  = new Validator("adduser");
frmvalidator.addValidation("username","req","Please Enter User Name");
  
  frmvalidator.addValidation("firstname","req","Please Enter First Name");
  frmvalidator.addValidation("middlename","req","Please Enter Middle Name Value");
  frmvalidator.addValidation("lastname","req","Please Enter Last Nmae");
  frmvalidator.addValidation("password","req","Please Enter Password ");
  frmvalidator.addValidation("dob","req","Please Enter Date Of Birth ");
  frmvalidator.addValidation("dor","req","Please Enter Date Of Registration ");
  frmvalidator.addValidation("address","req","Please Enter Address");
  frmvalidator.addValidation(" phoneno","req","Please Enter Phoneno");
  frmvalidator.addValidation(" mailid","req","Please Enter MailID");  
  frmvalidator.addValidation("photo","req","Please Enter PhotoGraph ");
  
  
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
