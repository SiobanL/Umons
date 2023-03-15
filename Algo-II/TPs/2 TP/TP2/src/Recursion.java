public class Recursion {
    public static int factorielle(int n){
        if(n == 1){
            return 1;
        }
        else {
            return factorielle(n-1);
        }
    }
    public static int fibo(int n){
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            return fibo(n-1) + fibo(n-2);
        }
    }
    public static int pascal(int n, int p){
        if((p*1 == 0) || (n*1 == p*1)){
            return 1;
        }
        else{
            if (p > n){
                return 0;
            }
            return pascal(n-1,p-1) + pascal(n-1,p);
        }
    }
}
