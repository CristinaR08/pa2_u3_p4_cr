package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public Transferencia buscar(Integer id);
	public void eliminar(Integer id);
	public List<Transferencia> listaTransferencias();
	
}
