package br.com.fiap.appproduto.produto.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.appproduto.produto.dto.ProdutoDto;
import br.com.fiap.appproduto.produto.model.Produto;
import br.com.fiap.appproduto.produto.repositories.ProdutoRepository;

@Controller
public class ProdutoController {	
	@Autowired
	private ProdutoRepository produtoRepository;
	//autoWired = injeção de dados
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("produtos/index");
		
		Produto produto1 = new Produto(new Long(1),"Chocolate",3,new BigDecimal(2));
		Produto produto2 = new Produto(new Long(2),"Chocolate Belga",100,new BigDecimal(40));
		Produto produto3 = new Produto(new Long(2),"Chocolate Branco",30,new BigDecimal(15));
		List<Produto> produtos = Arrays.asList(produto1,produto2,produto3);
		//modelView.addObject("listarProdutos", produtos);
		
		List<Produto> produtoDaRepository = produtoRepository.findAll();
		modelView.addObject("listarProdutos", produtoDaRepository);
		return modelView;
	}
	@GetMapping("/produtos/criar")
	public ModelAndView criar() {
		
		ModelAndView modelView = new ModelAndView("produtos/criar");
				
		return modelView;	 
	
}
	
	@PostMapping("produtos")
	public String salvar(ProdutoDto produto) {
		//espera oq recebe + classe 
		Produto produtoEntity = modelMapper.map(produto, Produto.class);
		
		produtoRepository.save(produtoEntity);
		return "redirect:/produtos";
	}
}
