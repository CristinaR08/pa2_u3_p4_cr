package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public void agregar(Cliente cliente) {
		this.clienteRepository.insertar(cliente);
		
	}

	@Override
	public void modificar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
		
	}

	@Override
	public Cliente encontrar(Integer id) {
		return this.clienteRepository.buscarId(id);
	}

	@Override
	public void borrar(Integer id) {
		this.clienteRepository.eliminarId(id);
		
	}

	@Override
	public List<Cliente> encontrarInnerJoin() {
		return this.clienteRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Cliente> encontrarInnerJoin_2() {
		return this.clienteRepository.seleccionarInnerJoin_2();
	}
	
	@Override
	public List<Cliente> encontrarOuterRightJoin() {
		return this.clienteRepository.seleccionarOuterRightJoin();
	}
	
	@Override
	public List<Cliente> encontrarOuterRightJoin_2() {
		return this.clienteRepository.seleccionarOuterRightJoin_2();
	}

	@Override
	public List<Cliente> encontrarOuterLefttJoin() {
		return this.clienteRepository.seleccionarOuterLefttJoin();
	}
	
	@Override
	public List<Cliente> encontrarOuterLefttJoin_2() {
		return this.clienteRepository.seleccionarOuterLefttJoin_2();
	}

	@Override
	public List<Cliente> encontrarOuterFullJoin() {
		return this.clienteRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Cliente> encontrarOuterFullJoin_2() {
		return this.clienteRepository.seleccionarOuterFullJoin_2();
	}

	@Override
	public List<Cliente> encontrarWhereJoin() {
		return this.clienteRepository.seleccionarWhereJoin();
	}
	
	@Override
	public List<Cliente> encontrarWhereJoin_2() {
		return this.clienteRepository.seleccionarWhereJoin_2();
	}

}
