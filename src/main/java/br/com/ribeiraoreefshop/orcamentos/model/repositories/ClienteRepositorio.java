/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.ribeiraoreefshop.orcamentos.model.entity.Cliente;

/**
 * @author Tiago Ferezin Data: 14/07/2018
 */
public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

}
