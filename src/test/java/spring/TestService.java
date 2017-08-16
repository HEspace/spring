package spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.App;
import fr.dta.service.EmployeeService;
import fr.dta.service.MailService;

public class TestService {
	
	@Test 
	public void TestService(){
		
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        EmployeeService es = (EmployeeService) context.getBean("employeeService");
        MailService ma = context.getBean(MailService.class);
        ma.setMessage("mailService A");

        MailService mailServiceB = context.getBean(MailService.class);
        mailServiceB.setMessage("mailService B");
        
        ma.sendMail();
        mailServiceB.sendMail();
		context.close();
	}
	

}
