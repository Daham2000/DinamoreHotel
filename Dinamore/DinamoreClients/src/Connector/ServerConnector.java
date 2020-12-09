package Connector;

import dinamore.Common.Controller.Observerble;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServerConnector {

    private static ServerConnector serverconnector;
    private Observerble observerble;

    private ServerConnector() throws NotBoundException, MalformedURLException, RemoteException {
        observerble = (Observerble) Naming.lookup("rmi://localhost:5500/DinomoreServer");

    }

    public static ServerConnector getInstance() throws NotBoundException, MalformedURLException, RemoteException {
        return serverconnector == null ? serverconnector = new ServerConnector() : serverconnector;
    }

    public Observerble getObserverble() {
        return observerble;
    }

}
