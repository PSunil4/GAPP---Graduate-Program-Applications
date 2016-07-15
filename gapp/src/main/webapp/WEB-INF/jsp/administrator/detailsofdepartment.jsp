<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Details Of a Department</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2>Department Details</h2>
			</div>
		</div>
		<hr>
		<h5 class="text-right">Welcome ${username} | <a href="logout.html">Logout</a></h5>
		<br />
		<div class="row col-md-8 col-md-offset-2" >
			<div class="panel panel-primary">
			<div class="panel-heading">Department Details <a class="btn btn-success btn-sm pull-right" href="listofdepartments.html"> Back </a></div>
				<table class="table">
					<thead>
						<tr class="filters">
							<th>Department Name</th>
							<th>Program Name(s)</th>
							<th>Additional Requirement(s)</th>
							<th>Field Required?</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${ departmentDetail.departmentName }</td>
							<td>
								<c:forEach items="${programInfo}" var="programInfo">
									 ${ programInfo.programName } <br />
								</c:forEach>
							</td>
							<td> 
								<c:forEach items="${deptAdditionalFields}" var="deptAdditionalFields">
									${ deptAdditionalFields.fieldName } 
									<br />
								</c:forEach>
							</td>
							<td> 
								<c:forEach items="${deptAdditionalFields}" var="deptAdditionalFields"> 
									<c:if test="${deptAdditionalFields.fieldRequired == true }"> Required</strong> </c:if>
									<c:if test="${deptAdditionalFields.fieldRequired != true }"> Optional </c:if> 
									<br />
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>