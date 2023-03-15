public class NumericalIntegrationMethodSimpson
implements NumericalIntegrationMethod
{

    /* Calcule l'intégrale d'un polynôme de degré 2 (parabole)
       qui passe par f(a), f(m) et f(b). L'intégrale d'un tel polynôme
       est donnée par (b-a)/6*(f(a)+f(b)+4*f(m)).

       Ici, l'intervalle considéré est [a,b] où b=a+w.
       Le point milieu de l'intervalle [a,b] est donné par m=a+w/2.

       La valeur de cette intégrale peut également être obtenue en
       faisant la moyenne pondérée des surfaces calculées par les
       méthodes des rectangles et des trapèzes. Le poids accordé à la
       méthode des rectangles est double de celui accordé à la méthode
       des trapèzes. C'est cette méthode qui est implémentée ici.
     */
    public double compute(double a, double width, Function f) {
	double r= NumericalIntegration.METHOD_RECTANGLE.compute(a, width, f);
	double t= NumericalIntegration.METHOD_TRAPEZOID.compute(a, width, f);
	return (2*r + t) / 3;
    }

}
