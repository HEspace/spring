package fr.dta.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.dta.model.Employe;


@Repository()
@Profile(value = { "!JPA" })
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository{

	
	public void saveEmployee(Employe employee) {
		getJdbcTemplate().update("insert into employee(firstname, lastname,ssn, hiradate,salary) "+ 
	"values(?,?,?,?,?)",
	employee.getNom(), employee.getPrenom(), 
	employee.getSs(), employee.getDateEmbauche(), 
	employee.getSalaire());	
	}
	
	

	
	public List<Employe> findAllEmployees() {
		 return getJdbcTemplate().query(
	   "select id, firstname, lastname, ssn, hiredate, salary from employee", new EmployeeMapper()) ;
	}

	
	public Employe findBySsn(String ssn) {
		 return getJdbcTemplate().queryForObject(
	                "select id, firstname, lastname, ssn, hiredate, salary from employee where ssn = ?",
	                new Object[]{ssn},
	                new EmployeeMapper());
	    }
	

	
	public void updateEmployee(Employe employee) {
		 int test = getJdbcTemplate().update(
	                "update employee set firstname = ?, lastname = ?, ssn = ?, hiredate = ?, salary = ? where id = ?",
	                employee.getNom(), 
	                employee.getPrenom(), 
	                employee.getSs(), 
	                employee.getDateEmbauche(),
	                employee.getSalaire(),
	                employee.getId());
		 if (test ==0){
			 throw new RuntimeException();
		 }
	}
	
	  private static final class EmployeeMapper implements RowMapper<Employe> {
	    	
	        public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employe employee = new Employe();
	            employee.setId(rs.getLong("id"));
	            employee.setPrenom(rs.getString("firstname"));
	            employee.setNom(rs.getString("lastname"));
	            employee.setSs(rs.getString("ssn"));
	            employee.setSalaire(rs.getBigDecimal("salary"));
	            employee.setDateEmbauche(rs.getDate("hiredate"));
	            return employee;
	        }
	
	  }

	
	public void deleteAllEmployees() {
		getJdbcTemplate().update("Supression de tous les employés");		
	}




	
	public Employe findLastHired() {
		 return getJdbcTemplate().queryForObject(
	                "select id, firstname, lastname, ssn, hiredate, salary from employee order by hiredate desc limit 1",
	                new EmployeeMapper());
	}




	
	public void restart() {
		// TODO Auto-generated method stub
		
	}
}
