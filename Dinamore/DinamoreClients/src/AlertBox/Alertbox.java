package AlertBox;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Alertbox {

    public static void showMassage(String text1, String text2) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(text2);
        alert.setHeaderText(text1);
        alert.showAndWait();
    }
}
