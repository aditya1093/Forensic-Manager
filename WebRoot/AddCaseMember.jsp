
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
        <form name="addcasemember" action="./AddCaseMemberAction" method="post" onSubmit="return validate()" >     
<table width=430 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="430" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="2" bgcolor="black"><center><b><font color="white">CASE MEMBER DETAILS</font></center></th>
      <tr rowspan="5"></tr>
       
      <tr></tr><tr></tr>
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> </td></tr>
     
      
     <tr>
      <td>Case ID</td>
      <td><select  name="caseid" value="">
      <option value="">-Select-</option>
      <% CoreHash ch1=new CaseRegistrationDAO().getCaseID();
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
      <td>Member First Name</td>
      <td><input type="text" name="memberfstname" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>Member Middle Name</td>
      <td><input type="text" name="membermidname" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Member Last Name</td>
      <td><input type="text" name="memberlstname" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Member Type</td>
      <td><select name="membertype" >
      <option value="">-Select-</option>
      <option value="Respondent">Respondent</option>
      <option value="Defendent">Defendent</option>
      </select>
      </td>
      </tr>
      
      <tr>
      <td>Sequence Number</td>
      <td><input type="text" name="sequenceno" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Member Father First Name</td>
      <td><input type="text" name="memberffstname" value=""/>
      </td>
      </tr>
      
      
      <tr>
      <td>Member Father Middle Name</td>
      <td><input type="text" name="memberfmidname" value=""/>
      </td>
      </tr>
      
      <tr>
      <td>Member Father Last Name</td>
      <td><input type="text" name="memberflstname" value=""/>
      </td>
      </tr>
      
     
      
      <tr>
      <td>Address</td>
      <td><textarea rows=5 columns=5 name="address" value=""></textarea>
      </td>
      </tr>
      
      <tr>
      <td>Date Of Birth</td>
      
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
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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

var frmvalidator  = new Validator("addcasemember");
    
  frmvalidator.addValidation("caseid","dontselect=0");
  frmvalidator.addValidation("memberfstname","req","Please Enter Member First Name");
  frmvalidator.addValidation("membermidname","req","Please Enter Member Middle Name");  
  frmvalidator.addValidation("memberlstname","req","Please Enter Member Last Name");
  frmvalidator.addValidation("membertype","dontselect=0");
  frmvalidator.addValidation("sequenceno","req","Please Enter Sequence Number");  
  frmvalidator.addValidation("memberffstname","req","Please Enter Member Father First Name");
  frmvalidator.addValidation("memberfmidname","req","Please Enter Member Father Middle Name");
  frmvalidator.addValidation("memberflstname","req","Please Enter Member Father Last Name");  
  frmvalidator.addValidation("address","req","Please Enter Member Address");
  frmvalidator.addValidation("dateofbirth","dontselect=0");
  
  
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
