package View;

import ClientViewController.ChiefController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainChefView extends Application {
    
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage=primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Chef.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chef Application");
        Image image = new Image("/assects/Icons/icons8-chef-hat-64.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getStage(){
        return primaryStage;
    }
}
