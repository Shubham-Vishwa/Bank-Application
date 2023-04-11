<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	import ="temptable.UserBiodataBean"
    	import = "admininfo.AdminBean"
    	import = "accinfo.UserDetailsBean"
    	import = "java.util.Vector"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin jsp</title>
<link rel="stylesheet" href="admin.css">
<script src="admin.js"></script>
</head>
<body>
<div id="main">
  <div id="d1"></div>
  <div id="d2">
    <div id="d2d1">
      <div id="option">
        <a href="checkformadmin"><button>Register Customer</button></a>
        <button onclick="edit();">Edit Customer</button>
        <button onclick="del();">Delete Customer</button>
        <button onclick="showOne();">One Customer Details</button>
        <button onclick="showallcust">All Customer Details</button>
      </div>
    </div>
    <div id="d2d2">
      
      <!-- Check Form -->
      <div id="checkform" class="frmstyle" style="display:block">
      <%
	    AdminBean admin = (AdminBean)session.getAttribute("admin");
        String adminName = admin.getfName()+" "+admin.getlName();
	    UserBiodataBean ubean = (UserBiodataBean)request.getAttribute("ubiodata");
	    if(ubean==null){
		  
	    }else{
		  String accNo = ubean.getId()+ubean.getBranchCode()+(int)ubean.getfName().toUpperCase().charAt(0);
	  %>
	  <script>console.log("<%=adminName %>");</script>
      <div id="sub1"><h2>Account Opening Form</h2></div>
      <div id="sub2">
	    <form action="decideformadmin" method="post">
	      <jsp:forward page=""></jsp:forward>
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
      <% } %>
     </div><!-- End of Check Form -->
      
      <!-- Edit Customer -->
     <div id="edit" class="frmstyle" style="display:block">
       <form action="editcust" method="post">
         <table>
           <tr><td>Account No:</td><td><input type="text" name="accno"/></td></tr>
           <tr><td>Email Id:</td><td><input type="text" name="mid"/></td></tr>
           <tr><td>Phone No:</td><td><input type="text" name="phno"/></td></tr>
           <tr><td></td><td><input type="submit" value="Edit"/></td></tr>
         </table>
       </form>
     </div>
     
     <!-- Delete Customer -->
     <div id="del" class="frmstyle" style="display:block">
       <h2>Delete One Customer</h2>
       <form action="delcust" method="post">
         <table>
           <tr><td>Account No:</td><td><input type="text" name="accno"/></td></tr>
           <tr><td></td><td><input type="submit" value="Delete"/></td></tr>
         </table>
       </form>
     </div>
     
     <!-- Show One Customer -->
     <div id="showone" class="frmstyle" style="display:block">
       <h2>Show One Customer</h2>
       <form action="onecust" method="post">
         <table>
           <tr><td>Account No:</td><td><input type="text" name="accno"/></td></tr>
           <tr><td></td><td><input type="submit" value="Show"/></td></tr>
         </table>
       </form>
     </div>
     
     
     <!-- Show All Customer -->
     <div id="showall" class="frmstyle">
     <%
      // Vector<UserDetailsBean> v = request.getParameter("details");
     %>
     </div>
     
     
    </div><!-- End of d2d2 -->
  </div>
</div>
</body>
</html>