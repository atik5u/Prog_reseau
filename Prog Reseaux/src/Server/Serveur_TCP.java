package Server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Serveur_TCP {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ecoute = new ServerSocket(1234);
			System.out.println("serveur");
			while(true) {
				Socket client = ecoute.accept();
				//OutputStream os = client.getOutputStream();
				PrintWriter out=new PrintWriter(client.getOutputStream(),true);
				BufferedReader in= new BufferedReader(new InputStreamReader(client.getInputStream()));
				//InputStream is = client.getInputStream();
				out.println("bonjour");
				System.out.println(in.readLine());
				client.close();
			
			}
		}catch(Exception e) {
			
		}
	}
	
}
