package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_FACTURA")
	private Long idFactura;
	@Column(name="FECHA_FACTURA")
	private java.util.Date fechaFactura;
	@Column(name="SUBTOTAL")
	private Long subtotal;
	@Column(name="VALOR_IVA")
	private Long valorIVA;
	@Column(name="TOTAL_FACTURA")
	private long totalFactura;
	@Column(name="TIPO_DOCUMENTO_CLIENTE")
	private Long tipoDocumentoCliente;
	@Column(name="NUMERO_DOCUMENTO_CLIENTE")
	private Long numeroDocumentoCliente;
	@Column(name="TIPO_DOCUMENTO_MECANICO")
	private Long tipoDocumentoMecanico;
	@Column(name="NUMERO_DOCUMENTO_MECANICO")
	private Long numeroDocumentoMecanico;
	
	
	
	
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
	
	public java.util.Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(java.util.Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Long getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Long subtotal) {
		this.subtotal = subtotal;
	}
	public Long getValorIVA() {
		return valorIVA;
	}
	public void setValorIVA(Long valorIVA) {
		this.valorIVA = valorIVA;
	}
	public long getTotalFactura() {
		return totalFactura;
	}
	public void setTotalFactura(long totalFactura) {
		this.totalFactura = totalFactura;
	}
	public Long getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}
	public void setTipoDocumentoCliente(Long tipoDocumentoCliente) {
		this.tipoDocumentoCliente = tipoDocumentoCliente;
	}
	public Long getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}
	public void setNumeroDocumentoCliente(Long numeroDocumentoCliente) {
		this.numeroDocumentoCliente = numeroDocumentoCliente;
	}
	public Long getTipoDocumentoMecanico() {
		return tipoDocumentoMecanico;
	}
	public void setTipoDocumentoMecanico(Long tipoDocumentoMecanico) {
		this.tipoDocumentoMecanico = tipoDocumentoMecanico;
	}
	public Long getNumeroDocumentoMecanico() {
		return numeroDocumentoMecanico;
	}
	public void setNumeroDocumentoMecanico(Long numeroDocumentoMecanico) {
		this.numeroDocumentoMecanico = numeroDocumentoMecanico;
	}
	
}/*fin de class*/
