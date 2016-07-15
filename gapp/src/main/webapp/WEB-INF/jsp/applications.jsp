<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Applications</title>
</head>
<body>
	<table border="2" cellpadding="5px" cellspacing="5px">
		<tr>
			<th>ID</th>
			<th>Application Term</th>
			<th>Full Name </th>
			<th>Application Program Name</th>
			<th>Application Status Name </th>
		</tr>
		<c:forEach items="${applications}" var="apps">
			<tr>
				<td>${apps.applicationId}</td>
				<td>${apps.applicationTerm}</td>
				<td>${apps.studentSystemUser.firstname } ${apps.studentSystemUser.lastname }</td>
				<td>${apps.programToApply.programName }</td>
				<td>${apps.applicationStatus.statusName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>