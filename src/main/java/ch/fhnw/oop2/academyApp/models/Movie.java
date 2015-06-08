package ch.fhnw.oop2.academyApp.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;

/**
 * Created by Samuel Kupferschmid on 05/12/2015.
 */
public class Movie implements Serializable {

    private StringProperty title;

    public void setTitle(String value) { titleProperty().set(value); }
    public String getTitle() { return titleProperty().get(); }
    public StringProperty titleProperty() {
        if (title == null) title = new SimpleStringProperty(this, "title");
        return title;
    }

    public int getYearOfAward() {
        return yearOfAward;
    }

    public void setYearOfAward(int yearOfAward) {
        this.yearOfAward = yearOfAward;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMainActor() {
        return mainActor;
    }

    public void setMainActor(String mainActor) {
        this.mainActor = mainActor;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public EnumSet<Genre> getGenre() {
        return genre;
    }

    public void setGenre(EnumSet<Genre> genre) {
        this.genre = genre;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public int getOscarCnt() {
        return oscarCnt;
    }

    public void setOscarCnt(int oscarCnt) {
        this.oscarCnt = oscarCnt;
    }

    private int yearOfAward;
    private String director;
    private String mainActor;
    private String titleEnglish;
    private EnumSet<Genre> genre;
    private int yearOfProduction;
    private String country;
    private int duration;
    private int fsk;
    private Date release;
    private int oscarCnt;
}
