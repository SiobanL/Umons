public class RobotRightHand extends Robot{

    private Grid visited;
    private Labyrinth.Direction[][] orientation;
    public RobotRightHand(Labyrinth laby) {
        super(laby);
        this.visited = new Grid(laby.getRows(), laby.getCols());
        this.orientation = new Labyrinth.Direction(laby.getRows(), laby.getCols());
    }

    @Override
    public boolean step() {
        for (var x :orientation) {
            System.out.println(orientation);
        }
        return false;
    }
}
