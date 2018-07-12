/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tiago Ferezin
 * Data: 12/07/2018
 */
@Controller
@RequestMapping("/tela")
public class TelaController {
	
	public TelaController() {
		// TODO Auto-generated constructor stub
		System.out.println("Criou Tela Controller");
	}

	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome){
		
		return "Olá, " + nome;
		
	}
	
}
