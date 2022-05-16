package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.TipoDocumento;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOTiposDocumento {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearTipoDocumento(TipoDocumento tipoDocumento) {
		manejador.getTransaction().begin();
		manejador.persist(tipoDocumento);
		manejador.getTransaction().commit();
	}/*fin de crearTipoDocumento*/
	
	public void actualizarTipoDocumento(TipoDocumento tipoDocumento) {
		manejador.getTransaction().begin();
		manejador.merge(tipoDocumento);
		manejador.getTransaction().commit();
	}/*fin de actualizarTipoDocumento*/
	
	public TipoDocumento buscarTipoDocumento(Long id) {
		TipoDocumento tipoDocumento=new TipoDocumento();
		tipoDocumento=manejador.find(TipoDocumento.class,id);
		return tipoDocumento;
	}/*fin de buscarTipoDocumento*/
	
	public List<TipoDocumento> buscarTiposDocumento(){
		List<TipoDocumento> tiposDocumento=new ArrayList<TipoDocumento>();
		Query consulta=manejador.createQuery("SELECT TID FROM TipoDocumento TID",TipoDocumento.class);
		tiposDocumento= consulta.getResultList();
		return tiposDocumento;
	}/*fin de buscarTiposDocumento*/
	
	public void eliminarTipoDocumento(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarTipoDocumento*/
	
}/*fin de class*/
