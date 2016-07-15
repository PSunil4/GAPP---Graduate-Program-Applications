<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application Details</title>

<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/hr.css"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/viewDetailsDisplay.css" /> 

</head>
<body style="background-color: rgb(245, 245, 245)">
	<div class="container">
		<div class="row" style="margin-top: 20px">
			<div class="col-md-12">
				<fieldset>
					<h2>Student Application Information</h2>
					<hr class="colorgraph">
					<h4 class="text-right">Welcome ${username} | <a href="logout.html">Logout</a></h4>
				</fieldset>
			</div>
			<a class="btn btn-success pull-right" href="studenthome.html" role="button">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"> </span> Back </a>
			
			<div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 bhoechie-tab-container">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 bhoechie-tab-menu">
              <div class="list-group">
                <a href="#ai" class="list-group-item active text-center" style="width: 250px; height: 100px;">
                  <h4 class="glyphicon glyphicon-list-alt"></h4><br/>Application Information
                </a>
                <a href="#si" class="list-group-item text-center" style="width: 250px; height: 100px;">
                  <h4 class="glyphicon glyphicon-user"></h4><br/>Student Information
                </a>
                <a href="#ci" class="list-group-item text-center" style="width: 250px; height: 100px;">
                  <h4 class="glyphicon glyphicon-book"></h4><br/>Educational Background
                </a>
                <a href="#ar" class="list-group-item text-center" style="width: 250px; height: 100px;">
                  <h4 class="glyphicon glyphicon-pencil"></h4><br/>Academic Records
                </a>
                <a href="#af" class="list-group-item text-center" style="width: 250px; height: 100px;">
                  <h4 class="glyphicon glyphicon-plus-sign"></h4><br/>Additional Fields
                </a>
              </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 bhoechie-tab">
                <!-- flight section -->
                <div class="bhoechie-tab-content active">
                    <center>
                     <div class="pricing_header">
                     	<h2>Application Information</h2>
                        <div class="space"></div>
    				</div>
					<table
						class="table table-striped table-hover table-responsive active table-reflow table-inverse">
							<thead>
								<tr>
									<th>Fields</th>
									<th>Records</th>
								</tr>
							</thead>
							<tbody>
							<tr>
								<th scope="row">Program To Apply</th>
								<td>${applicationDetails.programToApply.programName }</td>
							</tr>
							<tr>
								<th scope="row">Programs' Department</th>
								<td>${applicationDetails.programToApply.department.departmentName }</td>
							</tr>
							<tr>
								<th scope="row">Application Term</th>
								<td>${applicationDetails.applicationTerm }</td>
							</tr>							
						</tbody>
					</table>
                    </center>
                </div>
                <!-- train section -->
                <div class="bhoechie-tab-content">
                    <center>
                    	<div class="pricing_header">
                     		<h2>Student Information</h2>
                        	<div class="space"></div>
    					</div>
                      <table
						class="table table-striped table-hover table-responsive active">
						<thead>
							<tr>
								<th>Student Fields</th>
								<th>Student Records</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Full Name</th>
								<td>${applicationDetails.appfirstname }
									${applicationDetails.appLastname }</td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td>${applicationDetails.appEmail }</td>
							</tr>
							<tr>
								<th scope="row">CIN</th>
								<td>
									<c:if test="${applicationDetails.appCIN == 0}">
										-
									</c:if>
									<c:if test="${applicationDetails.appCIN != 0}">
										${applicationDetails.appCIN }
									</c:if>
									
								</td>
							</tr>
							<tr>
								<th scope="row">Phone Number</th>
								<td>${applicationDetails.appPhoneNumber }</td>
							</tr>
							<tr>
								<th scope="row">Gender</th>
								<td>${applicationDetails.appGender }</td>
							</tr>
							<tr>
								<th scope="row">Birthdate</th>
								<td><fmt:formatDate type="date" dateStyle="long"
										value="${applicationDetails.appBirthdate }" /></td>
							</tr>
							<tr>
								<th scope="row">Citizenship</th>
								<td>${applicationDetails.appCitizenship }</td>
							</tr>	
						</tbody>
					</table>
                    </center>
                </div>
    
                <!-- hotel search -->
                <div class="bhoechie-tab-content">
                    <center>
                    	<div class="pricing_header">
                     		<h2>List of College/University Degrees</h2>
                        	<div class="space"></div>
    					</div>
                      <table
								class="table table-striped table-hover table-responsive active">
								<thead>
									<tr>
										<th>Institution Name</th>
										<th>Duration</th>
										<th>Degree Earned</th>
										<th>Major Of Degree</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${educationBackground}" var="background">
										<tr>
											<td>${background.nameOfInstitute }</td>
											<td>${background.timePeriodAttended }</td>
											<td>${background.degreeEarned }</td>
											<td>${background.majorOfDegree }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
                    </center>
                </div>
                <div class="bhoechie-tab-content">
                    <center>
                    	<div class="pricing_header">
                     		<h2>Academic Records</h2>
                        	<div class="space"></div>
    					</div>
                      <table
								class="table table-striped table-hover table-responsive active">
								<thead>
									<tr>
										<th>TOEFL Score</th>
										<th>GPA</th>
										<th>Transcript</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<c:if test="${applicationDetails.academicRecords.TOEFLScore == 0}">
											<td>Domestic Student</td>
										</c:if>
										<c:if test="${applicationDetails.academicRecords.TOEFLScore > 0}">
											<td>${applicationDetails.academicRecords.TOEFLScore }</td>
										</c:if>
										<td>${applicationDetails.academicRecords.GPA }</td>
										<td><a
											href="download.html?fileName=${applicationDetails.academicRecords.transcript}">${applicationDetails.academicRecords.transcript}</a></td>
									</tr>
								</tbody>
							</table>
						</center>
                </div>
                
                 <div class="bhoechie-tab-content">
                    <center>
                    	<div class="pricing_header">
                     		<h2>Additional Department Fields</h2>
                        	<div class="space"></div>
    					</div>
							<table
								class="table table-striped table-hover table-responsive active">
								<thead>
									<tr>
										<th>Field Name</th>
										<th>Field Value</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${additionalFields}" var="af"
										varStatus="count">
										<c:forEach items="${additionalFieldsValue}" var="fv"
											varStatus="count1">
											<c:if test="${count.index == count1.index}">
												<tr>
													<td>${af.fieldName }</td>
													<c:if test="${af.fieldValueType == 'File' }">
														<td>
															<a href="download.html?fileName=${fv.additionalFieldValue}">${fv.additionalFieldValue}</a>
														</td>
													</c:if>
													<c:if test="${af.fieldValueType != 'File' }">
														<td>${fv.additionalFieldValue}</td>
													</c:if>		
												</tr>
											</c:if>
										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</center>
                </div>
            </div>
        </div>
  </div>
</div>
				
	<script>
			$(document).ready(function() {
				$(".list-group a").click(function() {
					$(this).tab('show');
				});
				$("div.bhoechie-tab-menu>div.list-group>a").click(function(e) {
			        e.preventDefault();
			        $(this).siblings('a.active').removeClass("active");
			        $(this).addClass("active");
			        var index = $(this).index();
			        $("div.bhoechie-tab>div.bhoechie-tab-content").removeClass("active");
			        $("div.bhoechie-tab>div.bhoechie-tab-content").eq(index).addClass("active");
				});
			});
		</script>
</body>
</html>

