<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
</head>
<body>
	<table border="2" cellpadding="5px" cellspacing="5px">
		<tr>
			<th>ID</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>CIN</th>
			<th>Phone Number</th>
			<th>Gender</th>
			<th>Birthdate</th>
			<th>Citizenship</th>
			<th>TOEFL</th>
			<th>GPA</th>
			<th>Transcript</th>
		</tr>
		<c:forEach items="${student}" var="student">
			<tr>
				<td>${student.studentId}</td>
				<td>${student.systemUserStudent.lastname} ${student.systemUserStudent.firstname}</td>
				<td>${student.systemUserStudent.email}</td>
				<td>${student.CIN}</td>
				<td>${student.phoneNumber}</td>
				<td>${student.gender}</td>
				<td>${student.birthdate}</td>
				<td>${student.citizenship}</td>				
				<td>${student.academicRecords.TOEFLScore }</td>
				<td>${student.academicRecords.GPA }</td>
				<td>${student.academicRecords.transcript }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>