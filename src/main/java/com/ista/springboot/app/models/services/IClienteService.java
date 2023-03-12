package com.ista.springboot.app.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ista.springboot.app.models.entity.Cliente;

@Service
public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);
	
	public Cliente FindById(Long id);
	
	public void delete(Long id);

}
