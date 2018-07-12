/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.model.entity.factory;

import br.com.ribeiraoreefshop.orcamentos.model.entity.Produto;

/**
 * @author Tiago Ferezin Data: 12/07/2018
 */
public class ProdutoFactory {

	public Double valorTotal(Produto produto) {
		Double result = 0D;

		Double valorUnitario = produto.getValorUnitario();
		Double quantidade = produto.getQuantidade();

		result = valorUnitario * quantidade;
		
		return result;
	}

}
