public class Point {

    private double x,y;
    public Point(){
        x = 0;
        y = 0;
    }
    public Point (double _x, double _y){
        x = _x;
        y = _y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String toString(){
        return "x: " + getX() + "y: " + getY();
    }
}
