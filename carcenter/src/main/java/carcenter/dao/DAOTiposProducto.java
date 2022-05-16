package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.TipoProducto;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOTiposProducto {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearTipoProducto(TipoProducto tipoProducto) {
		manejador.getTransaction().begin();
		manejador.persist(tipoProducto);
		manejador.getTransaction().commit();
	}/*fin de crearTipoProducto*/
	
	public void actualizarTipoProducto(TipoProducto tipoProducto) {
		manejador.getTransaction().begin();
		manejador.merge(tipoProducto);
		manejador.getTransaction().commit();
	}/*fin de actualizarTipoProducto*/
	
	public TipoProducto buscarTipoProducto(Long id) {
		TipoProducto tipoProducto=new TipoProducto();
		tipoProducto=manejador.find(TipoProducto.class,id);
		return tipoProducto;
	}/*fin de buscarTipoProducto*/
	
	public List<TipoProducto> buscarTiposProducto(){
		List<TipoProducto> tiposProducto=new ArrayList<TipoProducto>();
		Query consulta=manejador.createQuery("SELECT TIR FROM TipoProducto TIR",TipoProducto.class);
		tiposProducto= consulta.getResultList();
		return tiposProducto;
	}/*fin de buscarTiposProducto*/
	
	public void eliminarTipoProducto(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarTipoProducto*/
	
}/*fin de class*/
