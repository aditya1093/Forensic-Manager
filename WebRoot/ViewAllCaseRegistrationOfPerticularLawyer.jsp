
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.project.dao.CaseTypeDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.model.CaseTypeModel"%>
<%@page import="com.dts.project.dao.ClientDAO"%>
<%@page import="com.dts.project.model.ClientModel"%>
<%@page import="com.dts.project.dao.CourtDAO"%>
<%@page import="com.dts.project.model.CourtModel"%>
<%@page import="com.dts.project.dao.LawyerDAO"%>
<%@page import="com.dts.project.model.LawyerModel"%>
<%@page import="com.dts.project.dao.SectionDAO"%>
<%@page import="com.dts.project.model.SectionModel"%>
<%@page import="com.dts.project.dao.EvidenceTypeDAO"%>
<%@page import="com.dts.project.model.EvidenceTypeModel"%>
<%@page import="com.dts.project.dao.CaseRegistrationDAO"%>
<%@page import="com.dts.project.model.CaseRegistrationModel"%>
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
function inDate(){

  var date=new Date();
  document.addcaseregistration.caseregistrationdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}


function inDate2(){

  var date=new Date();
  document.addcaseregistration.lawyeracceptdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}
function inDate3(){

  var date=new Date();
  document.addcaseregistration.evidenceregdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}
function inDate4(){

  var date=new Date();
  document.addcaseregistration.nexthearingdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}

