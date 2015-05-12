package ch.fhnw.oop2.academyApp;

import java.util.Date;

/**
 * Created by Samuel Kupferschmid on 05/12/2015.
 */
public class Movie {
    public int getYearOfAward() {
        return yearOfAward;
    }

    public void setYearOfAward(int yearOfAward) {
        this.yearOfAward = yearOfAward;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYearOfProduction() {
        return YearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        YearOfProduction = yearOfProduction;
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
    private String title;
    private String director;
    private String mainActor;
    private String titleEnglish;
    private Genre genre;
    private int YearOfProduction;
    private String country;
    private int duration;
    private int fsk;
    private Date release;
    private int oscarCnt;
}
