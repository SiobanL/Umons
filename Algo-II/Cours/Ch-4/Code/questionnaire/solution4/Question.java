import java.util.Scanner;

public class Question
{

    protected final String text;
    protected final String answer;

    public Question(String text, String answer)
    {
	this.text= text;
	this.answer= answer;
    }

    public String getAnswer()
    {
	return answer;
    }

    public boolean checkAnswer(String response)
    {
	return answer.equals(response);
    }

    public void display()
    {
	System.out.println(text);
    }

    public String ask()
    {
	Scanner scan= new Scanner(System.in);
	return scan.nextLine();
    }

}
