package carcenter.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import carcenter.modelo.entidades.Persona;
import carcenter.modelo.entidades.PersonaPK;
import carcenter.modelo.entidades.VCliente;
import carcenter.modelo.persistencia.FabricaJPA;

public class DAOPersonas {

	EntityManager manejador=FabricaJPA.getFabrica().createEntityManager();
	
	public void crearPersona(Persona persona) {
		manejador.getTransaction().begin();
		manejador.persist(persona);
		manejador.getTransaction().commit();
	}/*fin de crearPersona*/
	
	public void actualizarPersona(Persona persona) {
		manejador.getTransaction().begin();
		manejador.merge(persona);
		manejador.getTransaction().commit();
	}/*fin de actualizarPersona*/
	
	public Persona buscarPersona(PersonaPK personaPK) {
		Persona persona=new Persona();
		persona=manejador.find(Persona.class,personaPK);
		return persona;
	}/*fin de buscarPersona*/
	
	public List<Persona> buscarPersonas(){
		List<Persona> personas=new ArrayList<Persona>();
		Query consulta=manejador.createQuery("SELECT PER FROM Persona PER",Persona.class);
		personas= consulta.getResultList();
		return personas;
	}/*fin de buscarPersonas*/
	
	public List<VCliente> buscarClientes(String sql) {
		List<VCliente> clientes=null;
		manejador.getTransaction().begin();
		Query consulta=manejador.createNativeQuery(sql,VCliente.class);
		clientes= consulta.getResultList();
		return clientes;
	}/*fin de buscarClientes*/
	
	public void eliminarPersona(PersonaPK personaPK) {
		manejador.getTransaction().begin();
		manejador.remove(personaPK);
		manejador.getTransaction().commit();
	}/*fin de eliminarPersona*/
	
}/*fin de class*/
