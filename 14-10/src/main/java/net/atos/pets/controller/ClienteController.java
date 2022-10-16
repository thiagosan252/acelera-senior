package net.atos.pets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.atos.pets.model.Cliente;
import net.atos.pets.model.Pet;
import net.atos.pets.repository.ClienteRepository;
import net.atos.pets.repository.PetRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PetRepository petRepository;

	@GetMapping(path = { "/cadastro/cliente", "/cadastro/cliente/{id}" })
	public String inicio(Model model, @PathVariable(name = "id", required = false) String id) {

		if (id == null) {
			Cliente cliente = new Cliente();
			model.addAttribute("clienteForm", cliente);
		} else {
			model.addAttribute("clienteForm", clienteRepository.findById(id).orElse(new Cliente()));
		}
		return "cadastro/cliente";
	}

	@PostMapping("/cadastro/cliente")
	public String cadastrarCliente(@ModelAttribute Cliente clienteForm, Model model) {

		if (clienteForm == null) {
			return "cadastro/cliente";
		} else {
			clienteRepository.save(clienteForm);
		}

		return "redirect:/listarClientes";
	}

	@GetMapping(path = { "/cadastro/cliente/pet/{id}" })
	public String cadastrarPet(Model model, @PathVariable(name = "id") String id) {

		Pet pet = new Pet();
		model.addAttribute("petForm", pet);
		model.addAttribute("cliente", clienteRepository.findById(id).orElse(null));

		return "cadastro/pet";
	}
	
	@PostMapping(path = { "/cadastro/cliente/pet/{id}" })
	public String salvarPet(@ModelAttribute Pet petForm, @PathVariable(name = "id") String id) {

		Pet pet = petRepository.save(petForm);
		Cliente cliente = clienteRepository.findById(id).orElse(new Cliente());
		cliente.getPets().add(pet);
		clienteRepository.save(cliente);
		
		return "redirect:/listarClientes";
	}

	@GetMapping("/deletar/cliente/{id}")
	public String deletarCliente(@PathVariable("id") String id) {

		clienteRepository.deleteById(id);

		return "redirect:/listarClientes";
	}
	
	@GetMapping("/deletar/cliente/pet/{cpf}/{id}")
	public String deletarPet(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) {

		Cliente cliente = clienteRepository.findById(cpf).orElse(new Cliente());
		
		cliente.getPets().remove(petRepository.findById(id).orElse(null));
		clienteRepository.save(cliente);
		petRepository.deleteById(id);

		return "redirect:/listarClientes";
	}

	@GetMapping("/listarClientes")
	public String listarClientes(Model model) {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);

		return "listarClientes";
	}

}
