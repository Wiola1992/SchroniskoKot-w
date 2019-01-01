<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>dodawanie kota</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
	<h1>Strona schroniska</h1>
	<p>W poniższym formularzu możesz dodać kota do bazy.</p>
	<br />

	

		<form:form method="POST" modelAttribute="form"  accept-charset="UTF-8"> 
			<table border="1">
				<tr><td>Imię</td><td><form:input path="name"  /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" /></c:if></td></tr>
				<tr><td>Waga</td><td><form:input path="weight" /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="weight" /></c:if></td></tr>
				<tr><td>Imię opiekuna</td><td><form:input path="nameOfGuardian" /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="nameOfGuardian" /></c:if></td></tr>
				<tr><td>Data urodzenia kota</td><td><form:input type="date" path="dateOfBirth" /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="dateOfBirth" /></c:if></td></tr>
			
			</table>
			dupa
			<br />
			
			
			<input type="submit" value="Wyślij formularz" />
		</form:form>  
	<br />
	<a href="/schronisko-webapp/wszystkie"> Powrót do listy kotów</a>
</body>
</html>