public class NumericalIntegration
{

    public static final NumericalIntegrationMethod METHOD_RECTANGLE=
	new NumericalIntegrationMethodRectangle();
    public static final NumericalIntegrationMethod METHOD_TRAPEZOID=
	new NumericalIntegrationMethodTrapezoid();
    public static final NumericalIntegrationMethod METHOD_SIMPSON=
	new NumericalIntegrationMethodSimpson();

    public static double integrate(double a, double b, Function f, int numSteps,
				   NumericalIntegrationMethod m)
    {
	double sum= 0;
	double stepWidth= (b-a)/numSteps;
	for (; numSteps > 0; numSteps--, a+= stepWidth)
	    sum+= m.compute(a, stepWidth, f);
	return sum;
    }

}
