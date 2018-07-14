/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var limparModalEditar = function() {
	$('#idCliente').val('');
	$('#nome').val('');
};

var aplicarListaners = function() {
	
	$('#tabela-clientes').DataTable({
		dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
	});

	$('#modalAlterar').on('hide.bs.modal', limparModalEditar);

	$('.btn-editar').click(function() {
		var idCliente = $(this).parents('tr').data('id');
		var url = "cliente/" + idCliente;

		$.get(url).done(function(cliente) {
			$('#idCliente').val(cliente.idCliente);
			$('#nome').val(cliente.nome);

			$('#modalAlterar').modal('show');
		});
	});

	$('.btn-deletar').click(function() {
		
		var idCliente = $('.btn-deletar-tabela').parents('tr').data('id');

		$.ajax({
			url : "cliente/" + idCliente,
			type : 'DELETE',
			success : function(result) {
			
				$('tr[data-id="' + idCliente + '"]').remove();
			}
		});

		$('#modalConfirmarExclusao').modal('hide');
	});

	$('#btn-salvar').click(function() {

		var url = "produto";
		var dadosProduto = $('#form-cliente').serialize();

		$.post(url, dadosProduto).done(function(pagina) {

			$('#secao-clientes').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

};