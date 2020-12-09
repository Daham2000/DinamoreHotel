package dinamore.Common.Controller;

import Model.CustomOrder;
import dinamore.Common.Observer.Observer;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observerble extends Remote {

    public void addObserver(Observer observer)throws RemoteException;

    public void removeObserver(Observer observer)throws RemoteException;
    
    public void notifyAllObservers(Object ord)throws RemoteException;
    
    public void notifyAllObservers(int n)throws RemoteException;
    
    public void removeFromQueue(int t) throws RemoteException;
    
    public CustomOrder getFromQueue(int n)throws RemoteException;
    
    public int getCount()throws RemoteException;
    
    public int getCountofChef()throws RemoteException;
    
    public void finishOrder(CustomOrder ord) throws RemoteException;
    
}
