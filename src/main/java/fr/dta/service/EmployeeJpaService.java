package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.exception.EmplyeeNotFoundException;
import fr.dta.model.Employe;
import fr.dta.repository.EmployeeRepository;

@Service()
@Profile(value = {"JPA"})
@Transactional
public class EmployeeJpaService implements EmployeeService {

	
private EmployeeRepository eR;

@Autowired
public EmployeeJpaService(EmployeeRepository employeeRepository) {
	this.eR = employeeRepository;
}


	@Override
	public void saveEmployee(Employe employee) {
		eR.saveEmployee(employee);
	}

	@Override
	public List<Employe> findAllEmployees() {
		return eR.findAllEmployees();
	}

	@Override
	public Employe findBySsn(String ssn) {
		Employe employee = eR.findBySsn(ssn);
		if (employee == null){
			throw new EmplyeeNotFoundException();
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employe employee) {
		eR.updateEmployee(employee);
		
	}

	@Override
	public Employe findLastHired() {
		return null;
	}

	@Override
	public void updateEmployees(List<Employe> employees) {
		employees.forEach(employee ->{
			eR.updateEmployee(employee);});
	}


	@Override
	public void deleteAll() {
		eR.deleteAllEmployees();
		
	}


	@Override
	public void restart() {
		eR.restart();
	}

}
