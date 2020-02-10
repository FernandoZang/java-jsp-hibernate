<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	
	<title>Cadastrar Produto</title>
</head>

<body>
	
	<div class="container">
		<a href="list">Listar todos os produtos</a>
		<h1>Cadastrar Produto</h1>
		<form action="insert" method="post" class="form">
			<div class="form-group ">
				<label>Descrição: </label>
				<input required type="text" name="descricao" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-success form-control">Cadastrar</button>
		</form>
	</div>

	

</body>
</html>