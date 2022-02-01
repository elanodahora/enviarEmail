package br.com.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EmailUtils {
	
	private static final String HOSTNAME = "smtp.gmail.com";			
	
	private static final String USERNAME = "wsomus@gmail.com";		
						
	private static final String PASSWORD = "Wsomus@0720";

	private static final String EMAILORIGEM = "wsomus@gmail.com";   	
		
	public static Email conectaEmail() throws EmailException {
	
	Email email = new SimpleEmail();
	email.setHostName(HOSTNAME);
	email.setSmtpPort(587);	
	email.setAuthenticator(new DefaultAuthenticator(USERNAME,PASSWORD));		
	//email.setDebug(true);// habilitar essa linha caso queira ver o debug do envio de email	
	email.setStartTLSEnabled(true);
	email.setFrom(EMAILORIGEM);
	return email;  
	}   
	
	public static void enviaEmail(Mensagem mensagem) throws EmailException {				
		Email email = new SimpleEmail();	
		email = conectaEmail();   	
		email.setSubject(mensagem.getTitulo());		
		email.setMsg(mensagem.getMensagem());		
		email.addTo(mensagem.getDestino());				
		email.send();		 	
	}	

}
