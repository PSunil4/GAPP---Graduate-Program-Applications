<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Departments</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2>Department Management</h2>
			</div>
		</div>
		<hr>
		<h5 class="text-right">Welcome ${username} | <a href="logout.html">Logout</a></h5>
		
		<a href="addnewdepartment.html">Add Department(s)</a>
		&nbsp; | &nbsp; <a href="addnewdeptprograms.html">Add Department Program(s)</a>
		&nbsp; | &nbsp; <a href="addadditionaldeptfields.html">Add Additional Department Field(s)</a>
		<br /><br />
		<div class="row col-md-12" >
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">List Of All Departments & Information</h3>
				</div>
				<table class="table">
					<thead>
						<tr class="filters">
							<th>Department Name</th>
							<th>Number Of Programs</th>
							<th>View Details</th>
							<th>Edit Department Name</th>
							<th>Edit Program(s)</th>
							<th>Edit Additional Requirements</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOfDepts}" var="listOfDepts">
							<tr>
								<td>${listOfDepts.departmentName}</td>
								<c:forEach items="${PrgsPerDepts}" var="PrgsPerDepts">
									<c:if test="${listOfDepts.departmentId == PrgsPerDepts.programDeptId }">
										<td><strong> ${PrgsPerDepts.count}</strong> Program(s) Offered</td>
									</c:if>
								</c:forEach>
								<td><a href="detailsofdepartment.html?deptId=${listOfDepts.departmentId}">View</a></td>
								<td><a href="editdepartmentname.html?deptId=${listOfDepts.departmentId}">Change Dept Name</a></td>
								<td><a href="editdepartmentprogram.html?deptId=${listOfDepts.departmentId}">Add / Remove Program(s)</a></td>
								<td><a href="editadditionalinformation.html?deptId=${listOfDepts.departmentId}">Add / Remove Additional Requirements</a></td>
							</tr>
						</c:forEach>						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>