<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="../css/customTable.css"/>
<link rel="stylesheet" href="../css/hr.css"/>
<script src="../js/bootstrap.min.js"></script>
</head>
<body style="background-color: rgb(245, 245, 245)">
	<div class="container">
		<div class="row" style="margin-top: 20px">
			<div class="col-md-12">
				<fieldset>
					<h2>Student Home Page</h2>
					<hr class="colorgraph">
					<h4 class="text-right" style="padding-bottom: 10px;">Welcome ${username} | <a href="logout.html">Logout</a></h4>
				</fieldset>
			</div>
			
			<div> 
				<span style="width: 200px;"><p class="text-center bg-success pull-left" style="font-size: 20px;">
				<span class="${icon}" aria-hidden="true"> </span> 
				<strong>${applicationstatus} <fmt:formatDate type="date" dateStyle="long" value="${date}" /></strong></p></span>  
				
				<a class="btn btn-success pull-right" href="createnewapplication.html" role="button">
				<span class="glyphicon glyphicon-new-window" aria-hidden="true"> </span>  Create New Application </a>
			</div>
			
            <table class="table table-striped table-hover table-responsive active"  style="padding-top: 10px;">
                <thead>
                	<tr>
	                   <th>Date Of Submission</th>
	                   <th>Department Name</th>
	                   <th>Program Name</th>
	                   <th>Application Term</th>
	                   <th>Application Status</th>
	                   <th>Application Details</th>
					</tr>
                </thead>
                <tbody>
                	<c:if test="${listOfApplications.size() < 1 }">
                		<tr>
                			<td colspan="6" align="center">No Applications Made</td>
                		</tr>
                	</c:if>
					<c:forEach items="${listOfApplications}" var="apps">
						<tr>
						
							<td> <fmt:formatDate type="date" dateStyle="long" value="${apps.dateOfSubmission}" /> </td>
							<td>${apps.programToApply.department.departmentName }</td>
							<td>${apps.programToApply.programName }</td>
							<td>${apps.applicationTerm }</td>
							<td>${apps.applicationStatus }</td>
							<td>
								<a class="btn btn-primary btn-sm" href="applicationdetails.html?appsId=${apps.applicationId}" role="button">
								<span class="glyphicon glyphicon-search" aria-hidden="true"> </span>  View </a>
			
								<c:if test="${apps.applicationStatus ne 'Submitted' }">
								|	<a class="btn btn-primary btn-sm" href="editstudentapplication.html?appsId=${apps.applicationId}" role="button">
									<span class="glyphicon glyphicon-edit" aria-hidden="true"> </span>  Edit </a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
        </div>
    </div>	
	<br />
</body>
</html>