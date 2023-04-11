<%@ page language="java"
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	import ="temptable.UserBiodataBean"
    	import = "admininfo.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking of app forms</title>
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
<%
	AdminBean admin = (AdminBean)session.getAttribute("admin");
	UserBiodataBean ubean = (UserBiodataBean)request.getAttribute("ubiodata");
	String accNo = ubean.getId()+ubean.getBranchCode()+(int)ubean.getfName().toUpperCase().charAt(0);
	String adminName = admin.getfName()+" "+admin.getlName();
%>
<jsp:useBean id="userbean" class="temptable.UserBiodataBean" scope="session"/>
<script>console.log("<%=adminName %>");</script>

<div id="main">
  <div id="sub1"><h2>Account Opening Form</h2></div>
    <div id="sub2">
	  <form action="decideformadmin" method="post">
		<table>
		  <tr><td colspan=2 class="heading"><h4>Personal Details</h4></td></tr>
		  <tr><td>First Name:</td><td><%= ubean.getfName() %></td></tr>
		  <tr><td>Last Name:</td><td><%= ubean.getlName() %></td></tr>
		  <tr><td>Date of Birth:</td><td><%= ubean.getDob() %></td></tr>
		  <tr><td>Nominee Name:</td><td><%= ubean.getNominee() %></td></tr>
		  <tr><td>Relation with Nominee:</td><td><%= ubean.getNomrel() %></td></tr>
		  <tr><td colspan=2 class="heading"><h4>Occupation Details</h4></td></tr>
		  <tr><td>Occupation Type/Service:</td><td><%= ubean.getOccupation() %></td></tr>
		  <tr><td>Annual Income:</td><td><%= ubean.getIncome() %>Rs.</td></tr>
		  <tr><td colspan=2 class="heading"><h4>Address Details</h4></td></tr>
		  <tr><td>Address:</td><td><%= ubean.getAddress() %></td></tr>
		  <tr><td>City:</td><td><%= ubean.getCity() %></td></tr>
		  <tr><td>District:</td><td><%= ubean.getDistrict() %></td></tr>
		  <tr><td>State:</td><td><%= ubean.getState() %></td></tr>
		  <tr><td>Pin Code:</td><td><%= ubean.getPin() %></td></tr>
		  <tr><td colspan=2 class="heading"><h4>Contact Details</h4></td></tr>
		  <tr><td>Email Id:</td><td><%= ubean.getMid() %></td></tr>
		  <tr><td>Phone Number:</td><td><%= ubean.getPhno() %></td></tr>
		  <tr><td colspan=2 class="heading"><h4>Bank Details</h4></td></tr>
		  <tr><td>Customer Id:</td><td><%= ubean.getId() %></td></tr>
		  <tr><td>Branch Code:</td><td><%= ubean.getBranchCode() %></td></tr>
		  <tr><td>Account Type:</td><td><%= ubean.getAcctype() %></td></tr>
		  <tr><td>Account Number:</td><td><%= accNo %></td></tr>
		  <tr><td>Current Status:</td><td>
		  							<input type="radio" name="status" value="active"/>
		  							Active
			  						<input type="radio" name="status" value="inactive"/>
		  							Inactive
		  						</td></tr>
		  <tr><td>Risk Category:</td><td>
		  							<select name="risk">
		  								<option value="high">High</option>
		  								<option value="medium">Medium</option>
		  								<option value="low">Low</option>
		  							</select>
		  						</td></tr>
		  <tr><td>Remark:</td><td><input type="text" name="remark"/></td></tr>
		  <tr><td colspan=2><input type="hidden" name="admin" value="<%= adminName %>"/></td></tr>
		  <tr><td></td><td>
		  				<input type="submit" value="Accept" name="action"/>
						<input type="submit" value="Reject" name="action"/>
		  			</td></tr>
		</table><br/><br/>
	 </form>
  </div>
</div>
</body>
</html>