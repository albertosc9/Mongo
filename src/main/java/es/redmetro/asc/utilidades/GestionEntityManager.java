package es.redmetro.asc.utilidades;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionEntityManager {
	
	private final static String UNIDADPERSISTENCIA_REDMETRO="RedMetroBD";
	
private static EntityManagerFactory emf_ODB; 
//EntityManager para JPA 	
public static EntityManager getEntityManager() {
	EntityManager gestorEntidades=null;
	
	// Se apoya en el fichero persistence.xml
	if(emf_ODB==null)
		emf_ODB= Persistence.createEntityManagerFactory(UNIDADPERSISTENCIA_REDMETRO);

	gestorEntidades = emf_ODB.createEntityManager();
	return gestorEntidades;
}
}