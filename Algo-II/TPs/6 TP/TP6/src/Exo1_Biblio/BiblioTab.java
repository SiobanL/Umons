package Exo1_Biblio;

import java.util.ArrayList;
import java.util.Arrays;

public class BiblioTab extends Bibliotheque{
    private Ouvrage[] bookshelve;
    private int i = 0;

    public BiblioTab(){
        this(10);
    }
    public BiblioTab(int i){
        this.bookshelve = new Ouvrage[i];
        this.i = i;
    }

    @Override
    public void addOuvrage(Ouvrage ouvrage) {
        if (i < bookshelve.length){
            bookshelve[i] = ouvrage;
            i++;
        }
        else {System.out.printf("La bibliotheque est pleine");}
    }
    @Override
    public void removeOuvrage(int id) {
        int pos = 0;
        while(pos < i && bookshelve[pos].getCote() != cote){
            pos++;
        }
        while(pos < i -1){
            bookshelve[pos] = bookshelve[pos+1];
            pos++;
        }
        i--;
    }
    @Override
    public String toString() {
        return "Nombre d'ouvrage: "+ i +" :" + Arrays.toString(bookshelve);
    }
}
