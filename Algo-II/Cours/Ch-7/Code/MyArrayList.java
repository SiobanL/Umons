public class MyArrayList
extends MyAbstractList
{

    protected Object [] tab;

    public void add(int i, Object o) {
	int oldSize= size();
	Object [] newTab= new Object [oldSize+1];
	if (tab != null) {
	    System.arraycopy(tab, 0, newTab, 0, i);
	    System.arraycopy(tab, i, newTab, i+1, oldSize-i);
	}
	tab= newTab;
	tab[i]= o;
    }

    public Object get(int i) {
	return tab[i];
    }

    public int size() {
	if (tab != null)
	    return tab.length;
	return 0;
    }

    public void visit(MyVisitor v) {
	for (int i= 0; i < size(); i++)
	    v.visit(tab[i]);
    }

}
