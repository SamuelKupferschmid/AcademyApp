package ch.fhnw.oop2.academyApp.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;
import java.util.Date;
import java.util.EnumSet;

/**
 * Created by Samuel Kupferschmid on 05/12/2015.
 */
public class Movie implements Externalizable {

    private StringProperty title = new SimpleStringProperty(this, "title");
    private IntegerProperty yearOfAward = new SimpleIntegerProperty(this, "yearOfAward");
    private StringProperty director = new SimpleStringProperty(this, "director");
    private StringProperty mainActor = new SimpleStringProperty(this, "mainActor");
    private StringProperty titleEnglish = new SimpleStringProperty(this, "titleEnglish");
    private EnumSet<Genre> genre;
    private IntegerProperty yearOfProduction = new SimpleIntegerProperty(this, "yearOfProduction");
    private StringProperty country = new SimpleStringProperty(this, "country");
    private IntegerProperty duration = new SimpleIntegerProperty(this, "duration");
    private IntegerProperty fsk = new SimpleIntegerProperty(this, "fsk");
    private Date release;
    private IntegerProperty oscarCnt = new SimpleIntegerProperty(this, "oscarCnt");
    private StringProperty imageFilename = new SimpleStringProperty(this,"imageFilename");

    public StringProperty titleProperty() {
        return title;
    }

    public IntegerProperty yearOfAwardProperty() {
        return yearOfAward;
    }

    public StringProperty directorProperty() {
        return director;
    }

    public StringProperty mainActorProperty() {
        return mainActor;
    }

    public StringProperty titleEnglishProperty() {
        return titleEnglish;
    }

    public IntegerProperty yearOfProductionProperty() {
        return yearOfProduction;
    }

    public StringProperty countryProperty() {
        return country;
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public IntegerProperty fskProperty() {
        return fsk;
    }

    public IntegerProperty oscarCntProperty() {
        return oscarCnt;
    }

    public StringProperty imageFilename() {
        return imageFilename;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(title.get());
        out.writeInt(yearOfAward.get());
        out.writeUTF(director.get());
        out.writeUTF(mainActor.get());
        out.writeUTF(titleEnglish.get());

        out.writeInt(yearOfProduction.get());
        out.writeUTF(country.get());
        out.writeInt(duration.get());
        out.writeInt(fsk.get());

        out.writeInt(oscarCnt.get());
        out.writeUTF(imageFilename.get());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title.set(in.readUTF());
        yearOfAward.setValue(in.readInt());
        director.set(in.readUTF());
        mainActor.set(in.readUTF());
        titleEnglish.set(in.readUTF());

        yearOfProduction.set(in.readInt());
        country.set(in.readUTF());
        duration.set(in.readInt());
        fsk.set(in.readInt());

        oscarCnt.set(in.readInt());
        imageFilename.set(in.readUTF());
    }
}
