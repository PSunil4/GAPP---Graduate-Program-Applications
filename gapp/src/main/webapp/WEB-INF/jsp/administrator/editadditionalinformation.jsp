<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Additional Department Fields</title>
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
			<div class="col-md-5 col-md-offset-4">
			<a href="addadditionaldeptfields.html?addDeptFields=${department.departmentId }" class="col-md-7 col-md-offset-3"><strong>Add Additional Department Fields</strong></a>
			<br /> <br />
				<div class="panel panel-primary" style="height: 100%; width: 100%;">
				<div class="panel-heading">Edit Department Additional Fields <a class="btn btn-success btn-sm pull-right" href="listofdepartments.html"> Back </a></div>
					<div class="panel-body">
						<h4 class="text-error">Department Name: ${department.departmentName }</h4>
						<hr>
						<h4 class="text-info">List Of Additional Fields</h4>
							<form:form modelAttribute="additional" role="form" class="form-inline">
							<div class="form-group col-md-8">
								<c:forEach items="${additionalFields}" var="addFields">
									<form:input path="fieldName" type="text" value="${addFields.fieldName}" class="form-control"  required="true" readonly="true"/>
									<form:input path="fieldValueType" type="text" value="${addFields.fieldValueType}" class="form-control"  required="true" readonly="true"/>
									<form:input path="fieldRequired" type="text" value="${addFields.fieldRequired}" class="form-control"  required="true" readonly="true"/>
									<a href="removeadditionaldeptfields.html?addFieldsId=${addFields.additionalDeptFieldsId}&deptId=${department.departmentId}">Remove</a>
									<br /><br />
								</c:forEach>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>