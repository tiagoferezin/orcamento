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

import br.com.ribeiraoreefshop.orcamentos.exceptions.ProdutoInvalidException;
import br.com.ribeiraoreefshop.orcamentos.model.entity.Produto;
import br.com.ribeiraoreefshop.orcamentos.model.entity.factory.ProdutoFactory;
import br.com.ribeiraoreefshop.orcamentos.model.enumerator.UnidadeDeMedida;
import br.com.ribeiraoreefshop.orcamentos.model.repositories.ProdutoRepositorio;

/**
 * @author Tiago Ferezin Data: 12/07/2018
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listaProdutos(Model model) {
		Iterable<Produto> listaProdutos = produtoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de Produtos");
		model.addAttribute("listaProdutos", listaProdutos);
		model.addAttribute("listaUnidadeDeMedida", UnidadeDeMedida.values());
		return "produto/listaProduto";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarProduto(@Valid @ModelAttribute Produto produto,
			BindingResult bindingResult, Model model) {

		ProdutoFactory pf = new ProdutoFactory();

		Double total = 0D;

		total = pf.valorTotal(produto);
		produto.setValorTotal(total);

		if (bindingResult.hasErrors()) {

			throw new ProdutoInvalidException();

		} else {

			produtoRepositorio.save(produto);
		}

		Iterable<Produto> listaProdutos = produtoRepositorio.findAll();
		model.addAttribute("listaProdutos", listaProdutos);
		model.addAttribute("listaUnidadeDeMedida", UnidadeDeMedida.values());
		return "produto/tabelaProduto";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{idProduto}")
	public ResponseEntity<String> deletarProduto(@PathVariable Long idProduto) {
		System.out.println("Removendo");
		try {
			produtoRepositorio.delete(idProduto);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
