package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CBCClient extends UnicastRemoteObject implements CBClientIntf{
	private static final long serialVersionUID = 1L;
	public CBCClient()throws RemoteException {
		super();
	}
	public void notifyMe(String Message)throws RemoteException{
		System.out.println(Message);
	}
}
