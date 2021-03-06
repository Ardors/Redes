package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class MainCliente {

	private static boolean conectado;
	private static Socket s;
	
	public static void main(String[] args) {
		try {
			s = new Socket(Constantes.SERVER_HOST, Constantes.SERVER_PORT);
			conectado = true;
			ServerHandler sh = new ServerHandler(s);
			sh.start();
		} catch (UnknownHostException e) {
			conectado = false;
			e.printStackTrace();
		} catch (IOException e) {
			conectado = false;
			e.printStackTrace();
		}
		System.out.println("bienvenido");
		while(conectado){
				try {
					DataOutputStream dout = new DataOutputStream(s.getOutputStream());
					String mensaje = JOptionPane.showInputDialog("Dile algo al server");
					if(!mensaje.equals("fin")){
						dout.writeUTF(mensaje+"\n");
					}else{
						System.exit(0);
					}
				} catch (IOException e) {
					conectado = false;
					e.printStackTrace();
				}
		}
	}

}
