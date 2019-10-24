<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function go() {
		var url = document.getElementById("ui").value;
		window.location = url;
	}
</script>
</head>
<body>
	<center>
		<c:set var="pages" value="${page}"></c:set>
		<c:set var="totalrecords" value="${totalrecords}"></c:set>
		<%
			int pages = ((Integer) pageContext.getAttribute("pages")).intValue();
			int total = ((Integer) pageContext.getAttribute("totalrecords")).intValue();
			int num = total % pages;
			int t;
			if (num > 0) {
				t = (total / pages) + 1;
			} else {
				t = (total / pages);
			}
			for (int i = 0; i < t; i++) {
		%>
		<a href="/displayAll/Page/<%=i%>">page <%=i + 1%></a><br />
		<%
			}
		%>
		<select onchange="go" id="ui">
			<%
				for (int i = 0; i < t; i++) {
			%><option value="http://desktop-pft6m0c:9999/displayAll/Page/<%=i%>"><%=i + 1%></option>
			<%
				}
			%>
		</select>
		<!-- 	<a href = "/displayAll/Page/0">Page 1</a>
	<a href = "/displayAll/Page/1">Page 2</a>
	<a href = "/displayAll/Page/2">Page 3</a> -->
		<h3>Employee List ${employees.size()}</h3>
		<table border="2">
			<tr style="background-color: orange">
				<th>empno</th>
				<th>empname</th>
				<th>dept</th>
				<th>desig</th>
				<th>basic</th>
			</tr>
			<c:forEach var="employee" items="${employees}">
				<tr style="background-color: pink">
					<td>${employee.empno}</td>
					<td>${employee.empname}</td>
					<td>${employee.dept}</td>
					<td>${employee.desig}</td>
					<td>${employee.basic}</td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/">home</a>

		<%-- 	<c:set var = "pages" value="${pages}"></c:set>
	<c:set var = "list" value="${employees.size()}"></c:set>
	<c:out value=pages></c:out> --%>

		<%-- <c:forEach var = "i" begin = "0" end = "${employees.size()/2}">
		<a href = "/displayAll/Page/${i}">Page ${i+1}</a><br/><br/>
	 </c:forEach> --%>
		<!-- <a href = "/displayjavatrainers">Display Java Trainers</a><br/><br/>
	<a href = "/displayjavaemployees">Display Java Employees</a><br/><br/>
	<a href = "/displayemployeessalary">Display Employees salary</a><br/><br/>
	<a href = "/displayjavaemployeessalary">Display Java trainers salary</a><br/><br/>
	<a href = "/namestartswith">Display</a><br/><br/>
	<a href = "/orderbydesig">Order By Designation</a><br/><br/>
	<a href = "/descbydesig">Descending By Designation</a><br/><br/>
	<a href = "/descbydesigandsalary">Descending By Designation and salary</a><br/><br/>
	<a href = "/javadescbysalary">Descending By salary nad java</a><br/><br/>
	<a href = "/number">java trainers salary lt 5000 starts with a</a><br/><br/> -->
	</center>
</body>
</html>