package ch.fhnw.oop2.academyApp.models;

import javafx.collections.ObservableList;
import junit.framework.TestCase;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by Samuel on 06/02/2015.
 */
public class ModelTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        csv = new File("src/test/resources/movies.csv");


        model = new Model(File.createTempFile("academyApp","data"));
        model.load();
    }

    public void tearDown() throws Exception {

    }

    File csv;
    File data;
    Model model;

    public void testSave() throws Exception {

    }

    public void testLoad() throws Exception {

    }

    public void testGetMovieList() throws Exception {

    }

    public void testLoadFromCsv_LoadsAll() throws Exception {

        if(model.loadFromCsv(csv) < 0){
            fail("CSV not loaded");
        }
        ObservableList<Movie> list = model.getMovieList();

       assertEquals(83, list.stream().count());
    }
}