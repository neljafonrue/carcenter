package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tienda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIENDA")
	private Long idTienda;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="TELEFONO")
	private String telefono;
	
	
	
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}/*fin de class*/
