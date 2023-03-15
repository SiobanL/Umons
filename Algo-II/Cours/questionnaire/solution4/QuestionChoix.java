import java.util.Scanner;

public class QuestionChoix
    extends Question
{

    private final String [] choices;
    
    public QuestionChoix(String text, int responseIndex,
			 String ... choices)
    {
	super(text, choices[responseIndex]);
	this.choices= choices;
    }

    @Override
    public void display()
    {
	System.out.println(text);
	for (int i= 0; i < choices.length; i++)
	    System.out.println("  (" + i + ") " + choices[i]);
    }

    @Override
    public String ask()
    {
	Scanner scan= new Scanner(System.in);

	while (true) {
	    if (! scan.hasNextInt()) {
		System.out.println("Erreur : la réponse est un nombre dans l'intervalle [0.." + (choices.length-1) + "]");
		scan.next();
		continue;
	    }
	    int responseIndex= scan.nextInt();
	    if ((responseIndex < 0) || (responseIndex >= choices.length)) {
				System.out.println("Erreur : la réponse est un nombre dans l'intervalle [0.." + (choices.length-1) + "]");
		continue;
	    }
	    return choices[responseIndex];
	}
    }
    
}
