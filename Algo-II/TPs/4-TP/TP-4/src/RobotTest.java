public class RobotTest {
    public static void testRobot(Robot robot) {
        System.out.printf("Found the exit in %d steps%n",robot.finExit());
    }
    public static void main(String[] args) {
        //testRobot(new RobotRandom(Labyrinth.laby1()));
        //testRobot(new RobotRandom(Labyrinth.laby2()));
        //testRobot(new RobotRandom(Labyrinth.laby3()));
        //testRobot(new RobotRandom(Labyrinth.laby4()));
        //testRobot(new RobotPreferential(Labyrinth.laby1()));
        //testRobot(new RobotPreferential(Labyrinth.laby2()));
        //testRobot(new RobotPreferential(Labyrinth.laby3()));
        //testRobot(new RobotPreferential(Labyrinth.laby3(),new Labyrinth.Direction[]{Labyrinth.Direction.UP, Labyrinth.Direction.LEFT,Labyrinth.Direction.DOWN, Labyrinth.Direction.RIGHT}));
        //testRobot(new RobotPreferential(Labyrinth.laby4(),new Labyrinth.Direction[]{Labyrinth.Direction.UP, Labyrinth.Direction.LEFT,Labyrinth.Direction.DOWN, Labyrinth.Direction.RIGHT}));
        testRobot(new RobotRightHand(Labyrinth.laby1()));
    }
}
