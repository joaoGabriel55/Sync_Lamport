package serversUtils;

import java.io.InputStream;
import java.util.Scanner;

public class RecebedorDeMensagemDoServidor implements Runnable {

	private InputStream server;

	public RecebedorDeMensagemDoServidor(InputStream server) {
		this.server = server;
	}

	@Override
	public void run() {
		try {
			Scanner s = new Scanner(this.server);

			while (s.hasNextLine())
				System.out.println(s.nextLine());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
