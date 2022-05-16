package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Mantenimiento;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOMantenimientos {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearMantenimiento(Mantenimiento mantenimiento) {
		manejador.getTransaction().begin();
		manejador.persist(mantenimiento);
		manejador.getTransaction().commit();
	}/*fin de crearMantenimiento*/
	
	public void actualizarMantenimiento(Mantenimiento mantenimiento) {
		manejador.getTransaction().begin();
		manejador.merge(mantenimiento);
		manejador.getTransaction().commit();
	}/*fin de actualizarMantenimiento*/
	
	public Mantenimiento buscarMantenimiento(Long id) {
		Mantenimiento mantenimiento=new Mantenimiento();
		mantenimiento=manejador.find(Mantenimiento.class,id);
		return mantenimiento;
	}/*fin de buscarMantenimiento*/
	
	public List<Mantenimiento> buscarMantenimientos(){
		List<Mantenimiento> mantenimientos=new ArrayList<Mantenimiento>();
		Query consulta=manejador.createQuery("SELECT MAN FROM Mantenimiento MAN",Mantenimiento.class);
		mantenimientos= consulta.getResultList();
		return mantenimientos;
	}/*fin de buscarMantenimientos*/
	
	public void eliminarMantenimiento(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarMantenimiento*/
	
}/*fin de class*/
