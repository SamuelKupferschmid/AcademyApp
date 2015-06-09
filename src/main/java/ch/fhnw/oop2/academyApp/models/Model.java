package ch.fhnw.oop2.academyApp.models;

import com.sun.istack.internal.NotNull;
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

    public Model(File file) {
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
            if (!file.exists()) {
                return false;
            }
            ObjectInputStream input = null;
            try {
                InputStream fileInput = new FileInputStream(file);
                InputStream buffer = new BufferedInputStream(fileInput);
                input = new ObjectInputStream(buffer);
                movieList = (List<Movie>) input.readObject();

            } catch (Exception e) {
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

            return true;

        } finally {
            if (movieList == null) {
                movieList = new ArrayList<Movie>();
            }
            movies = FXCollections.observableList(movieList);
        }
    }

    public ObservableList<Movie> getMovieList() {
        if(movies == null){
            load();
        }
        return movies;
    }

    public long loadFromCsv(@NotNull File file) {
        if(!file.exists()){
            return -1;
        }
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();//flush the captions
            String line;
            while ((line = br.readLine()) != null) {
                String[] splits = line.split(";");
                if(splits.length != 13){
                    return -1;
                }
                Movie m = new Movie();
                m.titleProperty().set(splits[1]);
                m.yearOfAwardProperty().set(Integer.valueOf(splits[2]));
                m.directorProperty().set(splits[3]);
                m.mainActorProperty().set(splits[4]);
                m.titleEnglishProperty().set(splits[5]);
                m.yearOfProductionProperty().set(Integer.valueOf(splits[6]));
                m.countryProperty().set(splits[7]);
                m.durationProperty().set(Integer.valueOf(splits[8]));
                m.fskProperty().set(Integer.valueOf(splits[9]));
                //genre
                //release
                m.oscarCntProperty().set(Integer.valueOf(splits[12]));

                movies.add(m);
            }

            getMovieList().addAll(movies);

            return movies.stream().count();

        } catch (FileNotFoundException e) {
            return -1;
        } catch (IOException e) {
            return -1;
        }
    }

}
