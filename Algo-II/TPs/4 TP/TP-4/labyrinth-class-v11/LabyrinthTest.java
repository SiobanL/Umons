public class LabyrinthTest
{
    /**
    * Le résultat affiché est très long.
    * Exécutez ceci :
    *   java LabyrinthTest > output.txt
    * et ce qui aurait du être affiché à l'écran sera écrit dans le fichier
    * output.txt
    */
    public static void main(String[] args)
    {
        Labyrinth lab = Labyrinth.laby1();

        System.out.println("nb lignes : " + lab.getRows() + "    " +
                           "nb colonnes : " + lab.getCols());

        lab.print();
        System.out.println(lab.isWall(Labyrinth.Direction.LEFT));

        lab.go(Labyrinth.Direction.LEFT);
        lab.print();
        System.out.println(lab.isWall(Labyrinth.Direction.LEFT));
    }
}
