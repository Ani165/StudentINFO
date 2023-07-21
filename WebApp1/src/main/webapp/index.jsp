<%@page import="com.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.dao.StudentDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Registration form</h1>
		<hr>
		<form action="Servlet1" method="post" enctype="multipart/form-data">
			<table border="2">

				<tr>
					<td>NAME:</td>
					<td><input type="text" name="sname"
						placeholder="Enter username" required></td>
				</tr>
				<tr>
					<td>GENDER:</td>
					<td><input type="radio" name="gender" value="Male" required>Male
						<input type="radio" name="gender" value="Female" required>Female</td>
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
							<option value="BCA">BCA</option>
							<option value="MA">MA</option>
							<option value="B.com">B.com</option>
							<option value="M.com">M.com</option>
							<option value="BE">BE</option>
							<option value="ME">ME</option>
							<option value="MCA">MCA</option>
							<option value="BSc">BSc</option>
							<option value="BA">BA</option>
							<option value="MBA">MBA</option>
					</select></td>
				</tr>
				<tr>
					<td>CITY:</td>
					<td><input type="text" name="scity" placeholder="City"
						required></td>
				</tr>
				<tr>
					<td>PERCENTAGE:</td>
					<td><input type="text" name="spercentage"
						placeholder="Percentage" required></td>
				</tr>
				<tr>
					<td>Upload Image:</td>
					<td><input type="file" name="simg" required></td>
				</tr>
				<tr>
					<td>Upload Document:</td>
					<td><input type="file" name="sdocs" required></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit" name="s1"
						value="Add" ></td>
				</tr>
			</table>
		</form>
	<h3><a href="gridview.jsp">Gridview</a></h3>
	</center>
</body>
</html>