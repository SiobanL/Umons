public class QuestionTest
{

    public static final Question [] questions = new Question [] {
	new Question("Qui est le compagnon canin de Tintin ?",
		     "Milou"),
	new Question("Comment se prénomme votre prof d'Analyse ?",
		     "Christophe"),
	new Question("Quelle est la province d'origine de R. Magritte ?",
		     1,
		     "Namur", "Hainaut", "Bruxelles", "Flandre orientale",
		     "Limbourg"),
	new Question("Quelle est votre couleur préferée ?"),
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
