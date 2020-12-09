package Controller;

import DBController.DBControllerimpl;
import Model.CustomOrder;
import Model.Order;
import Model.OrderDetails;
import dinamore.Common.Controller.Observerble;
import dinamore.Common.Observer.Observer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ObserverbleImpl extends UnicastRemoteObject implements Observerble {

    private static int count = 0;
    private static int countofchef = 0;

    ArrayList<Observer> observer = new ArrayList<>();
    ArrayList<CustomOrder> queue = new ArrayList<>();
    ArrayList<CustomOrder> queue2 = new ArrayList<>();

    public ObserverbleImpl() throws RemoteException {
    }

    @Override
    public void addObserver(Observer obsrvr) throws RemoteException {
        observer.add(obsrvr);
    }

    @Override
    public void removeObserver(Observer obsrvr) throws RemoteException {
        observer.remove(obsrvr);
    }

    @Override
    public void notifyAllObservers(Object ord) throws RemoteException {
        queue.add((CustomOrder) ord);
        queue2.add((CustomOrder) ord);
        for (Observer observer : observer) {
            try {
                observer.update(queue);
            } catch (RemoteException ex) {
            }
        }
    }

    @Override
    public void removeFromQueue(int t) throws RemoteException {
        queue.remove(t);
    }

    @Override
    public int getCount() throws RemoteException {
        return count += 1;
    }

    @Override
    public int getCountofChef() throws RemoteException {
        return countofchef += 1;
    }

    @Override
    public void finishOrder(CustomOrder ord) throws RemoteException {
        String Oid = ord.getO_id();
        LocalDateTime Otime = ord.getOrderTime();
        int TOid = ord.getTOid();
        String C_name = ord.getCustomername();
        Order ord1 = new Order(Oid, Otime, TOid, C_name);
        String chefid = ord.getChefID();
        String timespend = ord.getTimeSpend();
        String ptime = ord.getProcceingTime();
        String finishtime = ord.getOr_finishTime();
        int qty = ord.getQty();
        OrderDetails ord2 = new OrderDetails(Oid, chefid, timespend, ptime, finishtime, qty);
        DBControllerimpl.getInstance().SaveOrder(ord1, ord2);
    }

    @Override
    public CustomOrder getFromQueue(int n) throws RemoteException {
        return queue2.get(n);
    }

    @Override
    public void notifyAllObservers(int n) throws RemoteException {
        for (Observer observer : observer) {
            try {
                observer.removeOrderFromtbl(n);
            } catch (RemoteException ex) {
            }
        }
    }

}
