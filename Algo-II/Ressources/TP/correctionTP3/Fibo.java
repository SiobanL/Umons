/**
 * Class permettant de calculer le ieme element de la suite de Fibonacci en
 * utilisant la memoisation.
 */
public class Fibo {

    /**
     * Tableau contenant les valeurs deja calculees.
     */
    private int[] fibo_vals;

    /**
     * Constructeur.
     *
     * @param max L'indice maximal qu'on peut atteindre
     */
    public Fibo(int max) {
        fibo_vals = new int[max];
        for (int i = 0; i < max; ++i) {
            fibo_vals[i] = 0;
        }
    }

    /**
     * Calcule le nieme nombre de la suite en utilisant values pour stocker les
     * resultats intermediaires.
     *
     * @param n L'indice du nombre voulu.
     * @param values Un tableau contenant au moins n+1 valeurs pour stocker les
     * resultats temporaires.
     * @return le nieme nombre de la suite.
     */
    public static int fibo_rec(int n, int[] values) {
        if (n >= values.length || n < 0) {
            return -1;
        }
        if (values[n] == 0) {
            if (n == 0) {
                values[n] = 0;
            }
            else if (n <= 2) {
                values[n] = 1;
            } else {
                values[n] = fibo_rec(n - 1, values) + fibo_rec(n - 2, values);
            }
        }
        return values[n];
    }

    /**
     * Calcule le nieme nombre de la suite de Fibonacci au depart d'un nouveau
     * tableau.
     *
     * @param n L'indice du nombre voulu.
     * @return Le nieme nombre de la suite.
     */
    public static int fibo(int n) {
        int[] values = new int[n + 1];
        for (int i = 0; i < values.length; ++i) {
            values[i] = 0;
        }
        return fibo_rec(n, values);
    }

    /**
     * Calcule le nieme nombre de la suite en reutilisant les valeurs calcules
     * lors d'un appel precedent. Par exemple, si on appelle fibo_class(5) et
     * ensuite, fibo_class(6), on aura deja les valeurs de la suite pour les
     * indices allant de 0 a 5.
     *
     * @param n L'indice du nombre voulu.
     * @return Le nieme nombre de la suite.
     */
    public int fibo_class(int n) {
        return fibo_rec(n, fibo_vals);
    }

    public static void main(String args[]) {
        int max = 41;
        int step = 5;
        int start = 5;

        System.out.println("fibo :");
        for (int i = start; i < max; i += step) {
            System.out.println("f("+i+") = "+fibo(i));
        }

        Fibo f = new Fibo(max);
        System.out.println("fibo avec orienté objet :");
        for (int i = start; i < max; i += step) {
            System.out.println("f("+i+") = "+f.fibo_class(i));
        }
    }
}
