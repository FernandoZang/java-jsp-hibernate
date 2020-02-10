<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.*" %>
<%@ page import="dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>Gerenciamento Bovinos</title>
</head>
<body>

<a href="../">Sítio Zang</a>
<hr>
<a href="new" class="btn btn-success">Cadastrar Bovino</a>
<h1>Gerenciamento de Bovinos</h1>

<center>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Sexo</th>
				<th>Ação</th>
			<tr>
		</thead>
		
		<c:forEach var="b" items="${bovinos}">
			<tr>
				<td><c:out value="${ b.id }"></c:out></td>
				<td><c:out value="${ b.nome }"></c:out></td>
				<td><c:out value="${ b.sexo }"></c:out></td>
				<td> <a href="edit?id=${b.id }" class="btn btn-primary">Editar</a> </td>
			</tr>
		</c:forEach>
		
	</table>
</center>

</body>
</html>