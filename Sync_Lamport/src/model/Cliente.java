package model;

/**
 * Responsavel pelo enviamento de requisições, à espera de uma resposta do
 * servidor
 */
public class Cliente {

	private String host;
	private int porta;
	private String nome;

	public Cliente() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
