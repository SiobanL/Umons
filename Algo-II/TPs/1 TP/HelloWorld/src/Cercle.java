public class Cercle {
    public static final double PI = 3.14159265;
    public static double perimetre(double rayon){
        return 2*PI*rayon;
    }
    public static double aire(double rayon){
        return 2*PI*(rayon*rayon);
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 50;i++){
            System.out.println("Périmetre & aire de " + i + ": " + perimetre(i) + " & " + aire(i));
        }
    }
}
