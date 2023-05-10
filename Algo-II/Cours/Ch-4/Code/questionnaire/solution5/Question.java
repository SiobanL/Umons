public class Question extends AbstractQuestion
{

    private final String answer;

    public Question(String text, String answer)
    {
	super(text);
	this.answer= answer;
    }

    @Override
    public boolean checkAnswer(String response) {
	return answer.equals(response);
    }

    @Override
    protected boolean isResponseValid(String response) {
	return true;
    }

}
