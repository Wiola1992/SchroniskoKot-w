<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Strona schroniska</h1>
	<p>Pogoda na najbliższe 5 dni</p>
	
	<strong>${pogoda.city.name}</strong>
	
	</br>
	</br>
	<table border = "1">
		<tr> 
			<td></td>
			<c:forEach  var="list" items="${dateList}"> 
				<c:if test="${list.hour == 12}">

					<td>${list.localDate} </td>
							
				</c:if> 
				</c:forEach>
	
	<tr> 
			<td> Dzieñ </td>
			 
			 <c:forEach  var="list" items="${dateList}"> 
					<c:if test="${list.hour == 12}">
							<td>${list.dayOfWeek} </td>
					</c:if> 
			</c:forEach>
		</tr>
		<tr> 
			<td> Temperatura </td>
			 
			 <c:forEach  var="list" items="${dateList}"> 
					<c:if test="${list.hour == 12}">
							<td>${list.mains.temp} </td>
					</c:if> 
			</c:forEach>
		</tr>
		<tr> 
			<td> Wiatr </td>
			 
			 <c:forEach  var="list" items="${dateList}"> 
					<c:if test="${list.hour == 12}">
							<td>${list.winds.speed} </td>
					</c:if> 
			</c:forEach>
		</tr>
		<tr> 
			<td> Opis </td>
			 
			 <c:forEach  var="list" items="${dateList}"> 
					<c:if test="${list.hour == 12}">
							 
							<c:forEach var="l" items="${list.weathers}">
							<td>	${l.description} </td>
							</c:forEach>
							 
					</c:if> 
			</c:forEach>
		</tr>
		
		<tr> 
			<td>  </td>
			 
			 <c:forEach  var="list" items="${dateList}"> 
					<c:if test="${list.hour == 12}">
							 
							<c:forEach var="l" items="${list.weathers}">
							<td> <img src="<c:url value="http://openweathermap.org/img/w/${l.icon}.png"/>"/>
							</c:forEach>
							 
					</c:if> 
			</c:forEach>
		</tr> 
	
		
	</table>
	

	

<a href="/schronisko-webapp/wszystkie"> Pokaż wszystkie koty </a>

</body>
</html>