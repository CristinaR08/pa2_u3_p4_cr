package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteService {

	public void agregar(Cliente cliente);
	public void modificar(Cliente cliente);
	public Cliente encontrar(Integer id);
	public void borrar(Integer id);
	//joins
	public List<Cliente> encontrarInnerJoin(); //inner join
	public List<Cliente> encontrarInnerJoin_2();
	public List<Cliente> encontrarOuterRightJoin(); //outer right join
	public List<Cliente> encontrarOuterRightJoin_2(); 
	public List<Cliente> encontrarOuterLefttJoin(); //outer left join
	public List<Cliente> encontrarOuterLefttJoin_2();
	public List<Cliente> encontrarOuterFullJoin(); //outer full join
	public List<Cliente> encontrarOuterFullJoin_2();
	// join where 
	public List<Cliente> encontrarWhereJoin();
	public List<Cliente> encontrarWhereJoin_2();
	//fetch join
	public List<Cliente> encontrarFetchJoin();
	
}
