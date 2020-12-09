package dinamore.Common.Observer;

import Model.CustomOrder;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Observer extends Remote {

    public void update(ArrayList ord) throws RemoteException;
    
    public void removeOrderFromtbl(int i) throws RemoteException;
}
