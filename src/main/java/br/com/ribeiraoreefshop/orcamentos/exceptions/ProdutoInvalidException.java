/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin
 * Data: 12/07/2018
 */

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ProdutoInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6252544076325467638L;

	

}
