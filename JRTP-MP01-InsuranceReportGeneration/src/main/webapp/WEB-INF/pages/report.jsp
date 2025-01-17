<%@ page language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fnt" %>

<html lang="en">
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 </head>
 <body> 
 <h1 style="text-align: center;">Insurance Report Page</h1>
<div class="container-fluid">
<hr>
<frm:form action="report" modelAttribute="ic" class="row g-3">
	<table class="table table-borderless">
	<tr>
		<td>
			Plan Name :		
		</td>
		
		<td>
			<frm:select path="planName">
				<frm:option value="">--Select--</frm:option>
				<frm:options items="${planName}" />
			</frm:select>		
		</td>
		<td>
			Plan Status :		
		</td>
		
		<td>
			<frm:select path="planStatus">
				<frm:option value="">--Select--</frm:option>
				<frm:options items="${planStatus}"/>
				
				<%-- <c:forEach var="ps" items="${planStatus}">
					<option value="${ps}">${ps}</option>
				</c:forEach> --%>
			</frm:select>		
		</td>
		<td>
			Gender :		
		</td>
		
		<td>
			<frm:select path="gender">
				<option value="">--Select--</option>
					<frm:option value="Male">Male</frm:option>
					<frm:option value="Female">Female</frm:option>
			</frm:select>		
		</td>
		
	</tr>
	<tr>
		<td>Start Date</td>
		<td>
			<frm:input type="date" path="planStartDate"/>		
		</td>
		
		<td>End Date</td>
		<td>
			<frm:input type="date" path="planEndDate"/>		
		</td>
		<td><input type="submit" value="Search" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;
		<a  href="./" class="btn btn-secondary">Reset</a> 
		</td>
	</tr>
</table>

<hr>
<c:if test="${! empty errorMsg}">
  <div class="alert alert-warning" role="alert">
  	<b style="text-align: center;" class="mb-0">${errorMsg}</b>
  </div>
</c:if>

<c:if test="${! empty result}">
  <div class="alert alert-warning" role="alert">
  	<b style="text-align: center;" class="mb-0">${result}</b>
  </div>
</c:if>
<c:if test="${! empty citizenList}">
<h2 style="text-align: center;">Citizen Report</h2>
<table class="table table-hover">
	<thead>
		<tr>
		<th>S.No.</th><th>Name</th><th>Gender</th><th>Plan Name</th><th>Plan Status</th>
		<th>Start Date</th><th>End Date</th><th>Benifit Amnt</th>
		<th>denialReason</th><th>Terminate Date</th><th>Terminate Reason</th>
		</tr>
	</thead>
	<c:forEach var="citizen" items="${citizenList}" varStatus="status">
		<tr>
			<%-- <td>${status.count}</td>  <!-- index+1 or count --> --%>
			<!-- In pagination, in every page it will start with  1 thath why i have taken 
			below login-->
			
			<td>${(page.number * page.size) + status.count}</td>
			<td>${citizen.name}</td>
			<td>${citizen.gender}</td>
			<td>${citizen.planName}</td>
			<td>${citizen.planStatus}</td>
			<td>${citizen.planStartDate}</td>
			<td>${citizen.planEndDate}</td>
			<td>${citizen.benifitAmmount}</td>
			<td>${citizen.denialReason}</td>
			<td>${citizen.terminatedDate}</td>
			<td>${citizen.terminationReason}</td>
		</tr>
	</c:forEach>
</table>

<%-- div class="d-flex justify-content-center align-items-center my-3">
    <c:if test="${!page.isFirst()}">
        <a href="./search?page=0" class="btn btn-outline-primary btn-sm mx-1">First Page</a>
        <a href="./search?page=${page.getNumber()-1}" class="btn btn-outline-primary btn-sm mx-1">Previous</a>
    </c:if>
    <div class="mx-2">
        <c:forEach begin="0" end="${page.getTotalPages()-1}" step="1" varStatus="status">
            <a href="./search?page=${status.index}" class="btn btn-link btn-sm">${status.count}</a>
        </c:forEach>
    </div>
    <c:if test="${!page.isLast()}">
        <a href="./search?page=${page.getNumber()+1}" class="btn btn-outline-primary btn-sm mx-1">Next</a>
        <a href="./search?page=${page.getTotalPages()-1}" class="btn btn-outline-primary btn-sm mx-1">Last Page</a>
    </c:if>
</div> --%>

<div class="d-flex justify-content-center align-items-center my-3">
    <c:if test="${!page.isFirst()}">
        <a href="./search?page=0&name=${name}&status=${status}&gender=${gender}&startdate=${startdate}&enddate=${enddate}" class="btn btn-outline-primary btn-sm mx-1">First Page</a>
        <a href="./search?page=${page.getNumber()-1}&name=${name}&status=${status}&gender=${gender}&startdate=${startdate}&enddate=${enddate}" class="btn btn-outline-primary btn-sm mx-1">Previous</a>
    </c:if>
    <div class="mx-2">
        <c:forEach begin="0" end="${page.getTotalPages()-1}" step="1" varStatus="status">
            <a href="./search?page=${status.index}&name=${name}&status=${status}&gender=${gender}&startdate=${startdate}&enddate=${enddate}" class="btn btn-link btn-sm">${status.count}</a>
        </c:forEach>
    </div>
    <c:if test="${!page.isLast()}">
        <a href="./search?page=${page.getNumber()+1}&name=${name}&status=${status}&gender=${gender}&startdate=${startdate}&enddate=${enddate}" class="btn btn-outline-primary btn-sm mx-1">Next</a>
        <a href="./search?page=${page.getTotalPages()-1}&name=${name}&status=${status}&gender=${gender}&startdate=${startdate}&enddate=${enddate}" class="btn btn-outline-primary btn-sm mx-1">Last Page</a>
    </c:if>
</div>


<center>
<a href="./excel"><img src="images/excel.jpg"  height="40px" width="40px"></a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="./pdf"><img src="images/pdf.jpg"  height="40px" width="40px"></a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="./"><img src="images/home.jpg"  height="40px" width="40px"></a>
</center>
</c:if>
</frm:form>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
