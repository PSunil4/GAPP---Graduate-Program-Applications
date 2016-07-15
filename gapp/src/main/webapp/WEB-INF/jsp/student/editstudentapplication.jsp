<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student Application</title>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap-theme.min.css"/>
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
					<h2>Edit Student Application</h2>
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
					<form:form role="form" modelAttribute="application"
						action="editstudentapplication.html" method="POST"
						enctype="multipart/form-data">
						
						<div class="tag-box tag-box-v3" id="appInfo">
							<div class="headline">
								<h3>Application Information</h3>
								<div class="form-group row">
									<br />
										<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Department Name</h4>
										<div class="col-md-3">
											<h4 class="text-danger form-control-label">${department.departmentName}</h4>
											<input type="hidden" id="departmentName" value="${department.departmentId}" />
										</div>
								</div>
								<hr>
								
								<div class="form-group row">
									<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Program To Apply</h4>
									<div class="dropdown">
										<div class="col-md-4">
											<select name="programName" class="form-control">
												<c:forEach items="${programs}" var="prgs">
													<c:choose>
													<c:when test="${prgs.programName == programSelected}">
														<option value="${prgs.programId}" selected="true">${prgs.programName}</option>
													</c:when>
													<c:otherwise>
														<option value="${prgs.programId}">${prgs.programName}</option>
													</c:otherwise>
												</c:choose>
												</c:forEach>			
											</select>
										</div>
									</div>
								</div>
								
								<div class="form-group row">
									<h4 class="text-info col-md-3 form-control-label text-right" style="width: 200px;">Application Term</h4>
									<div class="dropdown">
										<div class="col-md-4">
											<form:select name="applicationTerm" class="form-control"
												path="applicationTerm">
												<form:option value="Winter 2016">Winter 2016</form:option>
												<form:option value="Spring 2016">Spring 2016</form:option>
												<form:option value="Fall 2016">Fall 2016</form:option>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>

