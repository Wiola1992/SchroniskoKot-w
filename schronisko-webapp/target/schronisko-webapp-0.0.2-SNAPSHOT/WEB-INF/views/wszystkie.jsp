<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Strona schroniska</h1>
		
		<c:if test="${empty koty}">
		</br>
			Obecnie w bazie nie ma żadnego kota </br>
			</br>
		</c:if>
		</br>
		
		<c:if test="${not empty koty}">
			<p>Oto lista wszystkich kotów zapisanych w naszej bazie:</p>
			</br>
			<c:forEach varStatus="status" var="kot" items="${koty}">  
				<a href="<c:url value="/pokazkota/${kot.id}"/>">  ${kot.name} ${kot.dateOfBirth }   </a></br>
				
			</c:forEach>
		
		</c:if>
		</br>
		
		<a href="/schronisko-webapp/dodaj"> Dodaj nowego kota </a>
		</br>
		<a href="/schronisko-webapp/kontakt"> Napisz wiadomość do nas </a>
		</br>
		<a href="/schronisko-webapp"> Powrót do strony głównej</a>
</body>
</html>