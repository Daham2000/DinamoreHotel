package View;

import Connector.ServerConnector;
import dinamore.Common.Controller.Observerble;
import java.io.IOException;
import java.rmi.NotBoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainPhoneOparator extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, NotBoundException {
        Parent root = FXMLLoader.load(getClass().getResource("TeleOparator.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Telephone Oparator");
        Image image = new Image("/assects/Icons/icons8-telephone-64.png");
        primaryStage.getIcons().add(image);
        Observerble observerble = ServerConnector.getInstance().getObserverble();
        primaryStage.setX(10);
        primaryStage.setY(0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
