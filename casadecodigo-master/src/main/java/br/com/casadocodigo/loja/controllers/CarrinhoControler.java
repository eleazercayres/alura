package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoControler {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}
	
	@RequestMapping ("/add")
	public ModelAndView add(@ModelAttribute("produto") Produto produto, @RequestParam("tipo") TipoPreco tipo){
		carrinho.add( criaItem(produto, tipo));
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		return modelAndView;
	}


	private CarrinhoItem criaItem(Produto produto, TipoPreco tipoPreco) {
		produto = produtoDAO.find(produto.getId());
		return new CarrinhoItem(produto, tipoPreco);
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
	    carrinho.remover(produtoId, tipoPreco);
	    return new ModelAndView("redirect:/carrinho");
	}

}
