package Exo1_Biblio;

public class CD extends Ouvrage{
    protected String title, author;
    public CD(String title, String author){
        super();
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "CD: "+
                "\nTitle: " + this.title +
                "\nAuthor: " + this.author;
    }
}
