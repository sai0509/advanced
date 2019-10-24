<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="Authenticate" method="post" modelAttribute="user">
		<center>
			<h1>Enter Login Details</h1>
			<table>
				<tr>
					<th>User Name</th>
					<td><form:input path="username" /></td>
				</tr>
				</br>
				</br>
				<tr>
					<th>Password</th>
					<td><form:input path="password" /></td>
				</tr>
				</br>
				</br>
				<tr>
					<td colspan = "2"><input type = "submit" value = "Login" style="width: 150px; "/></td>
				</tr>
			</table>
		</center>
	</form:form>
</body>
</html>