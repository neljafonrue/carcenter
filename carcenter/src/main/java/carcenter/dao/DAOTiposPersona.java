package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.TipoPersona;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOTiposPersona {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearTipoPersona(TipoPersona tipoPersona) {
		manejador.getTransaction().begin();
		manejador.persist(tipoPersona);
		manejador.getTransaction().commit();
	}/*fin de crearTipoPersona*/
	
	public void actualizarTipoPersona(TipoPersona tipoPersona) {
		manejador.getTransaction().begin();
		manejador.merge(tipoPersona);
		manejador.getTransaction().commit();
	}/*fin de actualizarTipoPersona*/
	
	public TipoPersona buscarTipoPersona(Long id) {
		TipoPersona tipoPersona=new TipoPersona();
		tipoPersona=manejador.find(TipoPersona.class,id);
		return tipoPersona;
	}/*fin de buscarTipoPersona*/
	
	public List<TipoPersona> buscarTiposPersona(){
		List<TipoPersona> tiposPersona=new ArrayList<TipoPersona>();
		Query consulta=manejador.createQuery("SELECT TIP FROM TipoPersona TIP",TipoPersona.class);
		tiposPersona= consulta.getResultList();
		return tiposPersona;
	}/*fin de buscarTiposPersona*/
	
	public void eliminarTipoPersona(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarTipoPersona*/
	
}/*fin de class*/
