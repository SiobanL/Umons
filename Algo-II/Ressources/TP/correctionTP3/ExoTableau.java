class ExoTableau {

    /**
     * Affiche un tableau de nombres entiers sur une ligne.
     * @param tab Le tableau a afficher
     */
    public static void affichage(int[] tab) {
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * Retourne la somme des elements du tableau.
     * @param tab Le tableau a sommer
     * @return la somme des elements du tableau et 0 si le tableau est vide.
     */
    public static int somme(int[] tab) {
        int res = 0;
        for (int i = 0; i < tab.length; ++i) {
            res += tab[i];
        }
        return res;
    }

    /**
     * Retourne la moyenne des elements du tableau.
     * @param tab Le tableau dont on veut la moyenne.
     * @return La moyenne des elements du tableau et -1 si le tableau est vide.
     */
    public static double moyenne(int[] tab) {
        double sum = somme(tab);
        if (tab.length > 0){
            return sum / tab.length;
        }
        return 0;
    }

    /**
     * Retourne un tableau dont le ieme element est la somme des elements en
     * postion i dans les tableaux.
     * Si les tableaux n'ont pas la meme longueur, le resultat aura la longueur
     * du tableau le plus petit.
     *
     * @param tab1 Le premier tableau
     * @param tab2 Le deuxieme tableau
     * @return un tableau contenant la somme des tableaux indice par indice.
     */
    public static int[] zipSomme(int[] tab1, int[] tab2) {
        int[] res = new int[Math.min(tab1.length, tab2.length)];
        for (int i = 0; i < res.length; ++i) {
            res[i] = tab1[i]+tab2[i];
        }
        return res;
    }

    /**
     * Retourne un tableau dont le ieme element est la moyenne des elements en
     * postion i dans les tableaux.
     * Si les tableaux n'ont pas la meme longueur, le resultat aura la longueur
     * du tableau le plus petit.
     *
     * @param tab1 Le premier tableau
     * @param tab2 Le deuxieme tableau
     * @return un tableau contenant la moyenne des tableaux indice par indice.
     */
    public static double[] zipMoyenne(int[] tab1, int[] tab2){
        double[] res = new double[Math.min(tab1.length, tab2.length)];
        for (int i = 0; i < res.length; ++i) {
            res[i] = (tab1[i] + tab2[i]) / 2.;
        }
        return res;
    }

    /**
     * Verifie si un tableau est trie dans l'ordre croissant ou decroissant.
     *
     * @param tab Le tableau a verifier
     * @return true si le tableau est trie, faux sinon.
     */
    public static boolean ordered(int[] tab) {
        if (tab.length <= 2) {
            return true;
        }
        else {
            int i = 0;
            //On cherche un i tel que tab[i] != 0 et tab[i+1] != 0
            // => tel que tab[i]*tab[i+1] != 0
            while (i < tab.length-1 && tab[i] * tab[i+1] == 0) {
                ++i;
            }
            // Si tab[i] < tab[i+1], order < 0. Sinon, order > 0
            int order = tab[i] - tab[i+1];
            // On verifie qu'on a le meme ordre dans le reste de la liste
            for (i = i + 1; i < tab.length-1; ++i) {
                // Si tab[i] - tab[i+1] est de signe different de order, on
                // la liste n'est pas ordonnee. Pour verifier cela, on sait que
                // multiplier deux nombres de signe different donne un nombre
                // negatif.
                if ((tab[i] - tab[i+1]) * order < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Retourne le maximum du tableau.
     *  
     * @param tab Le tableau dont on veut le maximum.
     * @return le max du tableau ou -1 s'il est vide.
     */
    public static int max(int[] tab) {
        if (tab.length == 0) {
            return -1;
        }
        else {
            int candidate = tab[0];
            for (int i = 1; i < tab.length; ++i) {
                if (candidate < tab[i]) {
                    candidate = tab[i];
                }
            }
            return candidate;
        }
    }

    public static void testMethods(int[] tab) {
        affichage(tab);
        System.out.println("Sum : "+somme(tab));
        System.out.println("Average : "+moyenne(tab));
        System.out.println("Ordered : "+ordered(tab));
        System.out.println("Max : "+max(tab));
    }

    public static void testZip(int[] tab1, int[] tab2) {
        int[] res = zipSomme(tab1,tab2);
        System.out.println("zip sum");
        affichage(res);
        double[] resavg = zipMoyenne(tab1,tab2);
        System.out.println("zip avg");
        for (int i = 0; i < resavg.length; ++i) {
            System.out.print(resavg[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int number = 20;

        // Tableau contenant les 20 premiers puissances de 2
        int[] power = new int[number];
        int val = 1;
        for (int i = 0; i < number; ++i) {
            power[i] = val;
            val *= 2;
        }
        System.out.println("First powers of 2");
        testMethods(power);

        // Tableau contenant les 20 premiers nombres premiers
        int[] odd = new int[number];
        for (int i = 0; i < number; ++i) {
            odd[odd.length-1-i] = 2*i+1;
        }
        System.out.println("First odd numbers");
        testMethods(odd);

        // Tableau dont l'element en position i vaut (-1)^i*i
        int[] sign = new int[number];
        int exp = 1;
        for (int i = 0; i < number; ++i) {
            sign[i] = exp*i;
            exp *= -1;
        }
        System.out.println("Negative and positive numbers");
        testMethods(sign);

        System.out.println("power and odd");
        testZip(power,odd);
        System.out.println("power and signs");
        testZip(power,sign);
        System.out.println("odd and signs");
        testZip(odd,sign);
    }
}
