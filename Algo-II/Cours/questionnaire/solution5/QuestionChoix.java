import java.util.Scanner;

public class QuestionChoix extends AbstractQuestion
{

    private final String [] choices;
    private final int responseIndex;
    
    public QuestionChoix(String text, int responseIndex,
			 String ... choices)
    {
	super(text);
	this.responseIndex= responseIndex;
	this.choices= choices;
    }

    @Override
    public void display() {
	super.display();
	for (int i= 0; i < choices.length; i++)
	    System.out.println("  (" + i + ") " + choices[i]);
    }

    @Override
    public boolean checkAnswer(String response) {
	return new Integer(response).toString().equals(response);
    }

    @Override
    protected boolean isResponseValid(String response) {
	try {
	    Integer i= Integer.parseInt(response);
	    if ((i < 0) || (i >= choices.length)) {
		System.out.println("Erreur : la réponse est un nombre dans l'intervalle [0.." + (choices.length-1) + "]");
		return false;
	    }
	} catch (NumberFormatException e) {
	    System.out.println("Erreur : la réponse est un nombre dans l'intervalle [0.." + (choices.length-1) + "]");
	    return false;
	}
	return true;
    }
    
}
