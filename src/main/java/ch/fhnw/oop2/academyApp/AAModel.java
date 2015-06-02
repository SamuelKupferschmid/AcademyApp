package ch.fhnw.oop2.academyApp;

import java.io.*;
import java.util.List;

/**
 * Created by Samuel Kupferschmid on 5/12/2015.
 */
public class AAModel {

    private String filename;
    private List<Movie> movies;

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
        InputStream file = new FileInputStream(filename);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInputStream input = new ObjectInputStream(buffer);
        try {
            movies = (List<Movie>) input.readObject();
        } finally {
            input.close();
        }
    }

}
