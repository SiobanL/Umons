package tours_hanoi;

import javax.swing.JFrame;

public class Tester {

    /** Nombre de pièces à mettre en jeu
     *  (attention, le nombre de déplacements est de l'ordre de 2^N) */
    public static final int NUM_DISKS = 6;

    /** Délai entre l'affichage de deux mouvements (en millisecondes) */
    public static final int DELAY = 1000;

    /** Si cette constante vaut true, les mouvements des pièces sont affichés */
    public static final boolean SHOW_MOVES = true;

    /** Reference vers fenêtre d'affichage optionnelle */
    private static HanoiFrame f;

    /** Programme principal */
    public static void main(String [] args) {
        HanoiState state = new HanoiState(NUM_DISKS);

        if (SHOW_MOVES) {
            f = new HanoiFrame(state, DELAY);
        }
        solve(state, NUM_DISKS, 0, 2, 1);
    }

    /**
     * Déplace n pièces de la tour d'index tSrc vers la tour d'index tDst.
     *
     * @param state référence vers l'état des tours/pièces
     * @param n     nombre de pièces à déplacer
     * @param tSrc  index tour source
     * @param tDst  index tour destination
     * @param tInt  index tour intermédiaire
     */
    private static void solve(HanoiState state, int n, int tSrc, int tDst, int tInt) {
        if(n == 1){
            state.move(tSrc,tDst);
        }
        else {
            solve(state,n-1,tSrc,tInt,tDst);
            state.move(tSrc,tDst);
            solve(state,n-1,tInt,tDst,tSrc);
        }
    }

    public static void main(String[] args) {
    }
}
