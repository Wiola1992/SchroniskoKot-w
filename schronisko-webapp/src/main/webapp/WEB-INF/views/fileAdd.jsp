<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Strona schroniska</h1>
	<p>Poniżej możesz dodać zdjęcie swojego pupila </p>
	


	<form enctype="multipart/form-data" method="post" action="/schronisko-webapp/pokazkota/${id}/file/upload?${_csrf.parameterName}=${_csrf.token}" modelAttribute="fileAdd">
		Zdjęcie <input type="file" name="file" /> 
		Opis <input type="text" name="description" /> 
		
		<input type="submit" value="Dodaj zdjęcie" />
	</form>




	<a href="/schronisko-webapp/pokazkota/${id}"> Powrót </a>

</body>
</html>