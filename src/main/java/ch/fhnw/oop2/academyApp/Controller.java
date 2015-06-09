package ch.fhnw.oop2.academyApp;

import ch.fhnw.oop2.academyApp.models.Model;
import ch.fhnw.oop2.academyApp.models.Movie;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Michael on 5/12/2015.
 */
public class Controller implements Initializable {

    private Model model;
    private Stage stage;

    public Controller() {
        model = new Model(new File(getClass().getResource("movies.dat").getFile()));
        model.load();
    }

    @FXML
    private TableView<Movie> grid;

    @FXML
    private TableColumn<Movie, String> titleCol;

    @FXML
    private TableColumn<Movie, Integer> yearOfAwardCol;

    @FXML
    private TableColumn<Movie, String> directorCol;

    @FXML
    private TableColumn<Movie, String> mainActorCol;

    @FXML
    private TableColumn<Movie, String> titleEnglishCol;

    @FXML
    private TableColumn<Movie, Integer> yearOfProductionCol;

    @FXML
    private TableColumn<Movie, String> countryCol;

    @FXML
    private TableColumn<Movie, Integer> durationCol;

    @FXML
    private TableColumn<Movie, Integer> fskCol;

    @FXML
    private TableColumn<Movie, Integer> oscarCntCol;

    @FXML
    private TextField title;

    @FXML
    private TextField director;

    @FXML
    private TextField mainactor;

    @FXML
    private TextField duration;

    @FXML
    private TextField fsk;

    @FXML
    private TextField genre;

    @FXML
    private TextField yearOfAward;

    @FXML
    private TextField yearOfProduction;

    @FXML
    private TextField country;

    @FXML
    private Slider oscarCnt;

    @FXML
    private ImageView poster;

    @FXML
    private FlowPane oscarStatuettes;

    @FXML
    private DatePicker releaseDatePicker;

    @FXML
    private ImageView countryFlag;

    @FXML
    private Label titleTall;

    private Image oscarImg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            oscarImg = new Image(new FileInputStream(getClass().getResource("/oscar.png").getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        country.textProperty().addListener(this::onCountryChanged);
        oscarCnt.valueProperty().addListener(this::onOscarCntChanged);

        titleCol.setCellValueFactory(new PropertyValueFactory("title"));

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

        grid.setItems(model.getMovieList());
        grid.getSelectionModel().selectedItemProperty().addListener(this::onSelectionChanged);

        if (model.getMovieList().size() > 0) {
            grid.getSelectionModel().select(model.getMovieList().get(0));
        }

        titleTall.textProperty().bindBidirectional(title.textProperty());

    }

    private void onCountryChanged(ObservableValue<? extends String> observable, String oldValue, String newValue) {

        boolean success = false;
        try {
            URL path = getClass().getResource("/flags_iso/24/" + ("" + newValue).toLowerCase() + ".png");

            if (path != null) {

                File f = new File(path.getFile());

                if (f.exists()) {
                    FileInputStream stream = new FileInputStream(path.getFile());
                    Image flag = new Image(stream);
                    countryFlag.setImage(flag);
                    success = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!success) {
            //use empty Image
            FileInputStream stream = null;
            try {
                stream = new FileInputStream(getClass().getResource("/flags_iso/24/empty.png").getFile());
                countryFlag.setImage(new Image(stream));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void onOscarCntChanged(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

        oscarStatuettes.getChildren().clear();

        for (int i = newValue.intValue(); i > 0; i--) {
            oscarStatuettes.getChildren().add(new ImageView(oscarImg));
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void onSelectionChanged(ObservableValue<? extends Movie> observable, Movie oldValue, Movie newValue) {

        if (oldValue != null) {
            title.textProperty().unbindBidirectional(oldValue.titleProperty());
            director.textProperty().unbindBidirectional(oldValue.directorProperty());
            mainactor.textProperty().unbindBidirectional(oldValue.mainActorProperty());
            fsk.textProperty().unbindBidirectional(oldValue.fskProperty());
            duration.textProperty().unbindBidirectional(oldValue.durationProperty());
            oscarCnt.valueProperty().unbindBidirectional(oldValue.oscarCntProperty());
            genre.textProperty().unbindBidirectional(oldValue.genreProperty());
            country.textProperty().unbindBidirectional(oldValue.countryProperty());
            yearOfAward.textProperty().unbindBidirectional(oldValue.yearOfAwardProperty());
            yearOfProduction.textProperty().unbindBidirectional(oldValue.yearOfProductionProperty());
            oscarCnt.valueProperty().unbindBidirectional(oldValue.oscarCntProperty());
            releaseDatePicker.valueProperty().unbindBidirectional(oldValue.releaseProperty());
        }

        if (newValue != null) {
            title.textProperty().bindBidirectional(newValue.titleProperty());
            director.textProperty().bindBidirectional(newValue.directorProperty());
            mainactor.textProperty().bindBidirectional(newValue.mainActorProperty());
            fsk.textProperty().bindBidirectional(newValue.fskProperty(), new NumberStringConverter());
            duration.textProperty().bindBidirectional(newValue.durationProperty(), new NumberStringConverter());
            oscarCnt.valueProperty().bindBidirectional(newValue.oscarCntProperty());
            genre.textProperty().bindBidirectional(newValue.genreProperty());
            country.textProperty().bindBidirectional(newValue.countryProperty());
            yearOfAward.textProperty().bindBidirectional(newValue.yearOfAwardProperty(), new NumberStringConverter("####"));
            yearOfProduction.textProperty().bindBidirectional(newValue.yearOfProductionProperty(), new NumberStringConverter("####"));
            oscarCnt.valueProperty().bindBidirectional(newValue.oscarCntProperty());
            releaseDatePicker.valueProperty().bindBidirectional(newValue.releaseProperty());
        }
        String path = "/poster/" + newValue.imageFilename().get();
        if (path != null && getClass().getResource(path) != null) {
            File file = new File(getClass().getResource(path).getFile());
            if (file.exists()) {
                try {
                    Image img = new Image(new FileInputStream(file));
                    poster.setImage(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @FXML
    private void importBtnClick(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Import .csv File");
        fc.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(".csv-File", "csv"));
        File file = fc.showOpenDialog(stage);
        model.loadFromCsv(file);
    }

    @FXML
    private void newBtnClick(ActionEvent event) {
        Movie m = new Movie();
        grid.getItems().add(m);
        grid.getSelectionModel().select(m);
    }

    @FXML
    private void saveBtnClick(ActionEvent event) {

        try {
            model.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteBtnClick(ActionEvent event) {
        Movie m = grid.getSelectionModel().getSelectedItem();
        grid.getItems().remove(m);
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
