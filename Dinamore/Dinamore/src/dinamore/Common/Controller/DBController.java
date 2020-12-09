package dinamore.Common.Controller;

import Model.CustomOrder;
import Model.Order;
import Model.OrderDetails;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DBController extends Remote {

    public void SaveOrder(Order order,OrderDetails orderde) throws RemoteException ;

}
