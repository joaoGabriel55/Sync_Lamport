package serversUtils;

import java.net.Socket;
import java.util.Scanner;

import controlers.ServidorCtrl;
import model.Servidor;

public class TratadorDeMensagemDoCliente implements Runnable {

	private Socket cliente;
	private ServidorCtrl servidor;

	public TratadorDeMensagemDoCliente(Socket cliente, ServidorCtrl servidor) {
		super();
		this.cliente = cliente;
		this.servidor = servidor;
	}

	@Override
	public void run() {

		try {

			Scanner s = new Scanner(this.cliente.getInputStream());
			while (s.hasNextLine())
				servidor.distribuiMensagem(this.cliente, s.nextLine());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
