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
@Table(name = "provincia")
public class Provincia {
	
	@Id
	@SequenceGenerator(name = "seq_provincia",sequenceName = "seq_provincia",allocationSize = 1)
	@GeneratedValue(generator = "seq_provincia",strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	
	@Column(name = "prov_canton")
	private String canton;

	@Column(name = "prov_parroquia")
	private String parroquia;
	
	@OneToMany(mappedBy = "provincia",cascade = CascadeType.ALL)
	private List<Estudiante> estudiantes;

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", canton=" + canton + ", parroquia=" + parroquia + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	
}