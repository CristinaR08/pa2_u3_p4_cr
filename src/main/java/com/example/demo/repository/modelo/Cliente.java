package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cliente")
@Entity
public class Cliente {
	
	@Id
	@SequenceGenerator(name = "seq_cliente",sequenceName = "seq_cliente",allocationSize = 1)
	@GeneratedValue(generator = "seq_cliente",strategy = GenerationType.SEQUENCE)
	@Column(name = "clte_id")
	private Integer id;
	
	@Column(name = "clte_nombre")
	private String nombre;
	
	@Column(name = "clte_apellido")
	private String apellido;
	
	@Column(name = "clte_direccion")
	private String direccion;
	
	@Column(name = "clte_telefono")
	private Integer telefono;
	
	@Column(name = "clte_correo")
	private String correo;
	
	@Column(name = "clte_fechaRegistro")
	private LocalDateTime fechaRegistro;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedidos> pedidos;

//
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", correo=" + correo + ", fechaRegistro=" + fechaRegistro + "]";
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	

}
