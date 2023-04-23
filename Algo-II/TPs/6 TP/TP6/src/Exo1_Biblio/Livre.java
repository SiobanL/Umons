package Exo1_Biblio;

public class Livre {
    protected String author, title, editor;
    public Livre(String title, String author, String editor){
        this.title = title;
        this.author = author;
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Livre: "+
                "\nTitle: " + this.title +
                "\nAuthor: " + this.author +
                "\nEditor: " + this.editor;
    }
}
