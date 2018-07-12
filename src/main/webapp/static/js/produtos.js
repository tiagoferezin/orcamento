/**
 * 
 */

$(document).ready(function() {
	
	$('.valorUnitario').mask('##0.00', {reverse: true});

	$('#btn-salvar').on('click', function() {

		var url = "produto";
		var dadosProduto = $('#form-produto').serialize();

		$.post(url, dadosProduto).done(function(pagina) {

			$('#secao-produtos').html(pagina);

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalAlterar').modal('hide');
		});

	});

});