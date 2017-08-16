package fr.dta.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.model.Employe;


@Repository()
@Profile(value = { "JPA" })
@Transactional
public class EmployeeJpaRepository extends AbstractJpaRepository implements EmployeeRepository {

	public void saveEmployee(Employe employee) {
		persist(employee);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employe> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employe.class);
		return (List<Employe>) criteria.list();
	}

	@Override
	public Employe findBySsn(String ssn) {
	      Criteria criteria = getSession().createCriteria(Employe.class);
	        criteria.add(Restrictions.eq("ssn",ssn));
	        return (Employe) criteria.uniqueResult();
	}

	@Override
	public void updateEmployee(Employe employee) {
					update(employee);
		
	}

	@Override
	public void deleteAllEmployees() {
		getSession().createQuery("delete from Employe").executeUpdate();
	}

	@Override
	public Employe findLastHired() {
		 Criteria criteria = getSession().createCriteria(Employe.class);
	        criteria.addOrder(Order.desc("hireDate"));
	        return (Employe) criteria.uniqueResult();
	}

	@Override
	public void restart() {
		getSession().createSQLQuery("ALTER SEQUENCE seq_employee RESTART WITH 1").executeUpdate();		
	}

}
