public abstract class MyAbstractList
implements MyList
{
    
    public void add(Object o)
    {
	add(size(), o);
    }

}
