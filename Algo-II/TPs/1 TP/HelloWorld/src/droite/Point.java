package droite;
/**
 * Classe représentant un point en deux dimensions.
 **/
public class Point {

    private double x;
    private double y;

    /**
     * Constructeur pour un point de coordonnées (x,y).
     * @param x L'abscisse du point.
     * @param y L'ordonnée du point.
     **/
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retourne l'abscisse du point.
     * @return L'abscisse.
     **/
    public double getX() {
        return x;
    }

    /**
     * Retourne l'ordonnée du point.
     * @return L'ordonnée.
     **/
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
