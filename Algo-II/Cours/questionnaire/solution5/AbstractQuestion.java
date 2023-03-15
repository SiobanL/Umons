import java.util.Scanner;

public abstract class AbstractQuestion
{

    public final String text;

    public AbstractQuestion(String text) {
	this.text= text;
    }

    public abstract boolean checkAnswer(String response);

    public void display() {
	System.out.println(text);
    }

    public String ask() {
	String response;
	Scanner scan= new Scanner(System.in);
	do {
	    response= scan.nextLine();
	} while (!isResponseValid(response));
	return response;
    }

    protected abstract boolean isResponseValid(String response);

}
