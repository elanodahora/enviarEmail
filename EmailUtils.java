package br.com.email;
/*
  feito baseado em https://benignosales.wordpress.com/2010/11/18/jsf-2-0-enviando-e-mail-com-commons-mail/  
  obs foram feitas algumas modificaoes  para funcionar . os jar usados no projeto  
  commons-email-1.5.jar    javax.mail-1.5-6.jar  e mail-1.4.7.jar esses 3 jars podem ser baixados da internet e adicionados diretamente na pasta lib do projeto, 
  ou adicionando atraves dentro do arquivo pom.xml  para que usa mavem usando as seguintes configurações
  
	          <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-email -->
		<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-email</artifactId>
		    <version>1.5</version>		    
		    <scope>compile</scope>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/javax.mail/mail 
		 para enviar email-->
		<dependency>
		    <groupId>javax.mail</groupId>
		    <artifactId>mail</artifactId>
		    <version>1.4.7</version>
		</dependency>  
  
  
  obs: caso apareca no console a mensagem de erro "Sending the email to the following server failed : smtp.gmail.com:587"    
  tem que se certificar que os jars foram adicionados no projeto e
  tem que desativar o antivirus ou criar uma excecao para a aplicacao no antivirus para o envio do email funcionar
  
  Nas configurações da conta do email do gmail tem que  ir na guia segurança > e Ativar a opcão "Acesso a app menos seguro"  se nao fizer 
  isso,  o gmail nao permite o envio do email atraves da aplicação
 */

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
