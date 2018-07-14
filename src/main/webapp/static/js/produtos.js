/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var limparModalEditar = function() {
	$('#idProduto').val('');
	$('#descricao').val('');
	$('#quantidade').val('');
	$('#unidadeDeMedida').val('');
	$('#valorUnitario').val('');
};

var aplicarListaners = function() {
	
	$('#tabela-produtos').DataTable({
		dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
	});

	$('.valorUnitario').mask('##0.00', {
		reverse : true
	});

	$('.quantidade').mask('##0.000', {
		reverse : true
	});

	$('#modalAlterar').on('hide.bs.modal', limparModalEditar);

	$('.btn-editar').click(function() {
		var idProduto = $(this).parents('tr').data('id');
		var url = "produto/" + idProduto;

		$.get(url).done(function(produto) {
			$('#idProduto').val(produto.idProduto);
			$('#descricao').val(produto.descricao);
			$('#quantidade').val(produto.quantidade);
			$('#unidadeDeMedida').val(produto.unidadeDeMedida);
			$('#valorUnitario').val(produto.valorUnitario);

			$('#modalAlterar').modal('show');
		});
	});

	$('.btn-deletar').click(function() {
		
		var idProduto = $('.btn-deletar-tabela').parents('tr').data('id');

		$.ajax({
			url : "produto/" + idProduto,
			type : 'DELETE',
			success : function(result) {
			
				$('tr[data-id="' + idProduto + '"]').remove();
			}
		});

		$('#modalConfirmarExclusao').modal('hide');
	});

	$('#btn-salvar').click(function() {

		var url = "produto";
		var dadosProduto = $('#form-produto').serialize();

		$.post(url, dadosProduto).done(function(pagina) {

			$('#secao-produtos').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

};