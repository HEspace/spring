package fr.dta.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.model.Employe;

@Service
@Transactional
public class CompanyService {
	
	private EmployeeService es;
	
	
	
	public CompanyService(EmployeeService es) {
		this.es = es;
	}
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.es = employeeService;
	}



	public List<Employe> getAllEmployees() {
		return es.findAllEmployees();
	}
}
