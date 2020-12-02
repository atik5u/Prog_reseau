package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	ServeurIntf Serveur;
	int lastMsg;
	private boolean stop;
	private String name;

	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		Serveur = (ServeurIntf) Naming.lookup("//localhost/RmiServer");
		lastMsg = 0;
		stop = false;
	}

	public int getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(int lastMsg) {
		this.lastMsg = lastMsg;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void stop() {
		stop = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]) throws Exception {

		Client chatClient = new Client();

		Scanner sc = new Scanner(System.in);
		System.out.println("set your user name");
		chatClient.setName(sc.nextLine());
		CBClientIntf CB = new CBCClient();
		chatClient.Serveur.addCB(CB);

		String arrStr[] = chatClient.Serveur.messageBienvenue(chatClient.getName()).split(",");
		int id = Integer.parseInt(arrStr[1]);
		if (chatClient.name == null) {
			chatClient.name = "Client " + id;
		}

		System.out.println(arrStr[0]);
		// new ListeningThread(chatClient).start();

		String line = sc.nextLine();

		while (!line.equals("quit")) {
			// System.out.println(chatClient.getName() + " : ");
			chatClient.Serveur.AjoutMessage(chatClient.getName() + " : " + line, 0);
			line = sc.nextLine();
		}
		{
			chatClient.Serveur.messageBye(chatClient.getName());
		}
		chatClient.stop();
		sc.close();
	}

}

