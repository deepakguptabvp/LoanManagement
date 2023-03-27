<%@ taglib prefix="sf"uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form"prefix="form"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java"contentType="text/html;charset=ISO-8859-1"
pageEncoding="ISO-8859-1"isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LoanBazaar:LoanEligibilityCheckResults</title>
</head>
<body style="background-color:rgb(200,250,300)">

<h3>${msg}</h3>
<form:form id="results">
<c:if test="${not empty data}">
<table id="resultsTable"border="1">
<tr>
<td>BankName</td>
<td>LoanProductName</td>
<td>Max Eligible Loan Amount in Rupees</td>
<td>Tenure</td>
<td>Interest</td>
<td>EMIinRupees</td>
</tr>
<c:forEach items="${data}"var="a">
<tr>
<td>${a.bankName}</td>
<td>${a.loanProductName}</td>
<td>${a.maxLoanAmount}</td>
<td>${a.tenure}</td>
<td>${a.interest}</td>
<td>${a.monthlyInstallment}</td>
</tr>
</c:forEach>
</table>
</c:if>
</form:form>
</body>
</html