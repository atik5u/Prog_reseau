package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Serveur extends UnicastRemoteObject implements ServeurIntf {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> Msgs = new ArrayList<String>();
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Serveur() throws RemoteException {
		super(0);
		id = 0;
	}

	@Override
	public String messageBienvenue(String name) throws RemoteException {
		id++;
		Msgs.add("Server: " + name + " is here !");
		return "Bienvenue " + name + "!," + id;
	}

	public String messageBye(String name) throws RemoteException {
		Msgs.add("Server: " + name + " left :( !");
		id--;
		return "Bye " + name + "!";
	}

	public static void main(String args[]) throws Exception {
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
		}
		Serveur chatServeur = new Serveur();

		Naming.rebind("//localhost/RmiServer", chatServeur);

		System.out.println("Serveur pret!");

	}

	@Override
	public String toString() {
		String res = "";
		for (String string : Msgs) {
			res = res + string + "\r\n";
		}
		return "Serveur [Msgs= " + res + "]";
		// return "Serveur [Msgs=" + Msgs + "]";
	}

	public ArrayList<String> getMsgs() throws RemoteException {
		return Msgs;
	}

	public void setMsgs(ArrayList<String> msgs) {
		Msgs = msgs;
	}

	@Override
	public String ShowMessages(int lastMessage) throws RemoteException {
		// TODO Auto-generated method stub
		List<String> rList = Msgs.subList(lastMessage, Msgs.size());
		ArrayList<String> res = new ArrayList<String>();
		for (String string : rList) {
			res.add(string);
		}
		return res.toString();
	}

	public synchronized ArrayList<String> receiveMessages(int lastMessage) throws RemoteException {
		// TODO Auto-generated method stub
		List<String> rList = Msgs.subList(lastMessage, Msgs.size());
		ArrayList<String> res = new ArrayList<String>();
		for (String string : rList) {
			res.add(string);
		}
		return res;
	}

	@Override
	public synchronized void AjoutMessage(String S, int id) throws RemoteException {
		// TODO Auto-generated method stub
		Msgs.add(S);

	}

	public void ViderMessages() throws RemoteException {
		Msgs.clear();
	}

}