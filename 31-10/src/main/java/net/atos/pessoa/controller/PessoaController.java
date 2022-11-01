package net.atos.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.atos.pessoa.model.Pessoa;
import net.atos.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/pessoas")
	public List<Pessoa> getAll() {

		List<Pessoa> pessoas = pessoaRepository.findAll();

		return pessoas;
	}

	@GetMapping("/pessoas/{id}")
	public Pessoa getById(@PathVariable long id) {

		Pessoa pessoa = pessoaRepository.findById(id).orElse(null);

		return pessoa;
	}

	@PostMapping("/pessoas")
	public Pessoa save(@RequestBody Pessoa body) {

		Pessoa pessoa = pessoaRepository.save(body);

		return pessoa;
	}

	@DeleteMapping("/pessoas/{id}")
	public void delete(@PathVariable long id) {
		pessoaRepository.deleteById(id);
	}
}
