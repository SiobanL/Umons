public class NumericalIntegrationTest
{

    public static final NumericalIntegrationMethod [] methods= {
	NumericalIntegration.METHOD_RECTANGLE,
	NumericalIntegration.METHOD_TRAPEZOID,
	NumericalIntegration.METHOD_SIMPSON,
    };

    public static void main(String [] args) {
	Function f= new FunctionSine();
	double a= 0, b=Math.PI/2;
	int numSteps= 100;

	/* Calcule avec chaque méthode d'intégration
	   (rectangle, trapèze, simpson) */
	for (NumericalIntegrationMethod m : methods) {
	    double result= NumericalIntegration.integrate(a, b, f, numSteps, m);
	    System.out.println(m.getClass().getName() + " = " + result);
	}

	/* On peut comparer au résultat obtenu par calcul
	   int_a^b sin(x) dx = -cos(b) + cos(a)
	   En pratique, pour a=0 et b=pi/2, le résultat devrait être
	   -cos(pi/2)+cos(0) = 1 */
	double result= -Math.cos(b) + Math.cos(a);
	System.out.println(result);
    }

}
