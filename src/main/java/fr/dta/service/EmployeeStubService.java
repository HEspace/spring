package fr.dta.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.dta.model.Employe;

@Service()
@Profile(value = { "!JPA" })
public class EmployeeStubService implements EmployeeService{

	
	public void saveEmployee(Employe employee) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Employe> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Employe findBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}


	public void updateEmployee(Employe employee) {
		// TODO Auto-generated method stub
		
	}

	
	public Employe findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}



	public void updateEmployees(List<Employe> employees) {
		// TODO Auto-generated method stub
		
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
