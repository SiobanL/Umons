import java.util.ArrayList;

public class BoundedArrayList
{
    public class BoundedOutreachedException extends RuntimeException {};

    private ArrayList<Object> list;
    private int maxSize;

    public BoundedArrayList(int max)
    {
        this.maxSize = max;
        list = new ArrayList<Object>();
    }

    public boolean add(Object o)
    {
        if (this.maxSize == list.size())
        {
            throw new BoundedOutreachedException();
        }
        else
        {
            list.add(o);
            return true;
        }
    }
}

