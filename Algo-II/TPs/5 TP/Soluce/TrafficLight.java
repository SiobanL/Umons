import java.util.ArrayList;

public class TrafficLight
{
    private Lineable[] line;
    private int n;
    private static final int maxSize = 42;

    public TrafficLight()
    {
        /* On devrait idéalement utiliser un ArrayList<Lineable> que vous
         * n'avez pas encore vu. */
        line = new Lineable[maxSize];
        n = 0;
    }

    /* Le véhicule en position pos effectue un dépassement, s'il en a le droit.
     */
    private boolean pass(int pos)
    {
        if (!line[pos].canPass() || pos == 0 || line[pos - 1].canPass())
            return false;

        Lineable v = line[pos - 1];
        line[pos - 1] = line[pos];
        line[pos] = v;
        return true;
    }


    public void add(Lineable v)
    {
        int pos = n;
        assert pos < maxSize;
        line[pos] = v;
        n++;
        while (pass(pos))
        {
            pos--;
        }
    }

    public String toString()
    {
        /* Idéalement, on devrait utiliser un StringBuilder que vous n'avez pas
         * vu en cours. */
        String r = "";
        for(int i = 0; i < n; i++)
        {
            if (i > 0)
                r+= " <- ";
            r += line[i];
        }
        return r;
    }
}
