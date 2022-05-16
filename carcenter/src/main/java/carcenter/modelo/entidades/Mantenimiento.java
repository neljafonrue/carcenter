package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mantenimientos")
public class Mantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MANTENIMIENTO")
	private Long idMantenimiento;
	@Column(name="FECHA_PROGRAMACION")
	private java.util.Date fechaProgramacion;
	@Column(name="FECHA_TERMINACION")
	private java.util.Date fechaTerminacion;
	@Column(name="ESTADO")
	private String estado;
	@Column(name="MATRICULA_VEHICULO")
	private String matriculaVehiculo;
	@Column(name="TIPO_DOCUMENTO_MECANICO")
	private Long tipoDocumentoMecanico;
	@Column(name="NUMERO_DOCUMENTO_MECANICO")
	private Long numeroDocumentoMecanico;
	@Column(name="ID_TIENDA")
	private Long idTienda;
	@Column(name="ID_FACTURA")
	private Long idFactura;
	
	
	
	
	
	public Long getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Long idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	
	public java.util.Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(java.util.Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public java.util.Date getFechaTerminacion() {
		return fechaTerminacion;
	}
	public void setFechaTerminacion(java.util.Date fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMatriculaVehiculo() {
		return matriculaVehiculo;
	}
	public void setMatriculaVehiculo(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
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
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public Long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}
		
	
}/*fin de class*/
