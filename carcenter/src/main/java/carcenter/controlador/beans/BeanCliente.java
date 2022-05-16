package carcenter.controlador.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import carcenter.dao.DAOPersonas;
import carcenter.dao.DAOTiposDocumento;
import carcenter.modelo.entidades.Persona;
import carcenter.modelo.entidades.TipoDocumento;

@ManagedBean(name="cliente")
@ViewScoped
public class BeanCliente {
	
	private static final Long TIPO_PERSONA=2L;
	
	private Long idTipoDocumento=1L;
	private Long numeroDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String direccion;
	private String numeroTelefono;
	private String correoElectronico;
	
	private List<SelectItem> tiposDocumento;
	
	private void obtenerTiposDocumento() {
		DAOTiposDocumento daoTiposDoc=new DAOTiposDocumento();
		List<TipoDocumento> tiposDoc=daoTiposDoc.buscarTiposDocumento();
		if(tiposDoc!=null && !tiposDoc.isEmpty()) {
			tiposDocumento=new ArrayList<SelectItem>();
			for(TipoDocumento tipoDoc:tiposDoc) {
				SelectItem item=new SelectItem(tipoDoc.getIdTipoDocumento(), tipoDoc.getDescripcion());
				tiposDocumento.add(item);
			}/*fin de for*/
		}/*fin de if*/
	}/*fin de obtenerTiposDocumento*/
	
	
	public List<SelectItem> getTiposDocumento() {
		if(tiposDocumento==null) {
			obtenerTiposDocumento();
		}/*fin de if*/
		return tiposDocumento;
	}
	public void setTiposDocumento(List<SelectItem> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}
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
	
	
	public String guardarCliente() {
		Persona cliente=new Persona();
		cliente.setCorreoElectronico(correoElectronico);
		cliente.setDireccion(direccion);
		cliente.setEstado("A");
		cliente.setIdTipoDocumento(idTipoDocumento);
		cliente.setIdTipoPersona(TIPO_PERSONA);
		cliente.setNumeroDocumento(numeroDocumento);
		cliente.setNumeroTelefono(numeroTelefono);
		cliente.setPrimerApellido(primerApellido);
		cliente.setPrimerNombre(primerNombre);
		cliente.setSegundoApellido(segundoApellido);
		cliente.setSegundoNombre(segundoNombre);
		DAOPersonas daoPersonas=new DAOPersonas();
		daoPersonas.crearPersona(cliente);
		FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente registrado correctamente.",null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return null;
	}/*fin de guardarCliente*/
	
}/*fin de class*/
