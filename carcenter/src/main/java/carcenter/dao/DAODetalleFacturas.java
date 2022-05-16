package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.DetalleFactura;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAODetalleFacturas {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearDetalleFactura(DetalleFactura detalleFactura) {
		manejador.getTransaction().begin();
		manejador.persist(detalleFactura);
		manejador.getTransaction().commit();
	}/*fin de crearDetalleFactura*/
	
	public void actualizarDetalleFactura(DetalleFactura detalleFactura) {
		manejador.getTransaction().begin();
		manejador.merge(detalleFactura);
		manejador.getTransaction().commit();
	}/*fin de actualizarDetalleFactura*/
	
	public DetalleFactura buscarDetalleFactura(Long id) {
		DetalleFactura detalleFactura=new DetalleFactura();
		detalleFactura=manejador.find(DetalleFactura.class,id);
		return detalleFactura;
	}/*fin de buscarDetalleFactura*/
	
	public List<DetalleFactura> buscarDetallesFactura(){
		List<DetalleFactura> detallesFactura=new ArrayList<DetalleFactura>();
		Query consulta=manejador.createQuery("SELECT DEF FROM DetalleFactura DEF",DetalleFactura.class);
		detallesFactura= consulta.getResultList();
		return detallesFactura;
	}/*fin de buscarDetallesFacturas*/
	
	public void eliminarDetalleFactura(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarDetalleFactura*/
	
}/*fin de class*/
