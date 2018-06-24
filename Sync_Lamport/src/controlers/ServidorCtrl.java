package controlers;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.Servidor;
import serversUtils.TratadorDeMensagemDoCliente;

public class ServidorCtrl extends Servidor {

	public ServidorCtrl(int porta) {
		this.setPorta(porta);
		this.setClientes(new ArrayList<Socket>());
	}

	public void executa() {

		try {

			ServerSocket server = new ServerSocket(this.getPorta());
			System.out.println("Porta " + this.getPorta() + " aberta!");

			// Escutando
			while (true) {
				// Aceitar conexão
				Socket cliente = server.accept();
				cliente.getOutputStream().toString();
				System.out.println("Nova conexao com o user " + cliente.getInetAddress().getHostAddress());

				//Adicionando os cliente no mesmo server
				this.getClientes().add(cliente);
				
				TratadorDeMensagemDoCliente tratCli = new TratadorDeMensagemDoCliente(cliente, this);
				new Thread(tratCli).start();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void distribuiMensagem(Socket clienteReq, String msg) {

		for (Socket cliente : this.getClientes()) {
			if(!cliente.equals(clienteReq)) {
				try {
					PrintStream ps = new PrintStream(cliente.getOutputStream());
					ps.println(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

}
