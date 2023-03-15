public class Robot
{
    // Représente l'ensemble des déplacements valides. Commun a l'ensemble des
    // instances donc variable associée à la classe (i.e. 'static')
    private static Labyrinth.Direction[] directions = {
        Labyrinth.Direction.UP, Labyrinth.Direction.RIGHT,
        Labyrinth.Direction.DOWN, Labyrinth.Direction.LEFT
    };
    // Référence vers le labyrinthe duquel il faut sortir
    protected Labyrinth lab;
    // Nombre de pas/déplacements effectués par le robot
    protected int steps = 0;

    // Grille "mémoire" pour les cases visitées
    protected Grid visited;
    // Grille "mémoire" pour les murs détectés
    protected Grid walls;
    // Position relative actuelle du robot (i.e. dans ses grilles de mémoire)
    protected Position position;

    /**
     * Constructeur de 'Robot'
     *
     * @param lab   le labyrinthe dont il faut trouver une sortie
     */
    public Robot(Labyrinth lab) {
        this.lab = lab;
        // Dimension de notre "mémoire" : grille ayant
        // deux fois la largeur et la hauteur du labyrinthe
        int memoryCols = lab.getCols() * 2;
        int memoryRows = lab.getRows() * 2;

        // Creation d'une grille "mémoire" pour les cases visitées
        this.visited = new Grid(memoryRows, memoryCols);
        // Creation d'une grille "mémoire" pour les murs détectés
        this.walls = new Grid(memoryRows, memoryCols);
        // On se positionne au centre de cette mémoire
        this.position = new Position(memoryRows/2,memoryCols/2);
    }

    /**
     * Trouve la sortie du labyrinthe
     *
     * @return le nombre de pas effectués pour trouver la sortie, '-1' si aucune
     *         sortie n'a été trouvée.
     */
    public int findExit() {
        return -1;
    }

    /**
     * Remplit (par effet de bord) le tableau passé en paramètre
     * des directions valides/autorisées depuis la position actuelle.
     * 
     * @param tab   tableau (de taille 4) dans lequel les directions seront
                    insérés
     * @return le nombre de directions insérées dans le tableau
     */
    protected int getValidDirections(Labyrinth.Direction[] tab) {
        int n = 0;
        for(Labyrinth.Direction dir : directions) {
            if (!lab.isWall(dir)) {
                tab[n] = dir;
                n++;
            }
        }
        return n;
    }

    /**
     * Retourne vrai si le déplacement depuis la position actuelle vers la
     * direction passée en paramètre représente une position déjà visitée;
     *
     * @param dir   la direction dans laquelle on veut se déplacer.
     * @return vrai si la position résultante a déjà été visitée,
               faux sinon.
     */
    protected boolean isVisited(Labyrinth.Direction dir) {
        Position newPos = computePosition(position, dir);
        return visited.get(newPos);
    }
    
    /**
     * Retourne vrai si le déplacement depuis la position actuelle vers la
     * direction passée en paramètre n'est pas possible à cause d'un mur;
     * Enregistre également l'information dans la grille "mémoire".
     *
     * @param dir   la direction dans laquelle on veut se déplacer.
     * @return vrai s'il y a un mur dans la direction passée en paramètre,
               faux sinon.
     */
    protected boolean isWall(Labyrinth.Direction dir) {
        Position newPos = computePosition(position, dir);
        if (lab.isWall(dir)) {
            walls.set(newPos, true);
            return true;
        }
        else {
            return walls.get(newPos);
        }
    }

    /**
     * Déplace le robot dans la direction passée en paramètre; Retourne vrai 
     * si le déplacement depuis la position actuelle vers la direction passée 
     * en paramètre s'est fait avec succès; Enregistre également la nouvelle 
     * position comme étant visitée dans la grille "mémoire".
     *
     * @param dir   la direction dans laquelle on veut se déplacer.
     * @return vrai si le déplacement s'est fait avec succès,
               faux sinon.
     */
    public boolean go(Labyrinth.Direction dir) {
        if(!isWall(dir)) {
            this.position = computePosition(position, dir);
            visited.set(this.position, true);
            lab.go(dir);
            this.steps++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Calcule la position résultante d'un déplacement depuis la position
     * passée en paramètre vers la direction passée en paramètre.
     *
     * @param pos    la position de départ.
     * @param dir    la direction dans laquelle on veut se déplacer.
     * @return la nouvelle position représentant le déplacement dans la
               direction passée en paramètre.
     */
    protected Position computePosition(Position pos, Labyrinth.Direction dir) {
        int x = pos.col;
        int y = pos.row;
        // En fonction de la valeur de 'dir', on modifie la nouvelle position
        switch(dir){
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
        }
        return new Position(y,x);
    }
}
