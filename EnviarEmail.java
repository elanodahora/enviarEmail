package br.com.email;


public class EnviarEmail {
				
	public EnviarEmail() {
		
	}			
	
	public static void main(String[] args ){
		
		String sEmailDestinarario = "elanodahora@gmail.com";
															
		try {						
				Mensagem mensagem = new Mensagem();
				
				mensagem.setDestino(sEmailDestinarario);
				mensagem.setTitulo("Envio de email");								 				
				mensagem.setMensagem("Mensagem de Teste de envio de email usando java ");												
				EmailUtils.enviaEmail(mensagem);				
				System.out.println("Sua senha foi enviada para o e-mail: "+ sEmailDestinarario);							
			
		} catch (Exception e) {				
				System.out.println("erro:"+ e.getMessage());
		}		  
				
	}
}
