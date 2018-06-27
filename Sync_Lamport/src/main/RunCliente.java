package main;

import java.io.IOException;
import java.net.UnknownHostException;

import controlers.ClienteCtrl;

/** Processos */
public class RunCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		ClienteCtrl pro1 = new ClienteCtrl("127.0.0.1", 12345);
		ClienteCtrl pro2 = new ClienteCtrl("127.0.0.2", 12345);
		ClienteCtrl pro3 = new ClienteCtrl("127.0.0.3", 12345);
		ClienteCtrl pro4 = new ClienteCtrl("127.0.0.4", 12345);

		Runnable r1 = () -> {
			try {
				pro1.executa();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread p1 = new Thread(r1);
		p1.start();

		Runnable r2 = () -> {
			try {
				pro2.executa();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread p2 = new Thread(r2);
		p2.start();

		Runnable r3 = () -> {
			try {
				pro3.executa();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread p3 = new Thread(r3);
		p3.start();

		Runnable r4 = () -> {
			try {
				pro4.executa();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread p4 = new Thread(r4);
		p4.start();

	}

}
