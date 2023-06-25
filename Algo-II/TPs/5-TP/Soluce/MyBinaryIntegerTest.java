import java.util.Scanner;
import java.util.Arrays;

public class MyBinaryIntegerTest
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the list size: ");
        int n = scan.nextInt();
        Comparable[] tab = new Comparable[n];
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter an integer: ");
            tab[i] = new MyBinaryInteger(scan.nextInt());
        }
        Arrays.sort(tab);
        for (int i = 0; i < n; i++)
        {
            System.out.println(tab[i]);
        }
    }
}
