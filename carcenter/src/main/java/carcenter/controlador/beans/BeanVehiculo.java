package carcenter.controlador.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import carcenter.dao.DAOPersonas;
import carcenter.dao.DAOVehiculos;
import carcenter.modelo.entidades.VCliente;
import carcenter.modelo.entidades.Vehiculo;


@ManagedBean(name="vehiculo")
@ViewScoped
public class BeanVehiculo {

	private String matricula;
	private String marca;
	private String referencia;
	private Integer modelo;
	private String color;
	private Long tipoDocumentoCliente;
	private Long numeroDocumentoCliente;
	
	private List<SelectItem> listaClientes;
	private String clienteSeleccionado="0-0";
	
	private void obtenerClientes(){
		DAOPersonas daoClientes=new DAOPersonas();
		String sql="SELECT TID.ID_TIPO_DOCUMENTO AS ID_TIPO_DOCUMENTO "
				+ ",TID.NOMBRE AS NOMBRE_TIPO_DOCUMENTO "
				+ ",PER.NUMERO_DOCUMENTO AS NUMERO_DOCUMENTO "
				+ ",PER.PRIMER_NOMBRE AS PRIMER_NOMBRE "
				+ ",PER.SEGUNDO_NOMBRE AS SEGUNDO_NOMBRE "
				+ ",PER.PRIMER_APELLIDO AS PRIMER_APELLIDO "
				+ ",PER.SEGUNDO_APELLIDO AS SEGUNDO_APELLIDO "
				+ "FROM PERSONAS PER "
				+ ",TIPOS_DOCUMENTO TID "
				+ "WHERE TID.ID_TIPO_DOCUMENTO=PER.ID_TIPO_DOCUMENTO "
				+ "AND PER.ID_TIPO_PERSONA=2;";
		List<VCliente> clientes=daoClientes.buscarClientes(sql);
		if(clientes!=null && !clientes.isEmpty()) {
			listaClientes=new ArrayList<SelectItem>();
			SelectItem pItem=new SelectItem("0-0", "Seleccione un cliente...");
			listaClientes.add(pItem);
			for(VCliente cliente:clientes) {
				StringBuilder sbId=new StringBuilder("");
				sbId.append(cliente.getIdTipoDocumento()).append("-").append(cliente.getNumeroDocumento());
				StringBuilder sbLabel=new StringBuilder("");
				sbLabel.append("[").append(cliente.getNombreTipoDocumento()).append("-").append(cliente.getNumeroDocumento()).append("] - ")
				       .append(cliente.getPrimerNombre())
				       .append(" ")
				       .append(cliente.getSegundoNombre())
				       .append(" ")
				       .append(cliente.getPrimerApellido())
				       .append(" ")
				       .append(cliente.getSegundoApellido());
				SelectItem item=new SelectItem(sbId.toString(), sbLabel.toString());
				listaClientes.add(item);
			}/*fin de for*/
		}/*fin de if*/
	}/*fin de obtenerClientes*/

	public List<SelectItem> getListaClientes() {
		if(listaClientes==null) {
			obtenerClientes();
		}/*fin de if*/
		return listaClientes;
	}

	public void setListaClientes(List<SelectItem> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getClienteSeleccionado() {
		return clienteSeleccionado;
	}

	public void setClienteSeleccionado(String clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}



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
	
	public String guardarVehiculo() {
		String[] datos=clienteSeleccionado.split("-");
		Long tipoDoc=Long.parseLong(datos[0]);
		Long nroDoc=Long.parseLong(datos[1]);
		String txtMsj="";
		if(tipoDoc.longValue()!=0 && nroDoc.longValue()!=0) {
			Vehiculo vehiculo=new Vehiculo();
			vehiculo.setColor(color);
			vehiculo.setMarca(marca);
			vehiculo.setMatricula(matricula);
			vehiculo.setModelo(modelo);
			vehiculo.setReferencia(referencia);
			vehiculo.setTipoDocumentoCliente(tipoDoc);
			vehiculo.setNumeroDocumentoCliente(nroDoc);
			DAOVehiculos daoVehiculos=new DAOVehiculos();
			daoVehiculos.crearVehiculo(vehiculo);
			txtMsj="Vehículo registrado correctamente";
		}/*fin de if*/
		else {
			txtMsj="No se escogió el dueño del vehículo para poder registrarlo";
		}/*fin de else*/
		FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,txtMsj,null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return null;
	}/*fin de guardarVehiculo*/
	
}/*fin de class*/
