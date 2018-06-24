package main;

import java.io.IOException;
import java.net.UnknownHostException;

import controlers.ClienteCtrl;

/** Processos */
public class RunCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		new ClienteCtrl("127.0.0.1", 12345).executa();

	}

}
