package com.ista.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.app.models.entity.Cliente;
import com.ista.springboot.app.models.services.IClienteService;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	public IClienteService IClienteServices;

	@GetMapping("/cliente")
	public List<Cliente> indext() {
		return IClienteServices.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Cliente show(@PathVariable Long id) {
		return IClienteServices.FindById(id);
	}

	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return IClienteServices.save(cliente);
	}

	@PutMapping("/clienteUpdate")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente clienteactual = IClienteServices.FindById(id);
		clienteactual.setApellido(cliente.getApellido());
		clienteactual.setNombre(cliente.getNombre());
		clienteactual.setEmail(cliente.getEmail());
		clienteactual.setCreatetat(cliente.getCreatetat());
		clienteactual.setId(cliente.getId());
		return IClienteServices.save(clienteactual);

	}

	@DeleteMapping("/cliente{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		IClienteServices.delete(id);
	}

}
