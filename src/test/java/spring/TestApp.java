package spring;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.App;
import fr.dta.model.Employe;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.CompanyService;
import fr.dta.service.EmployeeMockService;
import fr.dta.service.EmployeeService;


public class TestApp {
	
	static AbstractApplicationContext context;
	static EmployeeService es;
	
	@BeforeClass
	public static void init(){
		System.setProperty("spring.profiles.active", "JPA");
		context = new AnnotationConfigApplicationContext(App.class);
		es = (EmployeeService) context.getBean("employeeJpaService");
		es.deleteAll();
		es.restart();
		
		
	}
	@Test
	public void testApp() throws ParseException {
		
		
	/*	SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
		context.getBean("employeeRepository");
		EmployeeMockService ems = (EmployeeMockService)context.getBean("employeeMockService");
		EmployeeRepository er = (EmployeeRepository)context.getBean("employeeRepository");
		CompanyService cs = (CompanyService)context.getBean("companyService");*/
			
		
		/*Assert.assertEquals(ems.findLastHired().getPrenom(), "Hedy"); // teste de la méthode findLastHired
		
		
		
		Integer employeeNumber = es.findAllEmployees().size();
		Long id = (long) (employeeNumber + 1);
		Employe newEmployee = new Employe(id, "Marie" + employeeNumber, "Curie", "145687785"+ employeeNumber,new BigDecimal(40000), new Date());
		es.saveEmployee(newEmployee);
		
		Assert.assertEquals(2,er.findAllEmployees().size()); // teste de la méthode findEmploye

		//EmployeeStubService ess = (EmployeeStubService)context.getBean("employeeStubService");
		ems.findBySsn("11111");
		
		
		
		// Test employeeService.updateEmployees ROLLBACK lorsque l'employé n'existe pas
		Employe nonExistingEmployee = new Employe(7777L, "Sub", "Zero", "145687785",new BigDecimal(0), new Date());
		newEmployee.setNom("New Nom");
		try{
		es.updateEmployees(Arrays.asList(newEmployee, nonExistingEmployee));
		} catch(RuntimeException e){}
		Assert.assertEquals("Zero" + employeeNumber, es.findBySsn("145687785" + employeeNumber).getNom());
*/
		
	
		
	}
	
	
	@Test
	public void testHibernate(){
	
		es.saveEmployee(new Employe("Hedy","EL"));
		
		
	}
	
	
	
	
	

}
