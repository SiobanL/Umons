public class Droite {
    public double a = 1,b = 1,c = 1;
    public Droite(double _a, double _b, double _c){
        a = _a;
        b = _b;
        c = _c;
    }
    public String toString(){
        return a + "x + " + b + "y =" + c;
    }
    public boolean isHorizontal(){
        return b != 0 && a/b != 0;
    }
    public Point intersection(Droite tempDroite){
        double tempX, tempY;
        if(a == tempDroite.a && b == tempDroite.b && c == tempDroite.c) {
            return null;
        }
        a = a / b;
        tempDroite.a = tempDroite.a / tempDroite.b;
        c = c / b;
        tempDroite.c = tempDroite.c / tempDroite.b;

        if(a- tempDroite.a == 0){
            return null;
        }
        tempX = -(tempDroite.c - c)/(tempDroite.a - a);
        tempY = a * tempX + c;
        return new Point(-tempX,tempY);
    }
    public static Droite create(Point p1, Point p2){
        double a= p1.getY()- p2.getY(), b = p1.getX() - p2.getX(), c = a * p1.getX() + b * p1.getY();
        return new Droite(a,b,c);

    }
}
