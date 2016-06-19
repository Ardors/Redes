package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientHandler extends Thread{
	
	private Socket s;
	private boolean conectado;

	public ClientHandler(Socket s){
		this.s = s;
		conectado = true;
		System.out.println("Nuevo cliente con ip: "+ s.getInetAddress());
	}
	
	@Override
	public void run(){
		while(conectado){
			try {
				InputStream is = s.getInputStream();
				DataInputStream di = new DataInputStream(is);
				String m = di.readLine();
				System.out.println(m);
				MainServidor.broadcast(m,this);
			} catch (IOException e) {
				conectado = false;
				System.out.println("Cliente " + s.getInetAddress() + " desconectado");
				e.printStackTrace();
			}
		}
	}
	
	public void enviarMensaje(String m) throws IOException{
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		dout.writeUTF(m+"\n");
	}
	public InetAddress getInetAddress(){
		return s.getInetAddress();
	}
}
