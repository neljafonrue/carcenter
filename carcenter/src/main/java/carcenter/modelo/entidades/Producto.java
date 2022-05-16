package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private Long idProducto;
	@Column(name="DESCRIPCION")
	private String Descripcion;
	@Column(name="CANTIDAD_EXISTENCIAS")
	private Integer cantidadExistencias;
	@Column(name="VALOR_UNITARIO_COMPRA")
	private Long valorUnitarioCompra;
	@Column(name="VALOR_UNITARIO_VENTA")
	private Long valorUnitarioVenta;
	@Column(name="ID_TIPO_PRODUCTO")
	private Long idTipoProducto;
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Integer getCantidadExistencias() {
		return cantidadExistencias;
	}
	public void setCantidadExistencias(Integer cantidadExistencias) {
		this.cantidadExistencias = cantidadExistencias;
	}
	public Long getValorUnitarioCompra() {
		return valorUnitarioCompra;
	}
	public void setValorUnitarioCompra(Long valorUnitarioCompra) {
		this.valorUnitarioCompra = valorUnitarioCompra;
	}
	public Long getValorUnitarioVenta() {
		return valorUnitarioVenta;
	}
	public void setValorUnitarioVenta(Long valorUnitarioVenta) {
		this.valorUnitarioVenta = valorUnitarioVenta;
	}
	public Long getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	
	
	
}/*fin de class*/
