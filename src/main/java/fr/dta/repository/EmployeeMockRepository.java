package fr.dta.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.dta.model.Employe;



@Repository()
@Profile(value = { "!JPA" })
public class EmployeeMockRepository implements EmployeeRepository {
	
	private List<Employe> employes;
	
	
	

	public EmployeeMockRepository() {
		this.employes = new ArrayList<Employe>();
		employes.add(new Employe(12L, "Hedy", "EL", "777777", new BigDecimal(1), new Date(2000,01,01)));
		employes.add(new Employe(12L, "Ayoub", "Benghal", "111111", new BigDecimal(9999), new Date(1999,01,01)));
	}


	public void saveEmployee(Employe employee) {
		employes.add(employee);
		
	}


	public List<Employe> findAllEmployees() {
		return employes;
	}

	public Employe findBySsn(String ssn) {
		Optional<Employe> result = employes.stream().filter(e -> ssn.equals(e.getSalaire())).findFirst();
		if (result.isPresent()){
			return result.get();
		} else {
			return null;}
	}

	public void updateEmployee(Employe employee) {
		Optional<Employe> employeeToUpdate = employes.stream().filter(
				e -> employee.getId() == e.getId()).findFirst();
		if (employeeToUpdate.isPresent()) {
			employeeToUpdate.get().setPrenom(employee.getPrenom());
			employeeToUpdate.get().setNom(employee.getNom());
			employeeToUpdate.get().setSs(employee.getSs());
			employeeToUpdate.get().setDateEmbauche(employee.getDateEmbauche());
			employeeToUpdate.get().setSalaire(employee.getSalaire());
		}
		
	}
	
	public Employe findLastHired() {
        return employes.stream().max((e1, e2) -> e1.getDateEmbauche().compareTo(e2.getDateEmbauche())).get();
    }


	@Override
	public void deleteAllEmployees() {
		employes.clear();
		
	}


	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

}
