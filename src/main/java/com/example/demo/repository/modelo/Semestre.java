package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "semestre")
public class Semestre {

	@Id
	@SequenceGenerator(name = "seq_semestre",sequenceName = "seq_semestre",allocationSize = 1)
	@GeneratedValue(generator = "seq_semestre",strategy = GenerationType.SEQUENCE)
	@Column(name = "sems_id")
	private Integer id;
	
	@Column(name = "sems_semestre")
	private Integer semestre;
	
	@Column(name = "sems_estado")//regular o no regular
	private String estado;
	
	@Column(name = "sems_periodo")
	private String periodo;
	
	@OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
	private List<Materia> materia;

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", semestre=" + semestre + ", estado=" + estado + ", periodo=" + periodo
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Materia> getMateria() {
		return materia;
	}

	public void setMateria(List<Materia> materia) {
		this.materia = materia;
	}
	
	
}
