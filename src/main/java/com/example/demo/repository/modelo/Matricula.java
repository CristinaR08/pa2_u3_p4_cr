package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	
	@Id
	@SequenceGenerator(name = "seq_matricula",sequenceName = "seq_matricula",allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
	@Column(name = "matc_id")
	private Integer id;
	
	@Column(name = "matc_estado") //1° 2° 3°
	private String estado;
	
	@Column(name = "matc_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "matc_monto")
	private BigDecimal monto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_materia")
	private Materia materia;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", estado=" + estado + ", fecha=" + fecha + ", monto=" + monto + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	
	
}
