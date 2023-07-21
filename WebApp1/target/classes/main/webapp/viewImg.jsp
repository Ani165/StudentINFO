<%@page import="java.rmi.StubNotFoundException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.dao.StudentDao,java.io.OutputStream" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
OutputStream o1=response.getOutputStream();
response.setContentType("image/jpg");
o1.write(new StudentDao().displayImageById(Integer.parseInt(request.getParameter("sid"))));
o1.flush();
o1.close();
%>
</body>
</html>