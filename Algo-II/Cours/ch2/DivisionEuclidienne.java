public class DivisionEuclidienne
{

	/* Division euclidienne de a par b */
	public static CoupleInt divide(int a, int b) {
		int q = 0;
		while (a > b) {
			q += 1;
			a -= b;
		}
		return new CoupleInt(q, a);
		/* en java, pas possible directement de retourner un couple (q, r=a) */
	}
	
	public static void main(String[] args) {
		int dividend = 123;
		int divisor = 9;
		CoupleInt q_r = divide(dividend, divisor);
		System.out.println(q_r.x);
		System.out.println(q_r.y);
		System.out.println(q_r.x * divisor + q_r.y);
	}
	
}
