<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

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
		<li><strong>Imię kota to ${kot.name}</strong></li>
		<li><strong>Jego waga ${kot.weight} kg</strong></li>
		<li><strong>Imię opiekuna ${kot.guardian}</strong></li>
		
		
	</ul>

</body>
</html>