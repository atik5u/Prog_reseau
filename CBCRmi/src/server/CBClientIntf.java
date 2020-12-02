package server;

import java.rmi.RemoteException;

public interface CBClientIntf {

	public void notifyMe(String Message)throws RemoteException;
}
