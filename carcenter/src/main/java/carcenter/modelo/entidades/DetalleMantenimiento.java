package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_mantenimientos")
public class DetalleMantenimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_DETALLE_MANTENIMIENTO")
	private Long idDetalleMantenimiento;
	@Column(name="CANTIDAD_UTILIZADA")
	private Integer cantidadUtilizada;
	@Column(name="ID_PRODUCTO")
	private Long idProducto;
	@Column(name="ID_MANTENIMIENTO")
	private Long idMantenimiento;
	
	
	
	public Long getIdDetalleMantenimiento() {
		return idDetalleMantenimiento;
	}
	public void setIdDetalleMantenimiento(Long idDetalleMantenimiento) {
		this.idDetalleMantenimiento = idDetalleMantenimiento;
	}
	
	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}
	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Long getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Long idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	
		
}/*fin de class*/
