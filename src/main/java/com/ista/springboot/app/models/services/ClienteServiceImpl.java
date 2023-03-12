package com.ista.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.app.models.dao.IClienteDao;
import com.ista.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao ClienteDao;

	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) ClienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return ClienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente FindById(Long id) {
		// TODO Auto-generated method stub
		return ClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ClienteDao.deleteById(id);

	}

}
