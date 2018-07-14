/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ribeiraoreefshop.orcamentos.exceptions.ClienteInvalidException;
import br.com.ribeiraoreefshop.orcamentos.model.entity.Cliente;
import br.com.ribeiraoreefshop.orcamentos.model.repositories.ClienteRepositorio;

/**
 * @author Tiago Ferezin Data: 14/07/2018
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listaClientes(Model model) {

		Iterable<Cliente> listaClientes = clienteRepositorio.findAll();

		model.addAttribute("titulo", "Lista de Clientes");
		model.addAttribute("listaClientes", listaClientes);

		return "cliente/listaCliente";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarCliente(@Valid @ModelAttribute Cliente cliente,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			throw new ClienteInvalidException();
		} else {
			clienteRepositorio.save(cliente);
		}

		Iterable<Cliente> listaClientes = clienteRepositorio.findAll();
		model.addAttribute("listaClientes", listaClientes);

		return "cliente/tabelaCliente";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{idCliente}")
	@ResponseBody
	public Cliente buscarCliente(@PathVariable Long idCliente) {
		Cliente cliente = new Cliente();

		cliente = clienteRepositorio.findOne(idCliente);

		return cliente;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{idCliente}")
	public ResponseEntity<String> deletarCliente(@PathVariable Long idCliente) {

		try {
			clienteRepositorio.delete(idCliente);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

}
