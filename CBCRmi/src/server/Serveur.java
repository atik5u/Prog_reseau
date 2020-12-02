package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Serveur extends UnicastRemoteObject implements ServeurIntf{

	private static final long serialVersionUID = 1L;
	public Vector<String> messages =  new Vector<String>();
	public Vector<Integer> ids = new Vector<Integer>();
	public Vector<CBClientIntf> CBs = new Vector<CBClientIntf>();
	
	public Serveur() throws RemoteException{
		super(0);
		ids.add(1);
	}
	public synchronized void addCB(CBClientIntf CB) throws RemoteException{
		CBs.add(CB);
		ids.add(ids.size());
	}
	
	@Override
	public String messageBienvenue(String name) throws RemoteException {
		for(int i=0;i<CBs.size();i++ ) {
			CBs.get(i).notifyMe("Hello " +name+ "!");
			}
		return null;
	}
	@Override
	public String messageBye(String name) throws RemoteException {
		for(int i=0;i<CBs.size();i++ ) {
			CBs.get(i).notifyMe(name + " has left !");
			}
		
		return "bye";
	}
	
	@Override
	public ArrayList<String> getMsgs() throws RemoteException {
		
		ArrayList<String> L = new ArrayList<String>();
		for(int i=0;i<messages.size();i++ )
			L.add(messages.elementAt(i));
		return L;
	}
	@Override
	public synchronized void AjoutMessage(String S, int id) throws RemoteException {
		for(int i=0;i<CBs.size();i++ ) {
			CBs.get(i).notifyMe(S);
		}
		
	}
	@Override
	public synchronized ArrayList<String> receiveMessages(int lastMessage) throws RemoteException {
		ArrayList<String> L = new ArrayList<String>();
		for(int i=lastMessage;i<CBs.size();i++ ) {
			CBs.get(i).notifyMe(messages.elementAt(i));
			L.add(messages.elementAt(i));
			
		}
		
		return L;
	}
	
}
