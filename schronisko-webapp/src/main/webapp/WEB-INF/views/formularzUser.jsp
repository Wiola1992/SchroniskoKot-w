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
<title>Kontakt</title>
</head>
<body>
	<h1>Strona schroniska</h1>
	<p>Aby się zarejestrować wypełnij poniższy formularz:</p>
	<br />

		<form:form method="POST" modelAttribute="formUser"  > 
			<table border="1">
				<tr>
					<td>
						Imię
					</td>
					<td>
						<form:input path="userName"/>
					</td>
					<td>
						<c:if test="${pageContext.request.method=='POST'}">
							<form:errors path="userName" />
						</c:if>
					</td>
				</tr>
				
				<tr>
					<td> 
						Hasło: 
					</td>
					<td>
						<form:input path="password"/>
					</td>
					<td>
						<c:if test="${pageContext.request.method=='POST'}">
							<form:errors path="password" />
						</c:if>
					</td>
				</tr>
				
			</table>
		
			<br />
			
			
			<input type="submit" value="Zarejestruj się" />
		</form:form>  
	<br />
	<a href="/schronisko-webapp/wszystkie"> Powrót do listy kotów</a>
</body>
</html>