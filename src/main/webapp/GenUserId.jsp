<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open Account</title>
<style>
	#main{
		width:500px;
		margin:10px auto;
		padding:20px;
		box-shadow:3px 3px 10px;
	}
	h4{
		display:inline;
		color:red;
		text-align:center;
	}
	.heading{
		background:#e9e9e9;
		text-align:center;
	}
</style>
</head>
<body>
<% String userid = (String)request.getAttribute("uid"); %>
<div id="main">
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
</body>
</html>
