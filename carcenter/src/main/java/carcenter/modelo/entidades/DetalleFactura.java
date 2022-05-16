package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_facturas")
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_FACTURA")
	private Long idDetalleFactura;
	@Column(name="ID_PRODUCTO")
	private Long idProducto;
	@Column(name="ID_FACTURA")
	private Long idFactura;
	@Column(name = "CANTIDAD")
	private Integer cantidad;
	@Column(name = "VALOR_PRODUCTO")
	private Long valorProducto;
	@Column(name = "VALOR_DESCUENTO")
	private Long valorDescuento;
	@Column(name = "VALOR_FINAL")
	private Long valorFinal;
	
	
	
	
	public Long getIdDetalleFactura() {
		return idDetalleFactura;
	}
	public void setIdDetalleFactura(Long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Long getValorProducto() {
		return valorProducto;
	}
	public void setValorProducto(Long valorProducto) {
		this.valorProducto = valorProducto;
	}
	public Long getValorDescuento() {
		return valorDescuento;
	}
	public void setValorDescuento(Long valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	public Long getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Long valorFinal) {
		this.valorFinal = valorFinal;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
		
	
	
}/*fin de class*/
