<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h3 class="my-3">Report Application</h3>
		<form:form action="search" modelAttribute="search" method="POST">
			<table class="table">
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names}"/>
						</form:select></td>
					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}"/>
						</form:select></td>
					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td><form:input type="date" path="startDate" value="${search.startDate}" /></td>
					<td>End Date:</td>
					<td><form:input type="date" path="endDate" value="${search.endDate}" /></td>
				</tr>
				<tr>
					<td>Returned Start Date</td>
					<td>${search.startDate}</td>
					<td>Returned End Date</td>
					<td>${search.endDate}</td>
				</tr>
				<tr>
					<td><a href="/" class="btn btn-secondary" >Reset</a></td>
					<td><input type="submit" value="Search" class="btn btn-primary" /></td>
				</tr>
			</table>
		</form:form>
		<hr/>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>S.No</th>
						<th>Holder Name</th>
						<th>Gender</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Benefit Amt</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${plans}" var="plan" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plan.citizenName}</td>
							<td>${plan.gender}</td>
							<td>${plan.planName}</td>
							<td>${plan.planStatus}</td>
							<td>${plan.planStartDate}</td>
							<td>${plan.planEndDate}</td>
							<td>${plan.benefitAmt}</td>
						</tr>
					</c:forEach>
					<c:if test="${empty plans}">
						<tr>
							<td colspan="8" class="text-center">No records found</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		<hr/>
		Export : <a href="excel">Excel</a> <a href="pdf">Pdf</a> <a href="email-excel">Send Excel to Email</a> <a href="email-pdf">Send PDF to Email</a>
		${excelToEmailMsg}
		${pdfToEmailMsg}
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
		crossorigin="anonymous"></script>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Citizen Plans Report</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

<!-- Custom CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<div class="container my-5">

    <div class="card p-4 shadow-sm border-0 rounded-4">
        <h3 class="text-center mb-4 fw-semibold text-primary">Citizen Plans Report</h3>

        <!-- Search Form -->
        <form:form action="search" modelAttribute="search" method="POST" class="mb-4">
            <div class="row g-3 align-items-end">
                <div class="col-md-3">
                    <label class="form-label fw-semibold">Plan Name</label>
                    <form:select path="planName" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Plan Status</label>
                    <form:select path="planStatus" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Gender</label>
                    <form:select path="gender" class="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">Start Date</label>
                    <form:input type="date" path="startDate" value="${search.startDate}" cssClass="form-control" />
                </div>

                <div class="col-md-3">
                    <label class="form-label fw-semibold">End Date</label>
                    <form:input type="date" path="endDate" value="${search.endDate }" cssClass="form-control" />
                </div>

                <div class="col-md-6 d-flex justify-content-start mt-3">
                    <a href="/" class="btn btn-secondary btn-custom me-2">Reset</a>
                    <input type="submit" value="Search" class="btn btn-primary btn-custom" />
                </div>
            </div>
        </form:form>

        <!-- Results Table -->
        <div class="table-responsive">
            <table class="table table-striped table-hover align-middle text-center">
                <thead class="table-header">
                    <tr>
                        <th>S.No</th>
                        <th>Holder Name</th>
                        <th>Gender</th>
                        <th>Plan Name</th>
                        <th>Plan Status</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Benefit Amt</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${plans}" var="plan" varStatus="index">
                        <tr>
                            <td>${index.count}</td>
                            <td>${plan.citizenName}</td>
                            <td>${plan.gender}</td>
                            <td>${plan.planName}</td>
                            <td>
                                <span class="badge 
                                    ${plan.planStatus eq 'Approved' ? 'bg-success' : 
                                     plan.planStatus eq 'Denied' ? 'bg-danger' : 
                                     'bg-secondary'}">
                                    ${plan.planStatus}
                                </span>
                            </td>
                            <td>${plan.planStartDate}</td>
                            <td>${plan.planEndDate}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty plan.benefitAmt}">
                                        ₹ ${plan.benefitAmt}
                                    </c:when>
                                    <c:otherwise>-</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty plans}">
                        <tr>
                            <td colspan="8" class="text-center text-muted py-3">No records found</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>

        <!-- Export Section -->
        <div class="d-flex justify-content-between align-items-center mt-4">
            <div class="export-links">
                <span class="fw-semibold text-dark me-2">Export :</span>
                <a href="excel">Excel</a>
                <a href="pdf">PDF</a>
                <a href="email-excel">Send Excel via Email</a>
                <a href="email-pdf">Send PDF via Email</a>
            </div>
            <div class="footer-msg text-success fw-medium">
                ${excelToEmailMsg} ${pdfToEmailMsg}
            </div>
        </div>

    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</body>
</html>
