/*package fr.dta.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfiguration {

	@Before("execution(* fr.dta.service.EmployeeService.*(..))")
	public void logUserServiceLayer(JoinPoint joinPoint) {
	System.out.println(joinPoint.getSignature().getDeclaringTypeName() + " : has been called");
	}

	@AfterThrowing(pointcut = "execution(* fr.dta.*.*.*(findBySsn))")
	public void EmployeeNotFoundException(RuntimeException re) {
		System.out.println(re.getMessage());
	}
	
	
	
	}
*/