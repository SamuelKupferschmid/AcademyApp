package ch.fhnw.oop2.academyApp.models;

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
        InputStream stream = ModelTest.class.getResourceAsStream("movie.csv");
    }

    public void tearDown() throws Exception {

    }

    File csv;
    File data;


    public void testSave() throws Exception {

    }

    public void testLoad() throws Exception {

    }

    public void testGetMovieList() throws Exception {

    }

    public void testLoadFromCsv() throws Exception {
        Model m = new Model();
        m.loadFromCsv(csv);    }
}