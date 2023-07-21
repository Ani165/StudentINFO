<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.List,java.util.*,com.model.Student,com.dao.StudentDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		Student s = (Student) request.getAttribute("student");
		List<String> c = new ArrayList();
		c.add("BCA");
		c.add("MA");
		c.add("B.com");
		c.add("M.com");
		c.add("BE");
		c.add("ME");
		c.add("MCA");
		c.add("BSc");
		c.add("BA");
		c.add("MBA");
		%>
		<h2>Student From</h2>
		<hr>
		<form action="Servlet1" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td colspan="2" align="center">
					<img src="viewImg.jsp?sid=<%=s.getSid()%>" height="200" width="165"><br>
					<a href="viewDocs.jsp?sid=<%=s.getSid()%>">view Docs</a></b></td>
				</tr>
				<tr>
					<td>ID:</td>
					<td><input type="text" name="sid" value="<%=s.getSid()%>"
						readonly></td>
				</tr>
				<tr>
					<td>NAME:</td>
					<td><input type="text" name="sname" value="<%=s.getSname()%>"></td>
				</tr>
				<tr>
					<td>GENDER:</td>
					<td>
						<%
						if (s.getGender().equalsIgnoreCase("Male")) {
						%> <input type="radio" name="gender" value="Male" checked="checked">Male 
							<input type="radio" name="gender" value="Female">Female <%
 						} 
						else
						{%> 
						<input type="radio" name="gender" value="Male">Male 
						<input type="radio" name="gender" value="Female" checked="checked">Female
					</td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><input type="date" id="birthday" name="birthday">
					</td>
				</tr>
				<tr>
					<td>CLASS:</td>
					<td><select name="sclass">
							<option>select</option>
							<%
							for (String s1 : c) {
								if (s1.equalsIgnoreCase(s.getSclass())) {
							%>
							<option value="<%=s1%>" selected="selected"><%=s1%></option>
							<%
							} else {
							%>
							<option value="<%=s1%>"><%=s1%></option>
							<%
							}
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>CITY:</td>
					<td><input type="text" name="scity" value="<%=s.getScity()%>"></td>
				</tr>
				<tr>
					<td>PERCENTAGE:</td>
					<td><input type="text" name="spercentage"
						value="<%=s.getSpercentage()%>"></td>
				</tr>
				<tr>
					<td>Upload New Image:</td>
					<td><input type="file" name="simg"></td>
				</tr>
				<tr>
					<td>Upload New Document:</td>
					<td><input type="file" name="sdocs"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" name="s1"
						value="Update"></td>
				</tr>
			</table>
		</form>
		
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
			for (Student s1 : new StudentDao().displayAllStudent()) {
			%>
			<tr>
				<td align="center"> <%=s1.getSid()%> </td>
				<td><a href="Servlet1?s1=Display&sid=<%=s1.getSid()%>"><img src="viewImg.jsp?sid=<%=s1.getSid()%>" height="200" width="160"></a></img></td>
				<td align="center"> <%=s1.getSname()%> </td>
				<td align="center"> <%=s1.getGender()%> </td>
				<td align="center"> <%=s1.getSclass()%> </td>
				<td align="center"> <%=s1.getScity()%> </td>
				<td align="center"> <%=s1.getSpercentage()%></td>
				<td><a href="viewDocs.jsp?sid=<%=s1.getSid()%>">View Docs</a></td>
				<td><a href="Servlet1?s1=Display&sid=<%=s1.getSid()%>">View</a>
					<a href="Servlet1?s1=Delete&sid=<%=s1.getSid()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</center>
</body>
</html>