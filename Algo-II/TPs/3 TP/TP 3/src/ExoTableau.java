import java.util.Arrays;

public class ExoTableau {
    private static int[] powerOfTwoCalculate(){
        int[] temp = new int[20];
        for (int i = 0; i < temp.length; i++){
            temp[i] = (int) Math.pow(2,i);
        }
        return temp;
    }
    private static int[] oddCalculate(){
        int[] temp = new int[20];
        int i = 39, pos = 0;
        while (temp[temp.length-1] == 0){
            if(pos == 20){
                break;
            }
            if(i%2 == 1){
                temp[pos] = i;
                pos++;
            }
            i--;
        }
        return temp;
    }
    private static int[] calculateForFun(){
        int[] temp = new int[20];
        for (int i = 0; i < temp.length-1; i++){
            temp[i] = (int) Math.pow(-1,i) *i;
        }
        return temp;
    }
    private static void display(double[] temp){
        System.out.printf("%s", Arrays.toString(temp));
        System.out.println();
    }
    private static void display(int[] temp){
        System.out.printf("%s", Arrays.toString(temp));
        System.out.println();
    }
    public static int sum(int[] temp){
        int res= 0;
        for (int i = 0; i < temp.length-1; i++){
            res += temp[i];
        }
        return res;
    }
    public static double average(int[] temp){
        return sum(temp)/ temp.length;
    }
    private static int[] zipSum(int[] array1, int[] array2){
        int[] temp = new int[Math.max(array1.length,array2.length)];
        for (int i = 0; i < temp.length; i++){
            if (array1.length > i && array2.length > i){
                temp[i] = array1[i] + array2[i];
            }else if(array1.length > i && array2.length <= i){
                temp[i] = array1[i];
            } else if (array1.length <= i && array2.length > i) {
                temp[i] = array2[i];
            }
        }
        return temp;
    }
    private static double[] zipAverage(int[] array1, int[] array2){
        double[] temp = new double[Math.max(array1.length, array2.length)];
        for (int i = 0; i < temp.length; i++){
            if (array1.length > i && array2.length > i){
                temp[i] = (array1[i] + array2[i])/2;
            }else if(array1.length > i && array2.length <= i){
                temp[i] = array1[i];
            } else if (array1.length <= i && array2.length > i) {
                temp[i] = array2[i];
            }
        }
        return temp;
    }
    private static boolean ordered(int[] temp){
        if (temp.length <= 2){
            return true;
        }
        int order  = 0;
        for (int i = 1; i < temp.length ; i++){
            int diff = temp[i-1] - temp[i];
            if (diff * order < 0){
                return false;
            }
            if (order == 0 && diff != 0){
                order = diff;
            }
        }
        return true;
    }
    private static int max(int[] temp){
        int tempRes = 0;
        for (int i = 0; i < temp.length-1; i++) {
            if (temp[i] < temp[i+1]){
                tempRes = temp[i+1];
            }
        }
        return tempRes;
    }
    public static void main(String[] args) {
        int[] powersOfTwo = powerOfTwoCalculate();
        int[] oddNumbers = oddCalculate();
        int[] calculateForFunArray = calculateForFun();
        display(powersOfTwo);
        display(oddNumbers);
        display(calculateForFunArray);
        System.out.printf("The sum of powersOFTwo is: %d\n", sum(powersOfTwo));
        System.out.printf("The average of powersOFTwo is: %.2f\n", average(powersOfTwo));
        System.out.print("The zipSum of powersOfTwo and oddNumbers is: ");
        display(zipSum(powersOfTwo,oddNumbers));
        System.out.print("The zipAverage of powersOFTwo and oddNumbers is: ");
        display(zipAverage(new int[] {2,2,2,2},new int[] {2}));
        System.out.println(ordered(calculateForFunArray));
        System.out.printf("the max of powersOfTwo is: %d", max(powersOfTwo));
    }
}