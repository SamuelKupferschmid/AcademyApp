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
        model = new Model(new File("main/java/ch/fhnw/oop2/academyApp/movies.dat"));
        model.loadFromCsv(new File("test/resources/movies.csv"));
    }

    @FXML
    TableView<Movie> grid;

    @FXML
    TextField director;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grid.setItems(model.getMovieList());

        TableColumn<Movie, String> titleCol = new TableColumn<Movie, String>("Title (German)");
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));

        TableColumn<Movie, String> yearOfAwardCol = new TableColumn<Movie, String>("Year (Award)");
        yearOfAwardCol.setCellValueFactory(new PropertyValueFactory("yearOfAward"));

        TableColumn<Movie, String> director = new TableColumn<Movie, String>("Director");
        director.setCellValueFactory(new PropertyValueFactory("director"));

        TableColumn<Movie, String> mainActorCol = new TableColumn<Movie, String>("Main Actor");
        mainActorCol.setCellValueFactory(new PropertyValueFactory("mainActor"));

        TableColumn<Movie, String> titleEnglishCol = new TableColumn<Movie, String>("Title (English)");
        titleEnglishCol.setCellValueFactory(new PropertyValueFactory("titleEnglish"));

        TableColumn<Movie, String> yearOfProductionCol = new TableColumn<Movie, String>("Year (Production)");
        yearOfProductionCol.setCellValueFactory(new PropertyValueFactory("yearOfProduction"));

        TableColumn<Movie, String> countryCol = new TableColumn<Movie, String>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory("country"));

        TableColumn<Movie, String> durartionCol = new TableColumn<Movie, String>("Duration");
        durartionCol.setCellValueFactory(new PropertyValueFactory("durartion"));

        TableColumn<Movie, String> fskCol = new TableColumn<Movie, String>("FSK");
        fskCol.setCellValueFactory(new PropertyValueFactory("fsk"));

        TableColumn<Movie, String> oscarCntCol = new TableColumn<Movie, String>("# of Oscars");
        oscarCntCol.setCellValueFactory(new PropertyValueFactory("oscarCnt"));

        grid.getColumns().setAll(titleCol, yearOfAwardCol, director, mainActorCol,titleEnglishCol,yearOfProductionCol,countryCol,durartionCol,fskCol,oscarCntCol);


        grid.selectionModelProperty().addListener(this::onSelectionChanged);
    }

    private void onSelectionChanged(ObservableValue<? extends TableView.TableViewSelectionModel<Movie>> observable, TableView.TableViewSelectionModel<Movie> oldValue, TableView.TableViewSelectionModel<Movie> newValue) {

    }

    /**
     * Save the changes of model
     */
    public void saveModel() {
        try {
            model.save();
            new File("main/java/ch/fhnw/oop2/academyApp/movies.dat").delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
