public class ExponentiationRecursive {

	public static double exp(int a, int n) {
		if (n == 0)
			return 1;
		if (n > 0)
			return a * exp(a, n-1);
		return 1 / exp(a, -n);
	}
	
	public static void main(String[] args) {
		int a = 4;
		for (int b = 0; b <= 5; b++)
			System.out.println(exp(a, b));
	}
	
}
