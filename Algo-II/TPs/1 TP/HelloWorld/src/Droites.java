public class Droites {
    public static void droite(double x1, double y1, double x2 , double y2){
        double a=0;
        if(x1 == x2 && y1 == y2){
            System.out.println("Error");
        }
        else if(x2-x1 == 0){
            a = 1;
        }
        else{
            a = -(y2-y1)/(x2-x1);
        }
        System.out.println("a: " + a + " b: " + x2 + " c: " + a* x1 + x2 * y1);
    }
    public static boolean appartient(double a, double b, double c, double x, double y){
        return a*x + b*y == c;
    }

    public static void main(String[] args) {

    }
}
