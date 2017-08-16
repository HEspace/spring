package fr.dta.service;

import java.util.List;

import fr.dta.model.Employe;

public interface EmployeeService {
	
	 void saveEmployee(Employe employee);

	 List<Employe> findAllEmployees();
	 
	 Employe findBySsn(String ssn);
	 
	 void updateEmployee(Employe employee);
	 
	 Employe findLastHired();
	 
	 void updateEmployees(List<Employe> employees);
	 
	 void deleteAll();
	 void restart();
	 


}
