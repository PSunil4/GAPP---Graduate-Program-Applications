<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrators Page</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="row" style="margin-top: 20px">
			<div class="col-md-12">
				<fieldset>
					<h2>Administrator Home Page</h2>
					<hr>
					<h5 class="text-right">Welcome ${username} | <a href="logout.html">Logout</a></h5>
				</fieldset>
			</div>

		<div class="col-sm-3 col-md-3">
            <div class="well">
        		<h4 class="text-info text-center"><a href="listofdepartments.html">Manage Departments</a></h4>
        	</div>
        </div>
        		</div>
	</div>
	
	<br />
</body>
</html>