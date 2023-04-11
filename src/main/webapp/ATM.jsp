<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="atminfo.ATMBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATM Card</title>
<style>
	#main{
		width:400px;
		text-align:center;
		box-shadow:3px 3px 10px;
		margin:100px auto 0px auto;
		padding:20px;
		background:#f0f0f0;
		border-radius:10px;
	}
	#cvv{
		float:left;
	}
	#ctype{
		float:right;
	}
	#detail{
		width:400px;
		margin:30px auto;
	}
</style>
</head>
<body>
	<%
		ATMBean bean = (ATMBean)request.getAttribute("atminfo");
		if(bean==null){
			
		}else{
			
	%>
	<div id="main">
		<h2>XYZ Bank of India</h2>
		<h1><%=bean.getCardno() %></h1>
		<h3><%=bean.getName() %></h3>
		<div><h3 style="display:inline" id="cvv"><%=bean.getCvv() %></h3><h3 style="display:inline" id="ctype"><%=bean.getCardtype() %></h3></div>
		<br/><br/>
	</div>
	<div style="width:400px; margin:20px auto;"><button onclick="show();">Show more details</button></div>
	<div id="detail" style="display:none;">
		<table>
			<tr><td>Mail Id :</td><td><%=bean.getMid() %></td></tr>
			<tr><td>Phone no:</td><td><%=bean.getPhno() %></td></tr>
			<tr><td>ATM Pin :</td><td><%=bean.getPin() %></td></tr>
		</table>
	</div>
	<script>
		function show(){
			var x = document.querySelector("#detail");
			if(x.style.display==="none"){
				x.style.display="block";
			}else{
				x.style.display="none";
			}
		}
	</script>
	<%
		}
	%>
</body>
</html>