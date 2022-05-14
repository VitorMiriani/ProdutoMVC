package br.com.fiap.appproduto.produto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		request.setAttribute("nomeUsuario", "Vitor Miriani");
		
		return "home";
	}
	
}
