package fr.dta.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dta.model.Employe;

@Service
@Scope(value = "prototype")
public class MailService {
	
	
	private String message;

    public void sendMail() {
        System.out.println(this.message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
	

}
