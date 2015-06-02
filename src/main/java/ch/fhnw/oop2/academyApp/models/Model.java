package ch.fhnw.oop2.academyApp.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel Kupferschmid on 5/12/2015.
 */
public class Model {

    private File file;
    private ObservableList<Movie> movies;

    public Model(File filen) {
        this.file = file;
    }


    public void save() throws IOException {
        FileOutputStream stream = new FileOutputStream(this.file);
        OutputStream buffer = new BufferedOutputStream(stream);
        ObjectOutput output = new ObjectOutputStream(buffer);

        List<Movie> ml = new ArrayList<>(movies);
        output.writeObject(ml);
        output.close();
    }

    public boolean load() {
        List<Movie> movieList = null;
        try {
            if (file.exists()) {
                ObjectInputStream input = null;
                try {
                    InputStream fileInput = new FileInputStream(file);
                    InputStream buffer = new BufferedInputStream(fileInput);
                    input = new ObjectInputStream(buffer);
                    movieList = (List<Movie>) input.readObject();

                } catch (Exception e) {
                    movieList = new ArrayList<>();
                    return false;
                } finally {
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            return false;
                        }
                    }
                }
            } else {
                movieList = new ArrayList<>();
                return false;
            }

            return true;
        }
        finally {
            movies = FXCollections.observableList(movieList);
        }
    }

    public ObservableList<Movie> getMovieList() {
        return movies;
    }

    public void loadFromCsv(String filename) {
        File file = new File(filename);


    }

}
