import java.util.ArrayList;
import java.util.Random;
public class RobotRandom extends Robot{
    private Random nbR;
    public RobotRandom(Labyrinth laby){
        super(laby);
        this.nbR = new Random();
    }
    @Override
    public boolean step() {
        ArrayList<Labyrinth.Direction> directions = new ArrayList<>();
        for (var dir: Labyrinth.Direction.values()) {
            if(!laby.isWall(dir)){
                directions.add(dir);
            }
        }
        return laby.go(directions.get(nbR.nextInt(directions.size())));
    }
}
