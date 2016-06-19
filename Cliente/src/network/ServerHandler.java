package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerHandler extends Thread{
	
	private Socket s;
	private boolean conectado;

	public ServerHandler(Socket s){
		this.s = s;
		conectado = true;
	}
	
	@Override
	public void run(){
		while(conectado){
			try {
				InputStream is = s.getInputStream();
				DataInputStream di = new DataInputStream(is);
				String m = di.readLine();
				System.out.println(m);
			} catch (IOException e) {
				conectado = false;
				System.out.println("Cliente " + s.getInetAddress() + " desconectado");
				e.printStackTrace();
			}
		}
	}

}
