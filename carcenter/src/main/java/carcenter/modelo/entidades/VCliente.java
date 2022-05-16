package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="vista_clientes")
@IdClass(value=PersonaPK.class)
public class VCliente {

	@Id
	@Column(name="ID_TIPO_DOCUMENTO")
	private Long idTipoDocumento;
	@Id
	@Column(name="NUMERO_DOCUMENTO")
	private Long numeroDocumento;
	
	@Column(name="NOMBRE_TIPO_DOCUMENTO")
	private String nombreTipoDocumento;
	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name="SEGUNDO_APELLIDO")	
	private String segundoApellido;
	
	
	
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}
	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
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
	
	
	
}/*fin de class*/
