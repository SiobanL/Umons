public class QuestionTest
{

    public static AbstractQuestion [] questions= {
	new Question("Qui a peint \"L'empire des lumières\" ?",
		     "René Magritte"),
	new QuestionChoix("Dans quelle province est né René Magritte ?",
			  1, "Flandre orientale", "Hainaut", "Luxembourg",
			  "Liège", "Namur"),
	new Question("Quel mot-clé est utilisé pour créer une variable "
		     + "de classe en Java ?", "static"),
	new Question("Quel mot-clé est utilisé pour rendre une variable "
		     + "constante en Java ?", "final"),
	new QuestionFree("Quelle est votre couleur préferée ?"),
    };

    public static boolean askQuestion(AbstractQuestion q) {
	q.display();
	String response= q.ask();
	if (q.checkAnswer(response)) {
	    System.out.println("Correct");
	    return true;
	} else {
	    System.out.println("Incorrect");
	    return false;
	}
    }
    
    public static void main(String [] args) {
	int total= 0;
	for (int i= 0; i < questions.length; i++) {
	    if (askQuestion(questions[i]))
		total++;
	    System.out.println();
	}
	System.out.println("*** Resultat : " +
			   total + "/" + questions.length +
			   " ***\n");
    }
    
}
