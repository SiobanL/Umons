import java.security.KeyStore;

public class RobotPreferential extends Robot {
    final Labyrinth.Direction[] tempDir;
    private Grid visited, vWalls;
    private Position position;

    public RobotPreferential(Labyrinth laby) {
        super(laby);
        this.tempDir = new Labyrinth.Direction[]{
                Labyrinth.Direction.UP, Labyrinth.Direction.RIGHT,
                Labyrinth.Direction.DOWN, Labyrinth.Direction.LEFT};
        this.visited = new Grid(laby.getRows() * 2, laby.getCols() * 2);
        this.vWalls = new Grid(laby.getRows() * 2, laby.getCols() * 2);
        this.position = new Position(laby.getRows(), laby.getCols());
    }

    public RobotPreferential(Labyrinth laby, Labyrinth.Direction[] directions) {
        super(laby);
        this.tempDir = directions;
        this.visited = new Grid(laby.getRows() * 2, laby.getCols() * 2);
        this.vWalls = new Grid(laby.getRows() * 2, laby.getCols() * 2);
        this.position = new Position(laby.getRows(), laby.getCols());
    }

    private Position lookup(Position start, Labyrinth.Direction dir) {
        return switch (dir) {
            case UP -> new Position(start.row - 1, start.col);
            case DOWN -> new Position(start.row + 1, start.col);
            case RIGHT -> new Position(start.row, start.col + 1);
            case LEFT -> new Position(start.row, start.col - 1);
            default -> throw new IllegalStateException("Position unknow");
        };
    }

    @Override
    public boolean step() {
        for (var direction : tempDir) {
            var dest = lookup(position, direction);
            if (!laby.isWall(direction) && !visited.get(dest) && !vWalls.get(dest)) {
                visited.set(dest, true);
                position = dest;
                laby.go(direction);
                return true;
            }
        }
        for (var direction : tempDir) {
            var dest = lookup(position, direction);
            if (!laby.isWall(direction) && !vWalls.get(dest)) {
                vWalls.set(dest, true);
                position = dest;
                laby.go(direction);
                return true;
            }
        }
        throw new IllegalStateException("I can't find the exit");
    }
}