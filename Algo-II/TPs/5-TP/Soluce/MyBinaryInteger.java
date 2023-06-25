/* On écrit
 * implements Comparable<MyBinaryInteger>
 * plutôt que juste
 * implements Comparable
 * afin d'autoriser l'implementation de compareTo juste pour les
 * MyBinaryInteger. Si on utilise Comparable, on est obligé d'implémenter
 * compareTo avec un Object (c'est-à-dire avec n'importe quel objet). */
public class MyBinaryInteger implements Comparable<MyBinaryInteger>
{
    private int value;

    public MyBinaryInteger(int v)
    {
        this.value = v;
    }

    private int numOnes()
    {
        /* La représentation binaire de 42 est 101010.
         * On crée un "masque", en commençant par 1, dont la représentation
         * binaire est 1.
         * Ensuite, on effectue un ET bit-à-bit entre le nombre et le masque :
         *    101010 (value)
         *    000001 (mask)
         * ET 000000 (ET bit-à-bit).
         * Si le bit du masque est à 1 dans value, alors le résultat aura au
         * moins un bit à 1 et sera donc plus grand que 0. Dans le contraire,
         * cela veut dire que le bit du masque est à 0 dans value.
         * On décale ensuite le masque de un bit vers la gauche, et on
         * recommence.
         *    101010 (value)
         *    000010 (mask)
         * ET 000010 (ET bit-à-bit) -> on incrémente num.
         *
         *    101010 (value)
         *    000100 (mask)
         * ET 000000 (ET bit-à-bit).
         *
         *    101010 (value)
         *    001000 (mask)
         * ET 001000 (ET bit-à-bit) -> on incrémente num.
         * [...] */
        int num = 0;
        int mask = 1;
        while (this.value >= mask)
        {
            if ((this.value & mask) > 0)
            {
                num++;
            }
            mask = mask << 1;
        }
        return num;
    }

    public int compareTo(MyBinaryInteger other)
    {
        return this.numOnes() - other.numOnes();
    }

    public String toString()
    {
        int mask = 1;
        if (this.value == 0)
        {
            return "0";
        }

        String res = "";
        while (this.value >= mask)
        {
            if ((this.value & mask) > 0)
            {
                res = "1" + res;
            }
            else
            {
                res = "0" + res;
            }
            mask = mask << 1;
        }
        return res;
    }
}
