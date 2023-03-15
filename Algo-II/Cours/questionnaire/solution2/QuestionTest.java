public class QuestionTest
{

    public static final Question [] questions = {
	new Question("Qui est le compagnon canin de Tintin ?", "Milou"),
	new Question("Comment se prénomme votre prof d'Analyse ?", "Christophe")
    };
    
    public static void main(String [] args) {
	for (int i= 0; i < questions.length; i++) {
	    questions[i].display();
	    String response= questions[i].ask();
	    if (questions[i].check(response))
		System.out.println("Réponse correcte");
	    else
		System.out.println("Réponse incorrecte");
	}
    }
    
}
