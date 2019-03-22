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
	<p>tu są dane wybranego kota</p>
	<ul>
		<li><strong>Imię kota to ${kotById.name}</strong></li>
		<li><strong>Jego waga ${kotById.weight} kg</strong></li>
		<li><strong>Imię opiekuna ${kotById.guardian}</strong></li>
		<li><strong>Data urodzenia ${kotById.dateOfBirth}</strong></li>
	</ul>
	<a href="/schronisko-webapp/pokazkota/${id}/file"> Dodaj zdjęcie </a>
	</br>
	</br>
	<c:if test="${empty files}" > 
		W bazie nie dodano zdjęcia.
	</c:if>
	<c:if test="${not empty files}">
		Oto zdjęcia:
		</br>
		</br>
		<c:forEach  var="file" items="${files}">  
			${file.originalFilename} 
						
			<a href="/schronisko-webapp/pokazkota/{id}/file/${file.name}"> Pobierz zdjęcie </a>
			</br>
		</c:forEach>
	</c:if>
		
	<c:if test="${empty zabawki}" > 
		Ten kot nie posiada jeszcze zabawki.
	</c:if>
	<c:if test="${not empty zabawki}">
		Oto lista zabawek:
		</br>
		</br>
		<c:forEach  var="zabawka" items="${zabawki}">  
			${zabawka.name} 			
			<a href="/schronisko-webapp/pokazkota/${id}/zabawka/${zabawka.idToys}/remove"> Usuń zabawkę </a>
			
			</br>
			
		</c:forEach>
	</c:if>
	</br>

	
	<a href="/schronisko-webapp/pokazkota/${id}/zabawka/add"> Dodaj nową zabawkę </a>
	</br>

	

<a href="/schronisko-webapp/wszystkie"> Pokaż wszystkie koty </a>

</body>
</html>