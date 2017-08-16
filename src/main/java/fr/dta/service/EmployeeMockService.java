package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.dta.exception.EmplyeeNotFoundException;
import fr.dta.model.Employe;
import fr.dta.repository.EmployeeMockRepository;


@Service()
@Profile(value = { "!JPA"})
public class EmployeeMockService implements EmployeeService {

	
	private EmployeeMockRepository emr;
	
	
	@Autowired
	public EmployeeMockService(EmployeeMockRepository emr) {
		this.emr = emr;
	}


	public void saveEmployee(Employe employee) {
		// TODO Auto-generated method stub
		
	}


	public List<Employe> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}


	public Employe findBySsn(String ssn) {
		Employe employe = emr.findBySsn(ssn);
		if (employe == null){
			throw new EmplyeeNotFoundException();
		}
		return employe;
	}

	
	public void updateEmployee(Employe employee) {
		// TODO Auto-generated method stub
		
	}


	public Employe findLastHired() {
		return emr.findLastHired();
	}

// Mise a jour des employés
	
	public void updateEmployees(List<Employe> employees) {
		employees.forEach(employee ->{
			emr.updateEmployee(employee);});
		
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
