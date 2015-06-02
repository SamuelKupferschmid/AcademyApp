package ch.fhnw.oop2.academyApp;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.List;

/**
 * Created by Samuel Kupferschmid on 5/12/2015.
 */
public class AAModel {

    private String filename;
    private ObservableList<Movie> movies;

    public AAModel(String filename) {
        this.filename = filename;
    }


    public void save() throws IOException {
        FileOutputStream file = new FileOutputStream(filename);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(movies);
    }

    public void load() throws IOException, ClassNotFoundException {

        File file = new File(filename);

        InputStream fileInput = new FileInputStream(file);
        InputStream buffer = new BufferedInputStream(fileInput);
        ObjectInputStream input = new ObjectInputStream(buffer);
        try {
            movies = (ObservableList<Movie>) input.readObject();
        } finally {
            input.close();
        }
    }

    public ObservableList<Movie> getMovies(){
        return movies;
    }

}
