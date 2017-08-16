package spring;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.dta.model.Employe;
import fr.dta.repository.EmployeeMockRepository;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.CompanyService;
import fr.dta.service.EmployeeMockService;
import fr.dta.service.EmployeeStubService;

public class TestUnitaire {

		@Test
		public void testApp() throws ParseException {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.getBean("employeeRepository");
		EmployeeMockService ems = (EmployeeMockService)context.getBean("employeeMockService");
		EmployeeRepository er = (EmployeeRepository)context.getBean("employeeRepository");
		CompanyService cs = (CompanyService)context.getBean("companyService");
		Assert.assertEquals(cs.getAllEmployees().size(),2 );		
		Assert.assertEquals(ems.findLastHired().getPrenom(), "Hedy"); // teste de la méthode findLastHired
		
		
		Assert.assertEquals(2,er.findAllEmployees().size()); // teste de la méthode findEmploye

		//EmployeeStubService ess = (EmployeeStubService)context.getBean("employeeStubService");
		
		try{
			;
		} catch (Exception e){
		}
		
		
		
		
		}
}
