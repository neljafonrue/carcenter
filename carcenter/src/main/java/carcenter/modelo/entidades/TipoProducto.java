package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipos_producto")
public class TipoProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_PRODUCTO")
	private Long idTipoProducto;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	
	public Long getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}/*fin de class*/
