package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value=PersonaPK.class)
@Table(name="personas")
public class Persona {
  
	@Id
	@Column(name="ID_TIPO_DOCUMENTO")
	private Long idTipoDocumento;
	@Id
	@Column(name="NUMERO_DOCUMENTO")
	private Long numeroDocumento;	
	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="NUMERO_TELEFONO")
	private String numeroTelefono;
	@Column(name="CORREO_ELECTRONICO")
	private String correoElectronico;
	@Column(name="ESTADO")
	private String estado;
	@Column(name="ID_TIPO_PERSONA")
	private Long idTipoPersona;
	
	
	
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getIdTipoPersona() {
		return idTipoPersona;
	}
	public void setIdTipoPersona(Long idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}
	
	
}/*fin de class*/
