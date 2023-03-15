public class Suite {
    public static void suiteArithmetique(int depart, int raison, int k){
        for(int i =1; i <= k; i++){
            System.out.println(i + ": " + depart+raison*i);
        }
    }
    public static void suiteGeometrique(int depart, int raison, int k) {
        for (int i = 1; i <= k; i++){
            System.out.println(i + ": " + depart * Math.pow(raison,i));
        }
    }
    public static void suiteFibonacci(int k){
        int[] numbers = {0,1,1};
        for(int i = 2;i <= k; i++){
            numbers[2] = numbers[0]+numbers[1];
            numbers[0] = numbers[1];
            numbers[1] = numbers[2];
        }
        System.out.println(k + ": " + numbers[2]);
    }
    public static void main(String[] args) {
        suiteArithmetique(-200,99,20);
        suiteGeometrique(1,2,32);
        suiteFibonacci(20);
    }
}
