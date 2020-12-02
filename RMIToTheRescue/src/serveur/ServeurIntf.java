package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServeurIntf extends Remote{

	public String messageBienvenue() throws RemoteException;
	public String ShowMessages() throws RemoteException;
	public ArrayList<String> getMsgs() throws RemoteException;
	public void AjoutMessage(String S) throws RemoteException;
	public void ViderMessages() throws RemoteException;
}