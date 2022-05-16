package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Producto;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOProductos {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearProducto(Producto producto) {
		manejador.getTransaction().begin();
		manejador.persist(producto);
		manejador.getTransaction().commit();
	}/*fin de crearProducto*/
	
	public void actualizarProducto(Producto producto) {
		manejador.getTransaction().begin();
		manejador.merge(producto);
		manejador.getTransaction().commit();
	}/*fin de actualizarProducto*/
	
	public Producto buscarProducto(Long id) {
		Producto producto=new Producto();
		producto=manejador.find(Producto.class,id);
		return producto;
	}/*fin de buscarProducto*/
	
	public List<Producto> buscarProductos(){
		List<Producto> productos=new ArrayList<Producto>();
		Query consulta=manejador.createQuery("SELECT PRO FROM Producto PRO",Producto.class);
		productos=consulta.getResultList();
		return productos;
	}/*fin de buscarProductos*/
	
	public void eliminarProducto(Producto producto) {
		manejador.getTransaction().begin();
		manejador.remove(producto);
		manejador.getTransaction().commit();
	}/*fin de eliminarProducto*/
	
}/*fin de class*/
