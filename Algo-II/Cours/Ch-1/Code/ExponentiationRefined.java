public class ExponentiationRefined {

	public static int exp(int a, int n) {
		int p = 1;
		while (n > 0) {
			if (n % 2 == 0) {
				a = a * a;
				n /= 2;
			} else {
				p *= a;
				n -= 1;
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		int a = 4;
		for (int b = 0; b <= 5; b++)
			System.out.println(exp(a, b));
	}
	
}
