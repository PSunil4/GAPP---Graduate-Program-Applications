<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<script src="../js/bootstrap.min.js"></script>
</head>
<body style="background: url(../images/rbg1.jpg) no-repeat center center fixed">
	<div class="container"  style="margin-top: 20px;">
		<div class="row text-center pad-top ">
			<div class="col-md-12">
				<h2 style="color: white;">Registration For GAPP Account</h2>
			</div>
		</div>
		<div class="row  pad-top">
			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-success">
					<div class="panel-heading">
						<strong> Create A GAPP Account </strong>
					</div>
					<div class="panel-body">
						<!-- This is a SPRING_MVC Form -->
						<form:form modelAttribute="systemuser" role="form">
						
							<p style="color:red; text-align: center;">${sessionScope.error}</p>
							<h4 class="text-info">Email</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-envelope"></span>
									</div>
									<form:input path="email" type="text" placeholder="Enter Email" class="form-control" required="true"/>
								</div>
							</div>
							<h4 class="text-info">Password</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</div>
									<form:input path="password" type="password" placeholder="Enter Password" class="form-control" required="true"/>
								</div>
							</div>
							<h4 class="text-info">Last Name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</div>
									<form:input path="lastname" type="text" placeholder="Enter Last Name" class="form-control" required="true"/>
								</div>
							</div>
							<h4 class="text-info">First Name</h4>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon">
										<span class="glyphicon glyphicon-user"></span>
									</div>
									<form:input path="firstname" type="text" placeholder="Enter First Name" class="form-control" required="true"/>
								</div>
							</div>
							<input class="btn btn-primary" type="submit" value="Register Me">
							<hr />
							Already Registered ? <a href="login.html">Login here</a>
							
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>