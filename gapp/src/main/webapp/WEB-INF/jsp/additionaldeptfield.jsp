<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Additional Department Field</title>
</head>
<body>
	<table border="2" cellpadding="5px" cellspacing="5px">
		<tr>
			<th>Department Name</th>
			<th>Field Name</th>
			<th>Field Value Type </th>
			<th>Required</th>
		</tr>
		<c:forEach items="${additionaldeptfield}" var="additionaldeptfield">
			<tr>
				<td>${additionaldeptfield.department.departmentName }</td>
				<td>${additionaldeptfield.fieldName}</td>
				<td>${additionaldeptfield.fieldValueType}</td>
				<td>${additionaldeptfield.fieldRequired}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>