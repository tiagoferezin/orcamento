/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();

});

var aplicarListaners = function() {

	$('.valorUnitario').mask('##0.00', {
		reverse : true
	});

	$('.quantidade').mask('##0.000', {
		reverse : true
	});

	$('.btn-deletar').click(function() {
		alert('Removendo');
		var idProduto = $(this).parents('tr').data('id');
		

		$.ajax({
			url : "produto/" + idProduto,
			type : 'DELETE',
			success: function(result) {
				alert('removido com sucesso');
		    	$('tr[data-id="'+idProduto+'"]').remove();
			}
		});

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