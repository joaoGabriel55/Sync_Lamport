package model;

import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	private int porta;

	/** Usuarios na sala de bate papo */
	private ArrayList<Socket> clientes;

	public Servidor() {
		super();
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public ArrayList<Socket> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Socket> clientes) {
		this.clientes = clientes;
	}

}
