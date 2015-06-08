package ch.fhnw.oop2.academyApp;

import ch.fhnw.oop2.academyApp.models.Model;
import ch.fhnw.oop2.academyApp.models.Movie;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Michael on 5/12/2015.
*/
public class Controller implements Initializable {

    private Model model;

    public Controller() {
        model = new Model();
    }

    @FXML
    TableView<Movie> grid;

    @FXML
    TextField director;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model.load(new File("main/java/ch/fhnw/oop2/academyApp/movies.dat"));
        grid.setItems(model.getMovieList());

        TableColumn<Movie, String> titleCol = new TableColumn<Movie, String>("Titel");
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        grid.getColumns().setAll(titleCol);
        grid.selectionModelProperty().addListener((observableValue, oldValue, newValue) -> {
        });
    }

    private void onSelectionChanged(ObservableValue<TableView.TableViewSelectionModel<Movie>> observable, TableView.TableViewSelectionModel<Movie> oldValue, TableView.TableViewSelectionModel<Movie> newValue) {

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
