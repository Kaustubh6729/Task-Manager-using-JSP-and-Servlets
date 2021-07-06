<%@page import="kaustubh.ConnectionPro"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="kaustubh.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tasks</title>
</head>
<style>
body{
	background-image: url(img/welcome-background.jpg); 
    background-size: cover;
    background-repeat: no-repeat;
}
table{
	width: 100%;
    border: 5px solid black
    background-color: yellow;
}
td{
	border: 2px solid black;
	background-color: yellow;
	font-size: 20px;
}
.hd{
	background-color: yellow;
	border: solid;
	border-radius: 5px;
	margin-right: 1200px;
}
.bckbtn{
	background-color: yellow;
	margin-left: 10px;
}
</style>
<body>
<div class="hd">
<h1>Your Tasks are:-</h1>
<h3>*true = Done</h3>
<h3>*false = Not Done/ In Progress</h3>
<br>
</div>
<br>
	<form method="post">

<table >
<tr>
<td><b>ID</b></td>
<td><b>Title</b></td>
<td><b>Username</b></td>
<td><b>Description</b></td>
<td><b>No. of Days</b></td>
<td><b>Status</b></td>
<td><b>Change Status</b></td>
<td><b>Delete Task</b></td>
</tr>
<%
try
{
	
User user = (User) session.getAttribute("logUser");
String usr = user.getName();
System.out.print(usr);
ConnectionPro c = new ConnectionPro();
String query="select * from tasks where username=? ";
//Connection con;

PreparedStatement stmt= c.getConnection().prepareStatement(query);
stmt.setString(1,usr);
ResultSet rs=stmt.executeQuery();
while(rs.next())
{
int ids = rs.getInt("id");
%>
    <tr><td><%=rs.getInt("id")%></td>
    <td><%=rs.getString("title") %></td>
	<td><%=rs.getString("username") %></td>
    <td><%=rs.getString("description") %></td>
    <td><%=rs.getInt("targetDate") %></td>
    <td><%=rs.getBoolean("status") %></td>
   	<td><a href="ChangeStatusServlet?id=<%=ids %>">Change Status</a></td>
    <td><a href="DeleteTaskServlet?id=<%=ids %>">Delete Task</a></td></tr>
        <%
	
}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    //c.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>

</form>
<br><br>
<button class="bckbtn" onclick="window.location.href='welcome.jsp'">Back</button>

</body>
</html>