<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<table id="tabela-clientes" class="display" style="width: 100%">
	<thead>
		<tr>
			<th>Nome</th>
			<th>Editar</th>
			<th>Deletar</th>

		</tr>
	</thead>
	<tbody>

		<c:forEach items="${listaClientes }" var="cliente">
			<tr data-id="${cliente.idCliente }">
				<td>${cliente.nome }</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button"
						class="btn btn-danger btn-deletar-tabela" data-toggle="modal"
						data-target="#modalConfirmarExclusao">Deletar</button></td>
			</tr>

		</c:forEach>

	</tbody>
	<tfoot>
		<tr>
			<th>Nome</th>
			<th>Editar</th>
			<th>Deletar</th>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalAlterar" style="float: right;">Cadastrar
					Cliente</button>
			</td>
		</tr>
	</tfoot>
</table>
