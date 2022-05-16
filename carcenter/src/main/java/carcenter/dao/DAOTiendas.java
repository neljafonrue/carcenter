package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Tienda;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOTiendas {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearTienda(Tienda tienda) {
		manejador.getTransaction().begin();
		manejador.persist(tienda);
		manejador.getTransaction().commit();
	}/*fin de crearTienda*/
	
	public void actualizarTienda(Tienda tienda) {
		manejador.getTransaction().begin();
		manejador.merge(tienda);
		manejador.getTransaction().commit();
	}/*fin de actualizarTienda*/
	
	public Tienda buscarTienda(Long id) {
		Tienda tienda=new Tienda();
		tienda=manejador.find(Tienda.class,id);
		return tienda;
	}/*fin de buscarTienda*/
	
	public List<Tienda> buscarTiendas(){
		List<Tienda> tiendas=new ArrayList<Tienda>();
		Query consulta=manejador.createQuery("SELECT TIE FROM Tienda TIE",Tienda.class);
		tiendas= consulta.getResultList();
		return tiendas;
	}/*fin de buscarTiendas*/
	
	public void eliminarTienda(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarTienda*/
	
}/*fin de class*/
