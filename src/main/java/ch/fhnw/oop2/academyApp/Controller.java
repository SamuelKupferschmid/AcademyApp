package ch.fhnw.oop2.academyApp;

import ch.fhnw.oop2.academyApp.models.Model;
import ch.fhnw.oop2.academyApp.models.Movie;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Michael on 5/12/2015.
 */
public class Controller implements Initializable {

    private Model model;

    public Controller() {
        model = new Model("main/java/ch/fhnw/oop2/academyApp/movies.dat");
    }

    @FXML
    TableView<Movie> grid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.load();
        grid.setItems(model.getMovieList());

        TableColumn<Movie,String> titleCol = new TableColumn<Movie,String>("Titel");
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));

        grid.getColumns().setAll(titleCol);

    }

    /**
     * Save the changes of model
     */
    public void saveModel() {
        try {
            model.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
