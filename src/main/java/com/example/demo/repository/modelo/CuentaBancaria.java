package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
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

@Table(name="cuentaBancaria")
@Entity
public class CuentaBancaria {
	
	@Id
	@SequenceGenerator(name = "seq_cuenta",sequenceName = "seq_cuenta",allocationSize = 1)
	@GeneratedValue(generator = "seq_cuenta",strategy = GenerationType.SEQUENCE)
	@Column(name = "cta_id")
	private Integer id;
	
	@Column(name = "cta_numero")
	private String numero;
	
	@Column(name = "cta_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cta_tipo")
	private String tipo;
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_propietario")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "cuentaBancariaOrigen",fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasO;
	
	
	@OneToMany(mappedBy = "cuentaBancariaDestino",fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasD;
	

//Getters y setters, toString
	
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Transferencia> getTransferenciasO() {
		return transferenciasO;
	}

	public void setTransferenciasO(List<Transferencia> transferenciasO) {
		this.transferenciasO = transferenciasO;
	}

	public List<Transferencia> getTransferenciasD() {
		return transferenciasD;
	}

	public void setTransferenciasD(List<Transferencia> transferenciasD) {
		this.transferenciasD = transferenciasD;
	}

	
	
}