<!-- APPLICATION INFORMATION -->
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
												placeholder="Last Name" path="appLastname" />
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>Email</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="email"
												placeholder="Email" path="appEmail" />

									</div>
									<h4 class="text-info col-md-2 form-control-label text-right">*Phone Number</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="phoneNumber"
												placeholder="Phone Number" path="appPhoneNumber" />								
									</div>
								</div>
								
								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right" style="width: 150px;"><span style="color:red;"><strong>*</strong></span>Citizenship</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="citizenship"
												placeholder="Citizenship" path="appCitizenship" />											
									</div>
									<h4 class="text-info col-md-2 form-control-label text-right">CIN</h4>
									<div class="col-md-3">
										<form:input class="form-control" name="CIN" placeholder="CIN"
												path="appCIN" />
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
								<h3>Student Information</h3>

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
												<c:if test="${educationalBackground.size() == 4}">
													<c:forEach items="${educationalBackground}" var="eb" varStatus="status">
													<tr>
														<th scope="row">
															<c:choose>
																<c:when test="${status.count == 1 }">First Degree</c:when>
																<c:when test="${status.count == 2 }">Second Degree</c:when>
																<c:when test="${status.count == 3 }">Third Degree</c:when>
																<c:when test="${status.count == 4 }">Fourth Degree</c:when>
															</c:choose>
														</th>
														<td><input class="form-control"
															name="institutionName${status.count}" placeholder="College Name" value="${eb.nameOfInstitute}"/></td>
														<td><input class="form-control"
															name="timePeriodAttended${status.count}" placeholder="(2011- 2015)" value="${eb.timePeriodAttended}" /></td>
														<td><input class="form-control" name="degreeEarned${status.count}"
															placeholder="Bachelor's degree" value="${eb.degreeEarned}"/></td>
														<td><input class="form-control" name="majorOfDegree${status.count}"
															placeholder="Name Of Major" value="${eb.majorOfDegree}"/></td>
													</tr>
													</c:forEach>
												</c:if>
												<c:if test="${educationalBackground.size() < 4}">
													<c:forEach items="${educationalBackground}" var="eb" varStatus="status" end="${educationalBackground.size()}">
													<tr>
														<th scope="row">
															<c:choose>
																<c:when test="${status.count == 1 }">First Degree</c:when>
																<c:when test="${status.count == 2 }">Second Degree</c:when>
																<c:when test="${status.count == 3 }">Third Degree</c:when>
																<c:when test="${status.count == 4 }">Fourth Degree</c:when>
															</c:choose>
														</th>
														<td><input class="form-control"
															name="institutionName${status.count}" placeholder="College Name" value="${eb.nameOfInstitute}"/></td>
														<td><input class="form-control"
															name="timePeriodAttended${status.count}" placeholder="(2011- 2015)" value="${eb.timePeriodAttended}" /></td>
														<td><input class="form-control" name="degreeEarned${status.count}"
															placeholder="Bachelor's degree" value="${eb.degreeEarned}"/></td>
														<td><input class="form-control" name="majorOfDegree${status.count}"
															placeholder="Name Of Major" value="${eb.majorOfDegree}"/></td>
													</tr>
													</c:forEach>
													<c:forEach begin="${educationalBackground.size()+1}" end="4" varStatus="status">
														<tr>
															<th scope="row">
																<c:choose>
																	<c:when test="${status.index == 1 }">First Degree</c:when>
																	<c:when test="${status.index == 2 }">Second Degree</c:when>
																	<c:when test="${status.index == 3 }">Third Degree</c:when>
																	<c:when test="${status.index == 4 }">Fourth Degree</c:when>
																</c:choose>
															</th>
															<td><input class="form-control"
																name="institutionName${status.index}" placeholder="College Name" /></td>
															<td><input class="form-control"
																name="timePeriodAttended${status.index}" placeholder="(2011- 2015)"  /></td>
															<td><input class="form-control" name="degreeEarned${status.index}"
																placeholder="Bachelor's degree" /></td>
															<td><input class="form-control" name="majorOfDegree${status.index}"
																placeholder="Name Of Major"/></td>
														</tr>
													</c:forEach>
												</c:if>
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
										<div class="col-md-4">
											<form:select name="international" class="form-control"
												id="international" path="international" onchange="changeInternational();">
												<form:option value="True"> Yes </form:option>
												<form:option value="False"> No </form:option>	
											</form:select>
										</div>
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										id="internationallbl" style="width: 250px;">TOEFL Score</h4>
									<div class="col-md-4">
										<form:input class="form-control" name="TOEFLScore" id="toefl"
											placeholder="TOEFL Score" path="academicRecords.TOEFLScore" />
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										style="width: 250px;"><span style="color:red;"><strong>*</strong></span>GPA</h4>
									<div class="col-md-4">
										<form:input class="form-control" name="GPA" placeholder="GPA"
											path="academicRecords.GPA" />
									</div>
								</div>

								<div class="form-group row">
									<h4 class="text-info col-md-2 form-control-label text-right"
										style="width: 250px;"><span style="color:red;"><strong>*</strong></span>Transcript</h4>
									<div class="col-md-4">
										<input type="file" class="form-control" name="transcript"
											placeholder="Transcript" />
										<label><a
											href="download.html?fileName=${application.academicRecords.transcript}">Last Upload: ${application.academicRecords.transcript}</a></label>
									</div>
									
								</div>
							</div>
						</div>
<!-- ACADEMIC RECORDS -->
<!-- APPLICATION OPERATIONS -->
						<div class="col-md-offset-4 col-md-4" style="margin-bottom: 30px">
							<input class="btn btn-success" name="submit" type="submit"	value="Submit Application"> &nbsp;&nbsp;
							<input class="btn btn-success" name="submit" type="submit" value="Save" style="width: 141px;">
						</div>
<!-- APPLICATION OPERATIONS -->
					</form:form>
				</div>
			</div>

		</div>
	</div>
</body>
<script type="text/javascript">

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
		changeInternational();
		getAdditionalRequirements();
	});
	
</script>
</html>