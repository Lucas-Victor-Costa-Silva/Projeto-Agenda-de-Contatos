<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Editar contato</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="styleNovo.css">

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="title">Editar Contato</div>
		<form name="frmContato" action="update">
			<div class="user-details">
				<div class="input-box">
					<span class="details">Nome</span> <input type="text" name="nome"
						placeholder="Digite o seu nome" maxlength="50"
						value="<%out.print(request.getAttribute("nome"));%>" required>
				</div>
				<div class="input-box">
					<span class="details">E-mail</span> <input type="email"
						placeholder="Digite o seu e-mail" name="email" maxlength="50"
						value="<%out.print(request.getAttribute("email"));%>">
				</div>
				<div class="input-box">
					<span class="details">Celular</span> <input id="telefone"
						type="text" name="fone" type="text" placeholder="(XX) XXXX-XXXX"
						maxlength="15"
						value="<%out.print(request.getAttribute("fone"));%>" required>
				</div>
			</div>
			<div class="button">
				<a class="btn-success" type="submit" onclick="validar()">Confirmar</a>
				<a class="btn-danger" type="reset" href="main">Cancelar</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			//Telefone
			$("#telefone").mask("(99) 99999-9999");
		});
	</script>
	<script src="scripts/validador.js" type="text/javascript"></script>
</body>
</html>