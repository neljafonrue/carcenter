package carcenter.modelo.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaJPA {
	
	private static final String ADMIN_PERSISTENCIA="ADMIN_PERSISTENCIA";
	private static EntityManagerFactory fabrica;
	
	public static EntityManagerFactory getFabrica() {
		if(fabrica==null) {
			fabrica=Persistence.createEntityManagerFactory(ADMIN_PERSISTENCIA);
		}/*fin de if*/
		return fabrica;
	}
	
	public static void cerrar() {
		if(fabrica!=null) {
			fabrica.close();
		}/*fin de if*/
	}

}/*fin de class*/
