<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Page JSP</title>
<link rel="stylesheet" href="index.css">
<script src="customer.js"></script>
<style>
	body{
		background-image:url("images/background.jpeg");
		background-size:cover;
	}
</style>
</head>
<body>
<div id="main">
  <div id="d1"></div>
  <div id="d2">
    <div id="d2d1"></div>
    <div id="d2d2">
      <div id="sec1">
       
        <!-- GenUserId -->
        <div id="appform" class="frmstyle" style="display:block">
        <% String userid = (String)request.getAttribute("uid"); 
        	if(userid==null){
        		
        	}else{
        		
        %>
        <div id="sub1"><h2>Account Opening Form</h2></div>
        <div id="sub2">
	    <form action="userbiodata" method="post">
		<table>
		  <tr><td colspan=2 class="heading"><h4>Personal Details</h4></td></tr>
		  <tr><td>Customer Id:</td><td><input type="text" name="id" value="<%= userid %>"/></td></tr>
		  <tr><td>Branch Name:</td><td>
		  							<select name="brcode">
		  								<option value="na">--Select--</option>
		  								<option value="1001">Varanasi</option>
		  								<option value="1002">Noida</option>
		  								<option value="1003">Hyderabad</option>
		  								<option value="1004">Banglore</option>
		  							</select>
		  							</td></tr>
		  <tr><td>Account Type:</td><td>
		  							<select name="acctype">
		  								<option value="na">--Select--</option>
		  								<option value="saving">Saving account</option>
		  								<option value="current">Current account</option>
		  							</select>
		  							</td></tr>
		  <tr><td>First Name:</td><td><input type="text" name="fname"/></td></tr>
		  <tr><td>Last Name:</td><td><input type="text" name="lname"/></td></tr>
		  <tr><td>Date of Birth:</td><td><input type="date" name="dob"/></td></tr>
		  <tr><td>Nominee Name:</td><td><input type="text" name="nominee"/></td></tr>
		  <tr><td>Relation with Nominee:</td><td><input type="text" name="nomrel"/></td></tr>
		  <tr><td colspan=2 class="heading"><h4>Occupation Details</h4></td></tr>
		  <tr><td>Occupation Type/Service:</td><td>
		  								<select name="occupation">
		  									<option value="na">--Select--</option>
		  									<option value="defence">Defence</option>
		  									<option value="bussiness">Bussiness</option>
		  									<option value="govemp">Government Employee</option>
		  									<option value="privemp">Private Employee</option>
		  								</select>
		  								</td></tr>
		  <tr><td>Annual Income:</td><td><input type="text" name="income"/> Rs.</td></tr>
		  <tr><td colspan=2 class="heading"><h4>Address Details</h4></td></tr>
		  <tr><td>Address:</td><td><input type="text" name="add"/></td></tr>
		  <tr><td>City:</td><td><input type="text" name="city"/></td></tr>
		  <tr><td>District:</td><td><input type="text" name="district"/></td></tr>
		  <tr><td>State:</td><td><input type="text" name="state"/></td></tr>
		  <tr><td>Pin Code:</td><td><input type="text" name="pin"/></td></tr>
		  <tr><td colspan=2 class="heading"><h4>Contact Details</h4></td></tr>
		  <tr><td>Email Id:</td><td><input type="email" name="mid"/></td></tr>
		  <tr><td>Phone Number:</td><td><input type="text" name="phno"/></td></tr>
		  <tr><td colspan=2><input type="checkbox" required />I allow Bank's correspondence to call/SMS me with reference to my application
		  </td></tr>
		  <tr><td></td><td><input type="submit" value="Submit Form"/></td></tr>
		</table>
	    </form>
        </div>
        </div>
        <%
        	}
        %>
        
        <!-- Apply Atm -->
      <div id="appatm" class="frmstyle" style="display:none">
        <div id="sub1"><h2>ATM Application Form</h2></div>
	    <div id="sub2">
		<form action="applyatm" method="post" onsubmit="getDate();">
		  <table>
			<tr><td>Account Number:</td><td><input type="text" name="accno" required/></td></tr>
			<tr><td>Card Type:</td><td>
									<select name="ctype">
									  <option value="default">--Select--</option>
									  <option value="Rupay">Rupay Card</option>
									  <option value="Visa">Visa Card</option>
									  <option value="Master">Master Card</option>
									</select>
									</td></tr>
			<tr><td>Mail Id:</td><td><input type="email" name="mid"/></td></tr>
			<tr><td>Phone Number:</td><td><input type="text" name="phno"/></td></tr>
			<tr><td>Set PIN:</td><td><input type="text" name="pin1"/></td></tr>
			<tr><td>Re-Enter PIN:</td><td><input type="text" name="pin2"/></td></tr>
			<tr><td><input type="hidden" name="atmdate" id="ad"/></td>
			
				<td><input type="submit" value="Apply"/></td></tr>
		  </table>
		 </form>
	  </div>
        </div>
        <script>
		function getDate(){
			const d = new Date();
			ad.value = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+
							d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
		}
	  </script>
        
      <!-- User Details -->
      <div id="details" class="frmstyle" style="display:none">
        <div><h2>Enter Fields for Details</h2></div>
	  <div>
	  	<form action="userdetails" method="post">
	  	  <table>
	  	  	<tr><td>Account Number:</td><td><input type="text" name="accno"/></td></tr>
	  	  	<tr><td>Date of Birth:</td><td><input type="date" name="dob"/></td></tr>
	  	  	<tr><td></td><td><input type="submit" value="Get Details"/></td></tr>
	  	  </table>
	  	</form>
	  </div>
      </div>
      </div><!-- Sec1 -->
      
      <div id="sec2">
        <a href="genuserid"><button onclick="appForm();">Open Account</button></a>
		<a><button onclick="appAtm();">Apply for ATM card</button></a>
		<a><button onclick="details();">User Details</button></a>
		<a href="userlogout"><button style='background:red;'>Logout</button></a>
      </div>
    </div>
  </div>
</div>
</body>
</html>