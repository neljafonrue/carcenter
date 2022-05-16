package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Vehiculo;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOVehiculos {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearVehiculo(Vehiculo vehiculo) {
		manejador.getTransaction().begin();
		manejador.persist(vehiculo);
		manejador.getTransaction().commit();
	}/*fin de crearVehiculo*/
	
	public void actualizarVehiculo(Vehiculo vehiculo) {
		manejador.getTransaction().begin();
		manejador.merge(vehiculo);
		manejador.getTransaction().commit();
	}/*fin de actualizarVehiculo*/
	
	public Vehiculo buscarVehiculo(String matricula) {
		Vehiculo vehiculo=new Vehiculo();
		vehiculo=manejador.find(Vehiculo.class,matricula);
		return vehiculo;
	}/*fin de buscarVehiculo*/
	
	public List<Vehiculo> buscarVehiculos(){
		List<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
		Query consulta=manejador.createQuery("SELECT VEH FROM Vehiculo VEH",Vehiculo.class);
		vehiculos= consulta.getResultList();
		return vehiculos;
	}/*fin de buscarVehiculos*/
	
	public void eliminarVehiculo(String matricula) {
		manejador.getTransaction().begin();
		manejador.remove(matricula);
		manejador.getTransaction().commit();
	}/*fin de eliminarVahiculo*/
	
}/*fin de class*/
