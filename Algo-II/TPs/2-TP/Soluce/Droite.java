/**
 * Classe permettant de représenter une droite d'équation a*x+b*y+c=0.
 **/
public class Droite {
    /**
     * Précision utilisée dans les calculs.
     **/
    public static final double EPS = 1e-12;

    private double a;
    private double b;
    private double c;

    /**
     * Construit la droite d'equation a*x+b*y+c=0.
     * @param a Coefficient d'abscisse.
     * @param b Coefficient d'ordonnée.
     * @param c Terme indépendant.
     **/
    public Droite(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Retourne true si la droite est horizontale et false sinon.
     * @return true si horizontale, false sinon.
     **/
    public boolean isHorizontal() {
        return Math.abs(a) < EPS;
    }

    /**
     * Retourne l'intersection de la droite avec celle passée en paramètres ou
     * null si elles sont parallèles.
     * @param droite La droite avec laquelle calculer l'intersection.
     * @return l'intersection des droites ou null si elles sont parallèles.
     **/
    public Point intersection(Droite droite) {
        double det = a * droite.b - droite.a * b;
        //Les droites sont paralleles
        if (Math.abs(det) < EPS) {
            return null;
        }
        //Résolu par la méthode de Cramer. On prend l'opposé des résultats car
        //Cramer utilise l'équation a*x+b*y=c.
        double x = (droite.c * b - c * droite.b) / det;
        double y = (droite.a * c - a * droite.c) / det;
        return new Point(x, y);
    }

    /**
     * Retourne la droite passant par p1 et p2 et null si p1=p2.
     * @param p1 Le premier point.
     * @param p2 Le second point.
     * @return la droite passant par p1 et p2 et null si p1=p2.
     **/
    public static Droite create(Point p1, Point p2) {
        if (Math.abs(p1.getX() - p2.getX()) < EPS && Math.abs(p1.getY() - p2.getY()) < EPS) {
            return null;
        }
        double a = p1.getY() - p2.getY();
        double b = p2.getX() - p1.getX();
        double c = -(a * p1.getX() + b * p1.getY());
        return new Droite(a, b, c);
    }

    @Override
    public String toString() {
        return "" + a + "x+" + b + "y+" + c + "=0";
    }
}
