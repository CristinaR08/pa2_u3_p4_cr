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

@Table(name = "pedidos")
@Entity
public class Pedidos {
	
	@Id
	@SequenceGenerator(name = "seq_pedidos",sequenceName = "seq_pedidos",allocationSize = 1)
	@GeneratedValue(generator = "seq_pedidos",strategy = GenerationType.SEQUENCE)
	@Column(name="pedi_id")
	private String id;
	
	@Column(name="pedi_producto")
	private String producto;
	
	@Column(name = "pedi_cantidad")
	private Integer cantidad;  //solo cuando realizo operaciones uso el numero como Integer
	
	@Column(name = "pedi_precio")
	private BigDecimal precio;
	
	@Column(name = "pedi_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "pedi_estado")
	private String estado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="pedido_id_cliente")
	private Cliente cliente;

	
// 
	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", fecha=" + fecha + ", estado=" + estado + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
