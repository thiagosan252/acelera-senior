package net.atos.animals.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlanoTitutalController {

	
	@GetMapping("/")
	public String inicio() {

		return "index";
	}
	
	@GetMapping("/cadastro-titular")
	public String cadastro() {

		return "cadastroTitular";
	}
}
