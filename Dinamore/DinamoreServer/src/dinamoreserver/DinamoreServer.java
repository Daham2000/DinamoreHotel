package dinamoreserver;

import Controller.ObserverbleImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DinamoreServer {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(5500);
        System.out.println("Server starting...");
        registry.rebind("DinomoreServer", new ObserverbleImpl());
    }

}
