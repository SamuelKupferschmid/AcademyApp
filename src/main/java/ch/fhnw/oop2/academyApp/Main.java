package ch.fhnw.oop2.academyApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Samuel on 06/02/2015.
 */
public class Main extends Application {

    public static void main(String[] arguments)
    {
        Application.launch(Main.class, arguments);
    }

    private Controller controller;


    @Override
    public void start(final Stage stage) throws Exception
    {
        FXMLLoader f = new FXMLLoader();
        final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("main/java/ch/fhnw/oop2/academyApp/main.fxml")));
        controller = f.getController();
        Scene scene = new Scene(fxmlRoot);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception {

        controller.saveModel();
        super.stop();
    }
}
