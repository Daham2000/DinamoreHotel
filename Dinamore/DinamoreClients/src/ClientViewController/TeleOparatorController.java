package ClientViewController;

import Connector.ServerConnector;
import Model.CustomOrder;
import dinamore.Common.Controller.Observerble;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TeleOparatorController implements Initializable {

    @FXML
    private Label TeleOprtrID;
    @FXML
    private ComboBox<String> CustName;
    @FXML
    private TextField C_phonenum;
    @FXML
    private TextField Qty;

    private static int c = 0;

    Observerble observerble;
    @FXML
    private TextField O_id;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Label localdatetime;
    @FXML
    private Label TOid;
    @FXML
    private Label ccontact;
    @FXML
    private Label Cname;
    @FXML
    private Label Qtys;

    int teleOparatorID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            observerble = ServerConnector.getInstance().getObserverble();
            int count = observerble.getCount();
            TeleOprtrID.setText("0" + String.valueOf(count));
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
        }
        
    }

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");

    @FXML
    private void SelectedCus(ActionEvent event) {
    }

    @FXML
    private void SentToKitchen(ActionEvent event) throws NotBoundException, MalformedURLException {
        try {
            String C_name = CustName.getValue();
            int P_number = Integer.parseInt(C_phonenum.getText());
            int qty = Integer.parseInt(Qty.getText());
            teleOparatorID = Integer.parseInt(TeleOprtrID.getText());
            String oid = O_id.getText();
            LocalDateTime now = LocalDateTime.now();
            CustomOrder ord = new CustomOrder(oid, P_number, qty, Integer.parseInt(TeleOprtrID.getText()),
                    C_name, (now));
            observerble.notifyAllObservers(ord);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void RefreshNow(ActionEvent event) {
        CustName.setValue("");
        C_phonenum.setText("");
        Qty.setText("");
    }

    int Count = 0;

    @FXML
    private void loadSummery(MouseEvent event) throws RemoteException {
        pane1.setVisible(false);
        pane2.setVisible(true);
        LocalDateTime now = LocalDateTime.now();
        String localtime = df.format(now);
        localdatetime.setText(localtime + "pm");
        TOid.setText(String.valueOf(teleOparatorID));
        CustomOrder fromQueue = observerble.getFromQueue(c);
        c += 1;
        ccontact.setText(String.valueOf(fromQueue.getTeleNum()));
        Cname.setText(fromQueue.getCustomername());
        Qtys.setText(String.valueOf(fromQueue.getQty()));
    }

    @FXML
    private void backtoMain(ActionEvent event) {
        pane1.setVisible(true);
        pane2.setVisible(false);
    }

    @FXML
    private void loadnextSmry(ActionEvent event) throws RemoteException {
        LocalDateTime now = LocalDateTime.now();
        String localtime = df.format(now);
        localdatetime.setText(localtime + "pm");
        CustomOrder fromQueue = observerble.getFromQueue(c);
        c += 1;
        ccontact.setText(String.valueOf(fromQueue.getTeleNum()));
        Cname.setText(fromQueue.getCustomername());
        Qtys.setText(String.valueOf(fromQueue.getQty()));
    }

    @FXML
    private void previousSummery(ActionEvent event) throws RemoteException {
        LocalDateTime now = LocalDateTime.now();
        String localtime = df.format(now);
        localdatetime.setText(localtime + "pm");
        c -= 1;
        CustomOrder fromQueue = observerble.getFromQueue(c);
        ccontact.setText(String.valueOf(fromQueue.getTeleNum()));
        Cname.setText(fromQueue.getCustomername());
        Qtys.setText(String.valueOf(fromQueue.getQty()));
    }

}
