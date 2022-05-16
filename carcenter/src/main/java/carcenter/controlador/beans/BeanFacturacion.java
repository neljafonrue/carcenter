package carcenter.controlador.beans;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import carcenter.dao.DAODetalleFacturas;
import carcenter.dao.DAOFacturas;
import carcenter.dao.DAOMantenimientos;
import carcenter.dao.DAOPersonas;
import carcenter.modelo.entidades.DetalleFactura;
import carcenter.modelo.entidades.Factura;
import carcenter.modelo.entidades.Mantenimiento;
import carcenter.modelo.entidades.VCliente;
import carcenter.modelo.entidades.VMantenimientoFactura;

@ManagedBean(name="facturacion")
@ViewScoped
public class BeanFacturacion {

	private Long idFactura;
	private Long tipoDocumentoCliente;
	private Long numeroDocumentoCliente;
	private String nombreCliente;
	private Long tipoDocumentoMecanico;
	private String nomDocumentoMecanico;
	private Long numeroDocumentoMecanico;
	private String nombreMecanico;
	private Long subtotal;
	private Long valorIVA;
	private Long totalFactura;
	
	private List<SelectItem> listaClientes;
	private String clienteSeleccionado="0-0";
	private List<VMantenimientoFactura> infoFactura;
	
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
	
