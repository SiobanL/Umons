import java.util.Scanner;
import java.lang.NumberFormatException;
import javax.swing.JOptionPane;

public class ConsoleReader
{
    private Scanner scan;

    public ConsoleReader()
    {
        this.scan = new Scanner(System.in);
    }

    public int readInt(String prompt)
    {
        int res = 0;
        System.out.print(prompt);
        while (scan.hasNext())
        {
            String t = scan.next();
            try
            {
                res = Integer.parseInt(t);
                return res;
            }
            catch (NumberFormatException e)
            {
                System.out.print(prompt);
            }
        }
        return res;
    }

    public int readIntOption(String prompt)
    {
        String res = "";
        int val = 0;
        while (res != null)
        {
            res = (String)JOptionPane.showInputDialog(prompt);
            try
            {
                val = Integer.parseInt(res);
                return val;
            }
            catch (NumberFormatException e)
            {
            }
        }
        return 0;
    }

}
