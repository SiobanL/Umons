public abstract class Robot {
    protected static Labyrinth laby;
    public Robot(Labyrinth laby){
        this.laby = laby;
    }
    public abstract boolean step();
    public int finExit(){
        int nb_steps = 0;
        while(!laby.isExit()){
            nb_steps++;
            System.out.printf("\n%d :--------------\n",nb_steps);
            this.step();
            laby.print();
        }
        return nb_steps-1;
    }
}
