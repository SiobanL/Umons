public class RobotPreferential extends Robot {
    // Ordre dans lequel on préfère parcourir les directions
    protected Labyrinth.Direction[] ordre;

    public RobotPreferential(Labyrinth lab, Labyrinth.Direction[] ordre) {
        super(lab);
        this.ordre = ordre;
    }

    public RobotPreferential(Labyrinth lab) {
        this(lab,
             new Labyrinth.Direction[]{
                 Labyrinth.Direction.UP, Labyrinth.Direction.RIGHT,
                 Labyrinth.Direction.DOWN, Labyrinth.Direction.LEFT
             }
        );
    }

    public int findExit() {
        while (!lab.isExit()) {
            lab.print();
            // Booléen utilisé pour savoir si un déplacement a été utilisé
            boolean moved = false;
            // On essaie d'abord de trouver une case non visitée qui n'est pas
            // un mur dans l'ordre de préférence des directions.
            for(Labyrinth.Direction dir : this.ordre) {
                if (!isWall(dir) && !isVisited(dir)) {
                    // On se déplace dans cette direction
                    go(dir);
                    moved = true;
                    break;
                }
            }
            // Si aucun déplacement n'a été trouvé, on relache les contraintes
            // et on cherche une case qui a déjà été visité (hors mur).
            if (!moved) {
                /* Aucune direction non visitée. */
                for(Labyrinth.Direction dir : this.ordre) {
                    if (!isWall(dir)) {
                        // On se déplace dans cette direction
                        go(dir);
                        // On indique à notre mémoire que cette case est
                        // maintenant considérée comme étant un mur
                        walls.set(this.position, true);
                        moved = true;
                        break;
                    }
                }
                // Si on n'a toujours pas trouvé de déplacement, on est bloqué
                if (!moved){
                    return -1;
                }
            }
        }
        return this.steps;
    }
}
