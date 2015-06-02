package ch.fhnw.oop2.academyApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Michael on 5/12/2015.
 */
public class AAController  extends Application {

    private AAModel model;
    private AAView view;

    public AAController(){
        model = new AAModel("movies.dat");

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));
        AnchorPane root = (AnchorPane) loader.load();


        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        AAController controller = new AAController();
        controller.launch("");
    }
}
