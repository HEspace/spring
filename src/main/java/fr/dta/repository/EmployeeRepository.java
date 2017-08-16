package fr.dta.repository;

import java.util.List;

import fr.dta.model.Employe;

public interface EmployeeRepository {

	void saveEmployee(Employe employee);
	List<Employe> findAllEmployees();
	Employe findBySsn(String ssn);
	void updateEmployee(Employe employee);
	Employe findLastHired();
	
	void deleteAllEmployees();
	
	void restart();
	
}
