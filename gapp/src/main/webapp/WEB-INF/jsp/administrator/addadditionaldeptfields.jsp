<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Additional Department Fields</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<script src="../js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
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
				<div class="panel panel-primary" style="height: 440px; width: 100%;">
					<div class="panel-heading">Additional Requirements <a class="btn btn-success btn-sm pull-right" href="listofdepartments.html"> Back </a></div>
					<div class="panel-body">
						<form:form modelAttribute="additionalRequirement" role="form">
						<h4 class="text-info">Select A Department</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="dropdown">
										<select name="departmentNames" class="form-control">
											<c:forEach items="${listOfdept}" var="depts">
												<c:choose>
													<c:when test="${param.addDeptFields == depts.departmentId}">
														<option value="${depts.departmentId}" selected="true">${depts.departmentName}</option>
													</c:when>
													<c:otherwise>
														<option value="${depts.departmentId}">${depts.departmentName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<h4 class="text-info">Enter a Field Name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-plus-sign"></span>
									</div>
									<form:input path="fieldName" type="text"
										placeholder="Field Name" class="form-control"
										required="true" />
								</div>
							</div>
							<h4 class="text-info">Enter a Field Type</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-text-width"></span>
									</div>
									<form:select path="fieldValueType" class="form-control">
										<option value="Number">Number</option>
										<option value="Text">Text</option>
										<option value="File">File</option>
									</form:select>
								</div>
							</div>
							<h4 class="text-info">Field Required?</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-ok-circle"></span>
									</div>
									<form:select path="FieldRequired" class="form-control">
										<option value="true">Required</option>
										<option value="false">Optional</option>
									</form:select>
								</div>
							</div>
							<input class="btn btn-primary pull-right" type="submit" value="Add Additional Fields">
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>