package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Factura;
import carcenter.modelo.entidades.VCliente;
import carcenter.modelo.entidades.VMantenimientoFactura;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOFacturas {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearFactura(Factura factura) {
		manejador.getTransaction().begin();
		manejador.persist(factura);		
		manejador.getTransaction().commit();
	}/*fin de crearFactura*/
	
	public void actualizarFactura(Factura factura) {
		manejador.getTransaction().begin();
		manejador.merge(factura);
		manejador.getTransaction().commit();
	}/*fin de actualizarFactura*/
	
	public Factura buscarFactura(Long id) {
		Factura factura=new Factura();
		factura=manejador.find(Factura.class,id);
		return factura;
	}/*fin de buscarFactura*/
	
	public List<Factura> buscarFacturas(){
		List<Factura> facturas=new ArrayList<Factura>();
		Query consulta=manejador.createQuery("SELECT FAC FROM Factura FAC",Factura.class);
		facturas= consulta.getResultList();
		return facturas;
	}/*fin de buscarFacturas*/
	
	public List<VMantenimientoFactura> buscarInfoParaFactura(String sql){
		List<VMantenimientoFactura> info=new ArrayList<VMantenimientoFactura>();
		manejador.getTransaction().begin();
		Query consulta=manejador.createNativeQuery(sql,VMantenimientoFactura.class);
		info= consulta.getResultList();
		return info;
	}/*fin de buscarInfoParaFactura*/
	
	public Factura buscarUltimaFactura(String sql) {
		Factura factura=new Factura();
		manejador.getTransaction().begin();
		Query consulta=manejador.createNativeQuery(sql,Factura.class);
		factura=(Factura) consulta.getSingleResult();
		return factura;
	}/*fin de buscarUltimaFactura*/
	
	public void eliminarFactura(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarFactura*/
	
}/*fin de class*/
