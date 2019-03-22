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
	<p>Wybierz miasto dla którego chcesz zobaczyć pogodę na najbliższe 5 dni.</p>
	<br />

	

		<form:form method="POST" modelAttribute="formPogoda"  accept-charset="UTF-8"> 
			<table border="1">
				<tr><td>Miasto</td><td><form:input path="city"  /></td><td><c:if test="${pageContext.request.method=='POST'}"><form:errors path="city" /></c:if></td></tr>
			
			</table>
			<br />
			
			<input type="submit" value="Sprawdź" />
		</form:form>  
	<br />
	<a href="/schronisko-webapp/wszystkie"> Powrót do listy kotów</a>
	<br />
	<br />
	<a href="/schronisko-webapp/kontakt"> Napisz wiadomość do nas </a>
</body>
</html>