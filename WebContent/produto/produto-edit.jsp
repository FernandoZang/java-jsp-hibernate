<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.ProdutoDao"%>
<%@ page import="models.Produto, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>Editar Produto</title>
</head>

<body>
	<h1>Editar Produto</h1>
	<a class="btn btn-primary" href="list">Listar Produtos</a>
	<div align="left">
		<form action="update" method="post" class="form">
			<div class="form-group">
				<label>ID: </label>
				<input class="form-control" required readonly type="text" name="id" value="${produto.id }">
			</div>
			<div class="form-group">
				<label>Descrição: </label>
				<input class="form-control" required type="text" name="descricao" value="${produto.descricao}">
			</div>
			<div class="form-group">
				<label>Versão: </label>
				<input class="form-control" required readonly type="text" name="version" value="${produto.version}">
			</div>
			
			<button class="form-control btn btn-success" type="submit">Salvar</button>
		</form>
	</div>

</body>
</html>