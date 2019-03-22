<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Strona schroniska</h1>
	<p>Poniżej możesz dodać zabawkę</p>
	
	
	
		<form:form method="POST" modelAttribute="ToyAdd"  accept-charset="UTF-8"> 
			<table border="1">
				<tr><td>Nazwa </td><td><form:input path="nameToy"  /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="nameToy" /></c:if></td></tr>
				<tr><td>Opis</td><td><form:input path="description" /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="description" /></c:if></td></tr>
			
			</table>
			<br />
			
			
			<input type="submit" value="Dodaj zabawkę" />
		</form:form>  
		

<a href="/schronisko-webapp/pokazkota/${id}"> Powrót </a>

</body>
</html>