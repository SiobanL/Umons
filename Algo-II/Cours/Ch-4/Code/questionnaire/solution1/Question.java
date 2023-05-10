import java.util.Scanner;

public class Question {

    public String text;
    public String answer;

    public Question(String text, String answer) {
	this.text= text;
	this.answer= answer;
    }

    public boolean ask() {
	System.out.println(text);
	Scanner scan= new Scanner(System.in);
	String response= scan.nextLine();
	return answer.equals(response);
    }
    
}
