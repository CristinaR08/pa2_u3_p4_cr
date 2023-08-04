package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@SequenceGenerator(name = "seq_estudiante",sequenceName = "seq_estudiante",allocationSize = 1)
	@GeneratedValue(generator = "seq_estudiante",strategy = GenerationType.SEQUENCE)
	@Column(name = "stud_id")
	private Integer id;
	
	@Column(name = "stud_nombre")
	private String nombre;
	
	@Column(name = "stud_apellido")
	private String apellido;
	
	@Column(name = "stud_cedula")
	private String cedula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_provincia")
	private Provincia provincia;
	
	@OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
	private List<Matricula> matriculas;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ "]";
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
}
