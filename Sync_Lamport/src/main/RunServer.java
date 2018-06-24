package main;

import java.io.IOException;

import controlers.ServidorCtrl;

public class RunServer {

	public static void main(String[] agrs) throws IOException{
		new ServidorCtrl(12345).executa();
	}
	
	
}
