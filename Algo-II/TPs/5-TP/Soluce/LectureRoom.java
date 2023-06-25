public class LectureRoom extends Room
{
    protected boolean fixedScreen;
    protected boolean fixedBeamer;

    public LectureRoom(int number, int capacity, String boardType,
            boolean fixedScreen, boolean fixedBeamer)
    {
        super(number, capacity, boardType);
        this.fixedScreen = fixedScreen;
        this.fixedBeamer = fixedBeamer;
    }

    public LectureRoom()
    {
        super();
        this.fixedScreen = true;
        this.fixedBeamer = false;
    }

    @Override
    protected String getStringType()
    {
        return "Lecture Room";
    }

    @Override
    public String toString()
    {
        return super.toString() +
            "\nFixed screen: " + fixedScreen +
            "\nFixed beamer: " + fixedBeamer;
    }
}
