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
    private TableView<Movie> grid;

    @FXML
    private TableColumn<Movie,String> titleCol;

    @FXML
    private TableColumn<Movie,Integer> yearOfAwardCol;

    @FXML
    private TableColumn<Movie,String> directorCol;

    @FXML
    private TableColumn<Movie,String> mainActorCol;

    @FXML
    private TableColumn<Movie,String> titleEnglishCol;

    @FXML
    private TableColumn<Movie,Integer> yearOfProductionCol;

    @FXML
    private TableColumn<Movie,String> countryCol;

    @FXML
    private TableColumn<Movie,Integer> durationCol;

    @FXML
    private TableColumn<Movie,Integer> fskCol;

    @FXML
    private TableColumn<Movie,Integer> oscarCntCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        grid.setEditable(true);
        grid.setItems(model.getMovieList());

        titleCol.setCellValueFactory(new PropertyValueFactory("title"));

        TableColumn<Movie, String> yearOfAwardCol = new TableColumn<Movie, String>("Year (Award)");
        yearOfAwardCol.setCellValueFactory(new PropertyValueFactory("yearOfAward"));
        yearOfAwardCol.setEditable(true);

        directorCol.setCellValueFactory(new PropertyValueFactory("director"));
        mainActorCol.setCellValueFactory(new PropertyValueFactory("mainActor"));
        titleEnglishCol.setCellValueFactory(new PropertyValueFactory("titleEnglish"));
        yearOfProductionCol.setCellValueFactory(new PropertyValueFactory("yearOfProduction"));
        countryCol.setCellValueFactory(new PropertyValueFactory("country"));
        durationCol.setCellValueFactory(new PropertyValueFactory("duration"));
        fskCol.setCellValueFactory(new PropertyValueFactory("fsk"));
        oscarCntCol.setCellValueFactory(new PropertyValueFactory("oscarCnt"));

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
