package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculos")
public class Vehiculo {

	@Id
	@Column(name="MATRICULA")
	private String matricula;
	@Column(name="MARCA")
	private String marca;
	@Column(name="REFERENCIA")
	private String referencia;
	@Column(name="MODELO")
	private Integer modelo;
	@Column(name="COLOR")
	private String color;
	@Column(name="TIPO_DOCUMENTO_CLIENTE")
	private Long tipoDocumentoCliente;
	@Column(name="NUMERO_DOCUMENTO_CLIENTE")
	private Long numeroDocumentoCliente;
	
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Integer getModelo() {
		return modelo;
	}
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	
	
	
	
}/*fin de class*/
