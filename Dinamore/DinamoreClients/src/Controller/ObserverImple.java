package Controller;

import Model.CustomOrder;
import dinamore.Common.Observer.Observer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ObserverImple extends UnicastRemoteObject implements Observer {
    
    private Super Observer;
    
    public ObserverImple(Super od) throws RemoteException {
        this.Observer = od;
    }
    
    @Override
    public void update(ArrayList ord) throws RemoteException {
        Observer.loadOrdersList(ord);
    }
    
    @Override
    public void removeOrderFromtbl(int i) throws RemoteException {
        Observer.removeOrderfrmtbl(i);
    }
    
}
