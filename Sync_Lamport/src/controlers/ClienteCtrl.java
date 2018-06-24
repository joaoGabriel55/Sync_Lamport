package controlers;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

import model.Cliente;
import serversUtils.RecebedorDeMensagemDoServidor;

public class ClienteCtrl extends Cliente {

	public ClienteCtrl(String host, int porta) {
		this.setHost(host);
		this.setPorta(porta);
	}

	public ClienteCtrl() {

	}

	@SuppressWarnings("static-access")
	public void executa() throws UnknownHostException, IOException {

		try {

			Socket clienteSocket = new Socket(this.getHost(), this.getPorta());
			Scanner teclado = new Scanner(System.in);
			PrintStream saida = new PrintStream(clienteSocket.getOutputStream());

			System.out.println("Processo:");

			this.setNome(teclado.nextLine());

			System.out.println("Processo, " + this.getNome() + ", Conectado!");

			RecebedorDeMensagemDoServidor rMsg = new RecebedorDeMensagemDoServidor(clienteSocket.getInputStream());
			new Thread(rMsg).start();

			int valorClock = getClockRandom(10, 3);

			int lt = 0;
			int ltMilis = 0;
			int ltMsg = 0;
			int count = 0;

			System.out.println("Send Process/Clock Value (s)/");
			while (true) {
				if (count == 0) {
					new Thread(rMsg).sleep(valorClock);
					lt = valorClock;
				} else {
					lt = lt + 1000;// ms
					ltMsg = lt;
					new Thread(rMsg).sleep(lt);
				}

				if (count == 0)
					saida.println(this.getNome() + "          /          " + valorClock/1000);
				else
					saida.println(this.getNome() + "          /          " + lt/1000);
				
				lt = Math.max(ltMsg, lt) + 1;

				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Valor do clock aleatório (entre 3 e 10) */
	public static int getClockRandom(int max, int min) {

		int maxConv = max * 1000;
		int minConv = min * 1000;

		Random random = new Random();
		return random.nextInt((maxConv - minConv) + 1000) + minConv;
	}

}
