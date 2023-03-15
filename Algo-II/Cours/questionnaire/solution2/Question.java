import java.util.Scanner;

public class Question {

    public String text;
    public String answer;

    public Question(String text, String answer) {
	this.text= text;
	this.answer= answer;
    }

    public void display() {
	System.out.println(text);
    }

    public String ask() {
	Scanner scan= new Scanner(System.in);
	return scan.nextLine();
    }

    public boolean check(String response) {
	return answer.equals(response);
    }
    
}
