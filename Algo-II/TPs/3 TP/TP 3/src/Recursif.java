import java.util.Arrays;

public class Recursif {
    private static int n= 10,p = 5;
    private static int[] fiboNumbers= new int[n+1];
    private static int[][] pascalArray = new int[n+1][];
    private static int fibo2(int n){
        if(n == 0){
            return fiboNumbers[0];
        }
        else if(n == 1){
            fiboNumbers[1] = 1;
            return fiboNumbers[1];
        }
        else{
            if(fiboNumbers[n] == 0){
                fiboNumbers[n] = fibo(n-1)+fibo(n-2);
                return fiboNumbers[n];
            }
            else {
                return fiboNumbers[n];
            }
        }
    }
     private static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            if (fiboNumbers[n] == 0)
                fiboNumbers[n] = fibo(n - 1) + fibo(n - 2);
            return fiboNumbers[n];
        }
     }
     private static int pascal(int n, int p){
         if((p*1 == 0) || (n*1 == p*1)){
             return n;
         }
         else{
             if (pascalArray[n][p] == 0){
                 pascalArray[n] = new int[p+1];
                 pascalArray[n][p] = pascal(n-1,p-1) + pascal(n-1,p);
             }
             return pascalArray[n][p];
         }
     }
    public static int comb(int n, int k) {
        if ((k == 0) || (k == n))
            return 1;
        if (k > n)
            return 0;
        return comb(n-1, k-1) + comb(n-1, k);
    }
     private static int[][] pascal2(int n, int p) {
         final int N_MAX = 7;
         int[][] comb = new int[N_MAX + 1][];
         for (int i = 0; i < comb.length; i++) {
             comb[i] = new int[i + 1];
             for (int k = 0; k <= i; k++) {
                 if ((k == i) || (k == 0))
                     comb[i][k] = 1; /* cas de base */
                 else
                     comb[i][k] = comb[i - 1][k - 1] + comb[i - 1][k]; /* cas récursif */
             }
         }
         return comb;
     }
     private static void display(int[][] temp){
         for (int i= 0; i < temp.length; i++) {
             for (int j= 0; j < temp[i].length; j++)
                 System.out.printf("%2d", temp[i][j]);
             System.out.println();
         }

     }
    public static void main(String[] args) {
        System.out.printf("le %d-ieme nombre de la suite de fibonacci est: %d\n",n,fibo(n));
        //System.out.printf("%s\n", Arrays.toString(fiboNumbers));
        System.out.printf("le nombre du triangle de pascal en position (%d,%d) est: %d\n",n,p,pascal(n,p));
        display(pascalArray);
    }
}
