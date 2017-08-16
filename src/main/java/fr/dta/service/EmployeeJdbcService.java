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
@Profile(value = { "!JPA"})
@Transactional
public class EmployeeJdbcService implements EmployeeService {

	
	private EmployeeRepository er;
	
	@Autowired
	public EmployeeJdbcService(EmployeeRepository employeeRepository) {
		this.er = employeeRepository;
	}
	
	@Override
	public void saveEmployee(Employe employee) {
		er.saveEmployee(employee);
		
	}

	@Override
	public List<Employe> findAllEmployees() {
		return er.findAllEmployees();
	}

	@Override
	public Employe findBySsn(String ssn) {
		Employe employee = er.findBySsn(ssn);
		if (employee == null){
			throw new EmplyeeNotFoundException();
		}
		return employee;
		
	}

	@Override
	public void updateEmployee(Employe employee) {
		er.updateEmployee(employee);
		
	}

	@Override
	public Employe findLastHired() {
		return null;
		
	}

	@Override
	public void updateEmployees(List<Employe> employees) {
		employees.forEach(employee ->{
			er.updateEmployee(employee);});
	
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}
	
	

}
