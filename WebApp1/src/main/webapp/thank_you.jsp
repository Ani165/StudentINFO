<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List,com.model.Student,com.dao.StudentDao"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<br>
	<h1>(◔◡◔) ♥ Thank You! ♥</h1>
	<br>
	<h2><a href="index.jsp">Fill Another Student Form</a></h2>
	<hr>
		<h1>Student List</h1>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>IMAGE</th>
				<th>NAME</th>
				<th>GENDER</th>
				<th>CLASS</th>
				<th>CITY</th>
				<th>PERCENTAGE</th>
				<th>DOCS</th>
				<th>ACTION</th>
			</tr>
			<%
			for (Student s : new StudentDao().displayAllStudent()) {
			%>
			<tr>
				<td align="center"> <%=s.getSid()%> </td>
				<td><a href="Servlet1?s1=Display&sid=<%=s.getSid()%>"><img src="viewImg.jsp?sid=<%=s.getSid()%>" height="200" width="160"></a></img></td>
				<td align="center"> <%=s.getSname()%> </td>
				<td align="center"> <%=s.getGender()%> </td>
				<td align="center"> <%=s.getSclass()%> </td>
				<td align="center"> <%=s.getScity()%> </td>
				<td align="center"> <%=s.getSpercentage()%></td>
				<td><a href="viewDocs.jsp?sid=<%=s.getSid()%>">View Docs</a></td>
				<td><a href="Servlet1?s1=Display&sid=<%=s.getSid()%>">View</a>
					<a href="Servlet1?s1=Delete&sid=<%=s.getSid()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	
</center>
</body>
</html>