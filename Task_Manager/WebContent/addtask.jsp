<%@page import="kaustubh.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
User user = (User) session.getAttribute("logUser");
if (user == null) {
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
<style>
body{
	background-image: url(img/welcome-background.jpg); 
    background-size: cover;
    background-repeat: no-repeat;
}
.boxs{
	margin-left: 620px;
    margin-top: 220px; 
    background-color: yellow;
    margin-right: 600px;
    padding-left: 45px;
    padding-bottom: 20px;
    padding-top: 10px;
    border: solid;
    border-radius: 5px;
}
.bckbtn{
	background-color: yellow;
	margin-left: 620px;
}
</style>

<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei"
	rel="stylesheet">
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->

</head>
<body>
		
		<div class="boxs" >
			<h1>Add Task</h1>
			<form action="AddTaskServlet" method="post">
				<p>Title</p>
				<input type="text" placeholder="Title" name="title" required>
				<p>Description</p>
				<input type="text" placeholder="Description" name="desc"
					required> 
				<p>No. of days</p>
				<input type="number" placeholder="Days" name="no_of_days"
					required> 
				<br><br>
				<input type="submit" value="Submit" name="Submit"> 
				<br>
			</form>
		</div>
<br><br>
<button class="bckbtn" onclick="window.location.href='welcome.jsp'">Back</button>
</body>
</html>