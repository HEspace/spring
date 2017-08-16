package fr.dta.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile(value = { "JPA" })
public class AbstractJpaRepository {

	@PersistenceContext
	protected EntityManager eM;

	//Récupération de la session Hibernate
	protected Session getSession() {
		return eM.unwrap(Session.class);
	}

	
	// Implémenter les méthodes de base persist 
	public void persist(Object entity) {
		eM.persist(entity);
	}
	
	// update
	public Object update(Object entity){
		return eM.merge(entity);
		
	}
	
	// delete
	public void delete(Object entity){
		getSession().delete(entity);
	}

}
