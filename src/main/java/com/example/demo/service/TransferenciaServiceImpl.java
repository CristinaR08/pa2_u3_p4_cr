package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepositoryImpl;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements ITranferenciaService {

	@Autowired
	private ICuentaBancariaRepository cuentaRepository;

	@Autowired
	private ITransferenciaRepository transferenciaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void agregar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);

	}

	@Override
	public void modificar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public Transferencia encontrar(Integer id) {
		return this.transferenciaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.transferenciaRepository.eliminar(id);
	}

	@Override
	public List<Transferencia> reporteTransferencias() {
		return this.transferenciaRepository.listaTransferencias();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizar(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		CuentaBancaria numCtaOrigen = this.cuentaRepository.buscarPorCuenta(ctaOrigen);
		BigDecimal saldoOrigen = numCtaOrigen.getSaldo();
		if (monto.compareTo(saldoOrigen) <= 0) {
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			numCtaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(numCtaOrigen);
			CuentaBancaria numCtaDestino = this.cuentaRepository.buscarPorCuenta(ctaDestino);
			BigDecimal saldoDestino = numCtaDestino.getSaldo();
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			numCtaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepository.actualizar(numCtaDestino);
			Transferencia transfer = new Transferencia();
			transfer.setCuentaBancariaOrigen(numCtaOrigen);
			transfer.setCuentaBancariaDestino(numCtaDestino);
			transfer.setMonto(monto);
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
			this.transferenciaRepository.actualizar(transfer);

		} else {
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
			numCtaOrigen.setSaldo(nuevoSaldoOrigen);
			;
			CuentaBancaria numCtaDestino = this.cuentaRepository.buscarPorCuenta(ctaDestino);
			BigDecimal saldoDestino = numCtaDestino.getSaldo();
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			numCtaDestino.setSaldo(nuevoSaldoDestino);
			Transferencia transfer = new Transferencia();
			transfer.setCuentaBancariaOrigen(numCtaOrigen);
			transfer.setCuentaBancariaDestino(numCtaDestino);
			transfer.setMonto(monto);
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(transfer);
			this.transferenciaRepository.actualizar(transfer);

			throw new RuntimeException();
		}

	}
}
