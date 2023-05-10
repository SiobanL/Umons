package Exo1_Biblio;

import java.util.Date;

public abstract class Ouvrage {
    protected String title, author;
    protected int cote;
    protected Date emprun;
    static int nb_ouvrage;

    public Ouvrage(){
        this.title = null;
        this.author = null;
        this.emprun = null;
        cote = setId();
    }
    public Ouvrage(String title, String author){
        this.title = title;
        this.author = author;
        this.emprun = null;
        cote = setId();
    }
    public Ouvrage(String title, String author,Date date){
        this.title = title;
        this.author = author;
        this.emprun = date;
        cote = setId();
    }
    public Date getEmprun() {
        return emprun;
    }
    public int getCote() {
        return cote;
    }
    public static int getNb_ouvrage() {
        return nb_ouvrage;
    }
    public static int setId(){
        return nb_ouvrage++;
    }
    @Override
    public String toString() {
        return  "Ouvrage: " +
                "\nTitle: " + this.title +
                "\nAuthor: " + this.author +
                "\nDate: " + this.emprun.toString() +
                "\nId: " + this.cote;
    }
}
