package Serv;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
public static void main(String[] args) {
	try {
		ServerSocket ecoute = new ServerSocket(1500);
		System.out.println("Serveur lancé!");
		//int id1=0;
		//int id2=1;
		while(true) {
		Socket client1 = ecoute.accept();
		Socket client2 = ecoute.accept();
		new ThreadChat(client1, client2).start();
		//id1++;
		//id2++;
		}
		} catch(Exception e) {
		// Traitement d�erreur
		}

}
}