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
	<title>Produtos</title>
</head>
<body>
	
	
	<a href="../">Sítio Zang</a>
	<h1>Gerenciamento de Produtos</h1>
	<h2>
	 <a href="new" class="btn btn-success" >Cadastrar produto</a>
	</h2>
	
	
	
	<div align="center" >
		<table class="table table-striped" >
			<thead>
				<tr>
					<th>Id</th>
					<th>Descrição</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="produto" items="${listaProduto}">
					<tr>
						<td > <c:out value="${produto.id}" /> </td>	
						<td> <c:out value="${produto.descricao}" /> </td>
						<td> 
							<a class="btn btn-primary" href="edit?id=${produto.id}" >Editar</a>
							<a class="btn btn-danger" href="delete?id=${produto.id}">Deletar</a></td>
						
					</tr>	
				</c:forEach>
			</tbody>

			
		</table>
		
	
	
	</div>

 
	
	
</body>
</html>