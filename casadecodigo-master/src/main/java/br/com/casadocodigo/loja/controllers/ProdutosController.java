package br.com.casadocodigo.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.component.FileSaver;
import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.CarrinhoItem;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO dao; 
	
	@Autowired
    private FileSaver fileSaver;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
	    binder.addValidators(new ProdutoValidation());
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") int id){
	    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
	    Produto produto = dao.find(id);
	    modelAndView.addObject("produto", produto);
//	    modelAndView.addObject("item", new CarrinhoItem(produto, null));
	    return modelAndView;
	}
	
	@RequestMapping("/{id}")
	@ResponseBody
	public Produto detalheJSON(@PathVariable("id") Integer id){
	    return dao.find(id);
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto){
		ModelAndView model = new ModelAndView("produtos/form");
		model.addObject("tipos", TipoPreco.values());
		return model;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="produtosHome", allEntries=true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto,BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
	        return form(produto);
	    }
		produto.setSumarioPath(fileSaver.grava("arquivos-sumario", sumario));
		dao.gravar(produto);
		redirectAttributes.addFlashAttribute("succeso", "Gravado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
		ModelAndView model = new ModelAndView("produtos/lista");
		model.addObject("produtos", dao.listar());
		return model;
    }
}
