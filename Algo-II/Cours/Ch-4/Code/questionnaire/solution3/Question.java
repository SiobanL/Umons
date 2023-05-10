import java.util.Scanner;

public class Question {

    public final String text;
    public final String answer;
    public final String [] choices;

    public final int type;

    public static final int TYPE_SIMPLE= 0;
    public static final int TYPE_CHOICES= 1;
    public static final int TYPE_FREE= 2;

    public Question(String text, String answer) {
	this.type= TYPE_SIMPLE;
	this.text= text;
	this.answer= answer;
	this.choices= null;
    }

    public Question(String text, int answerIndex, String...choices) {
	this.type= TYPE_CHOICES;
	this.text= text;
	this.answer= choices[answerIndex];
	this.choices= choices;
    }

    public Question(String text) {
	this.type= TYPE_FREE;
	this.text= text;
	this.answer= null;
	this.choices= null;
    }

    public void display() {
	System.out.println(text);
	if (type == TYPE_CHOICES) {
	    for (int i= 0; i < choices.length; i++)
		System.out.println("(" + i + ") " + choices[i]);
	}
    }

    public String ask() {
	String response= null;
	Scanner scan= new Scanner(System.in);
	if ((type == TYPE_SIMPLE) ||
	    (type == TYPE_FREE))
	    response= scan.nextLine();
	else if (type == TYPE_CHOICES) {
	    while (true) {
		if (!scan.hasNextInt()) {
		    System.out.println("La réponse doit être un entier");
		    scan.next();
		    continue;
		}
		int responseIndex= scan.nextInt();
		if ((responseIndex < 0) ||
		    (responseIndex >= choices.length)) {
		    System.out.println("La réponse doit être comprise entre 0 "
				       + "et " + (choices.length-1));
		    continue;
		}
		response= choices[responseIndex];
		break;
	    }
	}
	return response;
    }

    public boolean check(String response) {
	if ((type == TYPE_SIMPLE) ||
	    (type == TYPE_CHOICES))
	    return answer.equals(response);
	else
	    return true;
    }
    
}
