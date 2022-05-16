package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.DetalleMantenimiento;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAODetalleMantenimientos {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearDetalleMantenimiento(DetalleMantenimiento detalleMantenimiento) {
		manejador.getTransaction().begin();
		manejador.persist(detalleMantenimiento);
		manejador.getTransaction().commit();
	}/*fin de crearDetalleMantenimiento*/
	
	public void actualizarDetalleMantenimiento(DetalleMantenimiento detalleMantenimiento) {
		manejador.getTransaction().begin();
		manejador.merge(detalleMantenimiento);
		manejador.getTransaction().commit();
	}/*fin de actualizarDetalleMantenimiento*/
	
	public DetalleMantenimiento buscarDetalleMantenimiento(Long id) {
		DetalleMantenimiento detalleMantenimiento=new DetalleMantenimiento();
		detalleMantenimiento=manejador.find(DetalleMantenimiento.class,id);
		return detalleMantenimiento;
	}/*fin de buscarDetalleMantenimiento*/
	
	public List<DetalleMantenimiento> buscarDetallesMantenimiento(){
		List<DetalleMantenimiento> detallesMantenimiento=new ArrayList<DetalleMantenimiento>();
		Query consulta=manejador.createQuery("SELECT DEM FROM DetalleMantenimiento DEM",DetalleMantenimiento.class);
		detallesMantenimiento= consulta.getResultList();
		return detallesMantenimiento;
	}/*fin de buscarDetallesMantenimiento*/
	
	public void eliminarDetalleMantenimiento(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id); 
		manejador.getTransaction().commit();
	}/*fin de eliminarDetalleMantenimiento*/
	
}/*fin de class*/
