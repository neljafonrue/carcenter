package carcenter.modelo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vista_mantenimientos_factura")
public class VMantenimientoFactura {

	@Id
	@Column(name="ID_MANTENIMIENTO")
	private Long idMantenimiento;
	@Column(name="MATRICULA_VEHICULO")
	private String matriculaVehiculo;
	@Column(name="ID_TIPO_DOCUMENTO_CLIENTE")
	private Long idTipoDocumentoCliente;
	@Column(name="TIPO_DOCUMENTO_CLIENTE")
	private String tipoDocumentoCliente;
	@Column(name="NUMERO_DOCUMENTO_CLIENTE")
	private Long numeroDocumentoCliente;
	@Column(name="ID_TIPO_DOCUMENTO_MECANICO")
	private Long idTipoDocumentoMecanico;
	@Column(name="TIPO_DOCUMENTO_MECANICO")
	private String tipoDocumentoMecanico;
	@Column(name="NUMERO_DOCUMENTO_MECANICO")
	private Long numeroDocumentoMecanico;
	@Column(name="PRIMER_NOMBRE_CLIENTE")
	private String primerNombreCliente;
	@Column(name="SEGUNDO_NOMBRE_CLIENTE")
	private String segundoNombreCliente;
	@Column(name="PRIMER_APELLIDO_CLIENTE")
	private String primerApellidoCliente;
	@Column(name="SEGUNDO_APELLIDO_CLIENTE")
	private String segundoApellidoCliente;
	@Column(name="PRIMER_NOMBRE_MECANICO")
	private String primerNombreMecanico;
	@Column(name="SEGUNDO_NOMBRE_MECANICO")
	private String segundoNombreMecanico;
	@Column(name="PRIMER_APELLIDO_MECANICO")
	private String primerApellidoMecanico;
	@Column(name="SEGUNDO_APELLIDO_MECANICO")
	private String segundoApellidoMecanico;
	@Column(name="ID_TIENDA")
	private Long idTienda;
	@Column(name="NOMBRE_TIENDA")
	private String nombreTienda;
	@Column(name="ID_PRODUCTO")
	private Long idProducto;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="VALOR_UNITARIO_VENTA")
	private Long valorUnitarioVenta;
	@Column(name="CANTIDAD_UTILIZADA")
	private Integer cantidadUtilizada;
	@Column(name="VALOR_PRODUCTO")
	private Long valorProducto;
	
	
	public Long getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Long idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	public String getMatriculaVehiculo() {
		return matriculaVehiculo;
	}
	public void setMatriculaVehiculo(String matriculaVehiculo) {
		this.matriculaVehiculo = matriculaVehiculo;
	}
	public Long getIdTipoDocumentoCliente() {
		return idTipoDocumentoCliente;
	}
	public void setIdTipoDocumentoCliente(Long idTipoDocumentoCliente) {
		this.idTipoDocumentoCliente = idTipoDocumentoCliente;
	}
	public String getTipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}
	public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
		this.tipoDocumentoCliente = tipoDocumentoCliente;
	}
	public Long getNumeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}
	public void setNumeroDocumentoCliente(Long numeroDocumentoCliente) {
		this.numeroDocumentoCliente = numeroDocumentoCliente;
	}
	public Long getIdTipoDocumentoMecanico() {
		return idTipoDocumentoMecanico;
	}
	public void setIdTipoDocumentoMecanico(Long idTipoDocumentoMecanico) {
		this.idTipoDocumentoMecanico = idTipoDocumentoMecanico;
	}
	public String getTipoDocumentoMecanico() {
		return tipoDocumentoMecanico;
	}
	public void setTipoDocumentoMecanico(String tipoDocumentoMecanico) {
		this.tipoDocumentoMecanico = tipoDocumentoMecanico;
	}
	public Long getNumeroDocumentoMecanico() {
		return numeroDocumentoMecanico;
	}
	public void setNumeroDocumentoMecanico(Long numeroDocumentoMecanico) {
		this.numeroDocumentoMecanico = numeroDocumentoMecanico;
	}
	public String getPrimerNombreCliente() {
		return primerNombreCliente;
	}
	public void setPrimerNombreCliente(String primerNombreCliente) {
		this.primerNombreCliente = primerNombreCliente;
	}
	public String getSegundoNombreCliente() {
		return segundoNombreCliente;
	}
	public void setSegundoNombreCliente(String segundoNombreCliente) {
		this.segundoNombreCliente = segundoNombreCliente;
	}
	public String getPrimerApellidoCliente() {
		return primerApellidoCliente;
	}
	public void setPrimerApellidoCliente(String primerApellidoCliente) {
		this.primerApellidoCliente = primerApellidoCliente;
	}
	public String getSegundoApellidoCliente() {
		return segundoApellidoCliente;
	}
	public void setSegundoApellidoCliente(String segundoApellidoCliente) {
		this.segundoApellidoCliente = segundoApellidoCliente;
	}
	public String getPrimerNombreMecanico() {
		return primerNombreMecanico;
	}
	public void setPrimerNombreMecanico(String primerNombreMecanico) {
		this.primerNombreMecanico = primerNombreMecanico;
	}
	public String getSegundoNombreMecanico() {
		return segundoNombreMecanico;
	}
	public void setSegundoNombreMecanico(String segundoNombreMecanico) {
		this.segundoNombreMecanico = segundoNombreMecanico;
	}
	public String getPrimerApellidoMecanico() {
		return primerApellidoMecanico;
	}
	public void setPrimerApellidoMecanico(String primerApellidoMecanico) {
		this.primerApellidoMecanico = primerApellidoMecanico;
	}
	public String getSegundoApellidoMecanico() {
		return segundoApellidoMecanico;
	}
	public void setSegundoApellidoMecanico(String segundoApellidoMecanico) {
		this.segundoApellidoMecanico = segundoApellidoMecanico;
	}
	public Long getIdTienda() {
		return idTienda;
	}
	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getValorUnitarioVenta() {
		return valorUnitarioVenta;
	}
	public void setValorUnitarioVenta(Long valorUnitarioVenta) {
		this.valorUnitarioVenta = valorUnitarioVenta;
	}
	public Integer getCantidadUtilizada() {
		return cantidadUtilizada;
	}
	public void setCantidadUtilizada(Integer cantidadUtilizada) {
		this.cantidadUtilizada = cantidadUtilizada;
	}
	public Long getValorProducto() {
		return valorProducto;
	}
	public void setValorProducto(Long valorProducto) {
		this.valorProducto = valorProducto;
	}
	
	
}/*fin de class*/
