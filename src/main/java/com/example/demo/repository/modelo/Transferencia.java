package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Column(name = "trnf_fehca")
	private LocalDateTime fecha;
	
	@Column(name = "trnf_id")
	private Integer id;
	
	@Column(name = "trnf_id")
	private Integer id;
}
