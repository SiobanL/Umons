public class Converter {
    public String decToBin(int n){
        String res = "";
        while (n!=0){
            res += (n % 2);
            n = Math.floorDiv(n,2);
        }
        return res;
    }
}
