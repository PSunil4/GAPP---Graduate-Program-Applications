<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Application</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../css/customTable.css"/>
<link rel="stylesheet" href="../css/hr.css"/>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery-2.2.1.min.js"></script>
</head>
<body style="background-color: rgb(245, 245, 245)">
	<div class="container">
		<div class="row" style="margin-top: 20px">
			<div class="col-md-12">
				<fieldset>
					<h2>Create A New Application</h2>
					<hr class="colorgraph">
					<h4 class="text-right">Welcome ${username} | <a href="logout.html">Logout</a></h4>
				</fieldset>
			</div>
			
			<div>
				<span style="width: 200px;"><p class="text-center bg-danger pull-left" style="font-size: 20px;">
				<span class="${icon}" aria-hidden="true"> </span> 
				<strong>${applicationstatus}</strong></p></span>  
				
				<a class="btn btn-success pull-right" href="studenthome.html" role="button">
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"> </span> Back </a>
			</div>
			
			
			<div class="row">
				<div class="col-md-12" style="padding-top: 10px;">
					<form:form role="form" modelAttribute="application" action="createnewapplication.html" method="post" enctype="multipart/form-data">
<!-- START -->
<!-- Application Information -->
						<div class="tag-box tag-box-v3" id="appInfo">
							<div class="headline">
								<h3>Application Information</h3>
								<div class="form-group row">
									<br />
										<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Select A Department</h4>
										<div class="dropdown">
											<div class="col-md-4">
												<select name="departmentNames" class="form-control"
													id="departmentName"
													onchange="changePrgByDept(); getAdditionalRequirements();">
													<c:forEach items="${listOfDepartments}" var="depts">
														<option value="${depts.departmentId}">${depts.departmentName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Program To Apply</h4>
									<div class="dropdown">
										<div class="col-md-4">
											<select name="programName" class="form-control" id="programs">
											</select>
										</div>
									</div>
								</div>
								
								<div class="form-group row">
									<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Application Term</h4>
									<div class="dropdown">
										<div class="col-md-4">
											<form:select name="applicationTerm" class="form-control" path="applicationTerm">
												<form:option value="Winter 2016">Winter 2016</form:option>
												<form:option value="Spring 2016">Spring 2016</form:option>
												<form:option value="Fall 2016">Fall 2016</form:option>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>
<!-- Application Information -->				
<!-- STUDENT INFORMATION -->							
						<div class="tag-box tag-box-v3" id="basicInfo">
							<div class="headline" id="studentInfo">
								<h3>Student Information</h3>

								<div class="form-group row">
									<br />
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>First Name</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="firstName"
											placeholder="First Name" path="appfirstname" />
									</div>
									<h4 class="text-info col-md-2 form-control-label text-right"><span style="color:red;"><strong>*</strong></span>Last Name</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="lastName"
											placeholder="Last Name" path="appLastname"/>
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>Email</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="email" 
											placeholder="Email" path="appEmail"/>

									</div>
									<h4 class="text-info col-md-2 form-control-label text-right"><span style="color:red;"><strong>*</strong></span>Phone Number</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="phoneNumber" 
											placeholder="Phone Number" path="appPhoneNumber"/>									
									</div>
								</div>
								
								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>Citizenship</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="citizenship" 
											placeholder="Citizenship" path="appCitizenship"/>											
									</div>
									<h4 class="text-info col-md-2 form-control-label text-right">CIN</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="CIN" 
											placeholder="CIN" path="appCIN"/>
									</div>
								</div>
								
								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>Birthdate</h4>
									<div class="col-md-3">
										<form:input class="form-control" type="date" name="appBirthdate" 
											placeholder="mm/dd/yyyy" path="appBirthdate" required="true"/>
									</div>
									<h4 class="text-info col-md-2 form-control-label text-right"><span style="color:red;"><strong>*</strong></span>Gender</h4>
									<div class="col-md-3">
										<form:select name="gender" class="form-control" id="gender"
											path="appGender">
											<form:option value="Male"> Male </form:option>
											<form:option value="Female"> Female </form:option>
										</form:select>
									</div>
								</div>
							</div>
						</div>
<!-- STUDENT INFORMATION -->	
<!-- INSTITUTIONAL INFORMATION -->
						<div class="tag-box tag-box-v3" id="basicInfo">
							<div class="headline" id="studentInfo">
								<h3>Educational Background</h3>

								<div class="form-group row">
									<br />
									<table class="table table-responsive active">
										<thead>
											<tr>
												<th>Number Of Records</th>
												<th>Institution Name</th>
												<th>Duration</th>
												<th>Degree</th>
												<th>Major</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row"><span style="color:red;"><strong>*</strong></span>First Credential</th>
												<td><input class="form-control" name="institutionName1"
													placeholder="College Name" required="true" /></td>
												<td><input class="form-control"
													name="timePeriodAttended1" placeholder="(2011- 2015)"
													required="true" /></td>
												<td><input class="form-control" name="degreeEarned1"
													placeholder="Bachelor's degree" required="true" /></td>
												<td><input class="form-control" name="majorOfDegree1"
													placeholder="Name Of Major" required="true" /></td>
											</tr>
											<tr>
												<th scope="row">Second Credential</th>
												<td><input class="form-control" name="institutionName2"
													placeholder="College Name" /></td>
												<td><input class="form-control"
													name="timePeriodAttended2" placeholder="(2011- 2015)" /></td>
												<td><input class="form-control" name="degreeEarned2"
													placeholder="Bachelor's degree" /></td>
												<td><input class="form-control" name="majorOfDegree2"
													placeholder="Name Of Major" /></td>
											</tr>
											<tr>
												<th scope="row">Third Credential</th>
												<td><input class="form-control" name="institutionName3"
													placeholder="College Name" /></td>
												<td><input class="form-control"
													name="timePeriodAttended3" placeholder="(2011- 2015)" /></td>
												<td><input class="form-control" name="degreeEarned3"
													placeholder="Bachelor's degree" /></td>
												<td><input class="form-control" name="majorOfDegree3"
													placeholder="Name Of Major" /></td>
											</tr>
											<tr>
												<th scope="row">Forth Credential</th>
												<td><input class="form-control" name="institutionName4"
													placeholder="College Name" /></td>
												<td><input class="form-control"
													name="timePeriodAttended4" placeholder="(2011- 2015)" />
												</td>
												<td><input class="form-control" name="degreeEarned4"
													placeholder="Bachelor's degree" /></td>
												<td><input class="form-control" name="majorOfDegree4"
													placeholder="Name Of Major" /></td>
											</tr>
										</tbody>
									</table>
								</div>
						</div>
					</div>
<!-- INSTITUTIONAL INFORMATION -->
<!-- ACADEMIC RECORDS -->
						<div class="tag-box tag-box-v3" id="appInfo">
							<div class="headline">
								<h3>Academic Records</h3>
								<div class="form-group row">
									<br />
									<h4 class="text-info col-md-3 form-control-label text-right"
										style="width: 250px;">International Student?</h4>
									<div class="dropdown">
										<div class="col-md-3">
											<form:select name="gender" class="form-control"
												id="international" path="international"
												onchange="changeInternational();">
												<form:option value="True"> Yes </form:option>
												<form:option value="False"> No </form:option>
											</form:select>
										</div>
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										id="internationallbl" style="width: 250px;">TOEFL Score</h4>
									<div class="col-md-3">
										<form:input class="form-control" id="toefl" name="TOEFLScore"
											placeholder="TOELF Score" path="academicRecords.TOEFLScore" />
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										style="width: 250px;"><span style="color:red;"><strong>*</strong></span>GPA</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="GPA" placeholder="GPA"
											path="academicRecords.GPA" />
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										style="width: 250px;"><span style="color:red;"><strong>*</strong></span>Transcript</h4>
									<div class="col-md-3">
										<input type="file" class="form-control" name="transcript"
											placeholder="Transcript" />
									</div>
								</div>

							</div>
						</div>
<!-- ACADEMIC RECORDS -->
<!-- DEPARTMENT ADDITIONAL FIELDS -->
						<div class="tag-box tag-box-v3" id="appInfo">
							<div class="headline">
								<h3>Additional Department Requirement(s)</h3>
								<div class="form-group row">
									<br />
									<div class="col-md-3" id="additionalFieldsDiv">
		
									</div>
								</div>
							</div>
						</div>
<!-- DEPARTMENT ADDITIONAL FIELDS -->
<!-- APPLICATION OPERATIONS -->
						<div class="col-md-offset-4 col-md-4" style="margin-bottom: 30px">
							<input class="btn btn-success" name="submit" type="submit"	value="Submit Application"> &nbsp;&nbsp;
							<input class="btn btn-success" name="submit" type="submit" value="Save" style="width: 141px;">
						</div>
<!-- APPLICATION OPERATIONS -->
<!-- END -->
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	
	function changePrgByDept() {
		var deptName = $("#departmentName").val();

		$.ajax({
			type : 'GET',
			url : 'deptprogwithajax.html',
			dataType : 'json',
			data : {
				deptId : deptName
			},
			success : function(response) {
				var deptPrograms = "";
				for (var i = 0; i < response.length; i++) {
					deptPrograms += "<option value='" + response[i]["programId"]+ "'>"
						+ response[i]["programName"] + "</option>";
				}
				$("#programs").html(deptPrograms)
			},
			error : function(xmlHttpRequest, textStatus, errorThrown) {
				if (xmlHttpRequest.readyState = 0 || xmlHttpRequest.status == 0)
					return;
				}
		});
	}
	var counter = 0;
	function getAdditionalRequirements() {
		var deptName = $("#departmentName").val();
		
		$.ajax({
			type : 'GET',
			url : 'additionalFieldsWithAjax.html',
			dataType : 'json',
			data : {
				deptId : deptName
			},
			success : function(response) {
				var deptPrograms = "";
				
				$("#additionalFieldsDiv").empty();
				
				for (var i = 0; i < response.length; i++) {

					var additionalInfoRecord = $(document.createElement('div'))
				     .attr("id", 'additionalRecord' + i);
					
					if (response[i]["fieldValueType"] == "Text" || response[i]["fieldValueType"] == "Number") {
						additionalInfoRecord.after().html(
									'<h4 class="text-info form-control-label" style="width: 250px;">'+ response[i]["fieldName"] + ' : </h4>'
									+ '<input type="text" class="form-control" name="textbox' + i + '" id="textbox' + i + '" value="" required="required">');
					}
					else {
						additionalInfoRecord.after().html(
										'<h4 class="text-info form-control-label" style="width: 250px;"> ' + response[i]["fieldName"]+ ' : </h4>'
										+ '<input type="file" class="form-control" name="files[' + counter + ']" id="textbox' + i + '" required="required">');
					}
					additionalInfoRecord.appendTo("#additionalFieldsDiv");
					counter++;
				}				
				
			},
			error : function(xmlHttpRequest, textStatus, errorThrown) {
				if (xmlHttpRequest.readyState = 0 || xmlHttpRequest.status == 0)
					return;
				}
		});
	}
	
	function changeInternational() {
		var deptName = $("#international").val();
	        if (deptName == "True") {
	        	$("#internationallbl").show();
	            $("#toefl").show();
	        }
	        else {
	        	$("#internationallbl").hide();
	            $("#toefl").hide();
	        }
	        	
	}
	
	
	$(document).ready(function() {
		changePrgByDept();
		changeInternational();
		getAdditionalRequirements();
	});
	
	
</script>
</html>