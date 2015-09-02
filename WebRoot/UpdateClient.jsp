
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.UserDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.UserModel"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
        
        <form name="updateclient" action="./" method="post" onSubmit="return validate()" >     
<table width=4300 align=center border=2 bordercolor=red><tr><td><table align="center" WIDTH="430" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="6" bgcolor="black"><center><b><font color="white">CLIENT DETAILS</font></center></th>
      <tr rowspan="5"></tr>
     <tr></tr><tr></tr>
     <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> </td></tr>
     
     
      <tr>
      <td> Client FirstName</td>
      <td><input type="text" name="firstname" value=""/>
      </td>
      
      <td>Client Middle Name</td>
      <td><input type="text" name="middlename" value=""/>
      </td>
      
      <td>ClientLastName</td>
      <td><input type="text" name="lastname" value=""/>
      </td>
      </tr>
      
     <tr>
      <td> ClientFatherFirst Name</td>
      <td><input type="text" name="cffirstname" value=""/>
      </td>
      
      <td>ClientFatherMiddle Name</td>
      <td><input type="text" name="cfmiddlename" value=""/>
      </td>
      
      <td>ClientFatherLast Name</td>
      <td><input type="text" name="cflastname" value=""/>
      </td>
      </tr>
      
     
      <tr>
      <td>DateOfBirth Of Client </td>
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
    
      <td>DateOfBirth Of Father </td>
      <td>
    <SELECT name=fday size=1 > 
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
        <SELECT name=fmonth size=1> 
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
        <SELECT name=fyear size=1 > 
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
        </td>
    
      
      <td>DateOfRegistration</td>
      <td><input type="text" name="dateofreg" onfocus="inDate()"/>
      </td>
      </tr>
      
      
       <tr>
      <td>User Name</td>
      <td><select name="username">
      <option value="">-Select-</option>
      <% CoreHash ch2=new UserDAO().getUserNames();
         Enumeration em2=ch2.elements();
          UserModel usermodel=null;
         while(em2.hasMoreElements()){
             usermodel=(UserModel)em2.nextElement();
         %>
         <option value="<%=usermodel.getUserid() %>"><%=usermodel.getUsername() %></option>
        <%             
         }         
        %>
      </select>
      </td>
      
      <td>E-MailID</td>
      <td><input type="text" name="mailid" onBlur="checkMailId(updateclient.mailid.value)"  value=""/>
      </td>
      </tr>
      <tr></tr><tr></tr>
  
  <tr></tr><tr></tr>
<th colspan="6" bgcolor="black"><center><span class=Title>Contact Details</span>
</center></th>
<tr></tr><tr></tr>
<tr>
    <td><pre><span class=Title>    Address Type </span></pre></td>
    <td><select name="addressType" onChange="cleartext()">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="home"><font size="3" face="Verdana">Home</font></option>
    <option value="office"><font size="3" face="Verdana">Office</font></option>
    <option value="personal"><font size="3" face="Verdana">Personal</font></option>
      </select>
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <span class=Title>   City</span>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="city" value="" size="20"/>
	  </td>
</tr>
<tr>
    <td><pre><span class=Title>    House No</span></pre></td>
    <td><input type="text" name="houseNo" value="" size="20"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class=Title>   State</span>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="state" value="" size="20"/>
    </td>
</tr>
<tr>
    <td><pre><span class=Title>    Street</span></pre></td>
    <td><input type="text" name="street" value="" size="20"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class=Title>   Country</span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="country" value="" size="20"/>
	</td>
</tr>
<tr>
    <td><pre><span class=Title>    Phone Type</span></pre></td>
    <td><select name="phoneType">
        <option value="select" selected="true"><font size="3" face="Verdana">Select</font></option>
        <option value="home"><font size="3" face="Verdana">Home</font></option>
        <option value="office"><font size="3" face="Verdana">Office</font></option>
        <option value="mobile"><font size="3" face="Verdana">Mobile</font></option>
    </select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=Title>   Pin</span>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="pin" value="" size="20" />
	</td>
	
</tr>
<tr>
    <td><pre><span class=Title>    Phone No</span></pre></td>
    <td><input type="text" name="phoneNo" value="" size="20" />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class=Title>   Land Mark</span>
&nbsp;&nbsp;&nbsp;
	<input type="text" name="landMark" value="" size="20" onblur="showStatus()"/>
	</td>
</tr>
<th colspan="5">&nbsp;</th>
<tr></tr><tr></tr>

<tr>
    <td width="100%" align="center" Colspan="5"><font size="3" face="Verdana">
    <input type="submit" name="register" value="Register"/>&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" name="cancel" value="Cancel"/>
    </font></td>
    
</tr>


  
<input type="hidden" name="homeaddresstype" value=""/>
<input type="hidden" name="homehouseno"/>
<input type="hidden" name="homestreet"/>
<input type="hidden" name="homephonetype" value=""/>
<input type="hidden" name="homecountry"/>
<input type="hidden" name="homepin"/>
<input type="hidden" name="homestate" value=""/>
<input type="hidden" name="homephoneno"/>
<input type="hidden" name="homecity"/>
<input type="hidden" name="homelandmark"/>



 <input type="hidden" name="officeaddresstype" value=""/>
<input type="hidden" name="officehouseno"/>
<input type="hidden" name="officestreet"/>
<input type="hidden" name="officephonetype" value=""/>
<input type="hidden" name="officecountry"/>
<input type="hidden" name="officepin"/>
<input type="hidden" name="officestate" value=""/>
<input type="hidden" name="officephoneno"/>
<input type="hidden" name="officecity"/>
<input type="hidden" name="officelandmark"/>



<input type="hidden" name="personaladdresstype" value=""/>
<input type="hidden" name="personalhouseno"/>
<input type="hidden" name="personalstreet"/>
<input type="hidden" name="personalphonetype" value=""/>
<input type="hidden" name="personalcountry"/>
<input type="hidden" name="personalpin"/>
<input type="hidden" name="personalstate" value=""/>
<input type="hidden" name="personalphoneno"/>
<input type="hidden" name="personalcity"/>
<input type="hidden" name="personallandmark"/>
</table>
<table align="center" height="100" width="100">
<tr>
<td>
<img src="images/off3.gif" id="ImgPreview" height="80" width="60"></img>
</td>
</tr>
</table></td></tr></table>
</form>
<script>

var frmvalidator  = new Validator("updateclient");
frmvalidator.addValidation("username","dontselect=0");
  
  frmvalidator.addValidation("firstname","req","Please Enter First Name");
  frmvalidator.addValidation("middlename","req","Please Enter Middle Name Value");
  frmvalidator.addValidation("lastname","req","Please   Enter Last Nmae");
  frmvalidator.addValidation("cffirstname","req","Please Enter Client Father First Name");
  frmvalidator.addValidation("cfmiddlename","req","Please Enter Client Father Middle Name Value");
  frmvalidator.addValidation("cflastname","req","Please Enter Client Father Last Nmae");
  
  frmvalidator.addValidation("dateofbirthclient","req","Please Enter Date Of Birth Of Client ");
  frmvalidator.addValidation("dateofbirthclientfarher","req","Please Enter Date Of Birth Of Client");
  frmvalidator.addValidation("dateofreg","req","Please Enter Registration Date");
  
  frmvalidator.addValidation("mailid","req","Please Enter E-Mailid");  
 
  
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
