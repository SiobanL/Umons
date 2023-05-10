public class QuestionFree
    extends Question
{

    public QuestionFree(String text)
    {
	super(text, "");
    }

    @Override
    public boolean checkAnswer(String response)
    {
	return true;
    }
    
}
