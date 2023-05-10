public abstract class Room
{
    protected int number;
    protected int capacity;
    /* Idéalement, utiliser un enum. */
    protected String boardType;

    public Room(int number, int capacity, String boardType)
    {
        this.number = number;
        this.capacity = capacity;
        this.boardType = boardType;
    }

    public Room()
    {
        this(42, 42, "black");
    }

    protected abstract String getStringType();

    public String name()
    {
        return getStringType() + " " + number;
    }

    @Override
    public String toString()
    {
        return "Room type: " + getStringType() +
             "\nNumber: " + number +
             "\nCapacity: " + capacity +
             "\nBoard Type: " + boardType;
    }
}
