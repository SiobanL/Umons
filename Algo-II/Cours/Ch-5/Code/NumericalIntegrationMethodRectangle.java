public class NumericalIntegrationMethodRectangle
implements NumericalIntegrationMethod
{

    /* Calcule la surface du rectangle de hauteur f(m) et de largeur w,
       où m est le point milieu de l'intervalle, i.e. m=a+w/2
    */
    public double compute(double a, double width, Function f) {
	return width * f.eval(a+width/2);
    }

}