function inDate5(){

  var date=new Date();
  document.addcaseregistration.caseregistrationdate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  
}
function checkfuturedate() {

var temp = document.addcaseregistration;

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
 alert("It Is Correct."); 

return true; 
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
<table width="103%" border="1" cellspacing="0" cellpadding="0">
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
        <td width="17%"><br /></td>
        <td width="78%" align="left" valign="top"><br />
        <form name="viewcaseregistration" action="" method="post" onSubmit="return validate()" > 
        
       
            
<table align="center" WIDTH="800" border="1" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="38" bgcolor="black"><br /></th>
      <tr></tr>
       
       <tr></tr><tr></tr>
     
     <tr><td><div align="center"><h4><font color="#ff0080" face="Verdana"><strong><span class="Title"> 
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span></strong></font></h4></div> 
    <br /></td></tr>  
       
       
                <%
                String loginname=(String)session.getAttribute("user");
                
                LawyerModel  lawyermodel=null;
         
         String imagestorepath1=getServletContext().getRealPath("/images");
String audiostorepath1=getServletContext().getRealPath("/Audio");
String vediostorepath1=getServletContext().getRealPath("/Video");
            lawyermodel=new LawyerDAO().getLawyersProfile(imagestorepath1,loginname);
           int lawyerid=lawyermodel.getLawyerid();
                 


       try{
       CoreHash ch=new CaseRegistrationDAO().getAllCaseRegistrationOfPerticularLawyer(imagestorepath1,audiostorepath1,vediostorepath1,lawyerid);
         Enumeration em=ch.elements();
         System.out.println("in View Advertise Details-->");
          CaseRegistrationModel  caseregmodel=null;
          
          //CoreHash ch1=new SectionDAO().getSectionsOfPerticularLawTypes(caseregmodel.getCasetypename());
            // Enumeration em1=ch1.elements();
          //SectionModel  sectionmodel=null;
          
         %> 
         
         
        <tr>
      <td> Case ID</td> 
<%--      <td>CaseReg Date</td>--%>
<%--       <td>Case Type Name</td>   --%>
    <td>Client Name</td>
    <td>Next Hearing Date</td>
    <td>Court Name</td>
<%--    <td>Lawyer Name </td>--%>
    
     <td>Section ID</td> 
    
    
<%--    <td>Lawyer Acpt Date</td> --%>
<%--    <td>Lawyer End Date</td>--%>
<%--    <td>Lawyer State</td> --%>
    
    <th>Member Name</th>
<%--    <td>Member Type</td> --%>
<%--    <td>Sequence No</td>--%>
    <td>Mem Father Name</td> 
    <td>Address</td>
<%--    <td>DOB</td> --%>
    
    
    
    
<%--    <td>Evidence Reg Date</td>--%>
<%--    <td>Evidence Type Name</td> --%>
<%--    <td>Evidence Description</td>--%>
    <td>Evidence Image</td> 
    <td>Evidence Vedio</td>
    <td>Evidence Audio</td> 
    
    <td>Wit Name</td>
<%--    <td>Wit Type</td> --%>
<%--    <td>Wit Seqno</td>--%>
    <td>Wit Address</td>
<%--    <td>Wit DoB</td> --%>
    <td>Wit.Record Statement</td>
    
<%--  <td>Case Hearing Date</td>--%>
    <td>Hearing Result</td>
<%--    <td>Next Hearing Date</td>   --%>
   <td>Instruction</td> 
   </tr> 
   
      
         <% while(em.hasMoreElements()){
             caseregmodel=(CaseRegistrationModel)em.nextElement();
             
             
            //while(em1.hasMoreElements()){
            // sectionmodel=(SectionModel)em1.nextElement();
             
             
             
             
             
             
             
            
          
            
         %>

        <tr> 
        <td value="<%=caseregmodel.getCaseid() %>">
       <a href="SeeCaseRegistrationOfPerticulorLawyer.jsp?caseid=<%=caseregmodel.getCaseid()%>"><%=caseregmodel.getCaseid() %></a>
        </td>
<%--         <td> <%=caseregmodel.getCaseregdate()%></td>--%>
<%--         <td value="<%=caseregmodel.getCasetypeid() %>"> <%=caseregmodel.getCasetypename()%></td>--%>
         <td value="<%=caseregmodel.getClientid() %>"> <%=caseregmodel.getClientname()%></td>
         <td> <%=caseregmodel.getNexthearingdate()%></td>
         <td value="<%=caseregmodel.getCourtid()%>"> <%=caseregmodel.getCourtname() %></td>
<%--         <td value="<%=caseregmodel.getLawerid()%>"> <%=caseregmodel.getLawyername() %></td>--%>
         
         <td><%=caseregmodel.getSectionid()%></td>         
<%--         <td> <%=caseregmodel.getLawyeraceptdate()%></td>--%>
<%--           <td> <%=caseregmodel.getLawyeractivestate()%></td>--%>
         
         
         
         <td value="<%=caseregmodel.getMemid() %>"> <%=caseregmodel.getMemfstname()%></td>
<%--         <td> <%=caseregmodel.getMembertype()%></td>--%>
<%--         <td> <%=caseregmodel.getMemseqno()%></td>--%>
         <td > <%=caseregmodel.getMemftherfstname() %></td>
         <td > <%=caseregmodel.getMemaddress() %></td>         
<%--         <td><%=caseregmodel.getMemdob()%></td>--%>
         
         
<%--         <td ><%=caseregmodel.getEvidenceregdate() %></td>--%>
<%--         <td value="<%=caseregmodel.getEvidencetypeid() %>"> <%=caseregmodel.getEvidencetypename()%></td>--%>
<%--         <td> <%=caseregmodel.getEvidencedesc()%></td>  --%>
              
         <td><img src="userimages/<%=caseregmodel.getEvidenceid() %>.gif" height=30 width=50></td>
          <td><font color="#660000"><b><a href="WindowMediaPlayer1.jsp?sampleVideo=<%=caseregmodel.getEvidencevedio() %>"><font color="#660000"><b><%=caseregmodel.getEvidencevedio() %></b></font></a></b></font></td>
          <td><font color="#660000"><b><a href="WindowMediaPlayer2.jsp?sampleAudio=<%=caseregmodel.getEvidenceaudio() %>"><font color="#660000"><b><%=caseregmodel.getEvidenceaudio() %></b></font></a></b></font></td>
         
         
         
         <td <%=caseregmodel.getWitnessid() %>><%=caseregmodel.getWitfstname() %></td>
<%--         <td><%=caseregmodel.getWitnesstype() %></td>--%>
<%--         <td><%=caseregmodel.getWitnessseqno() %></td>--%>
          <td><%=caseregmodel.getAddress() %></td>
<%--          <td><%=caseregmodel.getWitnessdob() %></td>--%>
          <td><%=caseregmodel.getWitnesrecordedstmt() %></td>
                   
          
          
<%--          <td><%=caseregmodel.getHearingdate()%></td>--%>
          <td><%if(caseregmodel.getHearingresult()!=null){out.print(caseregmodel.getHearingresult());} else {out.print("");} %></td>
          
<%--          <td><%if(caseregmodel.getNexthearingdate1()!=null){out.print(caseregmodel.getNexthearingdate1());} else {out.print("");} %></td> --%>
          
          <td><%if(caseregmodel.getAnyspecialinstructions()!=null){out.print(caseregmodel.getAnyspecialinstructions());} else {out.print("");} %></td>
          
                
          </tr>
       
        <%             
         } }catch(Exception e){e.printStackTrace();}        
        %>  
      </table>
</form>
<script>

var frmvalidator  = new Validator("addcaseregistration");
  frmvalidator.addValidation("caseno","req","Please Enter Case Number");  
  frmvalidator.addValidation("caseregistrationdate","req","Please Enter Case Registration Date");
  frmvalidator.addValidation("casetypename","dontselect=0");
  frmvalidator.addValidation("clientname","dontselect=0");  
  frmvalidator.addValidation("nexthearingdate","req","Please Enter Next Hearing Date");
  frmvalidator.addValidation("courtname","dontselect=0");
  frmvalidator.addValidation("lawyername","dontselect=0");  
  
  
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
 
  <tr>
    <td height="25" colspan="2" bgcolor="#0D4961" align="center"><font color="#ffffff"><span class="style1">&copy;All rights reserved</span></font></td>
  </tr>
</table>
</body>
</html>
