package br.com.email;
//classe apara carregar titulo email de destino e Mensagem que sera enviada no email
public class Mensagem {

	private String destino;
	private String titulo;
	private String mensagem;

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}