/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin
 * Data: 14/07/2018
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ClienteInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -237343916457605197L;

}
