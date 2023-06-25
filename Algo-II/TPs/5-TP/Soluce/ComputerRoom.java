public class ComputerRoom extends Room
{
    protected int numWorkstations;
    protected String workstationType;

    public ComputerRoom(int number, int capacity, String boardType,
            int numWorkstations, String workstationType)
    {
        super(number, capacity, boardType);
        this.numWorkstations = numWorkstations;
        this.workstationType = workstationType;
    }

    public ComputerRoom()
    {
        super();
        this.numWorkstations = 21;
        this.workstationType = "linux pc";
    }

    @Override
    protected String getStringType()
    {
        return "Computer Room";
    }

    @Override
    public String toString()
    {
        return super.toString() +
            "\nNumber of workstations: " + numWorkstations +
            "\nWorkstation Type: " + workstationType;
    }
}
