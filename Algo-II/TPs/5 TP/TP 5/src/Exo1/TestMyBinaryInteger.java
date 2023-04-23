package Exo1;

import java.util.Arrays;
import java.util.Scanner;
public class TestMyBinaryInteger {
    private static int question(){
        Scanner userInput = new Scanner(System.in);
        System.out.printf("Enter a int: ");
        return userInput.nextInt();
    }
    private static MyBinaryInteger[] questionValue(int length){
        Scanner userInput = new Scanner(System.in);
        MyBinaryInteger[] values = new MyBinaryInteger[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Value %d: ",i+1);
            values[i] = new MyBinaryInteger(userInput.nextInt());
        }
        userInput.close();
        return values;
    }
    private static void displayArray(MyBinaryInteger[] val){
        for (MyBinaryInteger temp:val) {
            System.out.printf("%s",temp.toString());
        }
    }
    public static void main(String[] args) {
        MyBinaryInteger[] values = questionValue(question());
        Arrays.sort(values);
        displayArray(values);
    }
}
