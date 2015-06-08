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
        final Parent fxmlRoot = (Parent)f.load(new FileInputStream(new File("main/views/main.fxml")));
        controller = f.getController();
        controller.setStage(stage);
        Scene scene = new Scene(fxmlRoot);
        scene.getStylesheets().add("main/resources/application.css");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception {

        controller.saveModel();
        super.stop();
    }
}
