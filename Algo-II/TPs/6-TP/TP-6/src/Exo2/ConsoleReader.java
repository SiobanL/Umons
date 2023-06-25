package Exo2;

import java.util.Scanner;

public class ConsoleReader {
    public static int readInt(String prompt){
        try {
            userInput.nextInt();
        }
        catch (Exception e){
            throw e;
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String prompt = userInput.next();
        readInt(prompt);
    }
}
