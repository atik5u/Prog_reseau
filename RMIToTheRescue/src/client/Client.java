package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import serveur.ServeurIntf;

public class Client {
	ServeurIntf Serveur;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf)Naming.lookup("//localhost/RmiServer");
	}
	
	public static void main(String args[]) throws Exception {
        Client chatClient=new Client(); 
        System.out.println(chatClient.Serveur.messageBienvenue());
    }
}
