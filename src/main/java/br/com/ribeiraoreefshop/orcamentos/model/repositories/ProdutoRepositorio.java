/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.ribeiraoreefshop.orcamentos.model.entity.Produto;

/**
 * @author Tiago Ferezin
 * Data: 12/07/2018
 */
public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
	
	

}
