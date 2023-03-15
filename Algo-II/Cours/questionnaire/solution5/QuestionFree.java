public class QuestionFree extends AbstractQuestion
{

    public QuestionFree(String text) {
	super(text);
    }

    @Override
    public boolean checkAnswer(String response)
    {
	return true;
    }

    @Override
    protected boolean isResponseValid(String response) {
	return true;
    }
    
}