	public String obtenerInfoFacturacionCliente() {
		if(!"0-0".equals(clienteSeleccionado)) {
			String[] datos=clienteSeleccionado.split("-");
			Long tipoDoc=Long.parseLong(datos[0]);
			Long nroDoc=Long.parseLong(datos[1]);
			String sql="SELECT * FROM vista_mantenimientos_factura WHERE ID_TIPO_DOCUMENTO_CLIENTE="
			           +tipoDoc.longValue()+" AND NUMERO_DOCUMENTO_CLIENTE="+nroDoc.longValue();
			DAOFacturas daoFacturas=new DAOFacturas();
			infoFactura=daoFacturas.buscarInfoParaFactura(sql);
			if(infoFactura!=null && !infoFactura.isEmpty()) {
				VMantenimientoFactura mf=infoFactura.get(0);
				setTipoDocumentoCliente(tipoDoc);
				setNumeroDocumentoCliente(nroDoc);
				setNombreMecanico(mf.getPrimerNombreMecanico()+" "+mf.getSegundoNombreMecanico()+" "+mf.getPrimerApellidoMecanico()+" "+mf.getSegundoApellidoMecanico());
				setNumeroDocumentoMecanico(mf.getNumeroDocumentoMecanico());
				setTipoDocumentoMecanico(mf.getIdTipoDocumentoMecanico());
				setNomDocumentoMecanico(mf.getTipoDocumentoMecanico());
				subtotal=0L;
				for(VMantenimientoFactura info:infoFactura) {
					subtotal+=info.getValorProducto();
				}/*fin de for*/
				BigDecimal bdSub=new BigDecimal(subtotal);
				BigDecimal bdIVA=bdSub.multiply(new BigDecimal(19)).divide(new BigDecimal(100)).setScale(2);
				valorIVA=Math.round(bdIVA.doubleValue());
				totalFactura=subtotal+valorIVA;
			}/*fin de if*/
			else {
				setNombreMecanico("");
				setNumeroDocumentoMecanico(null);
				setNomDocumentoMecanico("");
				subtotal=0L;
				valorIVA=0L;
				totalFactura=0L;
				FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontró información para facturar.",null);
				FacesContext.getCurrentInstance().addMessage(null, mensaje);
			}/*fin de else*/
		}/*fin de if*/
		else {
			setNombreMecanico("");
			setNumeroDocumentoMecanico(null);
			setNomDocumentoMecanico("");
			subtotal=0L;
			valorIVA=0L;
			totalFactura=0L;
			FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"No se seleccionó un cliente.",null);
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}/*fin de else*/
		return null;
	}/*fin de obtenerInfoFacturacionCliente*/

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Long getTipoDocumentoMecanico() {
		return tipoDocumentoMecanico;
	}

	public void setTipoDocumentoMecanico(Long tipoDocumentoMecanico) {
		this.tipoDocumentoMecanico = tipoDocumentoMecanico;
	}

	public List<VMantenimientoFactura> getInfoFactura() {
		return infoFactura;
	}

	public void setInfoFactura(List<VMantenimientoFactura> infoFactura) {
		this.infoFactura = infoFactura;
	}

	public Long getNumeroDocumentoMecanico() {
		return numeroDocumentoMecanico;
	}

	public void setNumeroDocumentoMecanico(Long numeroDocumentoMecanico) {
		this.numeroDocumentoMecanico = numeroDocumentoMecanico;
	}

	public String getNombreMecanico() {
		return nombreMecanico;
	}

	public void setNombreMecanico(String nombreMecanico) {
		this.nombreMecanico = nombreMecanico;
	}

	public Long getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Long subtotal) {
		this.subtotal = subtotal;
	}

	public Long getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(Long totalFactura) {
		this.totalFactura = totalFactura;
	}

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

	public String getNomDocumentoMecanico() {
		return nomDocumentoMecanico;
	}

	public void setNomDocumentoMecanico(String nomDocumentoMecanico) {
		this.nomDocumentoMecanico = nomDocumentoMecanico;
	}

	public Long getValorIVA() {
		return valorIVA;
	}

	public void setValorIVA(Long valorIVA) {
		this.valorIVA = valorIVA;
	}
	
	public String guardarFactura() {
		Factura factura=new Factura();
		java.util.Date fecFac=new java.util.Date(System.currentTimeMillis());
		DateFormat dft=new SimpleDateFormat("yyyy-MM-dd");
		String strFF=dft.format(fecFac);
		try {
			factura.setFechaFactura(dft.parse(strFF));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		factura.setNumeroDocumentoCliente(numeroDocumentoCliente);
		factura.setNumeroDocumentoMecanico(numeroDocumentoMecanico);
		factura.setSubtotal(subtotal);
		factura.setTipoDocumentoCliente(tipoDocumentoCliente);
		factura.setTipoDocumentoMecanico(tipoDocumentoMecanico);
		factura.setTotalFactura(totalFactura);
		factura.setValorIVA(valorIVA);
		DAOFacturas daoFacturas=new DAOFacturas();
		daoFacturas.crearFactura(factura);
		String sql="SELECT * FROM FACTURAS WHERE ID_FACTURA IN(SELECT MAX(ID_FACTURA) FROM FACTURAS)";
		factura=daoFacturas.buscarUltimaFactura(sql);
		Long idFactura=factura.getIdFactura();
		DAODetalleFacturas daoDetalleFactura=new DAODetalleFacturas();
		DAOMantenimientos daoMantenimientos=new DAOMantenimientos();
		for(VMantenimientoFactura info:infoFactura) {
			DetalleFactura df=new DetalleFactura();
			df.setCantidad(info.getCantidadUtilizada());
			df.setIdFactura(idFactura);
			df.setIdProducto(info.getIdProducto());
			df.setValorDescuento(0L);
			df.setValorProducto(info.getValorProducto());
			df.setValorFinal(info.getValorProducto()-df.getValorDescuento());
			daoDetalleFactura.crearDetalleFactura(df);
			Mantenimiento man=daoMantenimientos.buscarMantenimiento(info.getIdMantenimiento());
			man.setIdFactura(idFactura);
			daoMantenimientos.actualizarMantenimiento(man);
		}/*fin de for*/
		FacesMessage mensaje=new FacesMessage(FacesMessage.SEVERITY_INFO,"Factura guardada con éxito.",null);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
		return null;
	}/*fin de guardarFactura*/
}/*fin de class*/
