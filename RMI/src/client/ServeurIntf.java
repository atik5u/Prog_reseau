package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServeurIntf extends Remote{

	public String messageBienvenue() throws RemoteException;

}
