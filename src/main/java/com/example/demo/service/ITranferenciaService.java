package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITranferenciaService {

	public void agregar(Transferencia transferencia);
	public void modificar(Transferencia transferencia);
	public Transferencia encontrar(Integer id);
	public void borrar(Integer id);
	public List<Transferencia> reporteTransferencias();
	public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto);
}
