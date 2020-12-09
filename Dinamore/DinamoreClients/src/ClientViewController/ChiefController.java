package ClientViewController;

import AlertBox.Alertbox;
import Connector.ServerConnector;
import Controller.ObserverImple;
import Controller.Super;
import Model.CustomOrder;
import View.MainChefView;
import dinamore.Common.Controller.Observerble;
import dinamore.Common.Observer.Observer;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChiefController implements Initializable, Super {

    @FXML
    private Label chefID;

    private Observer observer;

    Observerble observerble;
    ObservableList<CustomOrder> list = FXCollections.observableArrayList();
    @FXML
    private TableView<CustomOrder> TableView1;
    @FXML
    private TableColumn<CustomOrder, String> OrderID1;
    @FXML
    private TableColumn<CustomOrder, Integer> C_phonenum1;
    @FXML
    private TableColumn<CustomOrder, Integer> Qty1;
    @FXML
    private TableColumn<CustomOrder, String> OrderTime1;
    @FXML
    private TableColumn<CustomOrder, Integer> TeleOparatorNo1;
    @FXML
    private Button takeOrder1;
    @FXML
    private TextField KitchenOrderTicket1;
    @FXML
    private TextField Name1;
    @FXML
    private TextField O_id1;
    @FXML
    private Label NoofOrders;
    @FXML
    private Label qty;
    @FXML
    private Label spendtime;
    @FXML
    private Label localdatetime;
    private Stage stage1;
    @FXML
    private AnchorPane ap;
    @FXML
    private Label Name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderID1.setCellValueFactory(new PropertyValueFactory<>("O_id"));
        C_phonenum1.setCellValueFactory(new PropertyValueFactory<>("teleNum"));
        Qty1.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        OrderTime1.setCellValueFactory(new PropertyValueFactory<>("OrderTime"));
        TeleOparatorNo1.setCellValueFactory(new PropertyValueFactory<>("TOid"));

        try {
            observerble = ServerConnector.getInstance().getObserverble();
            observer = new ObserverImple(this);
            observerble.addObserver(observer);
            int count = observerble.getCountofChef();
            chefID.setText("0" + String.valueOf(count));

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
        }
        stage1 = MainChefView.getStage();
        stage1.setOnCloseRequest((e) -> {
            try {
                observerble.removeObserver(observer);
            } catch (RemoteException ex) {
            }
        });
    }

    CustomOrder selectedItem;
    int selectedIndex = 0;
    String prosseingTime;
    LocalDateTime selectedTime;

    int cheid;
    String chefName;
    int Nooforders;
    int Qtyofchef;
    double totalSpendtime;
    int S = 0;

    @FXML
    private void takeSelectedOrd(ActionEvent event) throws RemoteException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        selectedTime = LocalDateTime.now();
        KitchenOrderTicket1.setText("Customer");
        selectedItem = TableView1.getSelectionModel().getSelectedItem();
        selectedIndex = TableView1.getSelectionModel().getSelectedIndex();
        Name1.setText(selectedItem.getCustomername());
        O_id1.setText(selectedItem.getO_id());
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
        LocalDateTime OrderTime = (selectedItem.getOrderTime());
        double minutes = ChronoUnit.MINUTES.between(selectedTime, OrderTime);
        prosseingTime = String.valueOf(minutes);
        selectedItem.setProcceingTime(prosseingTime);
        observerble.removeFromQueue(selectedIndex);
        observerble.notifyAllObservers(selectedIndex);
    }

    @FXML
    private void finishOrder(ActionEvent event) throws RemoteException {
        Nooforders += 1;
        int qty1 = selectedItem.getQty();
        Qtyofchef += qty1;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String finishedTime = df.format(now);
        double minutes = ChronoUnit.MINUTES.between(now, selectedTime);
        double hours = ChronoUnit.HOURS.between(now, selectedTime);
        String timespend = String.valueOf(minutes);
        totalSpendtime = (totalSpendtime + hours);
        cheid = Integer.parseInt(chefID.getText());
        selectedItem.setChefID(String.valueOf(cheid));
        selectedItem.setTimeSpend(timespend);
        selectedItem.setOr_finishTime(finishedTime);
        observerble.finishOrder(selectedItem);
        String report = "Kitchen Order Ticket: Customer \n Name:" + selectedItem.getCustomername() + "\n"
                + "Contract No:" + selectedItem.getTeleNum() + "\n" + "Processing Time: " + selectedItem.getProcceingTime() + "\n"
                + "Telephone Operator No:" + chefID.getText() + "\n" + "Chef Id: " + selectedItem.getChefID() + "\n"
                + "Quantity:" + selectedItem.getQty() + "\n\n"
                + "Thank You! Come again ";
        Alertbox.showMassage(report, "Finish Order");
    }

    @Override
    public void loadOrdersList(ArrayList ordList) {
        TableView1.getItems().removeAll();
        list.clear();
        for (int i = 0; i < ordList.size(); i++) {
            list.add((CustomOrder) ordList.get(i));
        }
        TableView1.setItems(list);
        System.out.println(list.size());
    }

    @FXML
    private void ReloadSummery(Event event) throws RemoteException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
        LocalDateTime now = LocalDateTime.now();
        String localtime = df.format(now);
        cheid = Integer.parseInt(chefID.getText());
        localdatetime.setText(localtime + "pm");
        switch (cheid) {
            case 1:
                chefName = "Kumara Silva";
                break;
            case 2:
                chefName = "Nimal Silva";
                break;
            case 3:
                chefName = "Herath Peris";
                break;
            case 4:
                chefName = "Banuka Silva";
        }
        Name.setText(chefName);
        NoofOrders.setText(String.valueOf(Nooforders));
        qty.setText(String.valueOf(Qtyofchef));
        spendtime.setText(String.valueOf(totalSpendtime) + "h");
    }

    @Override
    public void removeOrderfrmtbl(int t) {
        list.remove(t);
        TableView1.getItems().removeAll();
        TableView1.setItems(list);
    }

}
