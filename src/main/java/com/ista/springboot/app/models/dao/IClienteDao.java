package com.ista.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.springboot.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
