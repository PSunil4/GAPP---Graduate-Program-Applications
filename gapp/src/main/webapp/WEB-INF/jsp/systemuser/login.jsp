<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GAPP Login</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="../css/loginStyle.css"/>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/hr.css"/>
</head>
<body background="../images/bg3.jpg">
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="border-bottom: none;">
					<div class="text-center">
						<h2>Graduate Program Applications</h2>
					</div>
					<h3 class="text-center">Login</h3>
				</div>
				<hr class="colorgraph">
					<p class="text-center bg-success" style="padding: 0px 2px"><strong>${registrationSuccess} ${user.firstname} ${user.lastname}</strong></p>		
				
				<div class="modal-body">
					<form:form modelAttribute="systemuser" role="form">
					<p style="color:red; text-align: center;">${sessionScope.error}</p>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> 
							<form:input style="height: 40px;" path="email" type="text" placeholder="Enter Email" class="form-control" required="true" autofocus="true"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span>
							<form:input style="height: 40px;" path="password" type="password" placeholder="Enter Password" class="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<input class="btn btn-primary center-block" type="submit" value="Sign in">
						</div>
						<div class="form-group pull-right">
							<a href="registration.html" class="btn btn-success btn-md">Register</a>&nbsp
							<input class="btn btn-danger btn-md" type="reset" value="Reset" />
						</div>
					</form:form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12">
						<p>&copy; Sunil Panchal</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>