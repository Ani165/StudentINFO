<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.dao.StudentDao,com.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Student> list = new StudentDao().displayAllStudent();
	%>
	<center>
		<h1>List Of Student</h1>
		<table border="3" style=" border-spacing: 15px;">
			<%
			int count = 0;
			for (Student s : list)
			{	
				if(count%3==0)
				{%><tr></tr>
				<%}
			count++;%>
			<td align="center"><a href="Servlet1?s1=Display&sid=<%=s.getSid()%>">
			<img src="viewImg.jsp?sid=<%=s.getSid()%>" height="200" width="160"></a>
			<br><b><%=s.getSid() %>) <%=s.getSname() %></b>
			<br ><%=s.getSclass() %>
			</td>
			<%}%>


		</table>
	</center>
</body>
</html>