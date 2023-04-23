package Exo1_Biblio;

import java.util.Date;

public class Periodique {
    protected String name;
    protected int number;
    protected Date periodicity;

    public Periodique(String name, int number, Date periodicity){
        this.name = name;
        this.number = number;
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Periodique: "+
                "\nName: " + this.name +
                "\nNumber: " + this.number +
                "\nPeriodicity: " + this.periodicity.toString();
    }
}
