package carcenter.modelo.entidades;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fotos_vehiculos")
public class FotoVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_FOTO_VEHICULO")
	private Long idFotoVehiculo;
	@Column(name="FOTO")
	private Blob foto;
	@Column(name="MATRICULA_VEHICULO")
	private String matriculaVehiculo;
	
	
	public Long getIdFotoVehiculo() {
		return idFotoVehiculo;
	}
	public void setIdFotoVehiculo(Long idFotoVehiculo) {
		this.idFotoVehiculo = idFotoVehiculo;
	}
	
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public String getMatriculaVehiculo() {
		return matriculaVehiculo;
	}
	public void setMatriculaVehiculo(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
	}
	
	
	
}/*fin de class*/
