package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Pedidos;

public interface IClienteRepository {

	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente buscarId(Integer id);
	public void eliminarId(Integer id);
	//joins
	public List<Cliente> seleccionarInnerJoin(); //inner join
	public List<Cliente> seleccionarInnerJoin_2();
	public List<Cliente> seleccionarOuterLefttJoin(); //outer left join
	public List<Cliente> seleccionarOuterLefttJoin_2();
	public List<Cliente> seleccionarOuterRightJoin(); //outer right join
	public List<Cliente> seleccionarOuterRightJoin_2(); 
	public List<Cliente> seleccionarOuterFullJoin(); //outer full join
	public List<Cliente> seleccionarOuterFullJoin_2();
	// join where 
	public List<Cliente> seleccionarWhereJoin();
	public List<Cliente> seleccionarWhereJoin_2();
	//fetch
	public List<Cliente> seleccionarFetchJoin();
}
