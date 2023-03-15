package tours_hanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanoiState {

    /** Nombre de tours */
    public static final int NUM_TOWERS = 3;

    /** Nombre max. de pièces */
    public static final int MAX_DISKS = 20;

    /** Modèle d'une pièce (actuellement seulement sa taille (diamètre) */
    private static class Disk {

        /** Taille de la pièce */
        public final int size;

        /** Constructeur privé (factory) */
        private Disk(int size) {
            this.size = size;
        }

        /** Pièces créées */
        private static final Disk[] DISKS = new Disk[MAX_DISKS];

        /** Crée/retourne une pièce particulière */
        public static Disk getBySize(int size) {
            if (DISKS[size] == null)
                DISKS[size] = new Disk(size);
            return DISKS[size];
        }
    }

    /** Une tour est une pile (empêche d'emblée les accès ailleurs qu'au sommet) */
    private Stack<Disk> towers[];

    private int countMoves = 0;

    /** Construit un jeu des Tours de Hanoï */
    @SuppressWarnings("unchecked")
    private HanoiState() {
        towers = (Stack<Disk>[]) java.lang.reflect.Array.newInstance(Stack.class, NUM_TOWERS);
        for (int i = 0; i < NUM_TOWERS; i++)
            towers[i] = new Stack<Disk>();
    }

    /** Construit un jeu des Tours de Hanoï à n disques
     * @param n Le nombre de disques */
    public HanoiState(int n) {
        this();
        for (int i = 0; i < n; i++)
            add(0, Disk.getBySize(n - 1 - i));
    }

    /** Ajoute une pièce au sommet d'une tour */
    private void add(int tower, Disk p) {
        towers[tower].push(p);
    }

    /** Déplace une pièce du sommet d'une tour au sommet d'une autre tour.
     *  Vérifie que les contraintes du jeu sont respectées.
     *  @param from Indice de la tours de départ
     *  @param to Indice de la tour d'arrivée*/
    public void move(int from, int to) {
        if (towers[from].empty())
            throw new RuntimeException("Pile source vide");

        if (!towers[to].empty() &&
                (towers[to].peek().size < towers[from].peek().size))
            throw new RuntimeException("Déplacement sur une pièce plus grande");

        towers[to].push(towers[from].pop());

        countMoves++;

        notifyListeners();
    }

    /** Retourne le nombre de pièces sur la tour i
     * @param tower L'indice de la tour
     * @return Le nombre de pièces sur la tour*/
    public int getNumDisks(int tower) {
        return towers[tower].size();
    }

    /** Retourne la taille de la pièce en position j de la tour i
     * @param tower L'indice de la tour
     * @param j La position de la pièce
     * @return La taille de la pièce en position j dans la tour*/
    public int getDiskSize(int tower, int j) {
        return towers[tower].get(j).size;
    }

    /** Retourne le nombre total de déplacements
     * @return Le nombre total de déplacements*/
    public int getMovesCount() {
        return countMoves;
    }

    ////////////////////////////////////////////////////////////////

    /** Permet d'être notifié des changements d'états
     * (utilisé p.ex. par la fenêtre d'affichage) */
    public static interface Listener {

        public void stateChanged();

    }

    /** Liste des listeners */
    private List<Listener> listeners = new ArrayList<Listener>();

    /** Notifie l'ensemble des listeners du changement d'état */
    private void notifyListeners() {
        for (Listener l : listeners)
            l.stateChanged();
    }

    /** Enregistre un listener supplémentaire */
    public void addListener(Listener l) {
        listeners.add(l);
    }

}
