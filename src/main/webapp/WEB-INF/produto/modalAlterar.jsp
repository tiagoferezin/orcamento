<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modalAlterar" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-produto" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Produto</h4>
				</div>
				<div class="modal-body">
					<label for="descricao">Descrição: </label> <input id="descricao"
						name="descricao" class="form-control"> <label
						for="quantidade">Quantidade: </label> <input id="quantidade"
						name="quantidade" class="form-control"> <label
						for="unidadeDeMedida">Unidade de medida: </label> <select
						id="unidadeDeMedida" name="unidadeDeMedida" class="form-control">
						<c:forEach items="${listaUnidadeDeMedida}" var="unidadeDeMedida">
							<option value="${unidadeDeMedida}">${unidadeDeMedida}</option>
						</c:forEach>
					</select> 
					<label for="valorUnitario">Valor Unitário: </label> R$<input
						id="valorUnitario" name="valorUnitario"
						class="valorUnitario form-control" style="display: inline-block" placeholder="100.00">

					<input id="id" name="id" type="hidden"> <input id="csrf"
						name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-primary">Salvar
						Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>