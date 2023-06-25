import java.util.Scanner;

public class HelloWorld {
    public static void printHello(String _name, byte _age, double _taille){
        System.out.println("Hello world !\nMon nom est " + _name + ",\nj'ai " + _age + " ans et je mesure " + _taille + " mètre(s) :-)" );
    }
    public static void main(String[] args) {
        System.out.print("Entrez votre prenom: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.print("Entrez votre age: ");
        byte age = sc.nextByte();
        System.out.print("Entrez votre Taille: ");
        double taille = sc.nextDouble();

        sc.close();
        printHello(name ,age ,taille);
    }

}