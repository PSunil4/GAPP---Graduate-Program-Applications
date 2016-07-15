<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Department</title>
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
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-primary" style="height: 200px; width: 100%;">
					<div class="panel-heading">Add New Department <a class="btn btn-success btn-sm pull-right" href="listofdepartments.html"> Back </a></div>
					<div class="panel-body">
						<form:form modelAttribute="department" role="form">
							<h4 class="text-info">Enter New Department Name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-modal-window"></span>
									</div>
									<form:input path="departmentName" type="text"
										placeholder="Department Name" class="form-control"
										required="true" /> 
								</div>
							</div>
							<input class="btn btn-primary pull-right" type="submit" value="Add Department">
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>