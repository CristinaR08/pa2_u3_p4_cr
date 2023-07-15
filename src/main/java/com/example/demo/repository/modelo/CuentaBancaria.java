package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="cuentabancaria")
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
 
	//propietario
	
}
