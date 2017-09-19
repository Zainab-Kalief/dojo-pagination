<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
	
</style>
</head>
<body>
	<div>
		<c:forEach begin="1" end="${ totalPages }" var="index">
			<a href="/page/${index}">${index}</a>
		</c:forEach> 
	</div>
	<table>
		<tr>
			<td>FirstName</td>
			<td>Last Name</td>
			<td>Center </td>
		<tr>
		 <c:forEach items="${ all }" var="value">
			<tr>
			<td> <c:out value="${ value.firstName }"/> </td>
			<td><c:out value="${ value.lastName }"/> </td>
			<td><c:out value="${ value.dojo.name }"/> </td>
			</tr>
		</c:forEach> 
	</table>
</body>
</html>