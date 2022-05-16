package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.FotoVehiculo;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOFotosVehículos {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearFotoVehiculo(FotoVehiculo fotoVehiculo) {
		manejador.getTransaction().begin();
		manejador.persist(fotoVehiculo);
		manejador.getTransaction().commit();
	}/*fin de crearFotoVehiculo*/
	
	public void actualizarFotoVehiculo(FotoVehiculo fotoVehiculo) {
		manejador.getTransaction().begin();
		manejador.merge(fotoVehiculo);
		manejador.getTransaction().commit();
	}/*fin de actualizarFotoVehiculo*/
	
	public FotoVehiculo buscarFotoVehiculo(Long id) {
		FotoVehiculo fotoVehiculo=new FotoVehiculo();
		fotoVehiculo=manejador.find(FotoVehiculo.class,id);
		return fotoVehiculo;
	}/*fin de buscarFotoVehiculo*/
	
	public List<FotoVehiculo> buscarFotosVehiculos(){
		List<FotoVehiculo> fotosVehiculos=new ArrayList<FotoVehiculo>();
		Query consulta=manejador.createQuery("SELECT FOV FROM FotoVehiculo FOV",FotoVehiculo.class);
		fotosVehiculos= consulta.getResultList();
		return fotosVehiculos;
	}/*fin de buscarFotosVehiculos*/
	
	public void eliminarFotoVehiculo(Long id) {
		manejador.getTransaction().begin();
		manejador.remove(id);
		manejador.getTransaction().commit();
	}/*fin de eliminarFotoVehiculo*/
	
}/*fin de class*/
