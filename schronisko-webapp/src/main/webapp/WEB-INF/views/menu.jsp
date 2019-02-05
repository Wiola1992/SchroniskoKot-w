<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona schroniska kotów</title>
</head>
<body>

	<h1><spring:message code="webapp.kontroler.menu.title" /> </h1>
	<spring:message code="webapp.kontroler.menu.subtitle" />
	<br/>
	<a href="/schronisko-webapp/wszystkie"><spring:message code="webapp.kontroler.menu.allLink" /></a> 
	<br/>
	<a href="/schronisko-webapp/dodaj"><spring:message code="webapp.kontroler.menu.newLink" /></a>
	<br/>
	<a href="/schronisko-webapp/registration"> <spring:message code="webapp.kontroler.menu.registrationLink" /></a>
		</br>
	
	<a href="/schronisko-webapp/?language=pl ">Polski</a>
		<a href="/schronisko-webapp/?language=en ">Angielski</a>

</body>
</html>