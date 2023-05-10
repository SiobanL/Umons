public class NumericalIntegrationMethodTrapezoid
implements NumericalIntegrationMethod
{

    /* Calcule la surface du trapèze de hauteurs f(a) et f(b)
       et de base w. La surface d'un tel trapèze vaut w/2*(f(a)+f(b))
       Ici, b=a+w.
    */
    public double compute(double a, double width, Function f) {
	return width * (f.eval(a) + f.eval(a+width))/2;
    }

}
