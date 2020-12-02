package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServeurIntf extends Remote {

	public String messageBienvenue(String name) throws RemoteException;

	public String messageBye(String name) throws RemoteException;

	public String ShowMessages(int lastMessage) throws RemoteException;

	public ArrayList<String> getMsgs() throws RemoteException;

	public void AjoutMessage(String S, int id) throws RemoteException;

	public ArrayList<String> receiveMessages(int lastMessage) throws RemoteException;

}