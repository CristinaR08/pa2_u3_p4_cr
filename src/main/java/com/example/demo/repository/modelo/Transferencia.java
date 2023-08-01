package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "transferencia")
@Entity
public class Transferencia {

	@Id
	@SequenceGenerator(name = "seq_transferencia",sequenceName = "seq_transferencia",allocationSize = 1)
	@GeneratedValue(generator = "seq_transferencia",strategy = GenerationType.SEQUENCE)
	@Column(name = "trnf_id")
	private Integer id;
	
	@Column(name = "trnf_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "trnf_monto")
	private BigDecimal monto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="cuenta_id_origen")
	private CuentaBancaria cuentaBancariaOrigen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="cuenta_id_destino")
	private CuentaBancaria cuentaBancariaDestino;
	
	//
	
	@Override
	public String toString() {
		return "\nTransferencia:[id=" + id + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaBancariaOrigen() {
		return cuentaBancariaOrigen;
	}

	public void setCuentaBancariaOrigen(CuentaBancaria cuentaBancariaOrigen) {
		this.cuentaBancariaOrigen = cuentaBancariaOrigen;
	}

	public CuentaBancaria getCuentaBancariaDestino() {
		return cuentaBancariaDestino;
	}

	public void setCuentaBancariaDestino(CuentaBancaria cuentaBancariaDestino) {
		this.cuentaBancariaDestino = cuentaBancariaDestino;
	}
	
}
