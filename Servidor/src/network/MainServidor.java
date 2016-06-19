package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {

	static ArrayList<ClientHandler> clientes = new ArrayList<>();

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(Constantes.SERVER_PORT);
			while(true){
				Socket s = ss.accept();
				ClientHandler c = new ClientHandler(s);
				c.start();
				clientes.add(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void broadcast(String m, ClientHandler cliente){
		for(ClientHandler c : clientes){
			try {
				if(c != cliente){
					c.enviarMensaje("El cliente "+cliente.getInetAddress()+ " ha dicho: "+m);
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
