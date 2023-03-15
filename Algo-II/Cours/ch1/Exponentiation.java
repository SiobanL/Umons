public class Exponentiation {

	public static int exp(int a, int n) {
		int p = a;
		while (n > 1) {
			p *= a;
			n -= 1;
		}
		return p;
	}
	
	public static void main(String[] args) {
		int a = 4;
		for (int b = 0; b <= 5; b++)
			System.out.println(exp(a, b));
	}
	
}
