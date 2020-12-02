package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import serveur.ServeurIntf;

public class ListeningThread extends Thread{
	String in;
	//BufferedReader in2;
	//ServeurIntf s;
	
	public ListeningThread(ServeurIntf s) throws IOException {
		in = s.ShowMessages();
	}
	
	public void run(){
		while (true) {
			System.out.println(in);
		}
	}
}
