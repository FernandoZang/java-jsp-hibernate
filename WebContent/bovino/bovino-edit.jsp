<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="models.*" %>
<%@ page import="dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>Editar Bovino</title>
</head>
<body>


<h1>Editar Bovino</h1>
<a href="list" class="btn btn-primary">Listar Bovinos</a>
	<div align="left">
		<form class="form" action="update" method="post">
			<div class="form-group">
				<label>ID: </label>
				<input class="form-control" required readonly type="text" name="id" value="${bovino.id }">
			</div>	
			<div class="form-group">
				<label>Nome: </label>
				<input class="form-control" required type="text" name="nome" value="${bovino.nome}">
			</div>		
			<label>Sexo: </label>
			<div class="form-group">
				<select class="form-control" required name="sexo" >
					<c:forEach var="s" items="${sexos}">
						<c:choose>
							<c:when test="${s==bovino.sexo }">
								<option value="${s}" selected>${s}</option>
							</c:when>
							<c:otherwise>
								<option value="${s}">${s}</option>							
							</c:otherwise>
						</c:choose>
												
					</c:forEach>
				</select>
			</div>

			<button class="form-control btn btn btn-success" type="submit">Salvar</button>
		</form>
	</div>

</body>
</body>
</html>