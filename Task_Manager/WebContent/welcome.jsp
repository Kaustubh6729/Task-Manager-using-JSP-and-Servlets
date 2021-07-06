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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
.welcome {
	background-color: yellow;
	margin-right: 1150px;
	border-radius: 5px;
	border-style: solid;
}
body{
	background-image: url(img/welcome-background.jpg); 
    background-size: cover;
    background-repeat: no-repeat;
}
.tasks{
	margin-left: 600px;
}

.myBtn{ 
height: 150px; 
width: 300px; 
padding: 10px 15px; 
background-color: yellow;
font-size: 30px;
cursor: pointer;
border-radius: 5px;
text-align: center;

} 
.myBtn:hover {
  background-color: black;
  color: white;
  border-color: white;
  border: 2;
}
.loutbtn{
height: 50px; 
width: 100px; 
padding: 10px 15px; 
cursor: pointer;
border-radius: 5px;
text-align: center;
background-color: black;
color: white;
padding: 10px 15px;
margin-left: 120px;
}



</style>
</head>
<body>

	
		<h1 style="background-color: orange; margin-right: 1150px; border-radius: 5px; border-style: solid;">
			Welcome,
			<%=user.getName()%></h1>
		<div class="welcome">
			<h3>
				Your Account ID:
				<%=user.getId()%>
			</h3>
			<h3>
				Your Email:
				<%=user.getEmail()%>
			</h3>
			<h3>
				Your Password:
				<%=user.getPassword()%></h3>
			<button class="loutbtn">
				<a href="LogoutServlet" style="text-decoration:none; color: white">Log Out</a>
			</button>
		</div>
		<br>
		<br>
		<div class="tasks">
			<button type="submit" class="myBtn"><a href="addtask.jsp" style="text-decoration:none;">Add Task</a></button><br><br>
			<button type="submit" class="myBtn" ><a href="ViewTask.jsp" style="text-decoration:none; ">View Tasks</a></button><br><br>
		</div>

</body>
</html>
