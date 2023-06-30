<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Meus contatos</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="styleAgenda.css">
</head>
<body>
	<div class="container-agenda">
		<div class="title-agenda">Meus Contatos</div>
		<div class="table">
			<table class="content-table">
				<%
				if (lista != null) {
				%>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Fone</th>
						<th>E-mail</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<th><%=lista.get(i).getNome()%></th>
						<th><%=lista.get(i).getFone()%></th>
						<th><%=lista.get(i).getEmail()%></th>
						<th>
							<div class=".btn-agenda">
								<a class="btn-primary"
									href="select?idcon=<%=lista.get(i).getIdecon()%>">Editar</a> <a
									class="btn-danger"
									href="javascript: confirmar(<%=lista.get(i).getIdecon()%>)">Deletar</a>
							</div>
						</th>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
		<div class="btn-agenda">
		    <a class="btn-primary" href="index.html">Index</a>
			<a class="btn-primary" href="novo.html">Novo Contato</a>
		</div>
	</div>
	<script src="scripts/validador.js" type="text/javascript"></script>
</body>
</html>